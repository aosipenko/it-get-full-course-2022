package org.prog;

public class CyclesMain {

    public static void main(String... args) {
        switchStatement("a");
        switchStatement("m");
    }

    public static void smth(String[] someStrings) {
        Car someCar = new Car("asd");

    }

    public static void smth(int someInt) {
        int i = 2;
        do {
            i++;
            if (i > 16) {
                break;
            }
        } while ((someInt % i) != 0);
        System.out.println(i);
    }

    public static void switchStatement(String switchString) {
        switch (switchString) {
            case "a":
                System.out.println("this is a");
                break;
            case "b":
                System.out.println("this is b");
                break;
            case "c":
                System.out.println("this is c");
                break;
            default:
                System.out.println("default");
        }
    }
}
