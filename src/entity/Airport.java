public class Airport {
	Address address;
	String code;

	public Airport(Address address, String code) {
		this.address = address;
		this.code = code;
	}

	// getters and setters (do setters even really make sense here?)

	public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}