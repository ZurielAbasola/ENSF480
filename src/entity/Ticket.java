public class Ticket {
    private String ticketHolderId;
    private Flight flight;
    private Seat seat;
    private float price; // maybe this should be part of the seat or the flight though
    private CancellationInsurance calcellationInsurance;
    private boolean sold;

    public Ticket(Flight flight, Seat seat, float basePrice, String ticketHolderId) {
        this.flight = flight;
        this.seat = seat;
        this.price = basePrice * seat.getPriceMultiplier();
        this.ticketHolderId = ticketHolderId;
        this.sold = false;
        this.cancellationInsurance = null;
    }

    public Ticket(Flight flight, Seat seat, float basePrice, String ticketHolderId, CancellationInsurance cancellationInsurance) {
        this(flight, seat, basePrice, ticketHolderId);
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
}
