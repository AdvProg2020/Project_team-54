package model;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SellLog extends Log {
    private int logId;
    private Date date;
    private double amountReceived;
    private double deductedAmount;
    private ArrayList<Good> allSoldProducts = new ArrayList<>();
    private HashMap<Good,Integer> soldProducts;
    private String buyerName;
    private static ArrayList<SellLog> allSellLogs = new ArrayList<>();
    private LogStatus status;
    private String allProductsInOneString;
    // sending status

    public SellLog(Buyer buyer, double amountReceived, HashMap<Good,Integer> soldProducts){
        this.buyerName = buyer.getUsername();
        this.amountReceived = amountReceived;
        this.date = Date.from(ZonedDateTime.now().toInstant());
        this.soldProducts = soldProducts;
        this.logId = giveId();
        this.allProductsInOneString = createAllProductsInOneString();
        allSellLogs.add(this);
    }



    public int giveId(){
        int sellLogId = allSellLogs.size();
        sellLogId++;
        return sellLogId;
    }

    public String getAllProductsInOneString() {
        return allProductsInOneString;
    }

    public String createAllProductsInOneString() {
        StringBuilder products = new StringBuilder();
        for (Good good : soldProducts.keySet()) {
            products.append(good.getName()).append(" - ").append(soldProducts.get(good)).append(" , ");
        }
        return products.toString();
    }

    public String getStringDate() {
        return date.toString();
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