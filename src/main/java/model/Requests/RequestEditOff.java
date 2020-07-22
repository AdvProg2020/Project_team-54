package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Off;
import model.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RequestEditOff extends Request {
    private Off off;
    private String field;
    private String newInformation;
    private Seller seller;
    private ArrayList<RequestEditOff> allEditOffRequests = new ArrayList<>();

    public RequestEditOff(Off off, String field, String newInformation, Seller seller) {
        super();
        this.off = off;
        this.field = field;
        this.id = giveId();
        this.newInformation = newInformation;
        this.seller = seller;
        allEditOffRequests.add(this);
    }

    @Override
    public void acceptRequest(int id) {
//        super.acceptRequest(id);
        this.status = model.Requests.RequestConfirmation.Accepted;
        if(field.equalsIgnoreCase("startTime"))
            off.setStartTime(newInformation);
        else if(field.equalsIgnoreCase("endTime"))
            off.setEndTime(newInformation);
        else if(field.equalsIgnoreCase("discount"))
            off.setAmountOfOff(Integer.parseInt(newInformation));
        else
            AlertBox.display("cant change");
        getAllRequests().remove(this);
    }

    @Override
    public void denyRequest() {
        super.denyRequest();
    }

    public Off getOff() {
        return off;
    }

    public String getField() {
        return field;
    }

    public String getNewInformation() {
        return newInformation;
    }

    public Seller getSeller() {
        return seller;
    }

    public ArrayList<RequestEditOff> getAllEditOffRequests() {
        return allEditOffRequests;
    }

    @Override
    public String toString() {
        return "Edit Off Request With Id:" + this.getId() + "\n" +
                "Off ID: " + off.getId() + "\n" +
                "Seller With This Username Requested: " + seller.getUsername() + "\n" +
                "Editing: " + field + "\n" +
                "With New Information: " + newInformation;
    }

}
