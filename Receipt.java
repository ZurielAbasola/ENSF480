class Receipt {
	private String purchaserId;
	private Ticket ticket; // ticket has price
	private Payment payment; // has method and price and date

	public Receipt(String purchaserId, Ticket ticket, Payment payment) {
        this.purchaserId = purchaserId;
        this.ticket = ticket;
        this.payment = payment;
    }
}