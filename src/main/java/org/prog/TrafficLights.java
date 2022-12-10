package org.prog;

public class TrafficLights {

  public void sendSignal(Car targetCar, String color) {
    targetCar.setCurrentTrafficLight(color);
  }
}
