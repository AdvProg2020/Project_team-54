package main.java.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DiscountCode {
    private ArrayList<DiscountCode> allDiscountCodes = new ArrayList<>();
    private String code;
    public Date startTime;
    public Date endTime;
    public double amount;
    private int totalUsed;
    private ArrayList<Buyer> buyersHaveIt = new ArrayList<>();
//    private HashMap<Buyer , Integer> buyers = new HashMap<Buyer , Integer>();
//    private ArrayList<Buyer> allBuyers = new ArrayList<Buyer>();

    public DiscountCode(String code, ArrayList<Buyer> buyers, Date startTime, Date endTime, double amount) {
        this.code = code;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        allDiscountCodes.add(this);
    }

    public String getCode() {
        return code;
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
