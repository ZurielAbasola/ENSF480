package entity;
public abstract class PaymentMethod { // maybe this should just be an interface
	// can't think of anything that all payment methods would even have
	public abstract Boolean charge(float amount);
	public abstract void refund(float amount);
}