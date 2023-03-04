package org.prog.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import java.net.InetAddress;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.prog.dto.PersonDto;
import org.prog.dto.UserNameDto;
import org.prog.util.DataHolder;

public class SQLSteps {

  private final static String FILTER_BY_PARAMETER =
      "select FirstName, LastName from Persons WHERE %s = '%s'";

  private final static String NEW_USER_SQL =
      "insert into Persons (LastName, FirstName, Title, Gender)" +
          " VALUES ('%s', '%s', '%s', '%s')";

  @Given("I save users to DB")
  public void saveMultipleUsers(DataTable dataTable) {
    dataTable.asList().forEach(this::savePersonToDB);
  }

  @Given("I save person {string} to DB")
  public void savePersonToDB(String alias) {
    try {
      PersonDto personDto = (PersonDto) DataHolder.getInstance().get(alias);
      String query = String.format(NEW_USER_SQL, personDto.getName().getLast(), personDto.getName().getFirst(),
          personDto.getName().getTitle(), personDto.getGender());
      executeQuery(query, false);
    } catch (SQLException e) {
      System.err.println("Failed to create user due to SQL Exception!");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Given("I get user with {string} = {string} from DB as {string}")
  public void retrieveUser(String parameter, String value, String alias) throws ClassNotFoundException, SQLException {
    String query = String.format(FILTER_BY_PARAMETER, parameter, value);
    Optional<ResultSet> sqlResults = executeQuery(query, true);
    if (sqlResults.isPresent()) {
      while (sqlResults.get().next()) {
        PersonDto person = new PersonDto();
        UserNameDto userNameDto = new UserNameDto();
        userNameDto.setFirst(sqlResults.get().getString(1));
        userNameDto.setLast(sqlResults.get().getString(2));
        person.setName(userNameDto);
        DataHolder.getInstance().put(alias, person);
      }
    } else {
      Assert.fail("SQL Execution failed!");
    }
  }

  @Given("I print all users in DB with {string} = {string}")
  public void printUsers(String parameter, String value) throws ClassNotFoundException, SQLException {
    String query = String.format(FILTER_BY_PARAMETER, parameter, value);
    Optional<ResultSet> sqlResults = executeQuery(query, true);
    if (sqlResults.isPresent()) {
      while (sqlResults.get().next()) {
        String name = sqlResults.get().getString(1) + " " + sqlResults.get().getString(2);
        System.out.println(name);
      }
    } else {
      Assert.fail("SQL Execution failed!");
    }
  }

  @SneakyThrows
  private Optional<ResultSet> executeQuery(String query, boolean hasResponse)
      throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con;

    if ("DESKTOP-FM5R56F".equals(InetAddress.getLocalHost().getHostName())) {
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
    } else {
      con = DriverManager.getConnection("jdbc:mysql://mysql-docker:3306/db", "user", "password");
    }


    Statement stmt = con.createStatement();
    if (hasResponse) {
      return Optional.of(stmt.executeQuery(query));
    } else {
      stmt.execute(query);
      return Optional.empty();
    }
  }


}
