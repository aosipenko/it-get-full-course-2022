package org.prog.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

  protected final WebDriver driver;
  protected final String URL;

  protected AbstractPage(WebDriver driver, String url) {
    this.driver = driver;
    URL = url;
  }

  public void loadPage() {
    driver.get(URL);
    driver.manage().window().fullscreen();
  }
}
