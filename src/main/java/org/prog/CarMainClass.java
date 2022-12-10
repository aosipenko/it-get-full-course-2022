package org.prog;

public class CarMainClass {

  public static void main(String... args) {
    TrafficLights trafficLights = new TrafficLights();

    Car myCar = new Car("purple", "AA0001AA");
    Car bobsCar = new Car("green", "AA0002AA");
    Car alicesCar = new Car("black", "AA0003AA");
    Car policeCar = new Car("White", "AA0004AA");

    Car[] crossingCars = {myCar, bobsCar, alicesCar, policeCar};

    trafficLights.sendSignal(myCar, "red");
    trafficLights.sendSignal(bobsCar, "red");
    trafficLights.sendSignal(alicesCar, "red");
    trafficLights.sendSignal(policeCar, "red");

    moveCars(crossingCars);

    trafficLights.sendSignal(myCar, "green");
    trafficLights.sendSignal(bobsCar, "yellow");
    trafficLights.sendSignal(alicesCar, "red");
    trafficLights.sendSignal(policeCar, "red");

    moveCars(crossingCars);

    trafficLights.sendSignal(myCar, "green");
    trafficLights.sendSignal(bobsCar, "green");
    trafficLights.sendSignal(alicesCar, "green");
    trafficLights.sendSignal(policeCar, "green");

    moveCars(crossingCars);
  }

  public static void moveCars(Car[] cars) {
    for (int i = 0; i < cars.length; i++) {
      cars[i].crossTheCrossRoad(cars);
    }
  }
}
