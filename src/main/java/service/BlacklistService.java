package service;

import java.util.ArrayList;

public class BlacklistService {
    private ArrayList<String> blacklist = new ArrayList<>();

    public BlacklistService() {
        blacklist.add("Miese Peter");
        blacklist.add("Ärgermacher");
        blacklist.add("Provokateur");
    }

    public boolean isInBlacklist(String s) {
        return blacklist.contains(s);
    }
}
