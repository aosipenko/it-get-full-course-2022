package org.prog.util;

import java.net.InetAddress;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import javax.annotation.PreDestroy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class WebDriverFacade {

  private final WebDriver driver;

  public WebDriverFacade() {
    this.driver = configureDriver();
  }

  public void loadPage(String pageUrl) {
    driver.get(pageUrl);
    new WebDriverWait(driver, Duration.ofSeconds(45))
        .until(ExpectedConditions.urlContains(pageUrl));
  }

  public WebElement findElement(By locator) {
    System.out.println("locating element " + locator.toString());
    return driver.findElement(locator);
  }

  public List<WebElement> findElements(By locator) {
    System.out.println("locating element " + locator.toString());
    return driver.findElements(locator);
  }

  @PreDestroy
  public void preDestroy() {
    driver.quit();
  }

  @SneakyThrows
  private WebDriver configureDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability("enableVNC", true);
    chromeOptions.setCapability("enableVideo", true);
    WebDriver driver;
    if ("DESKTOP-FM5R56F".equals(InetAddress.getLocalHost().getHostName())) {
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    } else {
      driver = new RemoteWebDriver(new URL("http://selenoid-docker:4444/wd/hub"), chromeOptions);
    }
    return driver;
  }
}
