package org.prog;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AllureReportTests {

  @Test
  @Description("this is a base tests")
  @Severity(SeverityLevel.CRITICAL)
  public void allureCritTest() {
    printThing("This is a critical test");
    printThing("It tests critical things");
  }

  @Test
  @Description("this is a base tests")
  @Severity(SeverityLevel.BLOCKER)
  public void allureBlockTest() {
    printThing("This is a blocker test");
    printThing("It tests blocker things");
  }

  @Test
  @Description("this is a base tests")
  @Severity(SeverityLevel.MINOR)
  public void allureMinorTestOne() {
    printThing("This is a minor test");
    printThing("It tests minor things");
  }

  @Test
  @Description("this is a base tests")
  @Severity(SeverityLevel.MINOR)
  public void allureMinorTestTwo() {
    printThing("This is a minor test");
    printThing("It tests minor things");
  }

  @Step("I print things")
  private void printThing(String s) {
    System.out.println(s);
  }
}