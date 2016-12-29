package serviceTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import model.Customer;
import model.Event;
import model.Reservation;
import service.EmailEventOrganizerServiceMock;

@RunWith(MockitoJUnitRunner.class)
public class EmailEventOrganizerServiceTest {

    @Mock
    private EmailEventOrganizerServiceMock emailEventOrganizerServiceMock;
    
	@Test
	public void EmailEventOrganizer() throws Exception {
		// exactly 10% of the free seats
		String mailAddress = "Testmail@Test.de";
		Customer c = new Customer("Hans GuterBesucher", "some Address");
		Event e = new Event("Aufführung", new Date(), 59.99, 100);
		Reservation r = new Reservation(c.getName(), e.getUuid(), 10);
		HashMap<String, Reservation> returnVal = new HashMap<String, Reservation>();
		returnVal.put(mailAddress, r);
		if( r.getSeats() * 1.0 / e.getSeats() >= 0.1){
			when(emailEventOrganizerServiceMock.checkReservation(any(Reservation.class))).thenReturn(returnVal);
		}
		assertEquals("Didn't Match", emailEventOrganizerServiceMock.checkReservation(r), returnVal);
		
	}
	
	@Test
	public void testBlacklistServiceInBlacklist() throws Exception {
		// under 10% of the seats
		String mailAddress = "Testmail@Test.de";
		Customer c = new Customer("Hans GuterBesucher", "some Address");
		Event e = new Event("Aufführung", new Date(), 59.99, 100);
		Reservation r = new Reservation(c.getName(), e.getUuid(), 9);
		HashMap<String, Reservation> returnVal = new HashMap<String, Reservation>();
		returnVal.put(mailAddress, r);
		if( r.getSeats() * 1.0 / e.getSeats() >= 0.1){
			when(emailEventOrganizerServiceMock.checkReservation(any(Reservation.class))).thenReturn(returnVal);
		}
		assertNotEquals(emailEventOrganizerServiceMock.checkReservation(r), returnVal);

	}

}
