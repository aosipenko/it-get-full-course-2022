package org.prog.poly;

public class IFaceDemo {

  public static void main(String... args) {
//    Cat cat = new Cat();
//    Dog dog = new Dog();
//    Duck duck = new Duck();
//
//    smth(cat);
//    smth(dog);
//    smth(duck);

    driveTest(new Tesla());
    driveTest(new RaceCar());
  }

  public static void driveTest(ICar car) {
    car.fuel();
    car.startIgnition();
    car.setGear();
    car.accelerate();
  }

  public static void smth(Speech speech) {
    speech.speak();
  }
}
