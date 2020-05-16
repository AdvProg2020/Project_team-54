package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;
import model.Account;
import model.Category;
import model.Products;

import java.util.ArrayList;

public class Manager {
    protected Account account;

    public Manager(Account account) {
        this.account = account;
    }

    public Manager() {

    }

    public void login(String userName, String password) {
        //TODO
    }

    public void register(String userName, String password, String firstName, String lastName, String eMail, String phoneNumber, String role) {
        //TODO
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

    public boolean isValidDiscountCode(String discountCode) {
        //TODO
        return true;
    }

    public boolean isUserExist(String userName) {
        //TODO
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


}
