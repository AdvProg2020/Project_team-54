package model;

import java.util.ArrayList;
import java.util.HashMap;

public class AuctionComment {
    private Auction auction;
//    private HashMap<String,String>
    private ArrayList<String> commenter = new ArrayList<>();
    private ArrayList<String> message = new ArrayList<>();

    public AuctionComment(Auction auction) {
        this.auction = auction;
    }

    public void addMessage(String sellerUsername, String newMessage){
        commenter.add(sellerUsername);
        message.add(newMessage);
    }

    public String details(){
        String details = "";
        details += commenter.toString() + " : " + message.toString();
        return details;
    }
}
