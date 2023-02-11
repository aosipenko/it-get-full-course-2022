package org.prog.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

  public static void main(String... args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver chromeDriver = null;
    try {
      chromeDriver = new ChromeDriver();
      chromeDriver.get("https://google.com/");

      List<WebElement> buttons = chromeDriver.findElements(By.tagName("button"));
      buttons.get(3).click();

      WebElement search = chromeDriver.findElement(By.name("q"));
      search.sendKeys("test");
      search.sendKeys(Keys.ENTER);

      System.out.println("cookies are done");
    } finally {
      if (chromeDriver != null) {
        chromeDriver.quit();
      }
    }
  }

  void someMethod(){

  }
}
