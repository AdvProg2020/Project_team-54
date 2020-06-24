package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;
import com.google.gson.Gson;
import model.*;
import model.Requests.*;
import model.Requests.RequestNewManager;
import model.Requests.RequestNewSeller;
import view.ReadAndWriteFromFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    protected Account account;
    private ArrayList<Account> allActiveAccounts = new ArrayList<>();

    public Manager(){

    }

    public Manager(Account account) {
        this.account = account;
    }

    public Account login(String userName, String password) throws Exception {

        Gson gson = new Gson();

        String fileLocation = userName + "/gson.txt";
        ReadAndWriteFromFile t = new ReadAndWriteFromFile();
        if (!isUsernameValid(userName))
            throw new Exception("Username is not valid");
        else if(!isPasswordValid(password)) {
            throw new Exception("Password is not valid");
        }
//        else if (!Account.getAccountWithUsername(userName).getPassword().equals(password)) {
//            throw new Exception("Password is not correct");
//        }
        else{
            String response = t.readFromFile(fileLocation);
            if (response.startsWith("File doesn't exist"))
                return null;
            account = gson.fromJson(new FileReader("D:\\Projects\\AP\\Project_team-54"),Account.class);

//            account = Account.getAccountWithUsername(userName);
            return account;
        }
    }

    public void logout(){
//        fekr konm
//        this.account = null;
    }



    public void register(String userName, String password, String firstName,
                         String lastName, String eMail, String phoneNumber, String companyName, String role) throws Exception {
        String fileLocation = userName + "/gson.txt";
        Gson gson = new Gson();
        ReadAndWriteFromFile t = new ReadAndWriteFromFile();
        String response = t.readFromFile(fileLocation);
//        Buyer buyer = new Buyer(userName, firstName, lastName, eMail, phoneNumber, password, Role.buyer);
//        t.writeToFile(gson.toJson(buyer), fileLocation);

//        if (!response.startsWith("File doesn't exit"))
//            System.out.println("file ??????????");

//        if (!isUsernameValid(userName))
//            throw new Exception("Please Enter a Valid Username");
//        else if (!response.startsWith("File doesn't exit")) {
//            throw new RepeatedUsername();
//            //throw new Exception("Already registered with this username");
//        } else if (!isPasswordValid(password))
//            throw new Exception("Please Enter a Valid Password");
//        else if (!isEmailValid(eMail))
//            throw new Exception("Please Enter a Valid Email");
//        else if (!isPhoneNumberValid(phoneNumber))
//            throw new Exception("Please Enter a Valid Phone Number");
//        else
        if (role.equalsIgnoreCase("buyer")) {
            Account account2 = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.buyer);
            Buyer buyer = new Buyer(userName, firstName, lastName, eMail, phoneNumber, password, Role.buyer);

            String path = "D:\\Projects\\AP\\Project_team-54\\"+userName+".json";
            gson.toJson(buyer,new FileWriter(path));
            System.out.println("creation done");
//            t.writeToFile(gson.toJson(buyer), fileLocation);

        } else if (role.equalsIgnoreCase("seller")) {
            Account account2 = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.seller);
            RequestNewSeller newSeller = new RequestNewSeller(userName, firstName, lastName, phoneNumber, eMail, password, companyName);
            newSeller.setWhoRequested(account.getUsername());
            Seller seller = new Seller(userName, firstName, lastName, eMail, phoneNumber, password, companyName, Role.buyer);
            t.writeToFile(gson.toJson(seller), fileLocation);      //*** IT MUST INITIALIZE WHEN MANAGER ACCEPTED ***
        } else if (role.equalsIgnoreCase("manager")) {
            Account account2 = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.administrator);
            if (doesAdminExist()) {
                RequestNewManager newManager = new RequestNewManager(userName, firstName, lastName, phoneNumber, eMail, password);
            } else {
                model.Manager manager = new model.Manager(userName, firstName, lastName,
                        phoneNumber, eMail, password, Role.administrator);
                t.writeToFile(gson.toJson(manager), fileLocation);
            }
            //TODO
        }

        //allActiveAccounts.add(account2);
    }

    public static void readFromFile() throws FileNotFoundException {

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

    public ArrayList<String> viewInformation(){
        ArrayList<String> information = new ArrayList<>();
        information.add(account.getUsername());
        information.add(account.getName());
        information.add(account.getLastName());
        information.add(account.getEmail());
        information.add(account.getPhoneNumber());
        information.add(account.getRole().toString());
        return information;
        // view.ViewPersonalInfo
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
