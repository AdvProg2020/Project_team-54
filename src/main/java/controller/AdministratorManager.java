package controller;

import model.Account;
import model.Category;
import model.Good;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;

public class AdministratorManager extends Manager {

    public AdministratorManager(Account account) {
        super(account);
    }

    public void editCodedDiscount(String id, String type, String newInformation) {
        //TODO
    }

    public void createCodedDiscount(String discountCode, Date startTime, Date endTime, double discountPercent, double maxDiscount,
                                    ArrayList<Account> validAccount) {
        //TODO
    }

    public void addCategory(String name, ArrayList<String> specialFeatures, ArrayList<Good> products) {
        //TODO
    }

    public void editCategory(Category category, String type, String newInformation) {
        //TODO
    }

    public void deleteCategory(String name, ArrayList<Category> subCategory) {
        //TODO
    }

    public void editProductInformation(String productId, String type, String newInformation) {
        //TODO
    }

    public Account getAccountWithUserName(String userName) {
        return null;
        //TODO
    }

    public void deleteUser(String userName) {
        //TODO
    }

    public void deleteDiscountCode(String id) {
        //TODO
    }

    public void acceptRequest(String id) {
        //TODO
    }

    public void refuseRequest(String id) {
        //TODO
    }

    public void showRequests() {
        //TODO
    }

    public void showUserRequests(Account user) {
        //TODO
    }

    public void showBalanceBuyer(Account buyer) {
        //TODO
    }

}