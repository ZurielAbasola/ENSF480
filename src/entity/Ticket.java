package src.entity;
public class Ticket {
    private int id;
    private Integer ticketHolderId = null;
    private Flight flight;
    private Seat seat;
    private float price; // maybe this should be part of the seat or the flight though
    private CancellationInsurance cancellationInsurance;
    private boolean sold;

    public Ticket(int id, Flight flight, Seat seat, float basePrice) {
        this.id = id;
        this.flight = flight;
        this.seat = seat;
        this.price = basePrice * seat.getPriceMultiplier();
        this.sold = false;
        this.cancellationInsurance = null;
    }

    public Ticket(int id, Flight flight, Seat seat, float basePrice, Integer ticketHolderId) {
        this.id = id;
        this.flight = flight;
        this.seat = seat;
        this.price = basePrice * seat.getPriceMultiplier();
        this.ticketHolderId = ticketHolderId;
        this.sold = true;
        this.cancellationInsurance = null;
    }

    public Ticket(int id, Flight flight, Seat seat, float basePrice, Integer ticketHolderId, CancellationInsurance cancellationInsurance) {
        this(id, flight, seat, basePrice, ticketHolderId);
        this.cancellationInsurance = cancellationInsurance;
    }

    // getters and setters

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CancellationInsurance getCancellationInsurance() {
        return cancellationInsurance;
    }

    public void setCancellationInsurance(CancellationInsurance cancellationInsurance) {
        this.cancellationInsurance = cancellationInsurance;
    }

    public Boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Integer getTicketHolderId() {
        return ticketHolderId;
    }

    public void setTicketHolderId(Integer ticketHolderId) {
        this.ticketHolderId = ticketHolderId;
    }

    public int getID(){
		return id;
	}
}
