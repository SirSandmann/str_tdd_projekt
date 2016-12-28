package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import model.Event;

public class EventTest {
    private UUID uuid = UUID.randomUUID();
    private String title = "König der Löwen";
    private Date date = new Date();
    private Double price = 129.99;
    private Integer seats = 2000;

    private double DELTA = 1e-5;

    @Test
    public void getUuid() throws Exception {
        Event e = new Event(title, date, price, seats);

        assertTrue(e.getClass().getMethod("getUuid") != null);
        assertNotEquals("UUID should be unique", uuid, e.getUuid());
    }

    @Test
    public void getTitle() throws Exception {
        Event e = new Event(title, date, price, seats);

        assertTrue(e.getClass().getMethod("getTitle") != null);
        assertEquals("Retrieved wrong value", title, e.getTitle());
    }

    @Test
    public void getDate() throws Exception {
        Event e = new Event(title, date, price, seats);

        assertTrue(e.getClass().getMethod("getDate") != null);
        assertEquals("Retrieved wrong value", date, e.getDate());
    }

    @Test
    public void getPrice() throws Exception {
        Event e = new Event(title, date, price, seats);

        assertTrue(e.getClass().getMethod("getPrice") != null);
        assertEquals("Retrieved wrong value", price, e.getPrice(), DELTA);
    }

    @Test
    public void getSeats() throws Exception {
        Event e = new Event(title, date, price, seats);

        assertTrue(e.getClass().getMethod("getSeats") != null);
        assertEquals("Retrieved wrong value", seats, e.getSeats(), DELTA);
    }

    @Test
    public void equals() throws Exception {
        Event e1 = new Event(title, date, price, seats);
        Event e2 = new Event(title, date, price, seats);

        assertTrue(e1.getClass().getMethod("equals", Event.class) != null);
        assertNotEquals("Objects should not be the same. Different UUID", e1.equals(e2));
    }
}
