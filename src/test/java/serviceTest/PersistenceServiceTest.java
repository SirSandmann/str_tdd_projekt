package serviceTest;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;
import service.CustomerService;
import service.EventService;
import service.PersistenceService;
import service.ReservationService;

public class PersistenceServiceTest {
    @Before
    public void reset() {
        CustomerService.reset();
        EventService.reset();
        ReservationService.reset();
    }

    @Test
    public void loadCustomers() throws CustomerSameNameException {
        String address = "Musterstraße 1a";

        Customer c1 = new Customer("Klaus", address);
        Customer c2 = new Customer("Herbert", address);
        Customer c3 = new Customer("Dieter", address);
        CustomerService.addCustomer(c1);
        CustomerService.addCustomer(c2);
        CustomerService.addCustomer(c3);

        HashMap<String, Customer> customers = new HashMap<>();
        customers.put(c1.getName(), c1);
        customers.put(c2.getName(), c2);
        customers.put(c3.getName(), c3);

        HashMap<String, Customer> loadedCustomers = PersistenceService.loadCustomers();

        assertEquals("Size of loaded customers is not correct", customers.size(), loadedCustomers.size());

        Customer c1Loaded = loadedCustomers.get(c1.getName());
        assertTrue("Customer is not the same after loading from file", customers.get(c1.getName()).equals(c1Loaded));
    }

    @Test
    public void loadEvents() throws NotUniqueIdentifierException {
        String name = "König der Löwen";
        Double price = 129.99;
        Integer freeSeats = 2000;

        Event e1 = new Event(name, new Date(), price, freeSeats, "test@test.de");
        Event e2 = new Event(name, new Date(), price, freeSeats, "test@test.de");
        Event e3 = new Event(name, new Date(), price, freeSeats, "test@test.de");
        EventService.addEvent(e1);
        EventService.addEvent(e2);
        EventService.addEvent(e3);

        HashMap<UUID, Event> events = new HashMap<>();
        events.put(e1.getUuid(), e1);
        events.put(e2.getUuid(), e2);
        events.put(e3.getUuid(), e3);

        HashMap<UUID, Event> loadedEvents = PersistenceService.loadEvents();

        assertEquals("Size of loaded events is not correct", events.size(), loadedEvents.size());

        Event e1Loaded = loadedEvents.get(e1.getUuid());
        Event should = events.get(e1.getUuid());
        assertTrue("Event is not the same after loading from file", should.equals(e1Loaded));
    }

    @Test
    public void loadReservations() throws Exception {
        Event e = new Event("König der Löwen", new Date(), 129.99, 2000, "test@test.de");
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c1 = new Customer("Klaus", "Musterstraße 1a");
        Customer c2 = new Customer("Herbert", "Musterstraße 1a");
        Customer c3 = new Customer("Dieter", "Musterstraße 1a");
        CustomerService.addCustomer(c1);
        CustomerService.addCustomer(c2);
        CustomerService.addCustomer(c3);

        Reservation r1 = new Reservation(c1.getName(), eGet.getUuid(), 3);
        Reservation r2 = new Reservation(c2.getName(), eGet.getUuid(), 3);
        Reservation r3 = new Reservation(c3.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r1);
        ReservationService.addReservation(r2);
        ReservationService.addReservation(r3);


        HashMap<UUID, Reservation> reservations = new HashMap<>();
        reservations.put(r1.getUuid(), r1);
        reservations.put(r2.getUuid(), r2);
        reservations.put(r3.getUuid(), r3);

        HashMap<UUID, Reservation> loadedReservations = PersistenceService.loadReservations();

        assertEquals("Size of loaded reservations is not correct", reservations.size(), loadedReservations.size());

        Reservation r1Loaded = loadedReservations.get(r1.getUuid());
        Reservation should = reservations.get(r1.getUuid());
        assertTrue("Reservation is not the same after loading from file", should.equals(r1Loaded));
    }
}
