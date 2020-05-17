package model;
import java.util.ArrayList;

public class Good {
    private int id;
    private GoodStatus goodStatus;
    private String name;
    private String brand;
    private double price;
    private Account seller;
    private boolean inventoryStatus;
    private ArrayList<Category> category;
    // Specific category specifications
    private String description;
    private double averageScore;
    private ArrayList<String> comments;

    public Good(int id, String name, String brand, double price, Account seller, boolean inventoryStatus, ArrayList<Category> category, String description, double averageScore) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.seller = seller;
        this.inventoryStatus = inventoryStatus;
        this.category = category;
        this.description = description;
        this.averageScore = averageScore;
    }

    public void setInventoryStatus(boolean inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public void setComments(String comment) {
        this.comments.add(comment);
    }

    public int getId() {
        return id;
    }

    public GoodStatus getGoodStatus() {
        return goodStatus;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public Account getSeller() {
        return seller;
    }

    public boolean isInInventory() {
        return inventoryStatus;
    }

    public ArrayList<Category> getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public ArrayList<String> getComments() {
        return comments;
    }
}