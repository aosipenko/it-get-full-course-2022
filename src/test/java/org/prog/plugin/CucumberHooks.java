package org.prog.plugin;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;

public class CucumberHooks implements EventListener {

  @Override
  public void setEventPublisher(EventPublisher eventPublisher) {
//    eventPublisher.registerHandlerFor(TestRunStarted.class, this::setUpDriver);
//    eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
  }

//  private void setUpDriver(TestRunStarted event) {
//    try {
//      ChromeOptions chromeOptions = new ChromeOptions();
//      chromeOptions.setCapability("enableVNC", true);
//      chromeOptions.setCapability("enableVideo", true);
//      WebDriver driver;
//      if ("DESKTOP-FM5R56F".equals(InetAddress.getLocalHost().getHostName())) {
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//      } else {
//        driver = new RemoteWebDriver(new URL("http://selenoid-docker:4444/wd/hub"), chromeOptions);
//      }
//      WebSteps.driver = driver;
//      WebDriverRunner.setWebDriver(driver);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }

//  private void tearDown(TestRunFinished event) {
//    System.out.println("All tests finished, shutting down...");
//    WebSteps.driver.quit();
//  }
}
