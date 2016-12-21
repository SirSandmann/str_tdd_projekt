package testsuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import modelTest.CustomerTest;
import modelTest.EventTest;
import modelTest.ReservationTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({

   CustomerTest.class,
   ReservationTest.class,
   EventTest.class
   
})

public class ModelTestSuite {
	
	
}
