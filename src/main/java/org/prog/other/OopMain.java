package org.prog.other;

import org.prog.oop.ChildOne;
import org.prog.oop.ChildTwo;
import org.prog.oop.ParentClass;

public class OopMain {
  public static void main(String... args) {
    ParentClass parentClass = new ParentClass("parentString");
    parentClass.printBString();

    ChildOne childOne = new ChildOne("childOneString");
    childOne.printBString();

    ChildTwo childTwo = new ChildTwo("childTwoString");
    childTwo.printBString();

    ChildTwo childTwoTwin = new ChildTwo("childTwoTwinString");
    childTwoTwin.printBString();

    GrandChild grandChild = new GrandChild();
    grandChild.printBString();

    GrandChild grandChildTwo = new GrandChild();
    grandChildTwo.printBString();
  }
}
