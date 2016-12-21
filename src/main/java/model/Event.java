package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import custom_exceptions.EventSameDateAndTitleException;
import custom_exceptions.NotUniqueIdentifierException;

public class Event {
	//Added for verifying that Events have a unique Identifier 
	private static ArrayList<Event> events = new ArrayList<Event>();
	
	private String identificator;
	private String title;
	private LocalDate dateAndTime;
	private double ticketprice;
	private int availableSeatsOverall; 
	
	public Event(String title, LocalDate dateAndTime, double ticketprice, int availableSeatsOverall) throws EventSameDateAndTitleException, NotUniqueIdentifierException{
		this.setTitle(title);
		this.setDateAndTime(dateAndTime);
		this.setTicketprice(ticketprice);
		this.setAvailableSeatsOverall(availableSeatsOverall);
		this.setIdentificator(UUID.randomUUID().toString());
		events.add(this);
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws EventSameDateAndTitleException {
		if(isTitleAndDateUnique(title)){
			this.title = title;
		}else{
			throw new EventSameDateAndTitleException();
		}
	}

	public LocalDate getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDate dateAndTime) throws EventSameDateAndTitleException {
		if(isTitleAndDateUnique(dateAndTime)){
			this.dateAndTime = dateAndTime;
		}else{
			throw new EventSameDateAndTitleException();
		}
		
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
            if( e.getIdentificator().equals(s) ) {
                return false;
            }
        }
		return true;
	}
	
	public boolean isTitleAndDateUnique(String s){
		return isTitleAndDateUnique(s, this.getDateAndTime());
	}
	
	public boolean isTitleAndDateUnique(LocalDate d){
		return isTitleAndDateUnique(this.getTitle(), d);
	}
	
	private boolean isTitleAndDateUnique(String title, LocalDate date){
		for(Event e : getEvents()) {
			if(e.getTitle() != null && e.getDateAndTime() != null){
	            if( e.getTitle().equals(title) && e.getDateAndTime().equals(date) && e != this) {
	                return false;
	            }
			}
        }
		return true;
	}
	
	public static ArrayList<Event> getEvents() {
		return events;
	}
	
	public static void clearAllEvents(){
		events.clear();
	}
	
}
