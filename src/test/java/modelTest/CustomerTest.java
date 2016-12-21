package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import custom_exceptions.CustomerSameNameException;
import model.Customer;


public class CustomerTest {
	Customer customer = null;
	//clean the array List before Tests
	@Before
	public void cleanCustomerList() throws CustomerSameNameException{
		Customer.clearAllCustomers();
		customer = new Customer("Customer Name", "Ricklinger Stadtweg 120");
	}

	@Test
	public void testGetterAndSetter_Name() throws NoSuchMethodException, CustomerSameNameException {
			
		final String name = "Klaus";
	
		assertTrue(customer.getClass().getMethod("getName") != null);
		assertTrue(customer.getClass().getMethod("setName", String.class) != null);
		customer.setName(name);

		String result = customer.getName();
		assertEquals("Retrieved wrong value", name, result);

	}

	@Test
	public void testGetterAndSetter_Address() throws NoSuchMethodException, CustomerSameNameException {
		
		final String address = "Ricklinger Stadtweg";
		
		assertTrue(customer.getClass().getMethod("getAddress") != null);
		assertTrue(customer.getClass().getMethod("setAddress", String.class) != null);
		customer.setAddress(address);

		String result = customer.getAddress();
		assertEquals("Retrieved wrong value", address, result);
	}
	
	/*
	 * There cannot be the same customer with the same name
	 */
	@Test(expected = CustomerSameNameException.class)
	public void testUnique_Name() throws CustomerSameNameException{
		@SuppressWarnings("unused")
		final Customer customerDouble = new Customer(customer.getName(), customer.getAddress());
	}
}