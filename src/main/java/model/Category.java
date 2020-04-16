package model;
import java.util.ArrayList;

public class Category {
    public String name;
    public ArrayList<Product> products;
    public ArrayList<String> speacialFeature;
    public ArrayList<Category> allCategories;

    public Category(String name, ArrayList<String> speacialFeature) {
        this.name = name;
        this.speacialFeature = speacialFeature;
        allCategories.add(this);
    }
}
