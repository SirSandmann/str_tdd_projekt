package service;

import java.util.HashMap;

import model.Reservation;

public interface EmailEventOrganizerServiceMock {

	public HashMap<String, Reservation> checkReservation(Reservation r);
	
	public void sendMail(String mail);
}
