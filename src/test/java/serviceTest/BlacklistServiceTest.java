package serviceTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import service.BlacklistServiceMock;

@RunWith(MockitoJUnitRunner.class)
public class BlacklistServiceTest {
	
	@Mock
	BlacklistServiceMock blackListServiceMock;

	@Test
	public void testBlacklistServiceInBlacklist() throws Exception {
		// get random customer on Blacklist
		String blackListName = "BlackListName";
		when(blackListServiceMock.isInBlacklist(blackListName)).thenReturn(true);
		assertTrue("Service should return true", blackListServiceMock.isInBlacklist(blackListName));
	}
	
	
	@Test
	public void testBlacklistServiceNotInBlacklist() throws Exception {
		// get random customer not on the Blacklist
		String nonBlackListName = "Peter GuterBesucher";
		when(blackListServiceMock.isInBlacklist(nonBlackListName)).thenReturn(false);
		assertFalse("Service should return false", blackListServiceMock.isInBlacklist(nonBlackListName));;
	}
	
}
