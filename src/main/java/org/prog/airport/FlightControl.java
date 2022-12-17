package org.prog.airport;

public class FlightControl {

  final static int MAX_AIRPORT_CLIENTS = 8;

  public Plane[] planes;
  public String[] passengerNames = new String[MAX_AIRPORT_CLIENTS];//Alice; 0
  public int[] passengerSits = new int[MAX_AIRPORT_CLIENTS];//5; 0
  public String[] passengerFlights = new String[MAX_AIRPORT_CLIENTS];//ABC1; 0
  public String[] destinations;

  public FlightControl(Plane[] airportPlanes) {
    planes = airportPlanes;
    destinations = new String[] {"Atlanta", "Maldives"};
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

  public Plane getPlaneByFlightId(String flightId) {
    for (int i = 0; i < planes.length; i++) {
      if (planes[i].flightId.equals(flightId)) {
        return planes[i];
      }
    }
    return null;
  }

  public Plane getAnotherPlaneWIthSameDest(String flightId, String dest) {
    for (int i = 0; i < planes.length; i++) {
      if (!planes[i].flightId.equals(flightId) &&
          planes[i].flightDestination.equals(dest)) {
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
