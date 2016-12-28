package modelTest;

import model.Reservation;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ReservationTest {
    private UUID uuid = UUID.randomUUID();
    private UUID eventUuid = UUID.randomUUID();
    private String customerName = "Klaus";
    private Integer seats = 3;

    @Test
    public void getUuid() throws Exception {
        Reservation r = new Reservation(customerName, eventUuid, seats);

        assertTrue(r.getClass().getMethod("getUuid") != null);
        assertNotEquals("UUID should be unique", uuid, r.getUuid());
    }

    @Test
    public void getCustomerName() throws Exception {
        Reservation r = new Reservation(customerName, eventUuid, seats);

        assertTrue(r.getClass().getMethod("getCustomerName") != null);
        assertEquals("Name is not equal", customerName, r.getCustomerName());
    }

    @Test
    public void getEventUuid() throws Exception {
        Reservation r = new Reservation(customerName, eventUuid, seats);

        assertTrue(r.getClass().getMethod("getEventUuid") != null);
        assertEquals("EventUuid is not equal", eventUuid, r.getEventUuid());
    }

    @Test
    public void getSeats() throws Exception {
        Reservation r = new Reservation(customerName, eventUuid, seats);

        assertTrue(r.getClass().getMethod("getSeats") != null);
        assertEquals("Seats are not equal", seats, r.getSeats());
    }

    @Test
    public void equals() throws Exception {
        Reservation r1 = new Reservation(customerName, eventUuid, seats);
        Reservation r2 = new Reservation(customerName, eventUuid, seats);

        assertTrue(r1.getClass().getMethod("equals", Reservation.class) != null);
        assertNotEquals("Objects should not be the same. Different UUID", r1.equals(r2));
    }
}
