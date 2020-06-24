package model;

import java.util.ArrayList;
import java.util.Date;

public class Off {
    public static ArrayList<Off> allOffs = new ArrayList<>();
    private int id;
    private OffStatus status;
    public ArrayList<Good> products;
    public Date startTime;
    public Date endTime;
    public int discount;

    //tu vorodi,  ArrayList<Good> products , pak shod
    public Off(int id, Date startTime, Date endTime, int discount) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
//        this.products = products;
        this.status = OffStatus.creating;
    }

    public void addGoodToOff(Good good){
        products.add(good);
    }

    public static Off getOffById(int id){
        for (Off off: allOffs) {
            if(off.getId() == id)
                return off;
        }
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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
        return products;
    }

    public void setOffProducts(ArrayList<Good> offProducts) {
        this.products = offProducts;
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
        return discount;
    }

    public void setAmountOfOff(int amountOfOff) {
        this.discount = amountOfOff;
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
