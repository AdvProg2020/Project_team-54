package model;

import java.util.ArrayList;
import java.util.HashMap;

public class AuctionComment {
    private Auction auction;
//    private HashMap<String,String>
    private ArrayList<String> senders = new ArrayList<>();
    private ArrayList<String> message = new ArrayList<>();

    public AuctionComment(Auction auction) {
        this.auction = auction;
    }

    public void addMessage(String senderUsername, String newMessage){
        senders.add(senderUsername);
        message.add(newMessage);
    }

    public AuctionComment getAuctionComments(Auction auction){
        for (Auction auc:Auction.getAllAuctions()) {
            if(auc.equals(auction))
                return auc.getAuctionComment();
        }
        return null;
    }

    public String details(){
        String details = "";
        details += senders.toString() + " : " + message.toString();
        return details;
    }
}
