package serviceTest;

import custom_exceptions.NotUniqueIdentifierException;
import model.Event;
import org.junit.Before;
import org.junit.Test;
import service.EventService;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventServiceTest {
    private Event e;

    @Before
    public void reset() {
        EventService.reset();
        String email = "test@test.de";
        Integer freeSeats = 2000;
        String name = "König der Löwen";
        Double price = 129.99;
        e = new Event(name, new Date(), price, freeSeats, email);
    }

    @Test
    public void addEvent() throws NotUniqueIdentifierException {
        assertEquals("Collection must be empty", 0, EventService.getEvents().size());

        EventService.addEvent(e);

        assertEquals("Odd number of elements in events collection", 1, EventService.getEvents().size());

        Event eGet = EventService.getEvents().get(e.getUuid());

        assertTrue("Added customer is not correct persisted", e.equals(eGet));
    }

    @Test(expected = NotUniqueIdentifierException.class)
    public void addDuplicateEvent() throws NotUniqueIdentifierException {
        EventService.addEvent(e);
        EventService.addEvent(e);
    }
}
