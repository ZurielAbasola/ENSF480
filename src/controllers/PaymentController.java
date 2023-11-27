

class PaymentController extends Singleton {
	public Boolean makePayment(Ticket ticket, PaymentMethod paymentMethod, CancellationInsurance cancellationInsurance) {
		float price = ticket.getPrice();
		if(cancellationInsurance != null) {
			price += cancellationInsurance.getPrice();
		}
		if(!paymentMethod.charge(ticket.getPrice())) {
			return false;
		}
		ticket.setSold(true);
		ticket.setCancellationInsurance(cancellationInsurance);
		SQLConnector.updateTicket(ticket);
		Receipt receipt = new Receipt(currentUser.id, ticket, LocalDateTime.now());
		SQLConnector.getInstance().addReceipt(receipt);
		Payment payment = new Payment(method, receipt, ticket);
		SQLConnector.getInstance().addPayment(payment);
		// send ticket and receipt over email here if we add it
		return true;
	}

	public void cancelPayment(Ticket ticket, PaymentMethod paymentMethod) {
		paymentMethod.refund(ticket.getCancellationInsurance().getRefundAmount());
		ticket.setCancellationInsurance(null);
		ticket.setSold(false);
		SQLConnector.getInstance().updateTicket(ticket);
	}
}