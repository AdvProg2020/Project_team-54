package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Good;
import model.Off;
import model.OffStatus;

import java.util.ArrayList;
import java.util.Date;

public class RequestOff extends Request {
    private String requestType = " Off";
    public static ArrayList<Off> allOffs = new ArrayList<>();
    private ArrayList<RequestOff> allRequestOff = new ArrayList<>();
    private int offId;
    private OffStatus offStatus = OffStatus.creating;
    public Date startTime;
    public Date endTime;
    public int discount;
    public ArrayList<Good> allProductsInSale;

    public RequestOff(int id,ArrayList<Good> products,  Date startTime, Date endTime, int discount) {
        super();
        this.allProductsInSale = products;
        this.offId = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
        allRequestOff.add(this);
    }

    public String getRequestType() {
        return requestType;
    }

    @Override
    public void acceptRequest(int id) {
        this.status = RequestConfirmation.Accepted;
        offStatus = OffStatus.confirmed;
        Off off = new Off(offId,allProductsInSale, startTime,endTime,discount);
        AlertBox.display("Request accepted");
    }

    @Override
    public void denyRequest() {
        this.status = RequestConfirmation.Denied;
        AlertBox.display("Request denied");
    }

    @Override
    public String toString() {
        int amount = discount%100;
        String details = "";
        details += "off id: " + offId;
        details += "start time: " + startTime;
        details += "end time: " + endTime;
        details += "discount: " + amount;
        return details;
    }
}
