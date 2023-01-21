package org.prog;

import java.util.ArrayList;
import org.prog.airport.FlightControl;
import org.prog.airport.Passenger;
import org.prog.airport.Plane;
import org.prog.exceptions.PlaneNotFoundException;

public class Main {

  public static void main(String[] args) throws PlaneNotFoundException {
    ArrayList<Plane> planesList = new ArrayList<>();
    planesList.add(new Plane("FLGHT1"));
    planesList.add(new Plane("FLGHT2"));
    planesList.add(new Plane("FLGHT3"));

    FlightControl airport = new FlightControl(planesList);
    airport.setPlaneDestination("FLGHT1", "Atlanta");
    airport.setPlaneDestination("FLGHT2", "NY");
    airport.setPlaneDestination("FLGHT3", "Atlanta");
    airport.setPlaneDestination("FLGHT4", "Atlanta");

    createPassengers(airport);

    for (Passenger passenger : airport.getPassengers()) {
      airport.boardPassenger(passenger);
      System.out.println("Boarding done for " + passenger.getName());
      System.out.println("Passenger flight " + passenger.getFlightId());
      System.out.println("Sit number is  " + passenger.getSitId());
    }
  }

  public static void createPassengers(FlightControl airport) {
    airport.registerPassenger(new Passenger("Alice", "FLGHT1", "10A"));
    airport.registerPassenger(new Passenger("Jude", "FLGHT1", "10A"));
    airport.registerPassenger(new Passenger("Nikky", "FLGHT1", "10A"));
    airport.registerPassenger(new Passenger("Sam", "FLGHT1", "10A"));
    airport.registerPassenger(new Passenger("Bob", "FLGHT1", "20A"));
    airport.registerPassenger(new Passenger("Joe", "FLGHT2", "11A"));
    airport.registerPassenger(new Passenger("Jane", "FLGHT2", "11B"));
    airport.registerPassenger(new Passenger("Alice", "FLGHT2", "11C"));
    airport.registerPassenger(new Passenger("Sarah", "FLGHT3", "20A"));
    airport.registerPassenger(new Passenger("Arnie", "FLGHT3", "20B"));
    airport.registerPassenger(new Passenger("Kyle", "FLGHT3", "10A"));
  }
}


