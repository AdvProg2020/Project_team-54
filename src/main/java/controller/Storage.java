package main.java.controller;

import model.*;
import model.Manager;
import model.Requests.Request;

import java.util.ArrayList;

public class Storage {
    public static ArrayList<Account> allAccounts = new ArrayList<>();
    public static ArrayList<Manager> allAdmins = new ArrayList<>();
    public static ArrayList<Buyer> allBuyers = new ArrayList<>();
    public static ArrayList<Seller> allSellers = new ArrayList<>();
    public static ArrayList<Request> allRequests = new ArrayList<>();
    public static ArrayList<Good> allProducts = new ArrayList<>();
    public static ArrayList<Category> allCategories = new ArrayList<>();
    public static ArrayList<DiscountCode> allDiscountCodes = new ArrayList<>();
    public static ArrayList<Filter> allFilters = new ArrayList<>();
    public static ArrayList<Log> allLogs = new ArrayList<>();
    public static ArrayList<BuyLog> allSellLogs = new ArrayList<>();
    public static ArrayList<SellLog> allBuyLogs = new ArrayList<>();
//    public static ArrayList<Comment> allComments = new ArrayList<>();
//    public static ArrayList<Score> allScore = new ArrayList<>();

    //Storage ro begire


    public static ArrayList<Account> getAllAccounts() {
        return allAccounts;
    }

    public static ArrayList<Manager> getAllAdmins() {
        return allAdmins;
    }

    public static ArrayList<Buyer> getAllBuyers() {
        return allBuyers;
    }

    public static ArrayList<Seller> getAllSellers() {
        return allSellers;
    }

    public static ArrayList<Request> getAllRequests() {
        return allRequests;
    }

    public static ArrayList<Good> getAllProducts() {
        return allProducts;
    }

    public static ArrayList<Category> getAllCategories() {
        return allCategories;
    }

    public static ArrayList<DiscountCode> getAllDiscountCodes() {
        return allDiscountCodes;
    }

    public static ArrayList<Filter> getAllFilters() {
        return allFilters;
    }

    public static ArrayList<Log> getAllLogs() {
        return allLogs;
    }

    public static ArrayList<BuyLog> getAllSellLogs() {
        return allSellLogs;
    }

    public static ArrayList<SellLog> getAllBuyLogs() {
        return allBuyLogs;
    }

    public Account getAccountByUsername(String username){
        for(Account account : allAccounts){
            if(account.getUsername().equals(username))
                return account;
        }
        return null;
    }

    public DiscountCode getDiscountCodeWithCode(String code){
        for(DiscountCode discountCode : allDiscountCodes){
            if (discountCode.getCode().equals(code))
                return discountCode;
        }
        return null;
    }

    public static Request getRequestById(int id){
        for (Request request:allRequests) {
            if(request.getId()==id){
                return request;
            }
        }
        return null;
    }

    public Good getGoodById(int productId) {
        for (Good product : allProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    //TODO

}
