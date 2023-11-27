
class Payment {
	PaymentMethod method;
	Receipt receipt;
	Ticket ticket;

	public Payment(PaymentMethod method, Receipt receipt, Ticket ticket) {
        this.method = method;
        this.receipt = receipt;
        this.ticket = ticket;
    }
}