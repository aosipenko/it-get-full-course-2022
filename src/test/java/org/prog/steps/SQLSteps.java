package org.prog.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import org.junit.Assert;
import org.prog.dto.PersonDto;
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

  @Given("I print all users in DB with {string} = {string}")
  public void setupConnection(String parameter, String value) throws ClassNotFoundException, SQLException {
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

  private Optional<ResultSet> executeQuery(String query, boolean hasResponse)
      throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

    Statement stmt = con.createStatement();
    if (hasResponse) {
      return Optional.of(stmt.executeQuery(query));
    } else {
      stmt.execute(query);
      return Optional.empty();
    }
  }


}
