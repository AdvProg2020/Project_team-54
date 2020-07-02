package model;
//import com.google.gson.Gson;

import ScenesAndControllers.Manager;
import controller.BuyerManager;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Good {

    private Image image;
    private int id;
    private GoodStatus goodStatus;
    private String name;
    private String brand;
    private double price;
    private Account seller;
    private boolean inventoryStatus;
    private Category category;
    // Specific category specifications
    private String description;
    private double averageScore;
    private int numberOfScores;
    private ArrayList<Comment> comments;
    public static ArrayList<Good> allProducts = new ArrayList<>();
    public static ArrayList<Good> filteredProducts;
    public boolean isInOff = false;
    private int offId;
    private int quantity;
    private ArrayList<Buyer> buyersWhoBought = new ArrayList<>();
//    private static String fileLocation = "/Users/Reza/Desktop/gson.txt";
//    private static Gson gson = new Gson();


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Buyer> getBuyersWhoBought() {
        return buyersWhoBought;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSeller(Account seller) {
        this.seller = seller;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setGoodStatus(GoodStatus goodStatus) {
        this.goodStatus = goodStatus;
    }

    public static ArrayList<Good> getAllProducts() {
        return allProducts;
    }

    public void setOffId(int offId) {
        this.offId = offId;
    }

    public int getOffId() {
        return offId;
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
                    if (!product.getSeller().getFirstName().equals(filter.getValue()))
                        filteredProducts.remove(product);
                }
                break;
            case "priceMoreThan":
                for (Good product : allProducts) {
                    if (product.price < Double.parseDouble(filter.getValue()))
                        filteredProducts.remove(product);
                }
                break;
            case "priceLessThan":
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

    public static Good getProductById(int id) {
        for (Good good : getAllProducts()) {
            if (good.getId() == id)
                return good;
        }
        return null;
    }

    public Good(int id, String name, String brand, double price, Account seller,
                boolean inventoryStatus, Category category, String description) {
//        this.image = new Image("./Images/shopping-cart-icon-png-3.png");
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.seller = seller;
        this.inventoryStatus = inventoryStatus;
        this.category = category;
        this.description = description;
        this.averageScore = 0;
        this.numberOfScores = 0;
        this.goodStatus = GoodStatus.confirmed;
        this.comments = new ArrayList<>();
        if (category != null)
            category.getGoods().add(this);
        allProducts.add(this);
    }

    public Good(Image image, int id, String name, String brand, double price, Account seller,
                boolean inventoryStatus, Category category, String description) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.seller = seller;
        this.inventoryStatus = inventoryStatus;
        this.category = category;
        this.description = description;
        this.averageScore = 0;
        this.numberOfScores = 0;
        this.goodStatus = GoodStatus.confirmed;
        this.comments = new ArrayList<>();
        allProducts.add(this);
        if (category != null)
            category.getGoods().add(this);
    }


    public int getQuantity() {
        if (Manager.loggedInAccount != null) {
            BuyerManager buyerManager = new BuyerManager((Buyer) Manager.loggedInAccount);
            return buyerManager.viewCart().get(this);
        }
        return 0;
    }

    public void addScore(double score) {
        this.averageScore = ((this.averageScore * this.numberOfScores) + score) / (this.numberOfScores++);
        //inja nabayad numberOfScores++ beshe?
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

    public Category getCategory() {
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

    public Good getProductWithId(int id) {
        for (Good good : allProducts) {
            if (good.getId() == id)
                return good;
        }
        return null;
    }

    public static ArrayList<Good> getProductsWithBrand(String brand) {
        ArrayList<Good> information = new ArrayList<>();
        for (Good good : allProducts) {
            if (good.getBrand().equalsIgnoreCase(brand))
                information.add(good);
        }
        return information;
    }

    public static ArrayList<Good> getProductWithSeller(String sellerName) {
        ArrayList<Good> information = new ArrayList<>();
        for (Good good : allProducts) {
            if (good.getSeller().equals(Seller.getAccountWithUsername(sellerName)))
                information.add(good);
        }
        return information;
    }

    public static ArrayList<Good> getProductWithPrice(Double minPrice, Double maxPrice) {
        ArrayList<Good> information = new ArrayList<>();
        for (Good good : allProducts) {
            if (good.getPrice() >= minPrice && good.getPrice() <= maxPrice)
                information.add(good);
        }
        return information;
    }

}