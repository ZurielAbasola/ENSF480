

class FlightController extends Singleton {

	public ArrayList<Flight> getFlights() {
		ArrayList<Flight> flights = new ArrayList<Flight>();// will be replaced by call to boundary class that gets all flights
		return flights;
	}

	public Flight getFlight(String flightId) {
		Flight flight = new Flight();//replace will call to boundary class that gets flight with that id
		return flight;
	}

	public Flight addFlight(Plane plane, Crew crew, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, Airport origin, Airport destination) {
		flight newFlight = new Flight(plane, crew, departureDateTime, arrivalDateTime, origin, destination);
		// save to database
		return newFlight;
	}

	public Flight addFlight(Plane plane, Pilot pilot, ArrayList<FlightAttendant> flightAttendants, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, Airport origin, Airport destination) {
		Crew crew = new Crew(pilot, flightAttendants);
		flight newFlight = new Flight(plane, crew, departureDateTime, arrivalDateTime, origin, destination);
		// save to database
		return newFlight;
	}

	public Plane addPlane() {
		Plane newPlane = new Plane();
		// save to database
		return newPlane;
	}
}