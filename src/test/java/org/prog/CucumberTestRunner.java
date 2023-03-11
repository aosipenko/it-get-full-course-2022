package org.prog;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
    glue = "org.prog",
    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html", "org.prog.plugin.CucumberHooks"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
