package model;
import java.util.ArrayList;

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
    private void createDiscountCode(){

    }
    private void viewDiscountCOdes(){

    }
    private void manageRequest(){

    }
    private void manageCategories(){

    }
}
