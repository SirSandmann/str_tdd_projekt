package service;

import java.util.ArrayList;
import java.util.HashMap;

import custom_exceptions.CustomerSameNameException;
import model.Customer;
import model.Event;

public class Service {
	private static HashMap<String, Customer> customers = new HashMap<String, Customer>();
	public ArrayList<Event> getEvents(){
		return Event.getEvents();
	}

	public static HashMap<String, Customer> getCustomers() {
		return customers;
	}

	public static void addCustomer(String name, String address) throws CustomerSameNameException {
		if(!customers.containsKey(name)) {
			customers.put(name, new Customer(name, address));
		} else {
			throw new CustomerSameNameException();
		}
	}

	public static void reset(){
		customers.clear();
	}
}
