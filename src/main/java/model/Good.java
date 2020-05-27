package main.java.model;
import main.java.model.Category;

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
    private ArrayList<Comment> comments;
    public static ArrayList<Good> allProducts = new ArrayList<>();
    public static ArrayList<Good> filteredProducts;

    public static ArrayList<Good> getAllProducts() {
        return allProducts;
    }

    public static void removeAllFilters() {
        filteredProducts = allProducts;
    }

    public static void filtering(Filter filter) {
        if (filteredProducts.size() == 0)
            filteredProducts = allProducts;
        switch (filter.getField()) {
            case "brand":
                for (Good product : allProducts) {
                    if (!product.getBrand().equals(filter.getValue()))
                        filteredProducts.remove(product);
                }
                break;
            case "seller":
                for (Good product : allProducts) {
                    if (!product.getSeller().getName().equals(filter.getValue()))
                        filteredProducts.remove(product);
                }
                break;
            case "inventory status":
                for (Good product : allProducts) {
                    if (!product.isInInventory())
                        filteredProducts.remove(product);
                }
                break;
            case "priceMoreThan" :
                for (Good product : allProducts) {
                    if (product.price < Double.parseDouble(filter.getValue()))
                        filteredProducts.remove(product);
                }
                break;
            case "priceLessThan" :
                for (Good product : allProducts) {
                    if (product.price > Double.parseDouble(filter.getValue()))
                        filteredProducts.remove(product);
                }
                break;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Good getProductById(int id){
        for(Good good : getAllProducts()){
            if (good.getId() == id)
                return good;
        }
        return null;
    }

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
        allProducts.add(this);
    }

    public void setInventoryStatus(boolean inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}