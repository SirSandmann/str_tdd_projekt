package testsuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import serviceTest.CustomerServiceTest;
import serviceTest.EventServiceTest;
import serviceTest.ReservationServiceTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
		CustomerServiceTest.class,
		EventServiceTest.class,
		ReservationServiceTest.class
})

public class ServiceTestSuite {


}
