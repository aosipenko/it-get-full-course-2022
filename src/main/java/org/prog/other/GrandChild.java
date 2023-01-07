package org.prog.other;

import org.prog.oop.ChildTwo;

public class GrandChild extends ChildTwo {

  public GrandChild() {
    super("grandChildString");
  }

  public void localSmth() {
    aString = "";
    cString = "";

    myPublicMethod();
    myProtectedMethod();
  }
}
