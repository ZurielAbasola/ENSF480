import java.time.LocalDate;

class Membership {
	int id;
	LocalDate dateRegistered;
	LocalDate expiryDate;
	Boolean companionTicketUsed;

	public Membership() {
        this.id = "" + Math.rand() * 1000000; // will improve later
		this.dateRegistered = LocalDate.now();
		this.expiryDate = dateRegistered.plusYears(1);
		companionTicketUsed = false;
	}
}