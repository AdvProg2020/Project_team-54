package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DiscountCode {
    private ArrayList<DiscountCode> allDiscountCodes = new ArrayList<>();
    private int id;
    private Date startTime;
    private Date endTime;
    private double percentage;
    private double maxAmount;
    private int buyerTotalUse;
    private ArrayList<Buyer> buyersWithThisDiscount = new ArrayList<>();
//    private HashMap<Buyer, Integer> buyersWithThisDiscount = new HashMap<>();
//    private HashMap<Buyer , Integer> buyers = new HashMap<Buyer , Integer>();
//    private ArrayList<Buyer> allBuyers = new ArrayList<Buyer>();

    public DiscountCode(int id, ArrayList<Buyer> buyers, Date startTime, Date endTime, double percentage, double maxAmount) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.percentage = percentage;
        allDiscountCodes.add(this);
    }

    public boolean isThereDiscountCodeWithId(String code){
        for (DiscountCode discountCode:allDiscountCodes) {
            if (discountCode.getId() == id)
                return true;
        }
        return false;
    }

    public ArrayList<DiscountCode> getAllDiscountCodes() {
        return allDiscountCodes;
    }

    public int getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setBuyerTotalUse(int buyerTotalUse) {
        this.buyerTotalUse = buyerTotalUse;
    }










//    public HashMap<Buyer, Integer> getBuyersWithThisDiscount() {
//        return buyersWithThisDiscount;
//    }

//    public void addBuyer(Buyer buyer){
//        buyersWithThisDiscount.put(buyer, this.buyerTotalUse);
//    }





}
