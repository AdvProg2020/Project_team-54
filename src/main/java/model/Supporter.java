package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Supporter {
    private String username;
    private String password;
    private static ArrayList<Supporter> allSupporters = new ArrayList<>();

    public Supporter(String userName, String password) {
        this.username = userName;
        this.password = password;
        allSupporters.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Supporter> getAllSupporters() {
        return allSupporters;
    }

    static Supporter getSupoorterByUsername(String username){
        for (Supporter supporter: allSupporters) {
            if(supporter.getUsername().equals(username))
                return supporter;
        }
        return null;
    }
}
