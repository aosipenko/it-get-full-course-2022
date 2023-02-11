package org.prog.pages.selectors;

import lombok.Getter;
import org.openqa.selenium.By;

public enum PageSelectors {
  GOOGLE_SEARCH_INPUT_2(By.xpath("//button")),
  GOOGLE_SEARCH_INPUT(By.name("q")),
  GOOGLE_SEARCH_HEADERS(By.tagName("h3"));

  @Getter
  private By locator;

  PageSelectors(By locator) {
    this.locator = locator;
  }
}
