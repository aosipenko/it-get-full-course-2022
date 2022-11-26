package org.prog;

public class CarMainClass {

  /*
  000000000000000
  000000000000000
  000000000000000
  000aliceCarred0
  000bobsCarblue0
  000000000000000
   */

  public static void main(String... args) {

    System.out.println("Alice and Bob will buy : " + Car.modelName);

    Car aliceCar = new Car("magenta");
    Car bobsCar = new Car("yellow");

    System.out.println("Cars before paint are:");
    System.out.println("Alice car color: " + aliceCar.getCarColor());
    System.out.println("Bobs car color: " + bobsCar.getCarColor());

    System.out.println("====================================");

    aliceCar.paintCar("red");
    bobsCar.paintCar("blue");

    aliceCar.modelName = "new Model";

    System.out.println("Bob now owns : " + bobsCar.modelName);

    System.out.println("Cars after paint are:");
    System.out.println("Alice car color: " + aliceCar.getCarColor());
    System.out.println("Bobs car color: " + bobsCar.getCarColor());
  }
}
