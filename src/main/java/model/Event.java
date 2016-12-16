package model;

import java.time.LocalDate;

public class Event {
	private String identificator;
	private String title;
	private LocalDate dateAndTime;
	private double ticketprice;
	private int availableSeatsOverall; 

	public String getIdentifikator() {
		return identificator;
	}

	public String getIdentificator() {
		return identificator;
	}

	public void setIdentificator(String identificator) {
		this.identificator = identificator;
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

	public void setIdentifikator(String identifikator) {
		this.identificator = identifikator;
	}
	
}
