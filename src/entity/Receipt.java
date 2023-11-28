import java.time.LocalDateTime;

public class Receipt {
	private int purchaserId;
	private Ticket ticket;
	private LocalDateTime dateTime;

	public Receipt(int purchaserId, Ticket ticket, LocalDateTime dateTime) {
        this.purchaserId = purchaserId;
        this.ticket = ticket;
        this.dateTime = dateTime;
    }
}