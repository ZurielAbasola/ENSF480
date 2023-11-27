class CreditCard {
	private int number;
	private int expiry;
	private int cvv;

	public CreditCard(int number, int expiry, int cvv) {
        this.number = number;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    public Boolean charge(float amount) {
    	// in reality would connect to bank here and make sure there's enough credit left
    	return true;
    }
}