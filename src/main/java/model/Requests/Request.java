package main.java.model.Requests;

import java.util.ArrayList;
import java.util.Random;

import static main.java.model.Requests.RequestConfirmation.*;

public class Request {
    protected int id;
    private int allRequestsMade;
    protected RequestConfirmation status = NoAction;
    protected String request;
    private static ArrayList<Request> allRequests = new ArrayList<>();

    public Request(){
        //this.request = request;
        allRequests.add(this);
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

    public main.java.model.Requests.RequestConfirmation getStatus() {
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
        this.status = main.java.model.Requests.RequestConfirmation.Denied;
        //allRequests.remove(denyRequest);
    }

    public void acceptRequest(int id){
        this.status = main.java.model.Requests.RequestConfirmation.Accepted;
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
