package controller;

import model.*;
import model.Requests.Request;
import model.Requests.RequestNewManager;
import model.Requests.RequestNewSeller;
//import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Date;

import static model.Requests.Request.getRequestById;

public class AdministratorManager extends Manager {

    public AdministratorManager(Account account) {
        super(account);
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
        } else if (field.equalsIgnoreCase("endTime")){
            //TODO
        } else if (field.equalsIgnoreCase("percentage")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setPercentage(Double.parseDouble(newInformation));
        } else if (field.equalsIgnoreCase("maxAmount")){
            DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
            discountCode.setMaxAmount(Double.parseDouble(newInformation));
        }
    }

    public void createNewManager(String userName, String name, String lastName,
                                 String phoneNumber, String eMail, String password){
        new model.Manager(userName,name,lastName,phoneNumber,eMail,password,Role.administrator);
    }

    public void createCodedDiscount(String code, Date startTime, Date endTime, double percentage, double maxDiscount,
                                    ArrayList<Account> validAccount) {
        DiscountCode discountCode1 = new DiscountCode(code,startTime,endTime,percentage,maxDiscount);
    }

    public void viewDiscountCode(String code){
        DiscountCode.getAllDiscountCodes();
    }


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

    public void deleteDiscountCode(String code) throws Exception {
        int flag =0;
        for (DiscountCode discountCode:DiscountCode.getAllDiscountCodes()) {
            if (discountCode.getCode().equals(code))
                flag =1;
        }
        if (flag ==0)
            throw new Exception("No discount code found");
        //DiscountCode discountCode = DiscountCode.getDiscountCodeWithCode(code);
        DiscountCode.getAllDiscountCodes().remove(DiscountCode.getDiscountCodeWithCode(code));
    }

    public void acceptRequest(int id) {
        Request request = getRequestById(id);
        request.acceptRequest(id);
    }

    private void acceptRequestNewSeller(int id){
        RequestNewSeller request = (RequestNewSeller) getRequestById(id);
        request.acceptRequest(id);
    }

    private void acceptRequestNewManager(int id){
        RequestNewManager request = (RequestNewManager) getRequestById(id);
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
