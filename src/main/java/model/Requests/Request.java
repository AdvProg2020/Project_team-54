package model.Requests;

import java.util.ArrayList;
import java.util.Random;

import static model.Requests.RequestConfirmation.*;

public class Request {
    protected int id;
    private int allRequestsMade;
    protected RequestConfirmation status = NoAction;
    protected String request;
    private static ArrayList<Request> allRequests = new ArrayList<>();

    public Request(){
        //this.request = request;
        this.id = allRequestsMade++;
        allRequests.add(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(RequestConfirmation status) {
        this.status = status;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getId() {
        return id;
    }

    public int giveId() {
        Random random = new Random();
        int upperBound = 1000000000;
        int id = random.nextInt(upperBound);
        allRequestsMade++;
        return id;
    }

    public static ArrayList<Request> getAllRequests() {
        return allRequests;
    }

    public model.Requests.RequestConfirmation getStatus() {
        return status;
    }

    public static Request getRequestById(int id){
        for (Request request:allRequests) {
            if(request.getId()==id){
                return request;
            }
        }
        return null;
    }

    public void denyRequest(){
        this.status = model.Requests.RequestConfirmation.Denied;
        //allRequests.remove(denyRequest);
    }

    public void acceptRequest(int id){
        this.status = model.Requests.RequestConfirmation.Accepted;
    }

    public void removeRequest(Request request){
        allRequests.remove(request);
    }

    public String getDetails(){
        String details = "";
        return details;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", request=" + request +
                ", status='" + status + '\'' +
                '}';
    }
}
