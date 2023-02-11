package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.dto.PersonDto;
import org.prog.pages.GooglePage;
import org.prog.pages.selectors.PageSelectors;
import org.prog.util.DataHolder;

public class WebSteps {
  public static WebDriver driver;
  private GooglePage googlePage;

  @Given("I start my browser")
  public void startBrowser() {
    if (driver != null) {
      System.out.println("Driver already running");
    } else {
      driver = new ChromeDriver();
    }
  }

  @Given("I load google page")
  public void iLoadGooglePage() {
    if (googlePage == null) {
      googlePage = new GooglePage(driver);
    }
    googlePage.loadPage();
    driver.manage().window().fullscreen();
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
    Assertions.assertTrue(googlePage.getSearchHeaders().stream()
        .filter(Objects::nonNull)
        .anyMatch(header -> header.contains(searchValue)));
  }

  @Given("I click {}")
  public void clickAnyElement(PageSelectors e) {
    driver.findElement(e.getLocator()).click();
  }
}
