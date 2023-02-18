package org.prog.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;
import org.prog.util.DataHolder;

public class RestSteps {

  private final static String REQUEST = "https://randomuser.me/api/?inc=gender,name,nat&results=%s";

  @Given("I create a random person with gender {string} as {string}")
  public void createPerson(String gender, String alias) {
    PersonDto person = createUsers(20).getResults().stream()
        .filter(p -> p.getGender().equals(gender))
        .findFirst().get();

    String searchQuery = person.getName().getFirst() + " " + person.getName().getLast();
    System.out.println("Will be searching for " + searchQuery);

    DataHolder.getInstance().put(alias, person);
  }

  @Given("I create set of {int} person(s) as {string}")
  @Step("I create persons!")
  public void createSeveralPersons(int amount, String alias) {
    RootDto rootDto = createUsers(amount);
    DataHolder.getInstance().put(alias, rootDto);
  }

  @Then("User set {string} contains {int} person(s)")
  @Step("I validate persons!")
  public void validateAmount(String alias, int amount) {
    RootDto dto = (RootDto) DataHolder.getInstance().get(alias);
    Assert.assertEquals("User data set length mismatch!", amount, dto.getResults().size());
  }

  @Given("I create multiple persons")
  public void createMultiple(DataTable dataTable) {
    dataTable.asMap().forEach((key, value) -> createPerson(value, key));
  }

  private RootDto createUsers(int amount) {
    Response response = RestAssured.get(String.format(REQUEST, amount));
    return response.body().as(RootDto.class);
  }
}
