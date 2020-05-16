package model;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends Account {

    private double balance;
    private ArrayList<Buyer> allBuyers = new ArrayList<>();
    private ArrayList<Products> cart;
    private ArrayList<DiscountCode> allDiscountCodes = new ArrayList<>();
    private List<BuyLog> buyLog;

    public Buyer(String username, String name, String lastName, String email,
                 String telephonNumber, String password, Role role, double balance) {
        super(username,name,lastName,telephonNumber,email,password,role);
        this.balance = balance;
        allBuyers.add(this);
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isThereBuyerWithUsername(String username){
        for(Buyer buyer : allBuyers){
            if (buyer.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    //generating random username



    private void viewCart(){
    }

    private void viewOrders(){
        //***
    }

    private void viewDiscountCOdes(){

    }

}
