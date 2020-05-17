package main.java.model;

import java.util.ArrayList;

import static main.java.model.Category.*;

public abstract class Products {
    public static ArrayList<Good> allProducts;
    public static ArrayList<Good> filteredProducts;

    public static void viewCategories() {
        for (Category category : allCategories) {
            System.out.println(category.name);
        }
    }

//    public static void filtering() {
//        for (Good product : allProducts) {
//
//        }
//    }


    public static void showProducts() {
        for (Good product : allProducts) {
            System.out.println(product.getName());
        }
    }

    public static void showProduct(int id) {
        for (Good product : allProducts) {
            if (product.getId().equals(id))
                System.out.println(product.getName());
        }
    }

    public static void search(String keyWord) {
        for (Good product : allProducts) {
            if (product.getName().contains(keyWord))
                System.out.println(product.getName());
        }
    }


}
