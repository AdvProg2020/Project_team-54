package controller;

import model.*;
import model.Requests.Request;

import java.util.ArrayList;
import java.util.Date;

public class AdministratorManager extends Manager {

    public AdministratorManager(Account account) {
        super(account);
    }

    public void editCodedDiscount(int id, String type, String newInformation) {
        //TODO
    }

    public void createNewManager(String userName, String name, String lastName,
                                 String phoneNumber, String eMail, String password){
        new model.Manager(userName,name,lastName,phoneNumber,eMail,password,Role.administrator);
    }

    public void createCodedDiscount(String code, Date startTime, Date endTime, double percentage, double maxDiscount,
                                    ArrayList<Account> validAccount) {
        DiscountCode discountCode1 = new DiscountCode(code,startTime,endTime,percentage,maxDiscount);
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

//    public Account getAccountWithUserName(String userName) {
//        for (Account account : main.java.model.Account.getAllAcounts) {
//
//        }
//        return null;
//        //TODO
//    }

    public ArrayList<Account> manageUsers(){
        return Account.getAllAccounts();
    }

    public ArrayList<Category> manageCategories(){
        return Category.getAllCategories();
    }

    public Account viewUser(String username) throws Exception{
        if (Account.getAccountWithUsername(username)==null)
            throw new Exception("No Account Found With This Username");
        else
                return Account.getAccountWithUsername(username);
    }

    public void deleteUser(String userName) throws Exception {
        if (Account.getAccountWithUsername(userName) == null)
            throw new Exception("No Account Found With This Username");
        else{
            //json
            account = Account.getAccountWithUsername(userName);
            switch (account.getRole()){
                case buyer:
                    Buyer.getAllAccounts().remove(account);
                    return;
                case seller:
                    Seller.getAllAccounts().remove(account);
                case administrator:
                    model.Manager.getAllManagers().remove(account);
            }
            Account.getAllAccounts().remove(account);
        }
    }

    public void deleteDiscountCode(int id) {
        //TODO
    }

    public void acceptRequest(int id) {
        //TODO
    }

    public void refuseRequest(int id) {
        Request request = Request.getRequestById(id);
    }

    public void showRequests() {
        for (Request request:Request.getAllRequests()) {
            request.toString();
            //result is ignored
        }
    }

    public void showUserRequests(Account user) {
        //TODO
    }

    public void showBalanceBuyer(Account buyer) {
        //TODO
    }

    //Exception

    public static class InvalidUsername extends Exception{

        public InvalidUsername(String message){
            //TODO
            super(message);
        }
    }

    public static class InvalidDiscountCodeId extends Exception{

        public InvalidDiscountCodeId(String message){
            //TODO
            super(message);
        }
    }


}
