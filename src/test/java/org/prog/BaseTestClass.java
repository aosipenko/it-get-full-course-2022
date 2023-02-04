package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.RozetkaPage;

public class BaseTestClass {

  private static WebDriver driver;
  private static RozetkaPage rozetkaPage;

  @BeforeAll
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    rozetkaPage = new RozetkaPage(driver);
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

  @BeforeEach
  public void beforeTest() {
    rozetkaPage.loadPage();
    driver.manage().window().fullscreen();
  }

  @AfterEach
  public void afterTest() {
    System.out.println("============================================");
  }

  @Test
  public void testPaginationWithPageNumber() throws InterruptedException {
    rozetkaPage.goToPage("3");
    Thread.sleep(5000);
    WebElement productItem = rozetkaPage.getProductByLineAndIndex(1, 2, 5);
    Assertions.assertNotNull(productItem.getText(), "Element text expected not to be empty!");
    System.out.println(productItem.getText());
  }

  @Test
  public void testPaginationWithArrows() throws InterruptedException {
    rozetkaPage.switchToRight();
    Thread.sleep(5000);
    WebElement productItem = rozetkaPage.getProductByLineAndIndex(1, 2, 5);
    Assertions.assertNotNull(productItem.getText(), "Element text expected not to be empty!");
    System.out.println(productItem.getText());

  }
}
