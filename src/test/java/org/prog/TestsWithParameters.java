package org.prog;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.prog.web.SeleniumDemo;

public class TestsWithParameters {


  @Test
  public void smth(){
    SeleniumDemo seleniumDemo = new SeleniumDemo();

  }


  @ParameterizedTest
  @MethodSource("provideStringsForIsBlank")
  public void someTest(String args) {
    System.out.println("Running " + args);
    Assertions.assertEquals("test", args, "String comparison failed");
  }

  private static Stream<Arguments> provideStringsForIsBlank() {
    return Stream.of(
        Arguments.of("test"),
        Arguments.of("test"),
        Arguments.of("this test will fail")
    );
  }
}
