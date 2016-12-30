package serviceTest;

import custom_exceptions.CustomerSameNameException;
import custom_exceptions.NameOnBlacklistException;
import custom_exceptions.NotEnoughFreeSeatsException;
import custom_exceptions.NotUniqueIdentifierException;
import model.Customer;
import model.Event;
import model.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import service.*;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Test
    public void shouldSendEmail() throws NotUniqueIdentifierException, CustomerSameNameException, NotEnoughFreeSeatsException, NameOnBlacklistException {
        EmailService email = mock(EmailService.class);

        Customer c = new Customer("Klaus", "Musterstraße 1a");
        CustomerService.addCustomer(c);

        Event e = new Event( "König der Löwen", new Date(), 129.99, 2000, "test@test.de");
        EventService.addEvent(e);

        Reservation r = new Reservation(c.getName(),e.getUuid(), 250);
        ReservationService.setEmailService(email);
        ReservationService.addReservation(r);

        // verify that email was send with this mock
        verify(email).sendEmail(e.getEmail());
    }
}
