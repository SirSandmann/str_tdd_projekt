package serviceTest;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import custom_exceptions.NameOnBlacklistException;
import model.Customer;
import model.Event;
import model.Reservation;
import service.BlacklistService;

@RunWith(MockitoJUnitRunner.class)
public class BlacklistServiceTest {

    @Mock
    private BlacklistService blacklistService;

    //Name in Blacklist exception
	@SuppressWarnings("unused")
	@Test(expected = NameOnBlacklistException.class)
	public void testBlacklistServiceInBlacklist() throws Exception {
		// get random customer on Blacklist
		Customer c = new Customer(
				BlacklistService.blacklist.get(new Random().nextInt(BlacklistService.blacklist.size())),
				"some Address");
		Event e = new Event("Aufführung", new Date(), 59.99, 15000);
		Reservation r = new Reservation(c.getName(), e.getUuid(), 50);
	}
	
	
	@SuppressWarnings("unused")
	@Test
	public void testBlacklistServiceNotInBlacklist() throws Exception {
		// get random customer on Blacklist
		Customer c = new Customer("Peter Mitbenehmen","some Address");
		Event e = new Event("Aufführung", new Date(), 59.99, 15000);
		Reservation r = new Reservation(c.getName(), e.getUuid(), 50);
	}
	
	

}
