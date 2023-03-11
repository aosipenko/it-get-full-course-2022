package org.prog;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestsWithParameters {



  @Test( dataProvider = "myDataProvider")
  public void someTest(String args) {
    System.out.println("Running " + args);
    Assert.assertEquals(args, "test", "String comparison failed");
  }


  @DataProvider(name = "myDataProvider")
  private static Object[][] provideStringsForIsBlank() {
    return new Object[][]{
        {"test"},
        {"test"},
        {"test"},
        {"test!!!"}
    };
  }
}
