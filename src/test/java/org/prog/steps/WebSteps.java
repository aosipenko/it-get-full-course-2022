package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.prog.dto.PersonDto;
import org.prog.pages.GooglePage;
import org.prog.pages.selectors.PageSelectors;
import org.prog.util.DataHolder;
import org.prog.web.WebDriverFactory;
import org.prog.web.WebDriverName;
import org.testng.Assert;

public class WebSteps {
  public ThreadLocal<WebDriver> driverContainer =
      ThreadLocal.withInitial(() -> WebDriverFactory.getDriver(WebDriverName.CHROME));
  private GooglePage googlePage;

  @Given("I load google page")
  public void iLoadGooglePage() {
    if (googlePage == null) {
      googlePage = new GooglePage(driverContainer.get());
    }
    googlePage.loadPage();
    driverContainer.get().manage().window().fullscreen();
    googlePage.acceptCookiesIfPresent();
  }

  @When("I search for {string}")
  public void iSearchFor(String searchText) {
    System.out.println("Searchin for " + searchText);
  }

  @When("I search for person with alias {string}")
  public void iSearchForPerson(String alias) {
    PersonDto person = (PersonDto) DataHolder.getInstance().get(alias);
    String searchValue = person.getName().getFirst() + " " + person.getName().getLast();
    googlePage.setSearchValue(searchValue);
    googlePage.search(false);
  }

  @Then("I see a person {string} in search results")
  public void iSeeInSearchResults(String alias) {
    PersonDto person = (PersonDto) DataHolder.getInstance().get(alias);
    String searchValue = person.getName().getFirst() + " " + person.getName().getLast();
    Assert.assertTrue(googlePage.getSearchHeaders().stream()
        .filter(Objects::nonNull)
        .anyMatch(header -> header.contains(searchValue)));
  }

  @Given("I click {}")
  public void clickAnyElement(PageSelectors e) {
    driverContainer.get().findElement(e.getLocator()).click();
  }
}
