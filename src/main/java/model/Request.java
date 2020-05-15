package main.java.model;

import java.util.ArrayList;

import static main.java.model.RequestConfirmation.NoAction;

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

    //    public boolean isAccepted() {
//        return isAccepted;
//    }

//    public void setAccepted(boolean status) {
//        isAccepted = status;
//    }

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

    public static void denyRequest(int id){
        Request denyRequest = getRequestById(id);
        allRequests.remove(denyRequest);
    }

    public static void acceptRequest(int id){

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
