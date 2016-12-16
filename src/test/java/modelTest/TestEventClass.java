package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import model.Event;

public class TestEventClass {
	private final double DELTA = 1e-5;
	
	// name accessable in all test methods with the name
	@Rule
	public TestName testName = new TestName();

	/*
	 * Following Getter and Setter Methods
	 * the getter and setter are verified through 
	 * - verifying that a getter and setter method exists
	 * - run setter
	 * - retrieve value from the getter and compare with the one in the setter method
	 */
	@Test
	public void testGetterAndSetter_Identificator() throws NoSuchMethodException, SecurityException {
		// create event use methodname as identificator
		final Event event = new Event();

		// assert method getIdentifikator exists and set value
		assertTrue(event.getClass().getMethod("getIdentifikator") != null);
		assertTrue(event.getClass().getMethod("setIdentifikator", String.class) != null);
		event.setIdentifikator(testName.toString());
		
		String result = event.getIdentifikator();
		assertEquals("Retrieved wrong value", testName.toString(), result);

	}
	
	@Test 
	public void testGetterAndSetter_Titel() throws NoSuchMethodException, SecurityException {
		// create event use methodname as title
		final Event event = new Event();

		// assert method getIdentifikator exists and set value
		assertTrue(event.getClass().getMethod("getTitle") != null);
		assertTrue(event.getClass().getMethod("setTitle", String.class) != null);
		event.setTitle(testName.toString());
		
		String result = event.getTitle();
		assertEquals("Retrieved wrong value", testName.toString(), result);
	}
	
	@Test 
	public void testGetterAndSetter_DateAndTime() throws NoSuchMethodException, SecurityException {
		// create event and LocalDate to compare with
		final Event event = new Event();
		final LocalDate dateAndTime = LocalDate.now();

		// assert method getIdentifikator exists and set value
		assertTrue(event.getClass().getMethod("getDateAndTime") != null);
		assertTrue(event.getClass().getMethod("setDateAndTime", LocalDate.class) != null);
		event.setDateAndTime(dateAndTime);
		
		LocalDate result = event.getDateAndTime();
		assertEquals("Retrieved wrong value", dateAndTime, result);
	}
	
	@Test 
	public void testGetterAndSetter_Ticketprice() throws NoSuchMethodException, SecurityException {
		// create event and ticketprice
		final Event event = new Event();
		final double ticketprice = 59.99;

		// assert method getIdentifikator exists and set value
		assertTrue(event.getClass().getMethod("getTicketprice") != null);
		assertTrue(event.getClass().getMethod("setTicketprice", double.class) != null);
		event.setTicketprice(ticketprice);
		
		double result = event.getTicketprice();
		assertEquals("Retrieved wrong value", ticketprice, result, DELTA);
	}
	
	@Test 
	public void testGetterAndSetter_AvailableSeatsOverall() throws NoSuchMethodException, SecurityException {
		// create event and ticketprice
		final Event event = new Event();
		final int availableSeatsOverall = 5999;

		// assert method getIdentifikator exists and set value
		assertTrue(event.getClass().getMethod("getAvailableSeatsOverall") != null);
		assertTrue(event.getClass().getMethod("setAvailableSeatsOverall", int.class) != null);
		event.setAvailableSeatsOverall(availableSeatsOverall);
		
		int result = event.getAvailableSeatsOverall();
		assertEquals("Retrieved wrong value", availableSeatsOverall, result);
	}

}
