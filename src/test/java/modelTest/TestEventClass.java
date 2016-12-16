package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.naming.NamingException;
import javax.naming.directory.AttributeInUseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import model.Event;

public class TestEventClass {
	private final double DELTA = 1e-5;

	// name accessable in all test methods with the name
	@Rule
	public TestName testName = new TestName();
	
	//clean the array List before Tests
	@Before
	public void cleanEventList(){
		Event.clearAllEvents();
	}

	/*
	 * Following Getter and Setter Methods the getter and setter are verified
	 * through - verifying that a getter and setter method exists - run setter -
	 * retrieve value from the getter and compare with the one in the setter
	 * method
	 */

	@Test
	public void testGetterAndSetter_Identificator() throws NoSuchMethodException, SecurityException, NamingException {
		// create event use methodname as identificator
		final Event event = new Event();

		// assert method getIdentifikator exists and set value
		assertTrue(event.getClass().getMethod("getIdentificator") != null);
		assertTrue(event.getClass().getMethod("setIdentificator", String.class) != null);
		event.setIdentificator(testName.toString());

		String result = event.getIdentificator();
		assertEquals("Retrieved wrong value", testName.toString(), result);

	}

	@Test
	public void testGetterAndSetter_Titel() throws NoSuchMethodException, SecurityException, AttributeInUseException {
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
	public void testGetterAndSetter_DateAndTime() throws NoSuchMethodException, SecurityException, AttributeInUseException {
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
	public void testGetterAndSetter_Ticketprice()
			throws NoSuchMethodException, SecurityException, AttributeInUseException {
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
	public void testGetterAndSetter_AvailableSeatsOverall()
			throws NoSuchMethodException, SecurityException, AttributeInUseException {
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

	/*
	 * Identifier must be unique
	 */
	@Test(expected = AttributeInUseException.class)
	public void testUnique_Identifier() throws AttributeInUseException {
		final Event event1 = new Event();
		event1.setIdentificator(testName.toString());
		final Event event2 = new Event();
		event2.setIdentificator(testName.toString());
	}
	
	/*
	 * There cannot be the same event on the same date
	 * null values either for Title or for the date will be ignored in this case
	 */
	@Test(expected = AttributeInUseException.class)
	public void testUnique_NameAndDateEvent() throws AttributeInUseException{
		LocalDate dateAndTime = LocalDate.now();
		@SuppressWarnings("unused")
		final Event event1 = new Event("Konzert_Udo", dateAndTime);
		@SuppressWarnings("unused")
		final Event event2 = new Event("Konzert_Udo", dateAndTime);
	}

}
