package model;
import java.util.ArrayList;
import java.util.Date;

public class Off {
    public static ArrayList<Off> allOffs = new ArrayList<>();
    private String id;
    private OffStatus status;
    public ArrayList<Good> offProducts;
    public Date startTime;
    public Date endTime;
    public int offAmount;

    public Off(String id, Date startTime, Date endTime, int amountOfOff) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.offAmount = amountOfOff;
    }

    public void addGoodToOff(Good good){
        offProducts.add(good);
    }

    public static Off getOffById(String id){
        for (Off off: allOffs) {
            if(off.getId().equals(id))
                return off;
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static ArrayList<Off> getAllOffs() {
        return allOffs;
    }

    public static void setAllOffs(ArrayList<Off> allOffs) {
        Off.allOffs = allOffs;
    }

    public OffStatus getStatus() {
        return status;
    }

    public void setStatus(OffStatus status) {
        this.status = status;
    }

    public ArrayList<Good> getOffProducts() {
        return offProducts;
    }

    public void setOffProducts(ArrayList<Good> offProducts) {
        this.offProducts = offProducts;
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

    public int getOffAmount() {
        return offAmount;
    }

    public void setAmountOfOff(int amountOfOff) {
        this.offAmount = amountOfOff;
    }

    public String details(){
        String details = "";
        details += "Off{ "+ "offId= " + this.getId() + "\n";
        details += "startTime: " + this.getStartTime() + "\n";
        details += "endTIme: " + this.getEndTime() + "\n";
        details += "offStatus: " + this.getStatus() + "\n";
        details += "offAmount: " + this.getOffAmount() + "\n";
        details += "Goods: " + this.getOffProducts();
        return details;
    }
}
