package main.java.model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String username;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
    private static ArrayList<Account> allAccounts = new ArrayList<>();
    //private String sellerCompanyName;
    //private List<String> discount;
    //private List<SellLog> selLog;

    public Account(String username, String name, String lastName, String phoneNumber, String email, String password, Role role) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
        allAccounts.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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

    public static Account getAccountWithUsername(String username){
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
            super(message);
            //"appropriate account must log in.
        }
    }




}