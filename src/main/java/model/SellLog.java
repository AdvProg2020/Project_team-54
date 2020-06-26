package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SellLog extends Log {
    private String logId;
    private Date date;
    private double amountReceived;
    private double deductedAmount;
    private ArrayList<Good> allSoldProducts = new ArrayList<>();
    private HashMap<Good,Integer> soldProducts = new HashMap<>();
    private String buyerName;
    private static ArrayList<SellLog> allSellLogs = new ArrayList<>();
    private LogStatus status;
    // sending status

    public SellLog(Buyer buyer, double amountReceived, double deductedAmount, Date date, HashMap<Good,Integer> soldProducts){
        this.buyerName = buyer.getUsername();
        this.amountReceived = amountReceived;
        this.deductedAmount = deductedAmount;
        this.date = date;
        this.soldProducts = soldProducts;
        allSellLogs.add(this);
    }

    public void addSoldProduct(ArrayList<Good> soldProduct) {
        this.allSoldProducts.addAll(soldProduct);
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public double getDeductedAmount() {
        return deductedAmount;
    }

    public ArrayList<Good> getAllSoldProducts() {
        return allSoldProducts;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public static ArrayList<SellLog> getAllSellLogs() {
        return allSellLogs;
    }

    public LogStatus getStatus() {
        return status;
    }
}