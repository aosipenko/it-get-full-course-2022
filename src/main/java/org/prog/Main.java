package org.prog;

public class Main {

    public static void main(String... args) {
        Car myCar = new Car("red");
//        System.out.println(myCar.getCarColor());
//        paintCar(myCar, "red");
//        paintCar(myCar, "blue");
//        System.out.println(myCar.getCarColor());

        int i1 = 10;
        int i2 = 20;

        String s1 = "a";
        String s2 = "a";

        if (i1 != i2) {

        }

        if (s1.equals(s2)) {

        }

        if (s1 == s2){

        }


        int passengerCount = 3;
        myCar.setPassengers(passengerCount);
        System.out.println(myCar.getPassengers());
        myCar.setPassengers(2);
        System.out.println(myCar.getPassengers());
        System.out.println(passengerCount);

//        multipleIfElse("a", "a", "a");
//        multipleIfElse("b", "a", "a");
//        multipleIfElse("a", "b", "a");
//        multipleIfElse("a", "a", "b");
//        multipleIfElse("b", "b", "a");
//        multipleIfElse("a", "b", "b");
//        multipleIfElse("b", "a", "b");
//        multipleIfElse("b", "a", "c");
    }

    public static void anotherIf(boolean aFlag) {
        if (!aFlag) {
            System.out.println("they are the same!");
        } else {
            System.out.println("they are different!");
        }
    }

    public static void paintCar(Car myCar, String newCarColor) {
        if (myCar.getCarColor().equals(newCarColor)) {
            System.out.println("they are the same! No paintNeeded!");
        } else {
            System.out.println("Painting car in " + newCarColor);
            myCar.paintCar(newCarColor);
        }
    }

    public static void multipleIfElse(String s1, String s2, String s3) {
        if (s1.equals(s2) && s1.equals(s3)) {
            System.out.println("all string are the same!");
        } else if (s2.equals(s3)) {
            System.out.println("s2 is same as s3");
        } else if (s1.equals(s2)) {
            System.out.println("s1 is same as s2");
        } else if (s1.equals(s3)) {
            System.out.println("s1 is same as s3");
        } else {
            System.out.println("all string are different");
        }
    }
}
