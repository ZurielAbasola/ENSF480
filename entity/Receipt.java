package entity;
import java.time.LocalDateTime;

public class Receipt {
	private Integer purchaserId;
	private Ticket ticket;
	private LocalDateTime dateTime;

	public Receipt(Integer purchaserId, Ticket ticket, LocalDateTime dateTime) {
        this.purchaserId = purchaserId;
        this.ticket = ticket;
        this.dateTime = dateTime;
    }

    public Integer getPurchaserID(){
        return purchaserId;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }
}