package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BuyLog extends Log{
    private double amountPaid;
    private int logId;
    private int saleCode;
    private String date;
    private double discountApplied;
    private HashMap <Good , Integer> boughtProducts = new HashMap<>();
    private String buyerName;
    private static ArrayList<BuyLog> allBuyLogs = new ArrayList<>();
    private LogStatus logStatus;

    public BuyLog(double amountPaid, int saleCode, HashMap<Good,Integer> boughtProducts, String buyerName, int logId, Date logDate){
        this.amountPaid = amountPaid;
        this.saleCode = saleCode;
        this.boughtProducts = boughtProducts;
        this.buyerName = buyerName;
        this.logId = logId;
        this.logStatus = LogStatus.INPROGRESS;
    }

    public void addProducts(Good good, int number){
        this.boughtProducts.put(good,number);
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public HashMap<Good, Integer> getBoughtProducts() {
        return boughtProducts;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public static ArrayList<BuyLog> getAllBuyLogs() {
        return allBuyLogs;
    }

    public LogStatus getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus;
    }
}