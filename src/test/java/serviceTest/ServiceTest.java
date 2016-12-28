package serviceTest;

import custom_exceptions.CustomerSameNameException;
import model.Customer;
import model.Event;
import org.junit.Before;
import org.junit.Test;
import service.Service;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServiceTest {

	@Before
	public void reset() {
		Service.reset();
	}
	
	@Test
	public void addCustomer() throws CustomerSameNameException{
		String name = "Klaus";
		String address = "Musterstraße 1a";

		Customer c = new Customer(name, address);
		Service.addCustomer(name, address);

		assertEquals("Odd number of elements in customers collection",1, Service.getCustomers().size());

		Customer cGet = Service.getCustomers().get(name);

		assertTrue("Added customer is not correct persisted", c.equals(cGet));
	}

	@Test
	public void addEvent() throws CustomerSameNameException{
		String name = "König der Löwen";
		Double price = 129.99;
		Integer freeSeats = 2000;

		assertEquals("Collection must be empty",0, Service.getEvents().size());

		Event e = new Event(name, new Date(), price, freeSeats);
		Service.addEvent(e);

		assertEquals("Odd number of elements in customers collection",1, Service.getEvents().size());

		Event eGet = Service.getEvents().get(0);

		assertTrue("Added customer is not correct persisted", e.equals(eGet));
	}

	@Test (expected = CustomerSameNameException.class)
	public void addDuplicateCustomer() throws CustomerSameNameException {
		String name = "Klaus";
		String address = "Musterstraße 1a";
		String address2 = "Musterstraße 1b";

		Service.addCustomer(name, address);
		Service.addCustomer(name, address2);
	}
}
