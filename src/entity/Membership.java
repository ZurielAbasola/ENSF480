import java.time.LocalDate;

public class Membership {
	private int id;
	private LocalDate dateRegistered;
	private LocalDate expiryDate;
	private Boolean companionTicketUsed;

	public Membership() {
        this.id = "" + Math.rand() * 1000000; // will improve later
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
}