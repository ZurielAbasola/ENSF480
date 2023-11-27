// we could make a couple classes that inherit from this and have those as the options

class CancellationInsurance {
	private float price;
	private float refundAmount;

	public CancellationInsurance(float price, float refundAmount) {
        this.price = price;
        this.refundAmount = refundAmount;
    }

    // getters, no need for setters here

    public float getPrice() {
    	return price;
    }

    public float getRefundAmount() {
    	return refundAmount;
    }
}