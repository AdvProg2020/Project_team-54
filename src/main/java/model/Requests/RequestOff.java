package model.Requests;

import model.Good;
import model.Off;
import model.OffStatus;

import java.util.ArrayList;
import java.util.Date;

public class RequestOff extends Request {
    public static ArrayList<Off> allOffs = new ArrayList<>();
    private static ArrayList<RequestOff> allRequestOff = new ArrayList<>();
    private ArrayList<Good> products;
    private int offId;
    private OffStatus offStatus = OffStatus.creating;
    public Date startTime;
    public Date endTime;
    public int discount;

    public RequestOff(int id, ArrayList<Good> products, Date startTime, Date endTime, int discount) {
        super();
        this.products = products;
        this.offId = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
        allRequestOff.add(this);
    }

    @Override
    public void acceptRequest(int id) {
        this.status = RequestConfirmation.Accepted;
        offStatus = OffStatus.confirmed;
        Off off = new Off(offId, products, startTime, endTime, discount);
    }

    @Override
    public void denyRequest() {
        this.status = RequestConfirmation.Denied;
    }

    @Override
    public String toString() {
        int amount = discount % 100;
        String details = "";
        details += "off id: " + offId;
        details += "start time: " + startTime;
        details += "end time: " + endTime;
        details += "discount: " + amount;
        return details;
    }
}
