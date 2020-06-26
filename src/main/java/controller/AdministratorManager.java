package controller;

import ScenesAndControllers.AlertBox;
import javafx.scene.control.Alert;
import model.*;
import model.Requests.*;
//import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;

import static model.Requests.Request.getRequestById;
import static model.Role.*;

public class AdministratorManager extends ScenesAndControllers.Manager {

    public AdministratorManager(Account account) {
        super(account);
    }

    public void createNewManager(String userName, String name, String lastName,
                                 String phoneNumber, String eMail, String password){
        new model.Manager(userName,name,lastName,phoneNumber,eMail,password,Role.administrator);
    }


    //***** DISCOUNT CODES ******
    public void createCodedDiscount(String code, String startTime, String  endTime, double percentage, double maxDiscount,
                                    ArrayList<Account> validAccount) {
        DiscountCode discountCode1 = new DiscountCode(code,startTime,endTime,percentage,maxDiscount);
    }

    public void viewDiscountCode(String code){
        DiscountCode.getAllDiscountCodes();
    }

    public ArrayList<DiscountCode> showAllDiscountCodes(){
        return DiscountCode.getAllDiscountCodes();
    }

    public void editCodedDiscount(String code, String field, String newInformation) throws DiscountCodeDoesNotExist {
        int flag = 0;
        for(DiscountCode discountCode : DiscountCode.getAllDiscountCodes()){
            if(discountCode.getCode().equals(code))
                flag = 1;
        }
        if (flag == 0){
            AlertBox.display("There is no discount code with this code");
//            throw new DiscountCodeDoesNotExist();
        }
        if(field.equalsIgnoreCase("startTime")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setStartTime(newInformation);
        } else if (field.equalsIgnoreCase("endTime")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setEndTime(newInformation);
        } else if (field.equalsIgnoreCase("percentage")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setPercentage(Double.parseDouble(newInformation));
        } else if (field.equalsIgnoreCase("maxAmount")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setMaxAmount(Double.parseDouble(newInformation));
        }
    }

    //***** CATEGORY ******
    public void addCategory(String name, ArrayList<String> allFeatures, Category parent) {
        new Category(name, allFeatures, parent);
    }

    public void editCategory(String name, String type, ArrayList<String> newInformation) throws CategoryDoesNotExist {
        if(!Category.isThereCategoryWithName(name))
            AlertBox.display("There is no category with this name");
//            throw new CategoryDoesNotExist();

        for(Category category:Category.getAllCategories()){
            if(category.getName().equals(name)){
                if (type.equalsIgnoreCase("name")) {
                    category.setName(newInformation.get(0));
                } else if (type.equalsIgnoreCase("feature")) {
                    category.setSpecialFeature(newInformation);
                }
            }
        }


    }

    public void deleteCategory(String name, ArrayList<Category> subCategory) throws CategoryDoesNotExist {
        if(!Category.isThereCategoryWithName(name))
            AlertBox.display("There is no category with this name");
//            throw new CategoryDoesNotExist();
        Category.removeCategory(Category.getCategoryWithName(name));
    }

    public void editProductInformation(int productId, String type, String newInformation) throws ProductDoesNotExist {
        int id = Integer.valueOf(productId);
        int flag=0;
        for(Good good : Good.getAllProducts()){
            if (good.getId() == id){
                flag = 1;
            }
        }
        if (flag == 0)
            AlertBox.display("There is no product with this id");
//            throw new ProductDoesNotExist();
        if (flag == 1) {
            if (type.equalsIgnoreCase("price")) {
                Good.getProductById(productId).setPrice(Double.parseDouble(newInformation));
            } else if (type.equalsIgnoreCase("name")) {
                Good.getProductById(productId).setName(newInformation);
            } else if (type.equalsIgnoreCase("description")) {
                Good.getProductById(productId).setDescription(newInformation);
            }
        }

    }

    public ArrayList<Category> manageCategories(){
        return Category.getAllCategories();
    }

    //***** MANAGE USERS ******
    public Account viewUser(String username) throws Exception{
        if (Account.getAccountWithUsername(username)==null)
            AlertBox.display("No Account Found With This Username");
//            throw new Exception("No Account Found With This Username");
                return Account.getAccountWithUsername(username);
    }

    public ArrayList<Account> manageUsers(){
        return Account.getAllAccounts();
    }

    public void changeRole (String username, String role) {
        Account account = getAccountWithUsername(username);
        switch (role){
            case "buyer":
                account.setRole(buyer);
                break;
            case "seller":
                account.setRole(seller);
                break;
            case "administrator":
                account.setRole(administrator);
                break;
        }
    }

    public void deleteUser(String userName) throws Exception {
        if (Account.getAccountWithUsername(userName) == null)
            AlertBox.display("No Account Found With This Username");
//            throw new Exception("No Account Found With This Username");
        else{
            //json
            loggedInAccount = Account.getAccountWithUsername(userName);
            switch (loggedInAccount.getRole()){
                case buyer:
                    Buyer.getAllAccounts().remove(loggedInAccount);
                    return;
                case seller:
                    Seller.getAllAccounts().remove(loggedInAccount);
                case administrator:
                    model.Manager.getAllManagers().remove(loggedInAccount);
            }
            Account.getAllAccounts().remove(loggedInAccount);
        }
    }

    public void deleteDiscountCode(String code) throws Exception {
        DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
        if (discountCode == null)
            AlertBox.display("No discount code found");
//            throw new Exception("No discount code found");
        DiscountCode.getAllDiscountCodes().remove(discountCode);
    }

    public void deleteGood(int id) throws Exception{
        Good good = Good.getProductById(id);
        if (good == null)
            AlertBox.display("No good found");
//            throw new Exception("No good found");
        Good.getAllProducts().remove(good);
        //fekr konm az category ha ham hazf mishe
    }

    //***** REQUESTS ******
    public void acceptRequest(int id) {
        Request request = getRequestById(id);
        request.acceptRequest(id);
    }

    private void acceptRequestNewSeller (int id){
        RequestNewSeller request = (RequestNewSeller) getRequestById(id);
        ScenesAndControllers.Manager.allActiveSeller.add(new Seller(request.getUsername(), request.getName(), request.getLastName(), request.getEmail(), request.getPhoneNumber(), request.getPassword(), request.getCompanyName(), Role.seller));
        request.acceptRequest(id);
    }

    private void acceptRequestNewManager(int id){
        RequestNewManager request = (RequestNewManager) getRequestById(id);
        request.acceptRequest(id);
    }

    private void acceptRequestAddProduct(int id){
        RequestAddProduct request = (RequestAddProduct) getRequestById(id);
        request.acceptRequest(id);
    }

    private void acceptRequestOff(int id){
        RequestOff request = (RequestOff) getRequestById(id);
        request.acceptRequest(id);
    }

    public void refuseRequest(int id) {
        Request request = getRequestById(id);
        request.denyRequest();
    }

    public void showRequests() {
        for (Request request:Request.getAllRequests()) {
            request.getDetails();
            //result is ignored
        }
    }

    public void showRequestStatus(int id){
        Request request = Request.getRequestById(id);
        AlertBox.display(request.getStatus().name());
    }

    public static boolean isThereRequestById(int id){
        for (Request request:Request.getAllRequests()) {
            if (request.getId() == id)
                return true;
        }
        return false;
    }

    public ArrayList<Request> showUserRequests(Account user) {
        Seller seller = (Seller) user;
        return seller.getAllRequests();
    }

    //***** MISC ******
    public Double showBalanceBuyer(Account buyer) {
        return Buyer.getAccountWithUsername(buyer.getUsername()).getBalance();
    }

    //Exception

    public static class InvalidUsername extends Exception{
        public InvalidUsername(){
            AlertBox.display("Username is invalid");
//            super("username is invalid");
        }
    }

    public static class DiscountCodeDoesNotExist extends Exception{
        public DiscountCodeDoesNotExist(){
            AlertBox.display("There is no discount code with this id");
//            super("there is no discount code with this id");
        }
    }

    public static class CategoryDoesNotExist extends Exception{
        public CategoryDoesNotExist(){
            AlertBox.display("There is no category");
//            super("there is no category");
        }
    }

    public static class ProductDoesNotExist extends Exception{
        public ProductDoesNotExist(){
            AlertBox.display("There is no product");
//            super("there is no product");
        }
    }

}
