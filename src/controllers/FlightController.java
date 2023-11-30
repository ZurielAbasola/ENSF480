package src.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import src.boundary.*;
import src.utility.*;
import src.entity.*;

public class FlightController extends Singleton {

	public static FlightController getInstance() {
		return (FlightController) Singleton.getInstance();
	}

	public ArrayList<Flight> getFlights() {
		return SQLConnector.getInstance().getAllFlights();
	}

	// might want to make version of this based on airport code too, and maybe more for other filters
	public ArrayList<Flight> getFlights(String destination) {
		return SQLConnector.getInstance().getFlightsByDestination(destination);
	}

	public Flight getFlight(int flightId) {
		return SQLConnector.getInstance().getFlight(flightId);
	}

	public Flight addFlight(Plane plane, Crew crew, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, Airport origin, Airport destination, float basePrice) {
		Flight newFlight = new Flight(plane, crew, departureDateTime, arrivalDateTime, origin, destination, basePrice);
		SQLConnector.getInstance().addFlight(newFlight);
		return newFlight;
	}

	public Flight addFlight(Plane plane, Pilot pilot, ArrayList<FlightAttendant> flightAttendants, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, Airport origin, Airport destination, float basePrice) {
		Crew crew = new Crew(pilot, flightAttendants);
		Flight newFlight = new Flight(plane, crew, departureDateTime, arrivalDateTime, origin, destination, basePrice);
		SQLConnector.getInstance().addFlight(newFlight);
		return newFlight;
	}

	public void removeFlight(int flightNumber) {
		SQLConnector.getInstance().removeFlight(flightNumber); // just deletes from db
	}

	public void updateFlight(Flight updatedFlight) {
		SQLConnector.getInstance().updateFlight(updatedFlight); // finds flight from flightNumber of updatedFlight and updates it
	}

	public ArrayList<User> getFlightPassengers(Flight flight) {
		ArrayList<User> passengers = new ArrayList<User>();
		for(Ticket ticket : flight.getTickets().values()) {
			User passenger = SQLConnector.getUser(ticket.getTicketHolderId());
			passengers.add(passenger);
		}
		return passengers;
	}

	public ArrayList<User> getFlightPassengers(int flightNumber) {
		Flight flight = SQLConnector.getInstance().getFlight(flightNumber);
		return getFlightPassengers(flight);
	}

	

	// not sure we need these, and if we do, not sure we want them in here
	public ArrayList<Plane> getPlanes() {
		return SQLConnector.getInstance().getAllPlanes();
	}
	public Plane addPlane(int numRows, int seatsPerRow) {
		Plane newPlane = new Plane(numRows, seatsPerRow);
		SQLConnector.getInstance().addPlane(newPlane);
		return newPlane;
	}

	public Plane addPlane(int numRows) {
		Plane newPlane = new Plane(numRows);
		SQLConnector.getInstance().addPlane(newPlane);
		return newPlane;
	}

	public Plane addPlane() {
		Plane newPlane = new Plane();
		SQLConnector.getInstance().addPlane(newPlane);
		return newPlane;
	}

	public void removePlane(String planeId) {
		SQLConnector.getInstance().removePlane(planeId);
	}
}