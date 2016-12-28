package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Customer;


public class CustomerTest {
    private final String name = "Klaus";
    private final String address = "Musterstraße 1a";

    @Test
    public void getName() throws Exception {
        Customer c = new Customer(name, address);

        assertTrue(c.getClass().getMethod("getName") != null);

        assertEquals("Retrieved wrong value", name, c.getName());
    }

    @Test
    public void getAddress() throws Exception {
        Customer c = new Customer(name, address);

        assertTrue(c.getClass().getMethod("getAddress") != null);

        assertEquals("Retrieved wrong value", address, c.getAddress());
    }
}