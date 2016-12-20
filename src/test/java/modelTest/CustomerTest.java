package modelTest;

import model.Customer;

import static org.junit.Assert.*;
import org.junit.Test;


public class CustomerTest {
	
	@Test
	public void testGetterAndSetter_Name() throws NoSuchMethodException {
			
		final Customer customer = new Customer();
		final String name = "Klaus";
	
		assertTrue(customer.getClass().getMethod("getName") != null);
		assertTrue(customer.getClass().getMethod("setName", String.class) != null);
		customer.setName(name);

		String result = customer.getName();
		assertEquals("Retrieved wrong value", "Klaus", result);

	}

	@Test
	public void testGetterAndSetter_Address() throws NoSuchMethodException {
		
		final Customer customer = new Customer();
		final String address = "Ricklinger Stadtweg";
		
		assertTrue(customer.getClass().getMethod("getAddress") != null);
		assertTrue(customer.getClass().getMethod("setAddress", String.class) != null);
		customer.setAddress(address);

		String result = customer.getAddress();
		assertEquals("Retrieved wrong value", "Ricklinger Stadtweg", result);
	}
}