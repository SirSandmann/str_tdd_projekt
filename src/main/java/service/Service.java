package service;

import java.util.ArrayList;

import model.Customer;
import model.Event;

public class Service {
	
	public ArrayList<Event> getEvents(){
		return Event.getEvents();
	}
	
	public ArrayList<Customer> getCustomers(){
		return Customer.getCustomers();
	}
	
	public void addCustomer(String name, String address){
		
	}
}
