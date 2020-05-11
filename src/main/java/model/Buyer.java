package main.java.model;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends Account {

    private double balance;
    private ArrayList<Buyer> allBuyers = new ArrayList<>();
    private ArrayList<Products> cart;
    private ArrayList<DiscountCode> allDiscountCodes = new ArrayList<>();
    private List<BuyLog> buyLog;

    public Buyer(String username, String name, String lastName, String email, String telephonNumber, String password,Role role) {
        super(username,name,lastName,telephonNumber,email,password,role);
        allBuyers.add(this);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void viewPersonalInfo(){

    }

    private void viewCart(){
    }

    private void viewOrders(){
        //***
    }

    private void viewDiscountCOdes(){

    }

    private void viewBalance(){
        System.out.println(balance);
    }

}
