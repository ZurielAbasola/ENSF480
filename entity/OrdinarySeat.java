package entity;


public class OrdinarySeat extends Seat {
	public OrdinarySeat(String location) {
		super(location);
		this.priceMultiplier = 1.0f;
	}
}