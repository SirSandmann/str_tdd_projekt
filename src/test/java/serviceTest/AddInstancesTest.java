package serviceTest;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.EventSameDateAndTitleException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;

public class AddInstancesTest {

    @Before
    public void clearAllLists() {
        Reservation.clearReservations();
    }

    @Test
    public void testCreateReservation() throws EventSameDateAndTitleException, NotUniqueIdentifierException, CustomerSameNameException {
        ArrayList<Reservation> referenceList = new ArrayList<Reservation>();
        Event event = new Event("EventTitle", new Date(), 59.99, 10000);
        Customer customer = new Customer("Peter CustName", "Ricklinger Stadtweg 120");
        Reservation reservation = new Reservation(customer, event, 5000);
        referenceList.add(reservation);

        assertArrayEquals("Not complete List retrieved", referenceList.toArray(), Reservation.getReservations().toArray());
    }

}
