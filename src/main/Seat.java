class Seat {
	private String location; // row + letter (I don't love the name location but couldn't think of a better one)
	// maybe enum for type or we just make subclasses
	Boolean available; // probably makes more sense to put something like this on a flight instead of a seat, but not 100% sure

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

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}