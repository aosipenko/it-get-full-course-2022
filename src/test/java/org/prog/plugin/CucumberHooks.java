package org.prog.plugin;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import org.prog.steps.WebSteps;

public class CucumberHooks implements EventListener {

  @Override
  public void setEventPublisher(EventPublisher eventPublisher) {
    eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
  }

  private void tearDown(TestRunFinished event) {
    System.out.println("All tests finished, shutting down...");
//    WebSteps.driver.quit();
  }
}
