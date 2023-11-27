import java.time.LocalDateTime;

class Receipt {
	private String purchaserId;
	private Ticket ticket;
	private LocalDateTime dateTime;

	public Receipt(String purchaserId, Ticket ticket, LocalDateTime dateTime) {
        this.purchaserId = purchaserId;
        this.ticket = ticket;
        this.dateTime = dateTime;
    }
}