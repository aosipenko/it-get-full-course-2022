package org.prog;


public class Car {
  private String color;
  private String licensePlate;
  public int speed;
  public String currentTrafficLight;

  public Car(String carColor, String plateNumber) {
    color = carColor;
    licensePlate = plateNumber;
    speed = 0;
    currentTrafficLight = "yellow";
  }

  public void crossTheCrossRoad(Car[] otherCars) {
    for (int i = 0; i < otherCars.length; i++) {
      if (!licensePlate.equals(otherCars[i].licensePlate)) {
        if (speed != 0 && otherCars[i].speed != 0) {
          System.out.println("Car accident between " + licensePlate + " and "
              + otherCars[i].licensePlate);
        } else {
          System.out.println("We pass by");
        }
      }
    }
  }

  public void setCurrentTrafficLight(String newTrafficColor) {
    switch (newTrafficColor) {
      case ("red"):
        speed = 0;
        currentTrafficLight = newTrafficColor;
        break;
      case ("yellow"):
        currentTrafficLight = newTrafficColor;
        break;
      case ("green"):
        speed = 60;
        currentTrafficLight = newTrafficColor;
        break;
      default:
        System.out.println("do nothing");
    }
  }

  public String getCurrentTrafficLight() {
    return currentTrafficLight;
  }

  public void paintCar(String c) {
    color = c;
  }

  public String getCarColor() {
    return color;
  }
}
