package ScenesAndControllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Account;
import model.Requests.RequestEditProduct;
import model.Role;
import model.Seller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class accountPanelController {

    private static Account account;


    @FXML
    MenuBar menuBar;
    @FXML
    Label userName;
    @FXML
    Label firstName;
    @FXML
    Label lastName;
    @FXML
    Label email;
    @FXML
    Label phoneNumber;
    @FXML
    Label credits;
    @FXML
    Label company;
    @FXML
    ImageView image;


    @FXML
    private void initialize() {
        account = Manager.loggedInAccount;
        if (account != null) {
            image.setImage(account.getImage());
            userName.setText(account.getUsername());
            firstName.setText(account.getFirstName());
            lastName.setText(account.getLastName());
            email.setText(account.getEmail());
            phoneNumber.setText(account.getPhoneNumber());
            if (!Manager.loggedInAccount.getRole().equals(Role.administrator))
                credits.setText(String.valueOf(account.getBalance()));
            if (Manager.loggedInAccount.getRole().equals(Role.seller))
                company.setText(((Seller) Manager.loggedInAccount).getCompanyName());
        } else {
            AlertBox.display("logged in account not set yet");
        }
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDragDropped(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        image.setImage(img);
    }

    public void saveNewImage() {
        Manager.loggedInAccount.setImage(image.getImage());
        AlertBox.display("Image Changed Successfully");
    }

    public void manageOffs() throws IOException {
        Parent products = FXMLLoader.load(getClass().getResource("manageOffsScene.fxml"));
        Scene productsScene = new Scene(products);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(productsScene);
    }

    public void goToShoppingCart(Event event) throws IOException {
        if (Manager.loggedInAccount == null) {
            MainMenuController.primaryStage = (Stage) menuBar.getScene().getWindow();
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            Parent login = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
            Scene loginScene = new Scene(login);
            window.setScene(loginScene);
            window.showAndWait();
        } else if (Manager.loggedInAccount.getRole().equals(Role.buyer)) {
            Parent login = FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
            Scene loginScene = new Scene(login);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
        } else {
            AlertBox.display("you need to login with a buyer account first");
        }
    }

    public void changeCompany() {
        AlertBox.getNewInformation("Enter your new Company name : ", "Company name", "Change your Company name");
        if (AlertBox.sentText != null) {
            if (AlertBox.sentText.equals("")) {
                AlertBox.display("enter a valid name");
            }else {
                ((Seller) account).setCompanyName(AlertBox.sentText);
                company.setText(AlertBox.sentText);
            }
        }
        AlertBox.sentText = null;
    }

    public void changeUserName() {

        AlertBox.getNewInformation("Enter your new Username : ", "Username", "Change your Username");

        if (AlertBox.sentText != null) {
            if (!Manager.isUsernameValid(AlertBox.sentText))
                AlertBox.display("Please Enter a Valid Username");
            else if (Manager.checkUserNameRepeated(AlertBox.sentText)) {
                AlertBox.display("Username had been used");
            } else {
                account.setUsername(AlertBox.sentText);
                userName.setText(AlertBox.sentText);
            }
        }
        AlertBox.sentText = null;
    }

    public void changePassword() {
        AlertBox.getNewInformation("Enter your new password : ", "Password", "Change your Password");
        if (AlertBox.sentText != null) {
            if (!Manager.isPasswordValid(AlertBox.sentText))
                AlertBox.display("Please Enter a Valid Password");
            else
                account.setPassword(AlertBox.sentText);
        }
        AlertBox.sentText = null;
    }

    public void changeFirstName() {
        AlertBox.getNewInformation("Enter your new First name : ", "First name", "Change your First name");
        if (AlertBox.sentText != null) {
            if (AlertBox.sentText.equals("")) {
                AlertBox.display("enter a valid name");
            }else {
                account.setFirstName(AlertBox.sentText);
                firstName.setText(AlertBox.sentText);
            }
        }
        AlertBox.sentText = null;
    }

    public void changeLastName() {
        AlertBox.getNewInformation("Enter your new Last name : ", "Last name", "Change your Last name");
        if (AlertBox.sentText != null) {
            if (AlertBox.sentText.equals("")) {
                AlertBox.display("enter a valid name");
            }else {
                account.setLastName(AlertBox.sentText);
                lastName.setText(AlertBox.sentText);
            }
        }
        AlertBox.sentText = null;
    }

    public void changeEmail() {
        AlertBox.getNewInformation("Enter your new Email : ", "Email@Gmail.com", "Change your Email");
        if (AlertBox.sentText != null) {
            if (!Manager.isEmailValid(AlertBox.sentText))
                AlertBox.display("Please Enter a Valid Email");
            else {
                account.setUsername(AlertBox.sentText);
                email.setText(AlertBox.sentText);
            }
            AlertBox.sentText = null;
        }
    }

    public void changePhoneNumber() {
        AlertBox.getNewInformation("Enter your new Phone number : ", "09.........", "Change your Phone number");
        if (AlertBox.sentText != null) {
            if (!Manager.isPhoneNumberValid(AlertBox.sentText))
                AlertBox.display("Please Enter a Valid Phone Number");
            else {
                account.setUsername(AlertBox.sentText);
                phoneNumber.setText(AlertBox.sentText);
            }
        }
        AlertBox.sentText = null;
    }

    public void goToProductsScene(ActionEvent event) throws IOException {
        Parent products = FXMLLoader.load(getClass().getResource("productsScene.fxml"));
        Scene productsScene = new Scene(products);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(productsScene);
    }

    public void logout() throws IOException {
        Manager.loggedInAccount = null;
        Parent login = FXMLLoader.load(getClass().getResource("mainMenuScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void manageAccounts() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("manageAccountsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void manageProducts() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("manageProductsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void manageCategories() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("manageCategoriesScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void manageFilters() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("manageFilters.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void goToRequestScene() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("manageRequestsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void manageDiscountCodes() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("manageDiscountCodes.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void goToSellerProductScene() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("SellerProductsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void goToBuyerDiscountCodes() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("ViewDiscountCodes.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void addCredit() {
        AlertBox.getNewInformation("Enter your Gift card code : ", "Code", "Add credit using Gift card");
        if (AlertBox.sentText != null) {
            switch (AlertBox.sentText) {
                case ("gift50k") :
                    Manager.loggedInAccount.addBalance(50000);
                    break;
                case ("gift100k") :
                    Manager.loggedInAccount.addBalance(100000);
                    break;
                case ("gift1mil") :
                    Manager.loggedInAccount.addBalance(1000000);
                    break;
                default: AlertBox.display("Invalid Gift card");
            }
            credits.setText(String.valueOf(Manager.loggedInAccount.getBalance()));
        }
        AlertBox.sentText = null;

    }

    public void goToBuyLogs() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("ViewBuyLogsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

    public void goToSalePage(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("SelectOffScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    public void goToSellLogs() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("ViewSellLogsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) menuBar.getScene().getWindow();
        window.setScene(loginScene);
    }

}
