package org.prog.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaPage {

  private final WebDriver driver;
  private final static By TOP_SALES_LABEL = By.xpath("//span[text()=' ТОП ПРОДАЖ ']");
  private final static By TOP_SALES_LABEL_BROKEN = By.xpath("//span[text()='ТОП ПРОДАЖ']");
  private final static By ELEMENT_CELL = By.className("catalog-grid__cell");

  public RozetkaPage(WebDriver driver) {
    this.driver = driver;
  }

  public void loadPage() {
    driver.get("https://rozetka.com.ua/network-equipment/c80111/");
  }

  public void search(String value) {
    driver.findElement(By.name("search")).sendKeys(value);
    driver.findElement(By.className("search-form__submit")).click();
  }

  public WebElement verifySearchResult() {
    return new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(TOP_SALES_LABEL));
  }

  public WebElement getProductByLineAndIndex(int line, int index, int gridSize) {
    List<WebElement> cells = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ELEMENT_CELL)); //0-59
    int elementIndex = (line - 1) * gridSize + index - 1;
    return cells.get(elementIndex);
  }
}
