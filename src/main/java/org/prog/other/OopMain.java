package org.prog.other;

import org.prog.oop.ChildOne;
import org.prog.oop.ParentClass;

public class OopMain {
    public static void main(String... args) {
        ParentClass parentClass = new ParentClass("parentString");
        parentClass.printBString();

        ChildOne childOne = new ChildOne("childOneString");
        childOne.printBString();

        smth(parentClass);
        smth(childOne);

        smth2(parentClass);
        smth2(childOne);
    }

    public static void smth(ParentClass parent) {

    }

    public static void smth2(Object o) {

    }
}
