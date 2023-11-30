package src.entity;
public class CreditCard implements PaymentMethod {
	private Long number;
	private int expiry;
	private int cvv;

	public CreditCard(Long number, int expiry, int cvv) {
        this.number = number;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    public Boolean charge(float amount) {
    	// in reality would connect to bank here and make sure there's enough credit left
    	return true;
    }

    public void refund(float amount)
    {
        
    }

    public int getCvv() {
        return cvv;
    }

    public int getExpiry() {
        return expiry;
    }

    public Long getNumber() {
        return number;
    }
    
}