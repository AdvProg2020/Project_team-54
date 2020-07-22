package model;

import java.util.ArrayList;

public class SupporterChat {
    private String supporterUsername;
    private String userUsername;
    private ArrayList<String> sender = new ArrayList<>();
    private ArrayList<String> message = new ArrayList<>();
    private static ArrayList<SupporterChat> allSupporterChats = new ArrayList<>();

    public SupporterChat(String supporterUsername, String userUsername) {
        this.supporterUsername = supporterUsername;
        this.userUsername = userUsername;
        allSupporterChats.add(this);
    }

    public void addMessage(String sender, String message){
        this.sender.add(sender);
        this.message.add(message);
    }

    public String getSupporterUsername() {
        return supporterUsername;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public String getMessages() {
        return sender.toString() + " : " + message.toString();
    }

    //chat haye supporter va user
}
