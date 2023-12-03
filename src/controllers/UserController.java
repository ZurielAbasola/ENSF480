package src.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import src.boundary.*;
import src.utility.*;
import src.entity.*;

public class UserController extends Singleton {
	static User currentUser;
	static UserController instance = null;

	public static UserController getInstance() {
		if(instance == null) {
			instance = new UserController();
		}
		return instance;
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

	public Customer registerExistingCustomer(int customerId, Membership membership) {
		Customer customerToRegister = SQLConnector.getInstance().getCustomer(customerId);// needs to be implemented by boundary public class
		customerToRegister.setMembership(membership);
		SQLConnector.getInstance().updateCustomer(customerToRegister);
		return customerToRegister;
	}

	// probably register agent, flight attendant, pilot, and admin too

	public Boolean login(String username, String password) {
		//do find in database for user with username and password
		User loggedInUser = SQLConnector.getInstance().login(username, password);
		if(loggedInUser != null) {
			currentUser = loggedInUser;
			return true;
		}
		return false;
	}

	public static User getCurrentUser() {
        return currentUser;
    }
}