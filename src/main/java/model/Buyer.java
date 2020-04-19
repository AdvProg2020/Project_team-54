import java.util.ArrayList;

public class Buyer extends Account {
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String telephonNumber;
    private String password;
    private int balance;
    private ArrayList<String> allBuyers = new ArrayList<>();
    //private ArrayList<Products> cart;
    //private ArrayList<Products> buyLog;

    public Buyer(String username, String name, String lastName, String email, String telephonNumber, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.telephonNumber = telephonNumber;
        this.password = password;
        //allBuyers.add(this);  username ya name??
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private void viewPersonalInfo(){
        //System.out.println(username);

    }

    private void viewCart(){
        //System.out.println(cart);
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
