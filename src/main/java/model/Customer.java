package model;

import java.util.ArrayList;

import custom_exceptions.CustomerSameNameException;

public class Customer {
	//Added for verifying that Events have a unique Identifier 
	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	public String name;
	public String address;

	/* TODO: Make name Unique, add Constrcutors
	 * Identifikator muss unique sein 
	 */
	
	public Customer() throws CustomerSameNameException{
		this("");
	}
	
	public Customer(String name) throws CustomerSameNameException{
		this(name, "");
	}
	
	public Customer(String name, String address) throws CustomerSameNameException{
		this.setName(name);
		this.setName(address);
		customers.add(this);
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) throws CustomerSameNameException {
		if(isNameUnique(name)){
			this.name = name;
		}else{
			throw new CustomerSameNameException();
		}
	}
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	//method for checking if the identifier is unique
	private boolean isNameUnique(String s){
		for(Customer c : getCustomers()) {
            if( c.getName().equals(s) ) {
                return false;
            }
        }
		return true;
	}
	
	public ArrayList<Customer> getCustomers(){
		return Customer.customers;
	}
	
}
