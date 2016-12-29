package service;

import java.util.ArrayList;

public class BlacklistService {
	
	public static ArrayList<String> blacklist = new ArrayList<String>();
	
	static{
		blacklist.add("Miese Peter");
		blacklist.add("Ärgermacher");
		blacklist.add("Provokateur");
	}	
	
	public static boolean isInBlacklist(String s) throws Exception{
		if(blacklist.contains(s)){
			return true;
		}else{
			return false;
		}
	}

}
