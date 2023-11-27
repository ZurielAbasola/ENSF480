

class PaymentController extends Singleton {
	public Boolean makePayment(Ticket ticket, PaymentMethod paymentMethod, CancellationInsurance cancellationInsurance) {
		if(!paymentMethod.charge(ticket.getPrice())) {
			return false;
		}
		Receipt receipt = new Receipt();
		// lots more stuff
	}
}