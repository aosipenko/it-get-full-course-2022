package org.prog.airport;

public class Plane {

  private String flightId;
  private String flightDestination;
  private String[] passengers;

  public Plane(String flightId, int sitAmount) {
    this.flightId = flightId;
    passengers = new String[sitAmount];
  }

  public String getFlightId() {
    if (this.flightId == null) {
      return "default";
    } else {
      return this.flightId;
    }
  }

  public String getFlightDestination() {
    return this.flightDestination;
  }

  public void setFlightDestination(String flightDestination) {
    this.flightDestination = flightDestination;
  }

  public void boardPassenger(String name, int sitNumber) {
    if (sitNumber < passengers.length && passengers[sitNumber] == null) {
      System.out.println("Boarding done for " + name + " on flight " + flightId + " to " + flightDestination);
      passengers[sitNumber] = name;
    } else {
      offerFreeSit(name);
    }
  }

  private void offerFreeSit(String name) {
    System.out.println("Failed to find sit for " + name);
    int freeSit = getFreeSit();

    if (freeSit >= 0 && freeSit < passengers.length) {
      System.out.println("Backup sit found for " + name + " on flight " + flightId + " to " + flightDestination);
      passengers[freeSit] = name;
    } else {
      System.out.println("Flight " + flightId + " had no sits for passenger " + name);
    }
  }

  private int getFreeSit() {
    int freeSit = -1;

    for (int i = 0; i < passengers.length; i++) {
      if (passengers[i] == null) {
        freeSit = i;
      }
    }
    return freeSit;
  }
}
