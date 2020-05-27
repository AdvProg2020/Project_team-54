package main.java.model;
import java.util.ArrayList;
import java.util.Date;

public class SellLog extends Log {
    private String logId;
    private Date date;
    private double amountReceived;
    private double deductedAmount;
    private ArrayList<Good> soldProduct = new ArrayList<>();
    private Buyer buyerName;
    private static ArrayList<SellLog> allSellLogs = new ArrayList<>();
    private LogStatus status;
    // sending status

    public SellLog(Buyer buyer, double amountReceived, double deductedAmount, Date date){
        this.buyerName = buyer;
        this.amountReceived = amountReceived;
        this.deductedAmount = deductedAmount;
        this.date = date;
        allSellLogs.add(this);
    }

    public void addSoldProduct(ArrayList<Good> soldProduct) {
        this.soldProduct.addAll(soldProduct);
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public double getDeductedAmount() {
        return deductedAmount;
    }

    public ArrayList<Good> getSoldProduct() {
        return soldProduct;
    }

    public Buyer getBuyerName() {
        return buyerName;
    }

    public static ArrayList<SellLog> getAllSellLogs() {
        return allSellLogs;
    }

    public LogStatus getStatus() {
        return status;
    }
}