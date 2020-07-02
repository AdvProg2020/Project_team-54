package model.Requests;

import ScenesAndControllers.AlertBox;
import ScenesAndControllers.Manager;
import model.Role;
import model.Seller;

import java.util.ArrayList;

public class RequestNewSeller extends Request {
    private String requestType = "NewSeller";
    private String companyName;
    private String username;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private static ArrayList<RequestNewSeller> allRequestNewSeller = new ArrayList<>();
    private String whoRequested;

    public RequestNewSeller(String username, String name, String lastName,
                         String phoneNumber, String email, String password, String companyName) {
        super();
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        allRequestNewSeller.add(this);
        this.id = giveId();
        this.request = "RequestSeller";
    }

    public String getRequestType() {
        return requestType;
    }

    public String getWhoRequested() {
        return whoRequested;
    }

    public void setWhoRequested(String whoRequested) {
        this.whoRequested = whoRequested;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<RequestNewSeller> getAllRequestSeller() {
        return allRequestNewSeller;
    }

    public void denyRequest(){
        this.status = RequestConfirmation.Denied;
        //delete beshe az kolesh?!
        AlertBox.display("Request denied");
    }

    public void acceptRequest(int id){
        this.status = RequestConfirmation.Accepted;
        Seller seller = new Seller(username,name,lastName,email,phoneNumber,password, companyName, Role.seller);
        Manager.allActiveSeller.add(seller);
        seller.setCompanyName(companyName);
        AlertBox.display("Request accepted");
    }

//    @Override
//    public String getDetails() {
//        String details = "";
//        details += "Request for Seller with id " + this.id + "\n";
//        details += companyName + "\n";
//        details += username + "\n";
//        details += name + "\n";
//        details += lastName + "\n";
//        details += phoneNumber + "\n";
//        details += email + "\n";
//        details += password + "\n";
//        return details;
//    }

    @Override
    public String toString(){
        String details = "";
        details += "Request for Seller with id " + this.id + "\n";
        details += "Company Name: " + companyName + "\n";
        details += "username: " + username + "\n";
        details += "name: " + name + "\n";
        details += "last name: " + lastName + "\n";
        details += "phoneNumber: " + phoneNumber + "\n";
        details += "email: " + email + "\n";
        details += "password: " + password + "\n";
        return details;
    }
}
