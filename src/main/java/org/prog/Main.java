package org.prog;

import org.prog.airport.FlightControl;
import org.prog.airport.Plane;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Plane[] airportPlanes = new Plane[3];
    airportPlanes[0] = new Plane("FLGHT1", 2);
    airportPlanes[1] = new Plane("FLGHT2", 3);
    airportPlanes[2] = new Plane("FLGHT3", 3);

        FlightControl airport = new FlightControl(airportPlanes);
        airport.setPlaneDestination("FLGHT1", "Atlanta");
        airport.setPlaneDestination("FLGHT2", "NY");
        airport.setPlaneDestination("FLGHT3", "Atlanta");

        createPassengers(airport);

        for (int i = 0; i < airport.getPassengerNames().length; i++) {
            airport.boardPassenger(i);
        }
    }

  public static void createPassengers(FlightControl airport) {
    airport.registerPassenger(0, "Alice", 0, "FLGHT1");
    airport.registerPassenger(1, "Bob", 1, "FLGHT1");

    airport.registerPassenger(2, "Joe", 0, "FLGHT2");
    airport.registerPassenger(3, "Jane", 1, "FLGHT2");
    airport.registerPassenger(4, "Alice", 2, "FLGHT2");

    airport.registerPassenger(5, "Sarah", 0, "FLGHT3");
    airport.registerPassenger(6, "Arnie", 1, "FLGHT3");
    airport.registerPassenger(7, "Kyle", 10, "FLGHT3");
  }
}
