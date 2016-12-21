package model;

import java.util.ArrayList;
import java.util.UUID;

import custom_exceptions.NotUniqueIdentifierException;

public class Reservation { 
	
	//Added for verifying that Events have a unique Identifier 
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	private String identificator;
	private Customer customer;
	private Event event;
	private int amountOfReservatedSeats;
	
	public Reservation(Customer c, Event e, int amountOfReservatedSeats) throws NotUniqueIdentifierException{
		this.setCustomer(c);
		this.setEvent(e);
		this.setAmountOfReservatedSeats(amountOfReservatedSeats);
		this.setIdentificator(UUID.randomUUID().toString());
		reservations.add(this);
	}
	
	public String getIdentificator() {
		
		return identificator;
	}
		
	public void setIdentificator(String identificator) throws NotUniqueIdentifierException {
		if(isIdentificatorUnique(identificator)){
			this.identificator = identificator;
		}else{
			throw new NotUniqueIdentifierException();
		}
		
	}
	
	public Customer getCustomer() {
		
		return customer;
	}
	
	public void setCustomer(Customer c) {
		
		this.customer = c;
	}
	
	public Event getEvent() {
		
		return event;
	}
	
	public void setEvent(Event e) {
		
		this.event = e;
	}
	
	public int getAmountOfReservatedSeats() {
		
		return amountOfReservatedSeats;
	}
	
	public void setAmountOfReservatedSeats(int amountOfReservatedSeats) {
		
		this.amountOfReservatedSeats = amountOfReservatedSeats;
	}
	
	//method for checking if the identifier is unique
	private boolean isIdentificatorUnique(String s){
		for(Reservation r : getReservations()) {
            if( r.getIdentificator().equals(s) && r != this) {
                return false;
            }
        }
		return true;
	}
	
	public static ArrayList<Reservation> getReservations(){
		return reservations;
	}
	
	public static void clearReservations(){
		reservations.clear();
	}

}
