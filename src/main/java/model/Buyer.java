package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class Buyer extends Account {

    private double balance;
    private static ArrayList<Buyer> allBuyers;
//    private ArrayList<Good> cart;
    private HashMap<Good,Integer> cart;
    private ArrayList<DiscountCode> allDiscountCodes;
    private List<BuyLog> buyLog;

    {
        allBuyers = new ArrayList<>();
//        cart = new ArrayList<>();
        cart = new HashMap<>();
        allDiscountCodes = new ArrayList<>();
//        buyLog = new ArrayList<>();
    }

    public Buyer(String username, String name, String lastName, String email,
                 String telephonNumber, String password, Role role) {
        super(username,name,lastName,telephonNumber,email,password,role);
        allBuyers.add(this);
    }

    public static ArrayList<Buyer> getAllBuyers() {
        return allBuyers;
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

    private ArrayList<DiscountCode> viewDiscountCOdes(){
        return allDiscountCodes;
    }

    public void purchase(){
        //TODO
    }

    //@Override
    public String details(){
        int value = (int)balance;
        String details="";
        details += "Username: " + this.getUsername() + "\n";
        details += "Full Name: " + this.getName() + " " + this.getLastName() + "\n";
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

    public Buyer getBuyerWithName(String userName) {
        for (Buyer buyer : allBuyers) {
            if (buyer.getUsername().equalsIgnoreCase(userName))
                return buyer;
        }
        return null;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
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
