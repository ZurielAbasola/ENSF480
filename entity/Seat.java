package src.entity;
public class Seat {
	private int id;
	protected String location; // row + letter (I don't love the name location but couldn't think of a better one)
	protected float priceMultiplier;

	public Seat(String location) {
		this.location = location;
	}

	// getters and setters

	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPriceMultiplier() {
    	return priceMultiplier;
    }

    // public static utility function
    public static String getSeatKey(int row, String letter) {
		return row + letter;
	}

	public int getID(){
		return id;
	}
}