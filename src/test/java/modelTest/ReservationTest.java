package modelTest;

import model.Reservation;
import model.Customer;
import model.Event;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.EventSameDateAndTitleException;
import custom_exceptions.NotUniqueIdentifierException;

public class ReservationTest {
	Event event = null;
	Customer customer = null;
	Reservation reservation = null;

	@Before
	public void clearAllLists() throws CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException{
		Reservation.clearReservations();
		//Customer.clearAllCustomers();
		
		event = new Event("EventTitle", new Date(),59.99, 10000);
		customer = new Customer("Peter CustName", "Ricklinger Stadtweg 120");
		reservation = new Reservation(customer, event, 5000);
	}
	
	@Test
	public void testGetterAndSetter_Identificator() throws NoSuchMethodException, CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		final String identificator = "Reservierung 1";

		assertTrue(reservation.getClass().getMethod("getIdentificator") != null);
		assertTrue(reservation.getClass().getMethod("setIdentificator", String.class) != null);
		reservation.setIdentificator(identificator);

		String result = reservation.getIdentificator();
		assertEquals("Retrieved wrong value", identificator, result);
	
	}
	
	@Test
	public void testGetterAndSetter_Customer() throws NoSuchMethodException, CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		assertTrue(reservation.getClass().getMethod("getCustomer") != null);
		assertTrue(reservation.getClass().getMethod("setCustomer", Customer.class) != null);
		reservation.setCustomer(customer);

		Customer result = reservation.getCustomer();
		assertEquals("Retrieved wrong value", customer, result);

	}
	
	@Test
	public void testGetterAndSetter_Event() throws NoSuchMethodException, NotUniqueIdentifierException, EventSameDateAndTitleException, CustomerSameNameException {
		
		assertTrue(reservation.getClass().getMethod("getEvent") != null);
		assertTrue(reservation.getClass().getMethod("setEvent", Event.class) != null);
		reservation.setEvent(event);

		Event result = reservation.getEvent();
		assertEquals("Retrieved wrong value", event, result);

	}
	
	@Test
	public void testGetterAndSetter_AmountOfReservatedSeats() throws NoSuchMethodException, CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		final int amountOfReservatedSeats = 5;
		
		assertTrue(reservation.getClass().getMethod("getAmountOfReservatedSeats") != null);
		assertTrue(reservation.getClass().getMethod("setAmountOfReservatedSeats", int.class) != null);
		reservation.setAmountOfReservatedSeats(amountOfReservatedSeats);

		int result = reservation.getAmountOfReservatedSeats();
		assertEquals("Retrieved wrong value", amountOfReservatedSeats, result);

	}
	
	/*
	 * Identifier must be unique
	 */
	@Test(expected = NotUniqueIdentifierException.class)
	public void testUnique_Identifier() throws CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException{

		String identificator = "ReservationID";
		
		reservation.setIdentificator(identificator);
		final Reservation reservationDouble = new Reservation(reservation.getCustomer(), reservation.getEvent(), reservation.getAmountOfReservatedSeats());
		reservationDouble.setIdentificator(identificator);

	}
	
}
