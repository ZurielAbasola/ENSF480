package entity;

public class Payment {
    int id;
	PaymentMethod method;
	Receipt receipt = null;
	Ticket ticket;

	public Payment(PaymentMethod method, Receipt receipt, Ticket ticket) {
        this.method = method;
        this.receipt = receipt;
        this.ticket = ticket;
    }

    public Payment(PaymentMethod method, Receipt receipt, Ticket ticket, int id) {
        this.id = id;
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

    public int getID(){
        return id;
    }
}