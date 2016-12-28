package service;

import java.util.ArrayList;

public class BlacklistService {
	public static ArrayList<String> blacklist = new ArrayList<String>();
	
	public BlacklistService(){
		blacklist.add("Miese Peter");
		blacklist.add("Ärgermacher");
		blacklist.add("Provokateur");
	}
	

	public ArrayList<String> getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(ArrayList<String> blacklist) {
		this.blacklist = blacklist;
	}
	
	public boolean isInBlacklist(String s){
		if(blacklist.contains(s)){
			return true;
		}else{
			return false;
		}
	}

}
