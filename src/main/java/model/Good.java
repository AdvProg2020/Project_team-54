package main.java.model;
import java.util.ArrayList;

public class Good {
    private String id;
    private GoodStatus goodStatus;
    private String name;
    private String brand;
    private double price;
    private ArrayList<Account> seller;
    private boolean inventoryStatus;
    private Category category;
    // Specific category specifications
    private String description;
    private double averageScore;
    private ArrayList<String> comments;
}