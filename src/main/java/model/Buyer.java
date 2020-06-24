package model;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class Buyer extends Account {

    private double balance;
    private static ArrayList<Buyer> allBuyers;
    private ArrayList<Good> cart;
    private ArrayList<DiscountCode> allDiscountCodes;
    private List<BuyLog> buyLog;

    {
        allBuyers = new ArrayList<>();
        cart = new ArrayList<>();
        allDiscountCodes = new ArrayList<>();
    }

    public Buyer(String username, String name, String lastName, String email,
                 String telephonNumber, String password, Role role) {
        super(username,name,lastName,telephonNumber,email,password,role);
        allBuyers.add(this);
    }

    public static ArrayList<Buyer> getAllBuyers() {
        return allBuyers;
    }

    public void addProductToCart(Good product) {
        this.cart.add(product);
    }

    public void removeProductFromCart(Good product) {
        this.cart.remove(product);
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



    public ArrayList<Good> viewCart(){
        return cart;
    }

    private ArrayList<DiscountCode> viewDiscountCOdes(){
        return allDiscountCodes;
    }

}
