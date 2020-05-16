package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;
import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    protected Account account;

    public Manager(Account account) {
        this.account = account;
    }

    public Manager() {

    }

    public Account login(String userName, String password) throws Exception {
        if (!isUsernameValid(userName))
            throw new Exception("Username is not valid");
        else if(!isPasswordValid(password)) {
            throw new Exception("Password is not valid");
        } else if (!Account.getAccountWithUsername(userName).getPassword().equals(password)) {
            throw new Exception("Pass word is not correct");
        } else{
            account = Account.getAccountWithUsername(userName);
            return account;
        }
    }

    public void logout(){
        //TODO
    }

    public void register(String userName, String password, String firstName,
                         String lastName, String eMail, String phoneNumber, String role) throws Exception {
        if (!isUsernameValid(userName))
            throw new Exception("Please Enter a Valid Username");
        else if (isUserExist(userName)) {
            throw new Exception("Already registered with this username");
        } else if (!isPasswordValid(password))
            throw new Exception("Please Enter a Valid Password");
        else if (!isEmailValid(eMail))
            throw new Exception("Please Enter a Valid Email");
        else if (!isPhoneNumberValid(phoneNumber))
            throw new Exception("Please Enter a Valid Phone Number");
        else if (role.equalsIgnoreCase("buyer")) {
            Buyer buyer = new Buyer(userName, firstName, lastName, eMail, phoneNumber, password, Role.buyer);
        } else if (role.equalsIgnoreCase("seller")) {
            Seller seller = new Seller(userName, firstName, lastName, eMail, phoneNumber, password, Role.seller);
            //company name ro ham bayad yeja begire
        } else if (role.equalsIgnoreCase("admin")) {
            if (!doesAdminExist()) {
                Request request = new Request("AddManager");
            } else {
                model.Manager manager = new model.Manager(userName, firstName, lastName,
                        phoneNumber, eMail, password, Role.administrator);
            }
            //TODO
        }
    }

    public void changeFirstName(String newFirstName) {
        account.setName(newFirstName);
        //TODO
    }

    public void changeLastName(String newLastName) {
        account.setLastName(newLastName);
        //TODO
    }

    public void changeEmail(String newEmail) {
        account.setEmail(newEmail);
        //TODO
    }

    public void changePassword(String newPassword) {
        account.setPassword(newPassword);
        //TODO
    }

    public void changePhoneNumber(String newPhoneNumber) {
        account.setPhoneNumber(newPhoneNumber);
        //TODO
    }

    public void editField(String field, String newInput) throws Exception {
        if (field.equalsIgnoreCase("name")){
            account.setName(newInput);
        } else if (field.equalsIgnoreCase("lastName")){
            account.setLastName(newInput);
        } else if (field.equalsIgnoreCase("email")){
            if (!isEmailValid(newInput))
                 throw new Exception("Please Enter a Valid Email");
            else
                account.setEmail(newInput);
        } else if (field.equalsIgnoreCase("phoneNumber")){
            if(!isPhoneNumberValid(newInput))
                throw new Exception("Please Enter a Valid Phone Number");
            else
                account.setPhoneNumber(newInput);
        } else if (field.equalsIgnoreCase("password")){
            if(!isPasswordValid(newInput))
                throw new Exception("Please Enter a Valid Password");
            else
                account.setPassword(newInput);
        }

    }

    public boolean isValidDiscountCode(String discountCode) {
        //TODO
        return true;
    }

    public boolean isUserExist(String userName) {
        for(Account account : Account.getAllAccounts()){
            if(account.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    public boolean doesAdminExist(){
        if(model.Manager.getAllManagers().isEmpty()){
            return false;
        }
        return true;
    }

    public ArrayList<String> showProducts() {
        //return Products.getAllProducts;
        //TODO
        return null;
    }

    public void isCategory(String name, ArrayList<Category> subCategory) {
        //TODO
    }

    public boolean isEmailValid(String password){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean isPhoneNumberValid(String phoneNumber){
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    public boolean isUsernameValid(String username){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    public boolean isPasswordValid(String password){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }


}
