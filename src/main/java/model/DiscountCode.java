import java.util.ArrayList;
import java.util.Date;

public class DiscountCode {
    private String code;
    public Date startTime;
    public Date endTime;
    public int amount;
    private ArrayList<Buyer> buyers = new ArrayList<>();

    public DiscountCode(String code, ArrayList<Buyer> buyers, Date startTime, Date endTime, int amount) {
        this.code = code;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        this.buyers = buyers;
    }

    private void eachBuyerUsed(){

    }

}
