package org.prog.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

  private final WebDriver driver;
  private static final String URL = "https://google.com/";
  private static final By SEARCH_FIELD = By.name("q");

  public GooglePage(WebDriver driver) {
    this.driver = driver;
  }

  public void loadPage() {
    driver.get(URL);
  }

  public void acceptCookiesIfPresent() {
    List<WebElement> buttons = driver.findElements(By.tagName("button"));
    if (buttons.size() > 1) {
      buttons.get(3).click();
    } else {
      System.out.println("Cookies are not present, skipping");
    }
  }

  public void setSearchValue(String value) {
    driver.findElement(SEARCH_FIELD).sendKeys(value);
  }

  public void search(boolean usingButton) {
    if (usingButton) {
      clickElementIfVisible(By.name("btnK"));
    } else {
      driver.findElement(SEARCH_FIELD).sendKeys(Keys.ENTER);
    }
  }

  public void luckySearch() {
    clickElementIfVisible(By.name("btnI"));
  }

  private void clickElementIfVisible(By locator) {
    driver.findElements(locator).stream()
        .filter(WebElement::isDisplayed)
        .findFirst()
        .ifPresent(WebElement::click);
  }
}
