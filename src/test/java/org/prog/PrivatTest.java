package org.prog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.PrivatPage;

public class PrivatTest {

  private static WebDriver driver;

  private static PrivatPage privatPage;

  @BeforeAll
  public static void setup() {
    driver = new ChromeDriver();
    privatPage = new PrivatPage(driver);
  }

  @Test
  public void testPrivat() {
    privatPage.loadPage();
    driver.manage().window().fullscreen();
    privatPage.clickLogin("btxhyX");
    System.out.println("done!");
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
}
