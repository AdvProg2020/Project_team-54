package main.java.model;

import java.util.ArrayList;

import static main.java.model.Category.*;

public class Products {
    public static ArrayList<Good> allProducts;

    public void product() {

    }

    public void viewCategories() {
        for (Category category : allCategories) {
            System.out.println(category.name);
        }
    }

    public void filtering() {

    }

    public void sorting() {

    }

    public void showProducts() {
        //System.out.println(allProducts);
    }

    public void showProduct(int id) {

    }

    public void search() {

    }


}
