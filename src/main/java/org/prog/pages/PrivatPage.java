package org.prog.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivatPage {

  private final WebDriver driver;
  private final static String URL = "https://next.privat24.ua/";


  public PrivatPage(WebDriver driver) {
    this.driver = driver;
  }

  public void loadPage() {
    driver.get(URL);
  }

  public void iframeMethod(By iframeSelector, By shadowRootSelector) {
    WebElement iframe = driver.findElement(iframeSelector);
    driver.switchTo().frame(iframe);
    driver.switchTo().defaultContent();

    WebElement shadowRootElement = driver.findElement(shadowRootSelector);
    SearchContext searchContext = shadowRootElement.getShadowRoot();
    WebElement btn = searchContext.findElement(By.tagName("button"));
  }

  public void clickLogin(String className) {
    new WebDriverWait(driver, Duration.ofSeconds(30L))
        .until(ExpectedConditions.elementToBeClickable(By.className(className)));
  }
}
