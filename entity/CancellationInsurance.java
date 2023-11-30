package src.entity;
// we could make a couple classes that inherit from this and have those as the options

public class CancellationInsurance {
    private int id;
	private float price;
	private float refundAmount;

	public CancellationInsurance(int id, float price, float refundAmount) {
        this.id = id;
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

    public int getId(){
        return id;
    }

}