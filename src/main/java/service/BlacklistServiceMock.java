package service;

import java.util.ArrayList;

public interface BlacklistServiceMock {
	
	public static ArrayList<String> blacklist = new ArrayList<String>();	
	
	public boolean isInBlacklist(String s);

}
