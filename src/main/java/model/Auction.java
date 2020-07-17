package model;

import ScenesAndControllers.AlertBox;

import java.util.ArrayList;

public class Auction {
    private static ArrayList<Auction> allAuctions = new ArrayList<>();
    private String sellerUsername;
    private int goodId;
    private int highestPrice;
    private String startTime;
    private String endTime;
    private AuctionComment auctionComment;

    public Auction(String sellerUsername, int goodId, String startTime, String endTime) {
        this.sellerUsername = sellerUsername;
        this.goodId = goodId;
        this.startTime = startTime;
        this.endTime = endTime;
        allAuctions.add(this);
        auctionComment = new AuctionComment(this);
    }

    public static ArrayList<Auction> getAllSellerAuction(String sellerUsername){
        ArrayList<Auction> sellerAuctions = new ArrayList<>();
        for (Auction auction : allAuctions) {
            if(auction.sellerUsername.equals(sellerUsername)){
                sellerAuctions.add(auction);
            }
        }
        if(allAuctions.size()==0){
            AlertBox.display("This seller has no active auction");
            return null;
        }
        return sellerAuctions;
    }

    public static ArrayList<Auction> getAllAuctions(){
        return allAuctions;
    }

    public AuctionComment getAuctionComment() {
        return auctionComment;
    }
}