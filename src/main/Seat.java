class Seat {
	private String location; // row + letter (I don't love the name location but couldn't think of a better one)
	private float price;

	public Seat(String location) {
		this.location = location;
		this.available = false;
	}

	// getters and setters

	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}