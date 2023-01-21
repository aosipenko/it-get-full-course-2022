package org.prog.airport;

import java.util.ArrayList;
import org.prog.exceptions.PlaneNotFoundException;

public class FlightControl {

  private final ArrayList<Plane> planes;

  private final ArrayList<Passenger> passengers;

  public FlightControl(ArrayList<Plane> planes) {
    this.planes = planes;
    passengers = new ArrayList<>();
  }

  public ArrayList<Passenger> getPassengers() {
    return this.passengers;
  }

  public void setPlaneDestination(String flightId, String destination) {
    try {
      Plane plane = getPlaneByFlightId(flightId);
      plane.setFlightDestination(destination);
    } catch (PlaneNotFoundException planeNotFoundException) {
      System.err.println("No plane exists for flight " + flightId);
    }
  }

  public void boardPassenger(Passenger passenger) throws PlaneNotFoundException {
    Plane plane = getPlaneByFlightId(passenger.getFlightId());
    plane.boardPassenger(passenger);
  }

  private Plane getPlaneByFlightId(String flightId) throws PlaneNotFoundException {
    for (Plane inspectedPlane : planes) {
      if (inspectedPlane.getFlightId().equals(flightId)) {
        return inspectedPlane;
      }
    }
    throw new PlaneNotFoundException();
  }

  public void registerPassenger(Passenger passenger) {
    passengers.add(passenger);
  }
}
