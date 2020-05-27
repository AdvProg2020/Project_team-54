package main.java.model;

import java.util.ArrayList;
import java.util.Date;

public class Off {
    private int id;
    private OffStatus status;
    public ArrayList<Good> products;
    public Date startTime;
    public Date endTime;
    public int discount;

    public Off(int id, Date startTime, Date endTime, int discount, ArrayList<Good> products) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
        this.products = products;
        this.status = OffStatus.creating;
    }

    public int getId() {
        return id;
    }

    public void setStatus(OffStatus status) {
        this.status = status;
    }
}
