package model;
import java.util.ArrayList;

public class Seller {
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String telephonNumber;
    private String password;
    private double balance;
    private ArrayList<String> allSellers = new ArrayList<String>();
    //private ArrayList<Products> sellLog;

    public Seller(String username, String name, String lastName, String email, String telephonNumber, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.telephonNumber = telephonNumber;
        this.password = password;
        //allSellers.add(this);  username ya name??
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void viewPersonalInfo(){

    }

    private void viewCompanyInformation(){

    }

    private void viewSalesHistory(){

    }
    private void manageProducts(){

    }

    private void addProduct(Product newProduct){

    }

    private void removeProduct(int productId){

    }

    private void showCategories(){

    }

    private void viewOffs(){

    }

    private void viewBalance(){

    }


}
