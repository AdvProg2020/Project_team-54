package model;

import java.util.ArrayList;

import static model.Category.getAllCategories;

public abstract class Products {
    public static ArrayList<Good> allProducts;
    public static ArrayList<Good> filteredProducts;

    public static void viewCategories() {
        getAllCategories();

//        for (Category category : allCategories) {
//            System.out.println(category.name);
//        }
    }

    public static ArrayList<Good> getAllProducts() {
        return allProducts;
    }


    public static void showProducts() {
        for (Good product : allProducts) {
            System.out.println(product.getName());
        }
    }

    public static void showProduct(int id) {
        for (Good product : allProducts) {
            if (product.getId() == id)
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
