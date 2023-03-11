package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Objects;
import org.prog.dto.PersonDto;
import org.prog.pages.GooglePage;
import org.prog.util.DataHolder;
import org.prog.web.WebDriverName;
import org.prog.web.WebPageFactory;
import org.prog.web.WebPageNames;
import org.testng.Assert;

public class WebSteps {
  private ThreadLocal<GooglePage> googlePageContainer =
      ThreadLocal.withInitial(() -> (GooglePage) WebPageFactory.getPage(WebPageNames.GOOGLE, WebDriverName.CHROME));

  @Given("I load google page")
  public void iLoadGooglePage() {
    googlePageContainer.get().loadPage();
    googlePageContainer.get().acceptCookiesIfPresent();
  }

  @When("I search for {string}")
  public void iSearchFor(String searchText) {
    System.out.println("Searchin for " + searchText);
  }

  @When("I search for person with alias {string}")
  public void iSearchForPerson(String alias) {
    PersonDto person = (PersonDto) DataHolder.getInstance().get(alias);
    String searchValue = person.getName().getFirst() + " " + person.getName().getLast();
    googlePageContainer.get().setSearchValue(searchValue);
    googlePageContainer.get().search(false);
  }

  @Then("I see a person {string} in search results")
  public void iSeeInSearchResults(String alias) {
    PersonDto person = (PersonDto) DataHolder.getInstance().get(alias);
    String searchValue = person.getName().getFirst() + " " + person.getName().getLast();
    Assert.assertTrue(googlePageContainer.get().getSearchHeaders().stream()
        .filter(Objects::nonNull)
        .anyMatch(header -> header.contains(searchValue)));
  }
}
