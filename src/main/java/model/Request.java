package model;

import java.util.ArrayList;

import static model.RequestConfirmation.*;

public class Request {
    private int id;
    //private boolean isAccepted;
    private static int allRequestsMade;
    private RequestConfirmation status;
    private String request;
    private static ArrayList<Request> allRequests = new ArrayList<>();

    public Request(String request){
        this.id = giveId();
        this.request = request;
        this.status = NoAction;
        allRequests.add(this);
    }

    public int getId() {
        return id;
    }

    public int giveId() {
        allRequestsMade++;
        return allRequestsMade;
    }

    public static ArrayList<Request> getAllRequests() {
        return allRequests;
    }

    public RequestConfirmation getStatus() {
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

    public static boolean isThereRequestById(int id){
        for (Request request:allRequests) {
            if (request.getId() == id)
                return true;
        }
        return false;
    }

    public void denyRequest(){
        this.status = RequestConfirmation.Denied;

        //allRequests.remove(denyRequest);
    }

    public void acceptRequest(int id){
        this.status = RequestConfirmation.Accepted;
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
