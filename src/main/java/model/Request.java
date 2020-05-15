package main.java.model;

import java.util.ArrayList;

public class Request {
    private int id;
    private boolean isAccepted;
    //private RequestConfirmation status;
    private String request;
    private static ArrayList<Request> allRequests = new ArrayList<>();

    public Request(int id,String request){
        this.id = id;
        this.request = request;
        allRequests.add(this);
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

//    public boolean isAccepted() {
//        return isAccepted;
//    }

//    public void setAccepted(boolean status) {
//        isAccepted = status;
//    }

    public static ArrayList<Request> getAllRequests() {
        return allRequests;
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

//    public static void deleteDeniedRequests(){
//        for (Request request:allRequests) {
//
//        }
//    }




}
