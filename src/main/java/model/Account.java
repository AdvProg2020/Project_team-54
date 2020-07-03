package model;
import ScenesAndControllers.AlertBox;
import javafx.scene.image.Image;
//import com.google.gson.Gson;
//import com.google.gson.stream.JsonReader;

import java.util.ArrayList;

public class Account {
    private Image image;
    private double balance;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
    private static ArrayList<Account> allAccounts = new ArrayList<>();
//    private static String fileLocation = "/Users/Reza/Desktop/gson.txt";
//    private static Gson gson = new Gson();
    //private String sellerCompanyName;
    //private List<String> discount;
    //private List<SellLog> selLog;

    public Account(String username, String firstName, String lastName, String phoneNumber, String email, String password, Role role) {
        this.image = new Image("/Images/profile.jpg");
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = 0;
        allAccounts.add(this);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public static ArrayList<Account> getAllAccounts() {
        return allAccounts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static Account getAccountWithUsername(String username){

//        String fileLocation = username + "/gson.txt";
////        Gson gson = new Gson();
//        ReadAndWriteFromFile t = new ReadAndWriteFromFile();
//        String response = t.readFromFile(fileLocation);
//        System.out.println(response);

        for (Account account: allAccounts){
            if(account.getUsername().equals(username))
                return account;
        }
        return null;
    }



//    public String details(){
//        String details="";
//        details += "Username: " + username + "\n";
//        details += "Full Name: " + name + " " + this.getLastName() + "\n";
//        details += "Email: " + email + "\n";
//        details += "Telephone Number: " + phoneNumber + "\n";
//        details += "Role: " + role + "\n";
//
//        return details;
//    }

//    @Override
//    public String toString() {
//        return "Account{" +
//                "username='" + username + '\'' +
//                ", name='" + name + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", role=" + role +
//                '}';
//    }



    //Exceptions

    public static class NoAccountLoggedIn extends Exception{

        public NoAccountLoggedIn(String message){
            AlertBox.display("Please log in");
//            super(message);
//            "appropriate account must log in.
        }
    }




}