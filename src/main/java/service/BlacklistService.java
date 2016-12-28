package service;

import java.util.ArrayList;

import custom_exceptions.NameOnBlacklistException;

public class BlacklistService {
	public static ArrayList<String> blacklist = new ArrayList<String>();
	
	public BlacklistService(){
		blacklist.add("Miese Peter");
		blacklist.add("Ärgermacher");
		blacklist.add("Provokateur");
	}
	
	public boolean isInBlacklist(String s) throws Exception{
		if(blacklist.contains(s)){
			throw new NameOnBlacklistException();
		}else{
			return false;
		}
	}

}
