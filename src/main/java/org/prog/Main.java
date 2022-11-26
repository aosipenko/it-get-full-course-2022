package org.prog;

public class Main {

  public static void main(String... args) {
    String methodResponse = "test";
    String anotherString = "another test";
    System.out.println(methodResponse);
    methodResponse = anotherMethod("Bob", "Alice");
    System.out.println(methodResponse);

    noArgMethod();
  }

  public static String anotherMethod(String s1, String s2) {
    return s1 + " : " + s2;
  }

  public static void someMethod(String s1, String s2) {
    System.out.println(s1 + s2);
  }

  public static void addNumbers(int i1, int i2) {
    System.out.println(i1 + i2);
  }

  public static void noArgMethod(){
    System.out.println("asdasd");
  }

}
