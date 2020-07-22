package model;

import ScenesAndControllers.AlertBox;

import java.util.ArrayList;

public class Auction {
    private static ArrayList<Auction> allAuctions = new ArrayList<>();
    private String sellerUsername;
    private String buyerUsername;
    private int goodId;
    private int highestPrice;
    private String startTime;
    private String endTime;
    private AuctionComment auctionComment;

    public Auction(String sellerUsername, int goodId, String endTime) {
        this.sellerUsername = sellerUsername;
        this.goodId = goodId;
//        this.startTime = startTime; // hamun moqe auction shoro mishe?
        this.endTime = endTime;
        allAuctions.add(this);
        auctionComment = new AuctionComment(this);
        Good good = Good.getProductById(goodId);
        good.setInAuction(true);
    }

    public void newPrice(String buyerUsername, int highestPrice){
        // farz mikonim az qeymat qabli balatare
        this.buyerUsername = buyerUsername;
        this.highestPrice = highestPrice;
    }

    public static ArrayList<Auction> getAllSellerAuctions(String sellerUsername){
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

    public String getAuctionMessages(){
        return auctionComment.details();
    }

}