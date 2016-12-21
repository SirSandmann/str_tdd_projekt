package modelTest;

import model.Reservation;
import model.Customer;
import model.Event;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.EventSameDateAndTitleException;
import custom_exceptions.NotUniqueIdentifierException;

public class ReservationTest {

	@Before
	public void clearAllLists(){
		Reservation.clearReservations();
		Customer.clearAllCustomers();
		Event.clearAllEvents();
	}
	
	@Test
	public void testGetterAndSetter_Identificator() throws NoSuchMethodException, CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		final Reservation reservation = new Reservation(new Customer(), new Event());
		final String identificator = "Reservierung 1";

		assertTrue(reservation.getClass().getMethod("getIdentificator") != null);
		assertTrue(reservation.getClass().getMethod("setIdentificator", String.class) != null);
		reservation.setIdentificator(identificator);

		String result = reservation.getIdentificator();
		assertEquals("Retrieved wrong value", identificator, result);
	
	}
	
	@Test
	public void testGetterAndSetter_Customer() throws NoSuchMethodException, CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		final Customer customer = new Customer();
		final Reservation reservation = new Reservation(customer);
		
		assertTrue(reservation.getClass().getMethod("getCustomer") != null);
		assertTrue(reservation.getClass().getMethod("setCustomer", Customer.class) != null);
		reservation.setCustomer(customer);

		Customer result = reservation.getCustomer();
		assertEquals("Retrieved wrong value", customer, result);

	}
	
	@Test
	public void testGetterAndSetter_Event() throws NoSuchMethodException, NotUniqueIdentifierException, EventSameDateAndTitleException, CustomerSameNameException {
		
		final Event event = new Event();
		final Customer customer = new Customer();
		final Reservation reservation = new Reservation(customer, event);
		
		assertTrue(reservation.getClass().getMethod("getEvent") != null);
		assertTrue(reservation.getClass().getMethod("setEvent", Event.class) != null);
		reservation.setEvent(event);

		Event result = reservation.getEvent();
		assertEquals("Retrieved wrong value", event, result);

	}
	
	@Test
	public void testGetterAndSetter_AmountOfReservatedSeats() throws NoSuchMethodException, CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException {
		
		final Event event = new Event();
		final Customer customer = new Customer();
		
		final Reservation reservation = new Reservation(customer, event);
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
		final Event event = new Event();
		final Customer customer = new Customer();
		String identificator = "ReservationID";
		
		final Reservation reservation1 = new Reservation(customer, event);
		reservation1.setIdentificator(identificator);
		final Reservation reservation2 = new Reservation(customer, event);
		reservation2.setIdentificator(identificator);
	}
	
}
