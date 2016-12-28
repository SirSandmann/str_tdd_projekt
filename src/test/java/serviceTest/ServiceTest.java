package serviceTest;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;
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
    public void addCustomer() throws CustomerSameNameException {
        String name = "Klaus";
        String address = "Musterstraße 1a";

        assertEquals("Collection must be empty", 0, Service.getCustomers().size());

        Customer c = new Customer(name, address);
        Service.addCustomer(c);

        assertEquals("Odd number of elements in customers collection", 1, Service.getCustomers().size());

        Customer cGet = Service.getCustomers().get(name);

        assertTrue("Added customer is not correct persisted", c.equals(cGet));
    }

    @Test
    public void addEvent() throws NotUniqueIdentifierException {
        String name = "König der Löwen";
        Double price = 129.99;
        Integer freeSeats = 2000;

        assertEquals("Collection must be empty", 0, Service.getEvents().size());

        Event e = new Event(name, new Date(), price, freeSeats);
        Service.addEvent(e);

        assertEquals("Odd number of elements in events collection", 1, Service.getEvents().size());

        Event eGet = Service.getEvents().get(e.getUuid());

        assertTrue("Added customer is not correct persisted", e.equals(eGet));
    }

    @Test
    public void addReservation() throws NotUniqueIdentifierException, CustomerSameNameException {
        Event e = new Event("König der Löwen", new Date(),  129.99, 2000);
        Service.addEvent(e);
        assertEquals("Odd number of elements in events collection", 1, Service.getEvents().size());
        Event eGet = Service.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        Service.addCustomer(c);
        assertEquals("Odd number of elements in customers collection", 1, Service.getCustomers().size());
        Customer cGet = Service.getCustomers().get(c.getName());

        assertEquals("Collection must be empty", 0, Service.getReservations().size());
        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        Service.addReservation(r);
        assertEquals("Odd number of elements in reservations collection", 1, Service.getReservations().size());

        Reservation rGet = Service.getReservations().get(r.getUuid());

        assertTrue("Added customer is not correct persisted", r.equals(rGet));
    }

    @Test(expected = CustomerSameNameException.class)
    public void addDuplicateCustomer() throws CustomerSameNameException {
        String name = "Klaus";
        String address = "Musterstraße 1a";
        String address2 = "Musterstraße 1b";

        Customer c1 = new Customer(name, address);
        Customer c2 = new Customer(name, address2);

        Service.addCustomer(c1);
        Service.addCustomer(c2);
    }
}
