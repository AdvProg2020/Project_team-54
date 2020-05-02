package main.java.model;
import java.util.ArrayList;
import java.util.Date;

public class Manager extends Account {
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String telephonNumber;
    private String password;
    private ArrayList<String> allManagers;
    //public ArrayList<String> request;

    public Manager(String username, String name, String lastName, String email, String telephonNumber, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.telephonNumber = telephonNumber;
        this.password = password;
        //allManagers.add(this); username ya name?
    }
    private void personalInfo(){

    }
    private void manageUsers(){

    }
    private void manageAllProducts(){

    }
    private void createDiscountCode(String code, ArrayList<Buyer> buyers, Date startTime, Date endTime, int amount ){
        DiscountCode discountCode = new DiscountCode(code,buyers,startTime,endTime,amount);
    }
    private void viewDiscountCOdes(){

    }
    private void manageRequest(){

    }
    private void manageCategories(){

    }
}
