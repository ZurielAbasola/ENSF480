package src.entity;


public class ComfortSeat extends Seat {
	public ComfortSeat(String location) {
		super(location);
		this.priceMultiplier = 1.35f;
	}
}