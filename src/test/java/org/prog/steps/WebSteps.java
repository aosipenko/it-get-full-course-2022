package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.prog.dto.PersonDto;
import org.prog.pages.GooglePage;
import org.prog.util.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;

public class WebSteps {
  @Autowired
  private DataHolder dataHolder;
  @Autowired
  private GooglePage googlePage;

  @Given("I load google page")
  public void iLoadGooglePage() {
    googlePage.loadPage();
    googlePage.acceptCookiesIfPresent();
  }

  @When("I search for {string}")
  public void iSearchFor(String searchText) {
    System.out.println("Searchin for " + searchText);
  }

  @When("I search for person with alias {string}")
  public void iSearchForPerson(String alias) {
    PersonDto person = (PersonDto) dataHolder.get(alias);
    String searchValue = person.getName().getFirst() + " " + person.getName().getLast();
    googlePage.setSearchValue(searchValue);
    googlePage.search(false);
  }

  @Then("I see a person {string} in search results")
  public void iSeeInSearchResults(String alias) {
    PersonDto person = (PersonDto) dataHolder.get(alias);
    String searchValue = person.getName().getFirst() + " " + person.getName().getLast();
    Assertions.assertTrue(googlePage.getSearchHeaders().stream()
        .filter(Objects::nonNull)
        .anyMatch(header -> header.contains(searchValue)));
  }
}
