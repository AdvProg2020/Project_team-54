package model;
import model.Requests.Request;
import model.Requests.RequestNewSeller;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Account {
    private static ArrayList<Manager> allManagers = new ArrayList<>();
    //public ArrayList<String> request;

    public Manager(String userName, String name, String lastName, String phoneNumber, String eMail, String password, Role role) {
        super(userName,name,lastName,phoneNumber,eMail,password,role);
        allManagers.add(this);
    }


    public static ArrayList<Manager> getAllManagers() {
        return allManagers;
    }

    private void manageUsers(){

    }
    private void manageAllProducts(){

    }
//    private void createDiscountCode(String code, Date startTime, Date endTime, ArrayList<Buyer> buyers, int amount ){
//        DiscountCode discountCode = new DiscountCode(code,buyers,startTime,endTime,amount);
//        public void createCodedDiscount(String discountCode, Date startTime, Date endTime, double discountPercent, double maxDiscount,
//        ArrayList<Account> validAccount) {
//            //TODO
//        }
//    }


    private Request getRequestById(int ID) {
        for (Request request:Request.getAllRequests()) {
            if(request.getId()==ID)
            return request;
        }
        return null;
    }

    private void acceptRequestNewSeller (int id){
        RequestNewSeller request = (RequestNewSeller) getRequestById(id);
        controller.Manager.allActiveSeller.add(new Seller(request.getUsername(), request.getName(), request.getLastName(), request.getEmail(), request.getPhoneNumber(), request.getPassword(), request.getCompanyName(), Role.seller));
        request.acceptRequest(id);
    }

    private void manageCategories(){

    }
}
