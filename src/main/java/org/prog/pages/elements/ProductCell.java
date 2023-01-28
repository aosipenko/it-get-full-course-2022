package org.prog.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductCell {

  private final WebElement rootElement;

  public ProductCell (WebElement rootElement){
    this.rootElement = rootElement;
  }

  public String getProductPrice(){
    return rootElement.findElement(By.className("goods-tile__price-value")).getText();
  }

  public void openProductPage(){
    rootElement.findElement(By.tagName("a")).click();
  }
}
