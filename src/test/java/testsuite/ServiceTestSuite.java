package testsuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import serviceTest.AddInstancesTest;
import serviceTest.ListInstancesTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({

	ListInstancesTest.class,
	AddInstancesTest.class
   
})

public class ServiceTestSuite {
	
	
}
