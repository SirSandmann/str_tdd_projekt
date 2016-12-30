package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import model.Event;

public class EventTest {
    private Event e;
    private UUID uuid = UUID.randomUUID();
    private String title = "König der Löwen";
    private Date date = new Date();
    private Double price = 129.99;
    private Integer seats = 2000;
    private String email = "test@test.de";

    private double DELTA = 1e-5;

    @Before
    public void initEvent(){
        e = new Event(title, date, price, seats, email);
    }

    @Test
    public void getUuid() throws Exception {
        assertTrue(e.getClass().getMethod("getUuid") != null);
        assertNotEquals("UUID should be unique", uuid, e.getUuid());
    }

    @Test
    public void getTitle() throws Exception {
        assertTrue(e.getClass().getMethod("getTitle") != null);
        assertEquals("Retrieved wrong value", title, e.getTitle());
    }

    @Test
    public void getDate() throws Exception {
        assertTrue(e.getClass().getMethod("getDate") != null);
        assertEquals("Retrieved wrong value", date, e.getDate());
    }

    @Test
    public void getPrice() throws Exception {
        assertTrue(e.getClass().getMethod("getPrice") != null);
        assertEquals("Retrieved wrong value", price, e.getPrice(), DELTA);
    }

    @Test
    public void getSeats() throws Exception {
        assertTrue(e.getClass().getMethod("getSeats") != null);
        assertEquals("Retrieved wrong value", seats, e.getSeats(), DELTA);
    }

    @Test
    public void getEmail() throws Exception {
        assertTrue(e.getClass().getMethod("getEmail") != null);
        assertEquals("Retrieved wrong value", email, e.getEmail());
    }

    @Test
    public void equals() throws Exception {
        Event e2 = new Event(title, date, price, seats, email);

        assertTrue(e.getClass().getMethod("equals", Event.class) != null);
        assertNotEquals("Objects should not be the same. Different UUID", e.equals(e2));
    }
}
