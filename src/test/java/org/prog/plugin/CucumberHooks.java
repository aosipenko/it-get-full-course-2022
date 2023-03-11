package org.prog.plugin;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.prog.steps.WebSteps;
import org.prog.web.WebDriverFactory;
import org.prog.web.WebDriverName;

public class CucumberHooks implements EventListener {

  @Override
  public void setEventPublisher(EventPublisher eventPublisher) {
    eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
  }

  private void tearDown(TestRunFinished event) {
    WebDriverFactory.quitAll();
  }
}
