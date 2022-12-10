package org.prog;

public class Plane {

  public static String modelName = "Airbus-320";
  private String[] passengers = new String[6];
  public Plane(String[] passengers) {
    this.passengers = passengers;
  }
  public void setPassengers(String[] passengers) {
    this.passengers = passengers;
  }
  public String[] getPassengers() {
    {
      return passengers;
    }
  }
}