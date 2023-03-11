package org.prog.web;

import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

  private final static List<WebDriver> driverList = new ArrayList<>();

  private WebDriverFactory() {
  }

  public static WebDriver getDriver(WebDriverName webDriverName) {
    switch (webDriverName) {
      case CHROME_LOCAL:
        return new ChromeDriver();
      case FIREFOX_LOCAL:
        return new FirefoxDriver();
      case CHROME:
        return getRemote(chromeOptions());
      case FIREFOX:
        return getRemote(firefoxOptions());
      default:
        throw new RuntimeException("This driver is not supported!");
    }
  }

  public static void quitAll() {
    driverList.forEach(webDriver -> {
      if (webDriver != null) {
        webDriver.quit();
      }
    });
  }

  private static AbstractDriverOptions chromeOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability("enableVNC", true);
    chromeOptions.setCapability("enableVideo", true);
    return chromeOptions;
  }

  private static AbstractDriverOptions firefoxOptions() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setCapability("enableVNC", true);
    firefoxOptions.setCapability("enableVideo", true);
    return firefoxOptions;
  }

  @SneakyThrows
  private static WebDriver getRemote(AbstractDriverOptions options) {
    String url;
    if ("DESKTOP-FM5R56F".equals(InetAddress.getLocalHost().getHostName())) {
      url = "http://localhost:4444/wd/hub";
    } else {
      url = "http://selenoid-docker:4444/wd/hub";
    }
    WebDriver driver = new RemoteWebDriver(new URL(url), options);
    driverList.add(driver);
    return driver;
  }
}
