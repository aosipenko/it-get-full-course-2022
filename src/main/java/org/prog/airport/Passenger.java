package org.prog.airport;

public class Passenger {

  private final String name;
  private final String flightId;
  private String sitId;

  public Passenger(String name, String flightId, String sitId) {
    this.name = name;
    this.flightId = flightId;
    this.sitId = sitId;
  }

  public String getName() {
    return name;
  }

  public String getFlightId() {
    return flightId;
  }

  public String getSitId() {
    return sitId;
  }

  public void setSitId(String sitId) {
    this.sitId = sitId;
  }
}
