package main.java.model.Requests;


import main.java.model.Category;
import main.java.model.Products;
import main.java.model.Seller;


public class RequestAddProduct extends Request {
    private Seller seller;
    private Category category;
    private String name;
    private double price;
    private String description;

    public RequestAddProduct(Seller seller, Category category, String name, double price, String description) {
        this.seller = seller;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
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


    @Override
    public void acceptRequest(int id) {
        status = main.java.model.Requests.RequestConfirmation.Accepted;
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
