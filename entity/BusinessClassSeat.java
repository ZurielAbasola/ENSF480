package src.entity;


public class BusinessClassSeat extends Seat {
	public BusinessClassSeat(String location) {
		super(location);
		this.priceMultiplier = 2.1f;
	}
}