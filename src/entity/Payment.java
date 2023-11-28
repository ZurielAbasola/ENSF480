
public class Payment {
	PaymentMethod method;
	Receipt receipt = null;
	Ticket ticket;

	public Payment(PaymentMethod method, Receipt receipt, Ticket ticket) {
        this.method = method;
        this.receipt = receipt;
        this.ticket = ticket;
    }

    public Receipt getReceipt() {
    	return receipt;
    }

    public void setReceipt(Receipt receipt) {
    	this.receipt = receipt;
    }
}