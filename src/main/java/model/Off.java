package model;

import java.util.ArrayList;
import java.util.Date;

public class Off {
    public static ArrayList<Off> allOffs = new ArrayList<>();
    private int id;
    private OffStatus status;
    public ArrayList<Good> products;
    public String startTime;
    public String endTime;
    public int discount;
    private Seller seller;

    public Off(Seller seller, int id, ArrayList<Good> products, String startTime, String endTime, int discount) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
        this.products = products;
        this.status = OffStatus.creating;
        this.seller= seller;
        for (Good product : products) {
            product.isInOff = true;
            product.setOffId(id);
        }
        seller.allOffs.add(this);
        allOffs.add(this);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void addGoodToOff(Good good)throws Exception{
        if(!good.isInOff) {
            products.add(good);
            good.setOffId(id);
            good.isInOff = true;
        }
        throw new Exception("Already In An Off");
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
