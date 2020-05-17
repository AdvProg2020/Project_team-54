package model.Requests;

import model.Manager;
import model.Role;
import model.Seller;

import java.util.ArrayList;

public class RequestNewManager extends Request {
    private String username;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private ArrayList<RequestNewManager> allRequestNewManager = new ArrayList<>();

    public RequestNewManager(String username, String name, String lastName, String phoneNumber, String email, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.id = giveId();
        allRequestNewManager.add(this);
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

    public void denyRequest(){
        this.status = RequestConfirmation.Denied;
        //delete beshe az kolesh?!
    }

    public void acceptRequest(){
        this.status = RequestConfirmation.Accepted;
        Manager manager = new Manager(username,name,lastName,email,phoneNumber,password, Role.administrator);
    }

    public ArrayList<RequestNewManager> getAllRequestNewManager() {
        return allRequestNewManager;
    }

    @Override
    public String toString(){
        String details = "";
        details += "Request for new admin with id " + this.id + "\n";
        details += username + "\n";
        details += name + "\n";
        details += lastName + "\n";
        details += phoneNumber + "\n";
        details += email + "\n";
        details += password + "\n";
        return details;
    }

}
