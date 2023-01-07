package org.prog.airport;

public class FlightControl {

  final static int MAX_AIRPORT_CLIENTS = 8;

  private Plane[] planes;
  private String[] passengerNames = new String[MAX_AIRPORT_CLIENTS];//Alice; 0
  private int[] passengerSits = new int[MAX_AIRPORT_CLIENTS];
  private String[] passengerFlights = new String[MAX_AIRPORT_CLIENTS];
  private String[] destinations;

  public FlightControl(Plane[] airportPlanes) {
    planes = airportPlanes;
    destinations = new String[] {"Atlanta", "Maldives"};
  }

  public String[] getPassengerNames() {
    return passengerNames;
  }

  public void setPlaneDestination(String flightId, String destination) {
    Plane plane = getPlaneByFlightId(flightId);
    plane.setFlightDestination(destination);
  }

  public void boardPassenger(int passengerId) {
    String passengerName = passengerNames[passengerId];
    int passengerSit = passengerSits[passengerId];
    String flightId = passengerFlights[passengerId];

    Plane plane = getPlaneByFlightId(flightId);
    plane.boardPassenger(passengerName, passengerSit);
  }

  private Plane getPlaneByFlightId(String flightId) {
    for (int i = 0; i < planes.length; i++) {
      if (planes[i].getFlightId().equals(flightId)) {
        return planes[i];
      }
    }
    return null;
  }

  public void registerPassenger(int passengerId, String passengerName,
                                int passengerSit, String flightId) {
    passengerNames[passengerId] = passengerName;
    passengerSits[passengerId] = passengerSit;
    passengerFlights[passengerId] = flightId;
  }

}
