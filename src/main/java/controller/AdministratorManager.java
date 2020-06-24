package controller;

import model.*;
import model.Requests.Request;
import model.Requests.RequestAddProduct;
import model.Requests.RequestNewManager;
import model.Requests.RequestNewSeller;
//import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Date;

import static model.Requests.Request.getRequestById;
import static model.Role.*;

public class AdministratorManager extends Manager {

    public AdministratorManager(Account account) {
        super(account);
    }

    public void createNewManager(String userName, String name, String lastName,
                                 String phoneNumber, String eMail, String password){
        new model.Manager(userName,name,lastName,phoneNumber,eMail,password,Role.administrator);
    }


    //***** DISCOUNT CODES ******
    public void createCodedDiscount(String code, Date startTime, Date endTime, double percentage, double maxDiscount,
                                    ArrayList<Account> validAccount) {
        DiscountCode discountCode1 = new DiscountCode(code,startTime,endTime,percentage,maxDiscount);
    }

    public void viewDiscountCode(String code){
        DiscountCode.getAllDiscountCodes();
    }

    public void editCodedDiscount(String code, String field, String newInformation) throws DiscountCodeDoesNotExist {
        int flag = 0;
        for(DiscountCode discountCode : DiscountCode.getAllDiscountCodes()){
            if(discountCode.getCode().equals(code))
                flag = 1;
        }
        if (flag == 0){
            throw new DiscountCodeDoesNotExist();
        }
        if(field.equalsIgnoreCase("startTime")){
            //TODO
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
//            discountCode.setStartTime();
        } else if (field.equalsIgnoreCase("endTime")){
            //TODO
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
//            discountCode.setEndTime();
        } else if (field.equalsIgnoreCase("percentage")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setPercentage(Double.parseDouble(newInformation));
        } else if (field.equalsIgnoreCase("maxAmount")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setMaxAmount(Double.parseDouble(newInformation));
        }
    }

    //***** CATEGORY ******
    public void addCategory(String name, Category parent) {
        new Category(name,parent);
    }

    public void editCategory(String name, String type, String newInformation) throws CategoryDoesNotExist {
        if(!Category.isThereCategoryWithName(name))
            throw new CategoryDoesNotExist();

        for(Category category:Category.getAllCategories()){
            if(category.getName().equals(name)){
//                switch ()
                //TODO
            }
        }


    }

    public void deleteCategory(String name, ArrayList<Category> subCategory) throws CategoryDoesNotExist {
        if(!Category.isThereCategoryWithName(name))
            throw new CategoryDoesNotExist();
        Category.removeCategory(Category.getCategoryWithName(name));
    }

    public void editProductInformation(String productId, String type, String newInformation) throws ProductDoesNotExist {
        int id = Integer.valueOf(productId);
        int flag=0;
        for(Good good : Good.getAllProducts()){
            if (good.getId() == id){
                flag = 1;
            }
        }
        if (flag == 0)
            throw new ProductDoesNotExist();
//        switch (type){
//            case
//        }
        //TODO


    }

    public ArrayList<Category> manageCategories(){
        return Category.getAllCategories();
    }

    //***** MANAGE USERS ******
    public Account viewUser(String username) throws Exception{
        if (Account.getAccountWithUsername(username)==null)
            throw new Exception("No Account Found With This Username");
        else
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

    public void deleteDiscountCode(String code) throws Exception {
        DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
        if (discountCode == null)
            throw new Exception("No discount code found");
        DiscountCode.getAllDiscountCodes().remove(discountCode);
    }

    public void deleteGood(int id) throws Exception{
        Good good = Good.getProductById(id);
        if (good == null)
            throw new Exception("No good found");
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
        controller.Manager.allActiveSeller.add(new Seller(request.getUsername(), request.getName(), request.getLastName(), request.getEmail(), request.getPhoneNumber(), request.getPassword(), request.getCompanyName(), Role.seller));
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
        RequestAddProduct request = (RequestAddProduct) getRequestById(id);
        request.acceptRequest(id);
    }

    public void refuseRequest(int id) {
        Request request = getRequestById(id);
        request.denyRequest();
    }

    public ArrayList<DiscountCode> showAllDiscountCodes(){
        return DiscountCode.getAllDiscountCodes();
    }

    public void showRequests() {
        for (Request request:Request.getAllRequests()) {
            request.getDetails();
            //result is ignored
        }
    }

    public void showUserRequests(Account user) {
        //TODO
    }

    //***** MISC ******
    public void showBalanceBuyer(Account buyer) {
        //TODO
    }

    //Exception

    public static class InvalidUsername extends Exception{
        public InvalidUsername(){
            super("username is invalid");
        }
    }

    public static class DiscountCodeDoesNotExist extends Exception{
        public DiscountCodeDoesNotExist(){
            super("there is no discount code with this id");
        }
    }

    public static class CategoryDoesNotExist extends Exception{
        public CategoryDoesNotExist(){
            super("there is no category");
        }
    }

    public static class ProductDoesNotExist extends Exception{
        public ProductDoesNotExist(){
            super("there is no product");
        }
    }

}
