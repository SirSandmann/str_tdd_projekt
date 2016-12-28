package serviceTest;

import custom_exceptions.CustomerSameNameException;
import model.Customer;
import org.junit.Before;
import org.junit.Test;
import service.CustomerService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerServiceTest {

    @Before
    public void reset() {
        CustomerService.reset();
    }

    @Test
    public void addCustomer() throws CustomerSameNameException {
        String name = "Klaus";
        String address = "Musterstraße 1a";

        assertEquals("Collection must be empty", 0, CustomerService.getCustomers().size());

        Customer c = new Customer(name, address);
        CustomerService.addCustomer(c);

        assertEquals("Odd number of elements in customers collection", 1, CustomerService.getCustomers().size());

        Customer cGet = CustomerService.getCustomers().get(name);

        assertTrue("Added customer is not correct persisted", c.equals(cGet));
    }

    @Test(expected = CustomerSameNameException.class)
    public void addDuplicateCustomer() throws CustomerSameNameException {
        String name = "Klaus";
        String address = "Musterstraße 1a";
        String address2 = "Musterstraße 1b";

        Customer c1 = new Customer(name, address);
        Customer c2 = new Customer(name, address2);

        CustomerService.addCustomer(c1);
        CustomerService.addCustomer(c2);
    }
}
