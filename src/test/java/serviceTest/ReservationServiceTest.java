package serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import custom_exceptions.NotEnoughFreeSeatsException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;
import service.CustomerService;
import service.EventService;
import service.ReservationService;

public class ReservationServiceTest {

    private Event e;

    @Before
    public void reset() {
        CustomerService.reset();
        EventService.reset();
        ReservationService.reset();

        String email = "test@test.de";
        Integer freeSeats = 2000;
        String name = "König der Löwen";
        Double price = 129.99;
        e = new Event(name, new Date(), price, freeSeats, email);
    }

    @Test
    public void addReservation() throws Exception {
        EventService.addEvent(e);
        assertEquals("Odd number of elements in events collection", 1, EventService.getEvents().size());
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        assertEquals("Odd number of elements in customers collection", 1, CustomerService.getCustomers().size());
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        assertEquals("Collection must be empty", 0, ReservationService.getReservations().size());
        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r);
        assertEquals("Odd number of elements in reservations collection", 1, ReservationService.getReservations().size());

        Reservation rGet = ReservationService.getReservations().get(r.getUuid());

        assertTrue("Added customer is not correct persisted", r.equals(rGet));
    }

    @Test
    public void addDoubleReservation() throws Exception {
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r);
        assertEquals("Odd number of elements in reservations collection", 1, ReservationService.getReservations().size());

        Reservation r2 = new Reservation(cGet.getName(), eGet.getUuid(), 2);
        ReservationService.addReservation(r2);
        assertEquals("Odd number of elements in reservations collection", 1, ReservationService.getReservations().size());

        Reservation r1Get = ReservationService.getReservations().get(r.getUuid());
        Reservation r2Get = ReservationService.getReservations().get(r2.getUuid());
        Integer shouldSeats = 5;

        assertEquals("Seat number not incremented on second reservation", shouldSeats, r2Get.getSeats());
        assertEquals("Old reservation is not removed", null, r1Get);
    }

    @Test
    public void findReservation() throws Exception {
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r);

        Reservation rFound = ReservationService.findReservation(c.getName(), e.getUuid());
        assertTrue("Objects are not equals", r.equals(rFound));
    }

    @Test
    public void findNullReservation() throws Exception {
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r);

        Reservation rFound = ReservationService.findReservation(c.getName(), UUID.randomUUID());
        assertEquals("Reservation should not be found", null, rFound);
    }

    @Test(expected = NotEnoughFreeSeatsException.class)
    public void rejectReservation() throws Exception {
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 1999);
        ReservationService.addReservation(r);
        Reservation r2 = new Reservation(cGet.getName(), eGet.getUuid(), 1);
        ReservationService.addReservation(r2);
        Reservation r3 = new Reservation(cGet.getName(), eGet.getUuid(), 1);
        ReservationService.addReservation(r3);
    }

    @Test
    public void getFreeSeats() throws Exception {
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r);

        Integer freeSeats = ReservationService.getFreeSeats(e.getUuid());
        Integer shouldFreeSeats = 1997;

        assertEquals("Free seats are not correct calculated", shouldFreeSeats, freeSeats);
    }

    @Test(expected = NotUniqueIdentifierException.class)
    public void addDuplicateReservation() throws Exception {
        EventService.addEvent(e);
        Event eGet = EventService.getEvents().get(e.getUuid());

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);
        Customer cGet = CustomerService.getCustomers().get(c.getName());

        Reservation r = new Reservation(cGet.getName(), eGet.getUuid(), 3);
        ReservationService.addReservation(r);
        ReservationService.addReservation(r);
    }
}
