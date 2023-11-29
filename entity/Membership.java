package entity;
import java.time.LocalDate;

public class Membership {
	private int id;
	private LocalDate dateRegistered;
	private LocalDate expiryDate;
	private Boolean companionTicketUsed;

	public Membership() {
		int num = (int) (Math.random() * 1000000);
        this.id = num;
		this.dateRegistered = LocalDate.now();
		this.expiryDate = dateRegistered.plusYears(1);
		companionTicketUsed = false;
	}

	// if they use this then in the ui call this and call makePayment with price set to 0 (if it returned true)
	public Boolean useCompanionTicket() {
		if(!companionTicketUsed) {
			companionTicketUsed = true;
			return true;
		}
		return false;
	}

	public int getID(){
		return id;
	}

	public LocalDate getRegDate(){
		return dateRegistered;
	}

	public LocalDate getExpDate(){
		return expiryDate;
	}

	public Boolean getCompUsed(){
		return companionTicketUsed;
	}
}