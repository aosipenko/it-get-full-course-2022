package org.prog;


public class Car {

  public static String modelName = "TestName";
  private String color;
  private String engineVolume;

  private int passengers;

  public Car(String c) {
    color = c;
    engineVolume = "2L";
  }

  public void paintCar(String c) {
    color = c;
  }

  public String getCarColor() {
    return color;
  }
}
