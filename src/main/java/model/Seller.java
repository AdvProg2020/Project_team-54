package model;
import model.Requests.Request;

import java.util.ArrayList;

public class Seller extends Account {
    private String companyName;
    private static ArrayList<Seller> allSellers = new ArrayList<>();
    private ArrayList<SellLog> sellLog;
    private ArrayList<Products> allProducts = new ArrayList<>();
    private ArrayList<Request> allSellersRequests = new ArrayList<>();
    private double credit;

    public Seller(String username, String name, String lastName, String email,
                  String telephonNumber, String password,Role role) {
        super(username,name,lastName,telephonNumber,email,password,role);
        allSellers.add(this);
    }

    public ArrayList<Seller> getAllSellers() {
        return allSellers;
    }

    public ArrayList<SellLog> getSellLog() {
        return sellLog;
    }

    public ArrayList<Products> getAllProducts() {
        return allProducts;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<SellLog> sellLogs(){
        return sellLog;
    }

    private void manageProducts(){

    }

    private void addProduct(Good newProduct){

    }

    private void removeProduct(int productId){

    }

    private void showCategories(){

    }

    public String details(){
        String details="";
        details += "Username: " + this.getUsername() + "\n";
        details += "Full Name: " + this.getName() + " " + this.getLastName() + "\n";
        details += "Email: " + this.getEmail() + "\n";
        details += "Telephone Number: " + this.getPhoneNumber() + "\n";
        details += "Company Name: " + this.companyName + "\n";
        details += "Role: " + this.getRole() + "\n";

        return details;
    }

}
