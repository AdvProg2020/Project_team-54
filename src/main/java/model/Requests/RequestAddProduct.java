package model.Requests;


import model.Category;
import model.Good;
import model.Products;
import model.Seller;

import java.util.ArrayList;

public class RequestAddProduct extends Request {
    private Seller seller;
    private Category category;
    private String name;
    private double price;
    private String description;
    private static ArrayList<RequestAddProduct> allRequestAddProduct = new ArrayList<>();

    public RequestAddProduct(Seller seller, Category category, String name, double price, String description) {
        this.seller = seller;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.allRequestAddProduct.add(this);
        this.id = giveId();
    }

    public Seller getSeller() {
        return seller;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<RequestAddProduct> getAllRequestAddProduct() {
        return allRequestAddProduct;
    }

    @Override
    public void acceptRequest(int id) {
        status = RequestConfirmation.Accepted;
        int size = Products.getAllProducts().size();
//        Good good = new Good(size++,this.getName(),seller.getCompanyName(),this.getPrice())
    }

    @Override
    public String getDetails() {
        String details= "";
        details += seller.getName() + " " + seller.getLastName();
        details += " Requested for adding a good with name " + this.getName() + " and price " + this.getPrice();
        return details;
    }
}
