package model;
import ScenesAndControllers.Manager;
import model.Requests.Request;

import java.util.ArrayList;

public class Seller extends Account {
    private String companyName;
    private static ArrayList<Seller> allSellers = new ArrayList<>();
    private ArrayList<SellLog> sellLogs;
    private ArrayList<Good> allProducts;
    public ArrayList<Request> allRequests;
    private double credit;
    public ArrayList<Off> allOffs;


    public Seller(String username, String name, String lastName, String email,
                  String phoneNumber, String password, String companyName, Role role) {
        super(username,name,lastName, phoneNumber,email,password,role);
        Manager.allActiveAccounts.add(this);
        allSellers.add(this);
        this.companyName = companyName;
        this.allProducts = new ArrayList<>();
        this.allRequests = new ArrayList<>();
        this.sellLogs = new ArrayList<>();
        this.allOffs = new ArrayList<>();
    }

    public void addSellLog(SellLog sellLog) {
        this.sellLogs.add(sellLog);
    }


    public ArrayList<Request> getAllRequests() {
        return allRequests;
    }

    public ArrayList<Seller> getAllSellers() {
        return allSellers;
    }

    public ArrayList<SellLog> getSellLogs() {
        return sellLogs;
    }

    public ArrayList<Good> getAllProducts() {
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
        return sellLogs;
    }

    public void addProduct(Good newProduct){
        this.allProducts.add(newProduct);
    }

    public void removeProduct(int productId){
        this.allProducts.remove(getProductById(productId));
    }

    private ArrayList<Off> viewOffs(){
        return allOffs;
    }

    private void viewBalance(){
        //TODO
    }

    public String details() {
        String details = "";
        details += "Username: " + this.getUsername() + "\n";
        details += "Full Name: " + this.getFirstName() + " " + this.getLastName() + "\n";
        details += "Email: " + this.getEmail() + "\n";
        details += "Telephone Number: " + this.getPhoneNumber() + "\n";
        details += "Company Name: " + this.companyName + "\n";
        details += "Role: " + this.getRole() + "\n";
        return details;
    }
    private Good getProductById (int id) {
        for (Good product : this.allProducts) {
            if (product.getId() == id)
                return product;
        }
        return null;

    }

    @Override
    public String toString() {
        return "Seller{" +
                "companyName='" + companyName + '\'' +
                ", allSellers=" + allSellers +
                ", sellLog=" + sellLogs +
                ", allProducts=" + allProducts +
                ", credit=" + credit +
                '}';
    }
}
