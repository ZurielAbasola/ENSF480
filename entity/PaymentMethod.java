package entity;
public class PaymentMethod { // maybe this should just be an interface
	// can't think of anything that all payment methods would even have
	public Boolean charge(float amount);
	public void refund(float amount);
}