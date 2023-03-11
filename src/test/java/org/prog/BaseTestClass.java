package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;
import org.prog.pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTestClass {

  private static WebDriver driver;
  private static GooglePage googlePage;

  @BeforeClass
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    googlePage = new GooglePage(driver);
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void searchForPerson() {
    Response response = RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat&results=20");
    RootDto rootDto = response.body().as(RootDto.class);

    PersonDto person = rootDto.getResults().stream()
        .filter(p -> p.getGender().equals("male"))
        .findFirst().get();

    String searchQuery = person.getName().getFirst() + " " + person.getName().getLast();

    googlePage.loadPage();
    driver.manage().window().fullscreen();
    googlePage.acceptCookiesIfPresent();
    googlePage.setSearchValue(searchQuery);
    googlePage.search(false);
    List<String> searchResults = googlePage.getSearchHeaders();
    Assert.assertFalse(searchResults.isEmpty());
    Assert.assertTrue(
        searchResults.stream()
            .filter(Objects::nonNull)
            .anyMatch(elementText -> elementText.contains(searchQuery))
    );
  }
}
