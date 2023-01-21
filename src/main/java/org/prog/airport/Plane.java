package org.prog.airport;

import java.util.HashMap;

public class Plane {

  private final String flightId;
  private final HashMap<String, Passenger> passengers;
  private String flightDestination;

  public Plane(String flightId) {
    this.flightId = flightId;
    passengers = new HashMap<>();
  }

  public String getFlightId() {
    if (this.flightId == null) {
      return "default";
    } else {
      return this.flightId;
    }
  }

  public void setFlightDestination(String flightDestination) {
    this.flightDestination = flightDestination;
  }

  public void boardPassenger(Passenger passenger) {
    if (passengers.containsKey(passenger.getSitId())) {
      String replacementSit = passenger.getSitId() + "R";
      passenger.setSitId(replacementSit);
      boardPassenger(passenger);
    } else {
      System.out.println(
          "Boarding done for " + passenger.getName() + " on flight " + flightId + " to " + flightDestination);
      passengers.put(passenger.getSitId(), passenger);
    }
  }
}
