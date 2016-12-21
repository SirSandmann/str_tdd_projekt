package modelTest;

import model.Reservation;
import model.Customer;
import model.Event;

import static org.junit.Assert.*;
import org.junit.Test;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.EventSameDateAndTitleException;
import custom_exceptions.NotUniqueIdentifierException;

public class ReservationTest {
	/* TODO: Test for Uniqueness */
	@Test
	public void testGetterAndSetter_Identificator() throws NoSuchMethodException {
		
		final Reservation reservation = new Reservation();
		final String identificator = "Reservierung 1";

		assertTrue(reservation.getClass().getMethod("getIdentificator") != null);
		assertTrue(reservation.getClass().getMethod("setIdentificator", String.class) != null);
		reservation.setIdentificator(identificator);

		String result = reservation.getIdentificator();
		assertEquals("Retrieved wrong value", identificator, result);
	
	}
	
	@Test
	public void testGetterAndSetter_Customer() throws NoSuchMethodException, CustomerSameNameException {
		
		final Reservation reservation = new Reservation();
		final Customer customer = new Customer();
		
		assertTrue(reservation.getClass().getMethod("getCustomer") != null);
		assertTrue(reservation.getClass().getMethod("setCustomer", Customer.class) != null);
		reservation.setCustomer(customer);

		Customer result = reservation.getCustomer();
		assertEquals("Retrieved wrong value", customer, result);

	}
	
	@Test
	public void testGetterAndSetter_Event() throws NoSuchMethodException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		final Reservation reservation = new Reservation();
		final Event event = new Event();
		
		assertTrue(reservation.getClass().getMethod("getEvent") != null);
		assertTrue(reservation.getClass().getMethod("setEvent", Event.class) != null);
		reservation.setEvent(event);

		Event result = reservation.getEvent();
		assertEquals("Retrieved wrong value", event, result);

	}
	
	@Test
	public void testGetterAndSetter_AmountOfReservatedSeats() throws NoSuchMethodException {
		
		final Reservation reservation = new Reservation();
		final int amountOfReservatedSeats = 5;
		
		assertTrue(reservation.getClass().getMethod("getAmountOfReservatedSeats") != null);
		assertTrue(reservation.getClass().getMethod("setAmountOfReservatedSeats", int.class) != null);
		reservation.setAmountOfReservatedSeats(amountOfReservatedSeats);

		int result = reservation.getAmountOfReservatedSeats();
		assertEquals("Retrieved wrong value", amountOfReservatedSeats, result);

	}
	
}
