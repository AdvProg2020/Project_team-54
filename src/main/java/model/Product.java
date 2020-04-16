package model;
import java.util.ArrayList;

public class Product {
    public int id;
    public Category category;
    public String speacialFeature;
    public String name;
    public String companyName;
    public double price;
    public Seller seller;
    public String status;
    public double rate;
    public ArrayList<String> comments;
    //public Comment comment;

    public Product(int id, String name, String companyName, double price, Seller seller, Category category) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.price = price;
        this.seller = seller;
        this.category = category;
    }

    public void digest(){

    }

    public void attributes(){

    }

    public void compareProduct(int id){

    }

    private boolean inOff(){
        return false;
    }

    public void comments(){

    }

}
