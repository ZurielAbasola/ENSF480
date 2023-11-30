package src.entity;

public class Payment {
    int id;
	CreditCard card;
	Receipt receipt = null;
	Ticket ticket;

	public Payment(CreditCard card, Receipt receipt, Ticket ticket) {
        this.card = card;
        this.receipt = receipt;
        this.ticket = ticket;
    }

    public Payment(CreditCard card, Receipt receipt, Ticket ticket, int id) {
        this.id = id;
        this.card = card;
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

    public Ticket getTicket(){
        return ticket;
    }

    public CreditCard getPMethod(){
        return card;
    }

}