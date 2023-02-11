package org.prog;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
    glue = "org.prog",
    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html", "org.prog.plugin.CucumberHooks"})
public class CucumberTestRunner {
}
