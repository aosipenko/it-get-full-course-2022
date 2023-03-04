package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;
import org.prog.pages.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTestClass {

  @Autowired
  private static GooglePage googlePage;

  @Test
  public void searchForPerson() {
    Response response = RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat&results=20");
    RootDto rootDto = response.body().as(RootDto.class);

    PersonDto person = rootDto.getResults().stream()
        .filter(p -> p.getGender().equals("male"))
        .findFirst().get();

    String searchQuery = person.getName().getFirst() + " " + person.getName().getLast();

    googlePage.loadPage();
    googlePage.acceptCookiesIfPresent();
    googlePage.setSearchValue(searchQuery);
    googlePage.search(false);
    List<String> searchResults = googlePage.getSearchHeaders();
    Assertions.assertFalse(searchResults.isEmpty());
    Assertions.assertTrue(
        searchResults.stream()
            .filter(Objects::nonNull)
            .anyMatch(elementText -> elementText.contains(searchQuery))
    );
  }
}
