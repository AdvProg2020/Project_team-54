package model.Requests;


import ScenesAndControllers.AlertBox;
import model.Category;
import model.Good;
import model.Products;
import model.Seller;
import javafx.scene.image.Image;

import java.util.ArrayList;


public class RequestAddProduct extends Request {
    private String requestType = "AddProduct";
    private Seller seller;
    private Category category;
    private String name;
    private double price;
    private String brand;
    private String description;
    private String whoRequested;
    private Image image;
    private static ArrayList<RequestAddProduct> allAddProductRequests = new ArrayList<>();

    public RequestAddProduct(Image image, Seller seller, Category category, String name, double price, String description, String brand) {
        super();
        this.seller = seller;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.image = image;
        this.id = giveId();
        this.whoRequested = seller.getUsername();
        allAddProductRequests.add(this);
    }

    public String getRequestType() {
        return requestType;
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

    @Override
    public void acceptRequest(int id) {
        status = model.Requests.RequestConfirmation.Accepted;
        int size = Products.getAllProducts().size();
        size++;
        Good good = new Good(image,size,name,brand,price,seller,true,category,description);
        Good.getAllProducts().add(good);
//        Good good = new Good(size++,this.getName(),seller.getCompanyName(),this.getPrice())
        AlertBox.display("Request accepted");
    }

    @Override
    public void denyRequest() {
        status = RequestConfirmation.Denied;
        Request.getAllRequests().remove(this);
        AlertBox.display("Request denied");
    }

    @Override
    public String toString() {
        return "RequestAddProduct With Id=" + this.getId() + "\n" +
                "category= " + category.getName() + "\n" +
                "name= " + name + "\n" +
                "price= " + price + "\n" +
                "description= " + description + '\n' +
                "brand= " + brand + "\n" +
                "whoRequested= " + whoRequested ;
    }

//    @Override
//    public String getDetails() {
//        String details= "";
//        details += seller.getFirstName() + " " + seller.getLastName();
//        details += " Requested for adding a good with name " + this.getName() + " and price " + this.getPrice();
//        return details;
//    }
}
