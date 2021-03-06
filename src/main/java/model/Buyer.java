package model;
import ScenesAndControllers.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer extends Account {

    private static ArrayList<Buyer> allBuyers;
//    private ArrayList<Good> cart;
    private HashMap<Good,Integer> cart;
    private ArrayList<Good> productsInCart;
    public static ArrayList<DiscountCode> allDiscountCodes;
    private ArrayList<BuyLog> buyLog;
    private ArrayList<Good> ratedProducts;
    {
        allBuyers = new ArrayList<>();
//        cart = new ArrayList<>();
        cart = new HashMap<>();
        allDiscountCodes = new ArrayList<>();
//        buyLog = new ArrayList<>();
    }

    public Buyer(String username, String name, String lastName, String email,
                 String phoneNumber, String password, Role role) {
        super(username,name,lastName,phoneNumber,email,password,role);
        this.buyLog = new ArrayList<>();
        ratedProducts = new ArrayList<>();
        productsInCart = new ArrayList<>();
        Manager.allActiveAccounts.add(this);
        allBuyers.add(this);
    }

    public void addRatedProduct(Good good) {
        this.ratedProducts.add(good);
    }

    public ArrayList<Good> getRatedProducts() {
        return ratedProducts;
    }

    public ArrayList<Good> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(ArrayList<Good> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public static ArrayList<Buyer> getAllBuyers() {
        return allBuyers;
    }

    public ArrayList<BuyLog> getBuyLog() {
        return buyLog;
    }

    public void setBuyLog(ArrayList<BuyLog> buyLog) {
        this.buyLog = buyLog;
    }

    //*****CART*****
    public HashMap<Good,Integer> getCart() {
        return cart;
    }

    public void addProductToCart(Good product) {
        cart.put(product,0);
    }

    public void removeProductFromCart(Good product) {
        this.cart.remove(product);
    }

    public HashMap<Good,Integer> viewCart(){
        return cart;
    }

    private ArrayList<DiscountCode> viewDiscountCodes(){
        return allDiscountCodes;
    }

    public ArrayList<DiscountCode> getAllDiscountCodes() {
        return allDiscountCodes;
    }

    public void purchase(){
        //TODO
    }

    //@Override
    public String details(){
        int value = (int) this.getBalance();
        String details="";
        details += "Username: " + this.getUsername() + "\n";
        details += "Full Name: " + this.getFirstName() + " " + this.getLastName() + "\n";
        details += "Email: " + this.getEmail() + "\n";
        details += "Telephone Number: " + this.getPhoneNumber() + "\n";
        details += "Role: " + this.getRole() + "\n";
        details += "Balance: " + value + "\n";

        return details;
    }
/*
    public ArrayList<Buyer> getAllBuyers() {
        return allBuyers;
    }


 */

    public static Buyer getBuyerWithName(String userName) {
        for (Buyer buyer : allBuyers) {
            if (buyer.getUsername().equalsIgnoreCase(userName))
                return buyer;
        }
        return null;
    }

/*
    public boolean isThereBuyerWithUsername(String username){
        for(Buyer buyer : allBuyers){
            if (buyer.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }


 */
    //generating random username





}
