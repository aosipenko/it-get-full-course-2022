package org.prog.oop;

public class ChildTwo extends ParentClass {

  public String aString = "child";

  public ChildTwo(String bString) {
    super(bString);
  }

  public void smth() {
    aString = "";
    cString = "";
    myPublicMethod();
    myProtectedMethod();
  }

  public void mySuperMethod() {
    super.myPublicMethod();
  }

  public void myPublicMethod() {
    System.out.println("this is Child's public method");
  }

//
//  GrandChild
//        \
//      ChildTwo      ChildOne
//          \         /
//          ParentClass

}
