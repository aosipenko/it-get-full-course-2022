package org.prog.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;
import org.prog.util.DataHolder;

public class RestSteps {

  @Given("I create a random person with gender {string} as {string}")
  public void createPerson(String gender, String alias) {
    Response response = RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat&results=20");
    RootDto rootDto = response.body().as(RootDto.class);

    PersonDto person = rootDto.getResults().stream()
        .filter(p -> p.getGender().equals(gender))
        .findFirst().get();

    String searchQuery = person.getName().getFirst() + " " + person.getName().getLast();
    System.out.println("Will be searching for " + searchQuery);

    DataHolder.getInstance().put(alias, person);
  }

}
