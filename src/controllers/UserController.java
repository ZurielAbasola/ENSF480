

public class UserController extends Singleton {
	static User currentUser;

	public static UserController getInstance() {
		return (UserController) Singleton.getInstance();
	}

	public ArrayList<Customer> getRegisteredUsers() {
		return SQLConnector.getInstance().getRegisteredUsers();// just get all customers who's membership isn't null
	}

	public Customer registerCustomer(String name, Address address, String username, String password) {
		Customer newCustomer = new Customer(name, address, username, password);
		SQLConnector.getInstance().addCustomer(newCustomer);
		return newCustomer;
	}

	public Customer registerCustomer(String name, Address address, String username, String password, Membership membership) {
		Customer newCustomer = new Customer(name, address, username, password, membership);
		SQLConnector.getInstance().addCustomer(newCustomer);
		return newCustomer;
	}

	public Customer registerExistingCustomer(String customerId, Membership membership) {
		Customer customerToRegister = getCustomer(customerId);// needs to be implemented by boundary public class
		customerToRegister.setMembership(membership);
		SQLConnector.getInstance().updateCustomer(newCustomer);
		return customerToRegister;
	}

	// probably register agent, flight attendant, pilot, and admin too

	public Boolean login(String username, String password) {
		//do find in database for user with username and password
		User loggedInUser = SQLConnector.getInstance().login(username, password);
		if(loggedInUser != null) {
			currentUser = loggedInUser;
			return true
		}
		return false;
	}
}