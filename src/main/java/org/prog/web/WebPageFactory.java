package org.prog.web;

import org.prog.pages.AbstractPage;
import org.prog.pages.GooglePage;
import org.prog.pages.RozetkaPage;

public class WebPageFactory {

  private WebPageFactory() {
  }

  public static AbstractPage getPage(WebPageNames webPageName, WebDriverName driverName) {
    switch (webPageName) {
      case GOOGLE:
        return new GooglePage(WebDriverFactory.getDriver(driverName));
      case ROZETKA:
        return new RozetkaPage(WebDriverFactory.getDriver(driverName));
      default:
        throw new RuntimeException("Page is not suported!");
    }
  }
}
