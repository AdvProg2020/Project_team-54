package model.Requests;

import model.Role;
import model.Seller;

import java.util.ArrayList;

public class RequestNewSeller extends Request {
    private String companyName;
    private String username;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private ArrayList<RequestNewSeller> allRequestNewSeller = new ArrayList<>();

    public RequestNewSeller( String username, String name, String lastName,
                         String phoneNumber, String email, String password) {
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
    }

    public void acceptRequest(){
        this.status = RequestConfirmation.Accepted;
        Seller seller = new Seller(username,name,lastName,email,phoneNumber,password, Role.seller);
        seller.setCompanyName(companyName);
    }

    @Override
    public String toString(){
        String details = "";
        details += "Request for Seller with id " + this.id + "\n";
        details += companyName + "\n";
        details += username + "\n";
        details += name + "\n";
        details += lastName + "\n";
        details += phoneNumber + "\n";
        details += email + "\n";
        details += password + "\n";
        return details;
    }
}