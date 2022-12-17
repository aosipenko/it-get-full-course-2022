package org.prog.airport;

public class Plane {

  public String flightId;
  public String flightDestination;
  public String[] passengers;

  public Plane(String flightNumbers, int sitAmount) {
    flightId = flightNumbers;
    passengers = new String[sitAmount];
  }

  public void setFlightDestination(String destination) {
    flightDestination = destination;
  }

  public void boardPassenger(String name, int sitNumber) {
    if (sitNumber < passengers.length && passengers[sitNumber] == null) {
      System.out.println("Boarding done for " + name + " on flight " + flightId + " to " + flightDestination);
      passengers[sitNumber] = name;
    } else {
      offerFreeSit(name);
    }
  }

  public void offerFreeSit(String name) {
    System.out.println("Failed to find sit for " + name);
    int freeSit = getFreeSit();

    if (freeSit >= 0 && freeSit < passengers.length) {
      System.out.println("Backup sit found for " + name + " on flight " + flightId + " to " + flightDestination);
      passengers[freeSit] = name;
    } else {
      System.out.println("Flight " + flightId + " had no sits for passenger " + name);
    }
  }

  public int getFreeSit() {
    int freeSit = -1;

    for (int i = 0; i < passengers.length; i++) {
      if (passengers[i] == null) {
        freeSit = i;
      }
    }
    return freeSit;
  }
}
