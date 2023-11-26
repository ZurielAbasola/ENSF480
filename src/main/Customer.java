class Customer extends User {
	provate Membership membership = null;

	public Customer(String name, Address address, String username, String password) {
        super(name, address, username, password);
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