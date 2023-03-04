package org.prog.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.prog.util.WebDriverFacade;
import org.springframework.stereotype.Component;

@Component
public class GooglePage {

  private WebDriverFacade webDriverFacade;
  private static final String URL = "https://www.google.com/";
  private static final By SEARCH_FIELD = By.name("q");

  public GooglePage(WebDriverFacade webDriverFacade) {
    this.webDriverFacade = webDriverFacade;
  }

  public void loadPage() {
    webDriverFacade.loadPage(URL);
  }

  public void acceptCookiesIfPresent() {
    List<WebElement> buttons = webDriverFacade.findElements(By.tagName("button"));
    if (buttons.size() > 1) {
      buttons.get(3).click();
    } else {
      System.out.println("Cookies are not present, skipping");
    }
  }

  public void setSearchValue(String value) {
    webDriverFacade.findElement(SEARCH_FIELD).sendKeys(value);
  }

  public void search(boolean usingButton) {
    if (usingButton) {
      clickElementIfVisible(By.name("btnK"));
    } else {
      webDriverFacade.findElement(SEARCH_FIELD).sendKeys(Keys.ENTER);
    }
  }

  public void luckySearch() {
    clickElementIfVisible(By.name("btnI"));
  }

  public List<String> getSearchHeaders() {
    return webDriverFacade.findElements(By.tagName("h3")).stream()
        .map(WebElement::getText).collect(Collectors.toList());
  }

  private void clickElementIfVisible(By locator) {
    webDriverFacade.findElements(locator).stream()
        .filter(WebElement::isDisplayed)
        .findFirst()
        .ifPresent(WebElement::click);
  }
}
