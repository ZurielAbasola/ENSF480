public class Ticket {
    private Flight flight;
    private Seat seat;
    private Receipt receipt;
    private float price; // maybe this should be part of the seat or the flight though
    private CancellationInsurance calcellationInsurance;

    public Ticket(Flight flight, Seat seat, Receipt receipt, float price) {
        this.flight = flight;
        this.seat = seat;
        this.receipt = receipt;
        this.price = price;
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

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
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
}
