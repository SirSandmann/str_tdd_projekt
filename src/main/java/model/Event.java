package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.naming.directory.AttributeInUseException;

public class Event {
	//Added for verifying that Events have a unique Identifier 
	private static ArrayList<Event> events = new ArrayList<Event>();
	
	private String identificator;
	private String title;
	private LocalDate dateAndTime;
	private double ticketprice;
	private int availableSeatsOverall; 
	
	public Event(){
		this(UUID.randomUUID().toString());
	}
	
	public Event(String identificator){
		events.add(this);
	}

	public String getIdentificator() {
		return identificator;
	}

	public void setIdentificator(String identificator) throws AttributeInUseException {
		if(isIdentificatorUnique(identificator)){
			this.identificator = identificator;
		}else{
			throw new AttributeInUseException();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDate dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}

	public int getAvailableSeatsOverall() {
		return availableSeatsOverall;
	}

	public void setAvailableSeatsOverall(int availableSeatsOverall) {
		this.availableSeatsOverall = availableSeatsOverall;
	}
	
	//method for checking if the identifier is unique
	private boolean isIdentificatorUnique(String s){
		for(Event e : getEvents()) {
            if(e.getIdentificator() == s ) {
                return false;
            }
        }
		return true;
	}
	
	public static List<Event> getEvents() {
		return events;
	}
	
}
