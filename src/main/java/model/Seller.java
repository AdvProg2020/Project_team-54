package main.java.model;
import main.java.model.Requests.Request;

import java.util.ArrayList;

public class Seller extends Account {
    private String companyName;
    private static ArrayList<Seller> allSellers = new ArrayList<>();
    private ArrayList<SellLog> sellLog;
    private ArrayList<Good> allProducts;
    public ArrayList<Request> allRequests;
    private double credit;
    public ArrayList<Off> allOffs;


    public Seller(String username, String name, String lastName, String email,
                  String telephonNumber, String password,Role role) {
        super(username,name,lastName,telephonNumber,email,password,role);
        allSellers.add(this);
        this.allProducts = new ArrayList<>();
        this.allRequests = new ArrayList<>();
        this.sellLog = new ArrayList<>();
        this.allOffs = new ArrayList<>();
    }

    public ArrayList<Seller> getAllSellers() {
        return allSellers;
    }

    public ArrayList<SellLog> getSellLog() {
        return sellLog;
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

    private void viewSalesHistory(){

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
                ", sellLog=" + sellLog +
                ", allProducts=" + allProducts +
                ", credit=" + credit +
                '}';
    }
}
