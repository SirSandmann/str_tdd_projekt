package model;

public class Reservation { 
	
	private String identificator;
	public Customer customer;
	public Event event;
	private int amountOfReservatedSeats;
	/* TODO: COnstructors , needs to have a reference to customer and event*/
	public String getIdentificator() {
		
		return identificator;
	}
		
	public void setIdentificator(String identificator) {
		
		this.identificator = identificator;
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

}
