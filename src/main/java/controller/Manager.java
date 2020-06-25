package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;
import com.google.gson.Gson;
import model.*;
import model.Requests.*;
import model.Requests.RequestNewManager;
import model.Requests.RequestNewSeller;
import view.ReadAndWriteFromFile;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    protected Account account;
    private ArrayList<Account> allActiveAccounts = new ArrayList<>();
    private ArrayList<Buyer> allActiveBuyer = new ArrayList<>();
    public static ArrayList<Seller> allActiveSeller = new ArrayList<>();
    private ArrayList<model.Manager> allManager = new ArrayList<>();
    ArrayList<String> viewPersonalInfo = new ArrayList<>();

    public Manager(){

    }

    public Manager(Account account) {
        this.account = account;
    }

    public Account login(String userName, String password) throws Exception {
        //String fileLocation = userName + "/gson.txt";
        //ReadAndWriteFromFile t = new ReadAndWriteFromFile();
        if (!isUsernameValid(userName))
            throw new Exception("Username is not valid");
        else if(!isPasswordValid(password)) {
            throw new Exception("Password is not valid");
        }
        if (!checkUserNameRepeated(userName))
            throw new Exception("this Username has not registered !!!!");
        if (!checkUsernameAndPassword(userName, password))
            throw new Exception("username and password is incorrect");
//        else if (!Account.getAccountWithUsername(userName).getPassword().equals(password)) {
//            throw new Exception("Password is not correct");
//        }
        else{
            //String response = t.readFromFile(fileLocation);
            //if (response.startsWith("File doesn't exist"))
            //    return null;
            account = getAccountWithUsername(userName);
            return account; //null or real account
        }
    }

    public void logout(){
//        fekr konm
//        this.account = null;
    }

    public void register(String userName, String password, String firstName,
                         String lastName, String eMail, String phoneNumber, String companyName, String role) throws Exception {
//        String fileLocation = userName + "/gson.txt";
//        Gson gson = new Gson();
//        ReadAndWriteFromFile t = new ReadAndWriteFromFile();
//        String response = t.readFromFile(fileLocation);
//        Buyer buyer = new Buyer(userName, firstName, lastName, eMail, phoneNumber, password, Role.buyer);
//        t.writeToFile(gson.toJson(buyer), fileLocation);
//        if (!response.startsWith("File doesn't exit"))
//            System.out.println("file ??????????");
        if (!isUsernameValid(userName))
            throw new Exception("Please Enter a Valid Username");
        else if (!checkUserNameRepeated(userName)) {
            throw new RepeatedUsername();
            //throw new Exception("Already registered with this username");
        } else if (!isPasswordValid(password))
            throw new Exception("Please Enter a Valid Password");
        else if (!isEmailValid(eMail))
            throw new Exception("Please Enter a Valid Email");
        else if (!isPhoneNumberValid(phoneNumber))
            throw new Exception("Please Enter a Valid Phone Number");
        else
        if (role.equalsIgnoreCase("buyer")) {
            Account account2 = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.buyer);
            Buyer buyer = new Buyer(userName, firstName, lastName, eMail, phoneNumber, password, Role.buyer);
            allActiveAccounts.add(account2);
            allActiveBuyer.add(buyer);
            //t.writeToFile(gson.toJson(buyer), fileLocation);
        } else if (role.equalsIgnoreCase("seller")) {
            RequestNewSeller newSeller = new RequestNewSeller(userName, firstName, lastName, phoneNumber, eMail, password, companyName);
            newSeller.setWhoRequested(account.getUsername());
            //t.writeToFile(gson.toJson(seller), fileLocation);      //*** IT MUST INITIALIZE WHEN MANAGER ACCEPTED ***
        } else if (role.equalsIgnoreCase("manager")) {
            if (allManager.size() != 0) {
                RequestNewManager newManager = new RequestNewManager(userName, firstName, lastName, phoneNumber, eMail, password);
            } else {
                model.Manager manager = new model.Manager(userName, firstName, lastName,
                        phoneNumber, eMail, password, Role.administrator);
                allManager.add(manager);
                //t.writeToFile(gson.toJson(manager), fileLocation);
            }
        }
    }

    public Boolean checkUserNameRepeated(String userName) {
        for (int i = 0; i < allActiveAccounts.size(); i++) {
            if (allActiveAccounts.get(i).getUsername().equalsIgnoreCase(userName))
                return false;
        }
        return true;
    }

    public Boolean checkUsernameAndPassword(String userName, String password) {
        for (int i = 0; i < allActiveAccounts.size(); i++) {
            if (allActiveAccounts.get(i).getUsername().equalsIgnoreCase(userName) && allActiveAccounts.get(i).getPassword().equals(password))
                return true;
        }
        return false;
    }

    public Account getAccountWithUsername(String username) {
        for (int i = 0; i < allActiveAccounts.size(); i++) {
            if (allActiveAccounts.get(i).getUsername().equalsIgnoreCase(username))
                return allActiveAccounts.get(i);
        }
        return null;
    }
/*

    public void changeFirstName(String newFirstName) {
        account.setName(newFirstName);
    }

    public void changeLastName(String newLastName) {
        account.setLastName(newLastName);
    }

    public void changeEmail(String newEmail) {
        account.setEmail(newEmail);
    }

    public void changePassword(String newPassword) {
        account.setPassword(newPassword);
    }

    public void changePhoneNumber(String newPhoneNumber) {
        account.setPhoneNumber(newPhoneNumber);
    }


 */

    public void editField(String field, String newInput) throws Exception {
        if (account.getRole().equals(Role.buyer)) {
            for (int i = 0; i < allActiveBuyer.size(); i++) {
                if (allActiveBuyer.get(i).getUsername().equalsIgnoreCase(account.getUsername())) {
                    if (field.equalsIgnoreCase("name")) {
                        account.setName(newInput);
                        allActiveBuyer.get(i).setName(newInput);
                    } else if (field.equalsIgnoreCase("lastName")) {
                        account.setLastName(newInput);
                        allActiveBuyer.get(i).setLastName(newInput);
                    } else if (field.equalsIgnoreCase("email")) {
                        if (!isEmailValid(newInput))
                            throw new Exception("Please Enter a Valid Email");
                        else
                            account.setEmail(newInput);
                        allActiveBuyer.get(i).setEmail(newInput);
                    } else if (field.equalsIgnoreCase("phoneNumber")) {
                        if(!isPhoneNumberValid(newInput))
                            throw new Exception("Please Enter a Valid Phone Number");
                        else
                            account.setPhoneNumber(newInput);
                        allActiveBuyer.get(i).setPhoneNumber(newInput);
                    } else if (field.equalsIgnoreCase("password")) {
                        if(!isPasswordValid(newInput))
                            throw new Exception("Please Enter a Valid Password");
                        else
                            account.setPassword(newInput);
                        allActiveBuyer.get(i).setPassword(newInput);
                    }
                }
            }
        } else if (account.getRole().equals(Role.seller)) {
            for (int i = 0; i < allActiveSeller.size(); i++) {
                if (allActiveSeller.get(i).getUsername().equalsIgnoreCase(account.getUsername())) {
                    if (field.equalsIgnoreCase("name")) {
                        account.setName(newInput);
                        allActiveSeller.get(i).setName(newInput);
                    } else if (field.equalsIgnoreCase("lastName")) {
                        account.setLastName(newInput);
                        allActiveSeller.get(i).setLastName(newInput);
                    } else if (field.equalsIgnoreCase("email")) {
                        if (!isEmailValid(newInput))
                            throw new Exception("Please Enter a Valid Email");
                        else
                            account.setEmail(newInput);
                        allActiveSeller.get(i).setEmail(newInput);
                    } else if (field.equalsIgnoreCase("phoneNumber")) {
                        if(!isPhoneNumberValid(newInput))
                            throw new Exception("Please Enter a Valid Phone Number");
                        else
                            account.setPhoneNumber(newInput);
                        allActiveSeller.get(i).setPhoneNumber(newInput);
                    } else if (field.equalsIgnoreCase("password")) {
                        if(!isPasswordValid(newInput))
                            throw new Exception("Please Enter a Valid Password");
                        else
                            account.setPassword(newInput);
                        allActiveSeller.get(i).setPassword(newInput);
                    }
                }
            }
        }
    }

    public ArrayList<String> viewPersonalInfo(){
        viewPersonalInfo.add(account.getUsername());
        viewPersonalInfo.add(account.getName());
        viewPersonalInfo.add(account.getLastName());
        viewPersonalInfo.add(account.getEmail());
        viewPersonalInfo.add(account.getPhoneNumber());
        viewPersonalInfo.add(account.getRole().toString());
        return viewPersonalInfo;
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

    public ArrayList<Good> showProducts() {
        return Good.getAllProducts();
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

    public static class RepeatedUsername extends Exception{
        public RepeatedUsername(){
            super("username had been used");
        }
    }



}
