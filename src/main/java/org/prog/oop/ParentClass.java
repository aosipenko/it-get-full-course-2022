package org.prog.oop;

public class ParentClass {

  public String aString = "parent";
  private String bString;
  protected String cString;

  public ParentClass(String bString) {
    this.bString = bString;
  }

  public ParentClass(String bString, int i) {
    this.bString = bString;
  }

  public void myPublicMethod() {
    System.out.println("this is parent's method");
  }

  protected void myProtectedMethod() {
    System.out.println("this is parent's method");
  }

  public void printBString() {
    System.out.println(bString);
  }

  public final void finalMethod() {
    System.out.println("this is final method!");
  }
}
