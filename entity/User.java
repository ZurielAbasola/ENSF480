package entity;
public class User {
	protected int id;
	protected String name;
	protected Address address;
	protected String username;
	protected String password;

	public User(String name, Address address, String username, String password) {
        this.id = (int) (Math.random() * 1000000); // will improve later
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for address
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}