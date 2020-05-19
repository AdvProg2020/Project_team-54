package model;
import java.util.ArrayList;
import java.util.Date;

public class BuyLog extends Log{
    private double amountPaid;
    private int logId;
    private int saleCode;
    private String date;
    private double discountApplied;
    private ArrayList<Good> boughtProducts;
    private String sellerName;
    private static ArrayList<BuyLog> allBuyLogs = new ArrayList<>();
    private LogStatus logStatus;

    public BuyLog(double amountPaid, int saleCode, ArrayList<Good> boughtProducts, String sellerName, int logId, Date logDate){
        this.amountPaid = amountPaid;
        this.saleCode = saleCode;
        this.boughtProducts = boughtProducts;
        this.sellerName = sellerName;
        this.logId = logId;
        this.logStatus = LogStatus.INPROGRESS;
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