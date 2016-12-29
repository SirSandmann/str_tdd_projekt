package testsuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import serviceTest.BlacklistServiceTest;
import serviceTest.CustomerServiceTest;
import serviceTest.EventServiceTest;
import serviceTest.PersistenceServiceTest;
import serviceTest.ReservationServiceTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
		CustomerServiceTest.class,
		EventServiceTest.class,
		ReservationServiceTest.class,
		PersistenceServiceTest.class,
		ReservationServiceTest.class,
		BlacklistServiceTest.class
})

public class ServiceTestSuite {


}
