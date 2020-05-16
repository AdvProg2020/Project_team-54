package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DiscountCode {
    private ArrayList<DiscountCode> allDiscountCodes = new ArrayList<>();
    private int id;
    public Date startTime;
    public Date endTime;
    public double amount;
    private int totalUsed;
    private ArrayList<Buyer> buyersHaveIt = new ArrayList<>();
//    private HashMap<Buyer , Integer> buyers = new HashMap<Buyer , Integer>();
//    private ArrayList<Buyer> allBuyers = new ArrayList<Buyer>();

    public DiscountCode(int id, ArrayList<Buyer> buyers, Date startTime, Date endTime, double amount) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        allDiscountCodes.add(this);
    }

    public boolean isThereDiscountCodeWithId(String code){
        for (DiscountCode discountCode:allDiscountCodes) {
            if (discountCode.getId() == id)
                return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public double getAmount() {
        return amount;
    }

    public ArrayList<Buyer> getBuyersHaveIt() {
        return buyersHaveIt;
    }

    private void eachBuyerUsed(){

    }

}
