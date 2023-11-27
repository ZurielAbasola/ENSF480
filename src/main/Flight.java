import java.time.LocalDateTime;

class Flight {
	private Plane plane;
	private Crew crew;
	private LocalDateTime departureDateTime;
	private LocalDateTime arrivalDateTime;
	private Airport origin;
	private Airport destination;
    private Map<String, Ticket> tickets;

	public Flight(Plane plane, Crew crew, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, Airport origin, Airport destination) {
        this.plane = plane;
        this.tickets = plane.makeTickets();
        this.crew = crew;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.origin = origin;
        this.destination = destination;
    }

    // getters and setters

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Boolean isSeatAvailable(String location) {
        return tickets.get(seatKey) == null;
    }
}