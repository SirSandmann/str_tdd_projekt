package serviceTest;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.EventSameDateAndTitleException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;
import service.Service;

public class ListInstancesTest {
	Event event = null;
	Customer customer = null;
	Reservation reservation = null;
	Service service = null;

	@Before
	public void clearAllLists() throws CustomerSameNameException, NotUniqueIdentifierException, EventSameDateAndTitleException{
		Reservation.clearReservations();
		//Customer.clearAllCustomers();
		Event.clearAllEvents();
		
		service = new Service();
		event = new Event("EventTitle",LocalDate.now(),59.99, 10000);
		customer = new Customer("Peter CustName", "Ricklinger Stadtweg 120");
		reservation = new Reservation(customer, event, 5000);
	}
	
	/*
	 * Create Many Events and compare List of all created Elements with the List of the event class
	 * Different Names because of No Double Name and Date Exceptions
	 */
	@Test
	public void testListEvents() throws EventSameDateAndTitleException, NotUniqueIdentifierException{
		ArrayList<Event> referenceList= new ArrayList<Event>();
		
		//add the already created event and afterwards some random events
		referenceList.add(event);
		for(int i = 1; i < 5 ; i++){
			Event e = new Event("EventTitle" + i, LocalDate.now(), 59.99, 10000);
			referenceList.add(e);
		}
		assertArrayEquals("Not complete List retrieved", referenceList.toArray(), service.getEvents().toArray());
	}
	
	/*
	 * Create Many Customers and compare List of all created Elements with the List of the customer class
	 * Different Names because of No Double Name Exceptions
	 */
	@Test
	public void testListCustomers() throws CustomerSameNameException{
		ArrayList<Customer> referenceList= new ArrayList<Customer>();
		
		//add the already created event and afterwards some random events
		referenceList.add(customer);
		for(int i = 1; i < 5 ; i++){
			Customer c = new Customer("HansPeter" + i, "Ricklinger Stadtweg 120");
			referenceList.add(c);
		}
		//assertArrayEquals("Not complete List retrieved", referenceList.toArray(), service.getCustomers().toArray());
	}
}
