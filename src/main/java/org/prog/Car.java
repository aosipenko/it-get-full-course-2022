package org.prog;


public class Car {

  public static String modelName = "TestName";
  private String color;
  private String engineVolume;

  private int passengers;

  public Car(String carColor) {
    color = carColor;
    engineVolume = "2L";
  }

  public void paintCar(String c) {
    color = c;
  }

  public String getCarColor() {
    return color;
  }

  public void setPassengers(int passengers) {
    this.passengers = passengers;
  }

  public int getPassengers() {
    return passengers;
  }
}
