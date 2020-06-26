package model.Requests;


import model.Category;
import model.Good;
import model.Products;
import model.Seller;

import java.util.ArrayList;


public class RequestAddProduct extends Request {
    private String requestType = "AddProduct";
    private Seller seller;
    private Category category;
    private String name;
    private double price;
    private String description;
    private String whoRequested;

    public RequestAddProduct(Seller seller, Category category, String name, double price, String description) {
        super();
        this.seller = seller;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.id = giveId();
        this.whoRequested = seller.getUsername();
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
        //TODO
        //
        status = model.Requests.RequestConfirmation.Accepted;

        int size = Products.getAllProducts().size();
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        size++;
        Good good = new Good(size,name,seller.getCompanyName(),price,seller,true,categories,description);
//        Good good = new Good(size++,this.getName(),seller.getCompanyName(),this.getPrice())
    }

    @Override
    public void denyRequest() {
        status = RequestConfirmation.Denied;
        Request.getAllRequests().remove(this);
    }

    @Override
    public String getDetails() {
        String details= "";
        details += seller.getFirstName() + " " + seller.getLastName();
        details += " Requested for adding a good with name " + this.getName() + " and price " + this.getPrice();
        return details;
    }
}
