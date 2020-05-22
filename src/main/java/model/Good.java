package model;
import model.Category;

import java.util.ArrayList;

public class Good {
    private int id;
    private model.GoodStatus goodStatus;
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
    public static ArrayList<Good> allProducts = new ArrayList<>();
    public static ArrayList<Good> filteredProducts;

    public static ArrayList<Good> getAllProducts() {
        return allProducts;
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
//            case "price" :
//
//                break;
        }
    }

//    public static void showProducts() {
//        for (Good product : allProducts) {
//            System.out.println(product.getName());
//        }
//    }

//    public static void showProduct(int id) {
//        for (Good product : allProducts) {
//            if (product.getId() == id)
//                System.out.println(product.getName());
//        }
//    }

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

    public void setComments(String comment) {
        this.comments.add(comment);
    }

    public int getId() {
        return id;
    }

    public model.GoodStatus getGoodStatus() {
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