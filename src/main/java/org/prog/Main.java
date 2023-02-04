package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.RozetkaPage;
import org.prog.pages.elements.ProductCell;

public class Main {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver chromeDriver = null;
    try {
      chromeDriver = new ChromeDriver();
//      GooglePage googlePage = new GooglePage(chromeDriver);
//      googlePage.loadPage();
//      googlePage.acceptCookiesIfPresent();
//      googlePage.setSearchValue("test");
//      googlePage.search(true);

      RozetkaPage rozetkaPage = new RozetkaPage(chromeDriver);
      rozetkaPage.loadPage();

      chromeDriver.manage().window().fullscreen();

      WebElement productCell = rozetkaPage.getProductByLineAndIndex(3, 2, 5);
      chromeDriver.executeScript("arguments[0].scrollIntoView(true);", productCell);

      ProductCell pc = new ProductCell(productCell);
      String productPrice = pc.getProductPrice();
      System.out.println(productPrice);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (chromeDriver != null) {
        chromeDriver.quit();
      }
    }
  }


}


