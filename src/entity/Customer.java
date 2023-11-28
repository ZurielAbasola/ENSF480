public class Customer extends User {
	private Membership membership = null;

	public Customer(String name, Address address, String username, String password) {
        super(name, address, username, password);
    }

    public Customer(String name, Address address, String username, String password, Membership membership) {
        super(name, address, username, password);
        this.membership = membership;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void register(Membership membership) {
    	setMembership(membership);
    }

}