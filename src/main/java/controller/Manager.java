package controller;

import com.sun.org.apache.bcel.internal.generic.RET;
import model.Account;
import model.Category;

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

    public void register(String userName, String password, String firstName, String lastName, String eMail, int phoneNumber, String role) {
        //TODO
    }

    public void changeFirstName(String newFirstName) {
        //TODO
    }

    public void changeLastName(String newLastName) {
        //TODO
    }

    public void changeEmail(String newEmail) {
        //TODO
    }

    public void changePassword(String newPassword) {
        //TODO
    }

    public void changePhoneNumber(int newPhoneNumber) {
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
        //TODO
        return null;
    }

    public void isCategory(String name, ArrayList<Category> subCategory) {
        //TODO
    }


}
