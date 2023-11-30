package src.entity;
public interface PaymentMethod { 
	
	public Boolean charge(float amount);
	public void refund(float amount);
}