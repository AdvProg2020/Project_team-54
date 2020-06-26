package ScenesAndControllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import model.Requests.RequestNewManager;
import model.Requests.RequestNewSeller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    @FXML
     TextField username;
    @FXML
     PasswordField password;
    @FXML
     TextField firstName;
    @FXML
     TextField lastName;
    @FXML
     TextField email;
    @FXML
     TextField phoneNumber;
    @FXML
     ChoiceBox<String> accountType;


    @FXML
    private void initialize() {
        accountType.getItems().addAll("buyer", "seller", "manager");
        accountType.setValue("buyer");
    }

    public void registerScene(ActionEvent event) throws Exception {
        if (register(username.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phoneNumber.getText(), null, accountType.getValue()) == 0) {
            Parent login = FXMLLoader.load(getClass().getResource("ScenesAndControllers/mainMenuScene.fxml"));
            Scene loginScene = new Scene(login);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
        }
    }





    public static Account loggedInAccount;
    private static ArrayList<Account> allActiveAccounts = new ArrayList<>();
    private static ArrayList<Buyer> allActiveBuyer = new ArrayList<>();
    public static ArrayList<Seller> allActiveSeller = new ArrayList<>();
    private static ArrayList<model.Manager> allManager = new ArrayList<>();
//    ArrayList<String> viewPersonalInfo = new ArrayList<>();





    public Manager() {

    }

    public Manager(Account loggedInAccount1) {
        loggedInAccount = loggedInAccount1;
    }

    public static Account login(String userName, String password) throws Exception {
        //String fileLocation = userName + "/gson.txt";
        //ReadAndWriteFromFile t = new ReadAndWriteFromFile();
        if (!isUsernameValid(userName))
            AlertBox.display("Username is not valid");
//            throw new Exception("Username is not valid");
        else if (!isPasswordValid(password)) {
            AlertBox.display("Password is not valid");
//            throw new Exception("Password is not valid");
        }
        else if (!checkUserNameRepeated(userName))
            AlertBox.display("This Username has not registered !!!!");
//            throw new Exception("this Username has not registered !!!!");
        else if (!checkUsernameAndPassword(userName, password))
            AlertBox.display("Username and password is incorrect");
//            throw new Exception("username and password is incorrect");
        else if (!Account.getAccountWithUsername(userName).getPassword().equals(password)) {
//            in if momkene bug dashte bashe
            AlertBox.display("Password is not correct");
//            throw new Exception("Password is not correct");
        }
        else {
            //String response = t.readFromFile(fileLocation);
            //if (response.startsWith("File doesn't exist"))
            //    return null;
            loggedInAccount = getAccountWithUsername(userName);
            return loggedInAccount; //null or real account
        }
        return null;
    }

    public static int register(String userName, String password, String firstName,
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
            AlertBox.display("Please Enter a Valid Username");
//            throw new Exception("Please Enter a Valid Username");
        else if (checkUserNameRepeated(userName)) {
            AlertBox.display("Username had been used");
//            throw new RepeatedUsername();
            //throw new Exception("Already registered with this username");
        } else if (!isPasswordValid(password))
            AlertBox.display("Please Enter a Valid Password");
//            throw new Exception("Please Enter a Valid Password");
        else if (!isEmailValid(eMail))
            AlertBox.display("Please Enter a Valid Email");
//            throw new Exception("Please Enter a Valid Email");
        else if (!isPhoneNumberValid(phoneNumber))
            AlertBox.display("Please Enter a Valid Phone Number");
//            throw new Exception("Please Enter a Valid Phone Number");
        else if (role.equalsIgnoreCase("buyer")) {
            Account account2 = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.buyer);
            Buyer buyer = new Buyer(userName, firstName, lastName, eMail, phoneNumber, password, Role.buyer);
            allActiveAccounts.add(account2);
            allActiveBuyer.add(buyer);
            return 0;
            //t.writeToFile(gson.toJson(buyer), fileLocation);
        } else if (role.equalsIgnoreCase("seller")) {
            RequestNewSeller newSeller = new RequestNewSeller(userName, firstName, lastName, phoneNumber, eMail, password, companyName);
            newSeller.setWhoRequested(loggedInAccount.getUsername());
            return 0;
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
            return 0;
        }
        return 1;
    }

    public static Boolean checkUserNameRepeated(String userName) {
        for (int i = 0; i < allActiveAccounts.size(); i++) {
            if (allActiveAccounts.get(i).getUsername().equalsIgnoreCase(userName))
                return true;
        }
        return false;
    }

    public static Boolean checkUsernameAndPassword(String userName, String password) {
        for (int i = 0; i < allActiveAccounts.size(); i++) {
            if (allActiveAccounts.get(i).getUsername().equalsIgnoreCase(userName) && allActiveAccounts.get(i).getPassword().equals(password))
                return true;
        }
        return false;
    }

    public static Account getAccountWithUsername(String username) {
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

//    public void editField(String field, String newInput) throws Exception {
//        if (loggedInAccount.getRole().equals(Role.buyer)) {
//            for (int i = 0; i < allActiveBuyer.size(); i++) {
//                if (allActiveBuyer.get(i).getUsername().equalsIgnoreCase(loggedInAccount.getUsername())) {
//                    if (field.equalsIgnoreCase("name")) {
//                        loggedInAccount.setFirstName(newInput);
//                        allActiveBuyer.get(i).setFirstName(newInput);
//                    } else if (field.equalsIgnoreCase("lastName")) {
//                        loggedInAccount.setLastName(newInput);
//                        allActiveBuyer.get(i).setLastName(newInput);
//                    } else if (field.equalsIgnoreCase("email")) {
//                        if (!isEmailValid(newInput))
//                            AlertBox.display("Please Enter a Valid Email");
////                            throw new Exception("Please Enter a Valid Email");
//                        else
//                            loggedInAccount.setEmail(newInput);
//                        allActiveBuyer.get(i).setEmail(newInput);
//                    } else if (field.equalsIgnoreCase("phoneNumber")) {
//                        if (!isPhoneNumberValid(newInput))
//                            AlertBox.display("Please Enter a Valid Phone Number");
////                            throw new Exception("Please Enter a Valid Phone Number");
//                        else
//                            loggedInAccount.setPhoneNumber(newInput);
//                        allActiveBuyer.get(i).setPhoneNumber(newInput);
//                    } else if (field.equalsIgnoreCase("password")) {
//                        if (!isPasswordValid(newInput))
//                            AlertBox.display("Please Enter a Valid Password");
////                            throw new Exception("Please Enter a Valid Password");
//                        else
//                            loggedInAccount.setPassword(newInput);
//                        allActiveBuyer.get(i).setPassword(newInput);
//                    }
//                }
//            }
//        } else if (loggedInAccount.getRole().equals(Role.seller)) {
//            for (int i = 0; i < allActiveSeller.size(); i++) {
//                if (allActiveSeller.get(i).getUsername().equalsIgnoreCase(loggedInAccount.getUsername())) {
//                    if (field.equalsIgnoreCase("name")) {
//                        loggedInAccount.setFirstName(newInput);
//                        allActiveSeller.get(i).setFirstName(newInput);
//                    } else if (field.equalsIgnoreCase("lastName")) {
//                        loggedInAccount.setLastName(newInput);
//                        allActiveSeller.get(i).setLastName(newInput);
//                    } else if (field.equalsIgnoreCase("email")) {
//                        if (!isEmailValid(newInput))
//                            AlertBox.display("Please Enter a Valid Email");
////                            throw new Exception("Please Enter a Valid Email");
//                        else
//                            loggedInAccount.setEmail(newInput);
//                        allActiveSeller.get(i).setEmail(newInput);
//                    } else if (field.equalsIgnoreCase("phoneNumber")) {
//                        if (!isPhoneNumberValid(newInput))
//                            AlertBox.display("Please Enter a Valid Phone Number");
////                            throw new Exception("Please Enter a Valid Phone Number");
//                        else
//                            loggedInAccount.setPhoneNumber(newInput);
//                        allActiveSeller.get(i).setPhoneNumber(newInput);
//                    } else if (field.equalsIgnoreCase("password")) {
//                        if (!isPasswordValid(newInput))
//                            AlertBox.display("Please Enter a Valid Password");
////                            throw new Exception("Please Enter a Valid Password");
//                        else
//                            loggedInAccount.setPassword(newInput);
//                        allActiveSeller.get(i).setPassword(newInput);
//                    }
//                }
//            }
//        }
//    }

//    public ArrayList<String> viewPersonalInfo() {
//        viewPersonalInfo.add(loggedInAccount.getUsername());
//        viewPersonalInfo.add(loggedInAccount.getFirstName());
//        viewPersonalInfo.add(loggedInAccount.getLastName());
//        viewPersonalInfo.add(loggedInAccount.getEmail());
//        viewPersonalInfo.add(loggedInAccount.getPhoneNumber());
//        viewPersonalInfo.add(loggedInAccount.getRole().toString());
//        return viewPersonalInfo;
//    }

    public boolean isValidDiscountCode(String discountCode) {
        for (DiscountCode discount:DiscountCode.getAllDiscountCodes()) {
            if(discount.getCode().equals(discountCode))
                return true;
        }
        return false;
    }

    public boolean isUserExist(String userName) {
        for (Account account : Account.getAllAccounts()) {
            if (account.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    public boolean doesAdminExist() {
        if (model.Manager.getAllManagers().isEmpty()) {
            return false;
        }
        return true;
    }

    public ArrayList<Good> showProducts() {
        return Good.getAllProducts();
    }

//    public void isCategory(String name, ArrayList<Category> subCategory) {
//        //TODO
//    }

    public static boolean isEmailValid(String password) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    public static boolean isUsernameValid(String username) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    public static boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static class RepeatedUsername extends Exception {
        public RepeatedUsername() {
            super("username had been used");
        }
    }

}
