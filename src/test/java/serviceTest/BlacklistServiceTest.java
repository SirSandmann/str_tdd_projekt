package serviceTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import custom_exceptions.NameOnBlacklistException;
import model.Customer;
import model.Event;
import model.Reservation;
import service.BlacklistService;
import service.CustomerService;
import service.EventService;
import service.ReservationService;

@RunWith(MockitoJUnitRunner.class)
public class BlacklistServiceTest {
	
	@Test
    public void isInBlacklist() throws Exception {
		BlacklistService blacklistService = new BlacklistService();
		assertTrue("Should not be null", blacklistService != null);
		assertTrue(blacklistService.getClass().getMethod("isInBlacklist", String.class) != null);
		
    }

    @Test(expected = NameOnBlacklistException.class)
    public void shouldRejectBlacklistedUser() throws Exception {
        BlacklistService blacklist = mock(BlacklistService.class);
        Customer c = new Customer("Provokateur", "some Address");
        CustomerService.addCustomer(c);

        when(blacklist.isInBlacklist(c.getName())).thenReturn(true);

        Event e = new Event("Aufführung", new Date(), 59.99, 15000, "test@test.de");
        EventService.addEvent(e);

        Reservation r = new Reservation(c.getName(), e.getUuid(), 50);
        ReservationService.setBlacklistService(blacklist);
        ReservationService.addReservation(r);

        // verify that mock was used
        verify(blacklist).isInBlacklist(c.getName());
    }
}
