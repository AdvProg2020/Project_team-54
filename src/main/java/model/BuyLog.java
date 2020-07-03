package model;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BuyLog extends Log{
    private double amountPaid;
    private int logId;
    private int saleCode;
    private Date date;
    private double discountApplied;
    private HashMap <Good , Integer> boughtProducts = new HashMap<>();
    private ArrayList<Good> productsList;
    private String buyerName;
    private static ArrayList<BuyLog> allBuyLogs = new ArrayList<>();
    private LogStatus logStatus;
    private String allProductsInOneString;



    public BuyLog(double amountPaid, HashMap<Good,Integer> boughtProducts, String buyerName, double discountApplied){
        // Date logDate pak shod az vorudish
        // int saleCode pak shod az vorudis
        this.discountApplied = discountApplied;
        this.amountPaid = amountPaid;
//        this.saleCode = saleCode;
        this.boughtProducts = boughtProducts;
        productsList = new ArrayList<>(boughtProducts.keySet());
        this.buyerName = buyerName;
        this.logId = giveId();
        this.logStatus = LogStatus.INPROGRESS;
        this.date = Date.from(ZonedDateTime.now().toInstant());
        allBuyLogs.add(this);
    }

    public String getStringDate() {
        return date.toString();
    }

    public ArrayList<Good> getBuyLogs() {
        return productsList;
    }

    public String getAllProductsInOneString() {
        String products = "";
        for (Good good : productsList) {
            products += good.getName() + " , " ;
        }
        return products;
    }

    public int giveId(){
        int buylogId = allBuyLogs.size();
        buylogId++;
        return buylogId;
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