package main.java.controller;

import com.sun.org.apache.bcel.internal.generic.RET;
import main.java.model.Account;
import main.java.model.Category;
import main.java.model.Good;

import java.util.ArrayList;
import java.util.Date;

public class SellerManager extends Manager{
    public SellerManager(Account account) {
        super(account);
    }

    public void addOff(String id, ArrayList<Good> products, Date startTime, Date endTime, double discount) {
        //TODO
    }

    public void editOff(String id, String type, String newInformation) {
        //TODO
    }

    public void addProductToSalesList(String id, String name, String brand, Account seller, Category category, String description, double price, boolean inventoryStatus) {
        //TODO
    }

    public void editProductInformation(String productId, String type, String newInformation) {
        //TODO
    }

    public void getProductWithId (String id) {
        //TODO
    }

    public void removeProduct(String productId) {
        //TODO
    }

    public ArrayList<String> showSalesHistories(Account seller) {
        //TODO
        return null;
    }

    public void showCompanyInformation(String brand) {
        //TODO
    }

    public Good showProduct(String productId) {
        //TODO
        return null;
    }

    public void showOffs(String brand) {
        //TODO
    }

}
