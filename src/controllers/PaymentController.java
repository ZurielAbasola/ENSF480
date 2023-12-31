package src.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import src.boundary.*;
import src.utility.*;
import src.entity.*;

public class PaymentController extends Singleton {
	static PaymentController instance = null;

	public static PaymentController getInstance() {
		if(instance == null) {
			instance = new PaymentController();
		}
		return instance;
	}

	public Boolean makePayment(Ticket ticket, CreditCard creditCard, CancellationInsurance cancellationInsurance) {
		float price = ticket.getPrice();
		if(cancellationInsurance != null) {
			price += cancellationInsurance.getPrice();
		}
		if(!creditCard.charge(ticket.getPrice())) {
			return false;
		}
		ticket.setSold(true);
		ticket.setCancellationInsurance(cancellationInsurance);
		SQLConnector.updateTicket(ticket);
		Receipt receipt = new Receipt(UserController.getInstance().currentUser.getId(), ticket, LocalDateTime.now());
		SQLConnector.getInstance().addReceipt(receipt);
		Payment payment = new Payment(creditCard, receipt, ticket);
		SQLConnector.getInstance().addPayment(payment);
		// send ticket and receipt over email here if we add it
		return true;
	}

	public void cancelPayment(Ticket ticket, CreditCard creditCard) {
		creditCard.refund(ticket.getCancellationInsurance().getRefundAmount());
		ticket.setCancellationInsurance(null);
		ticket.setSold(false);
		SQLConnector.getInstance().updateTicket(ticket);
	}
}