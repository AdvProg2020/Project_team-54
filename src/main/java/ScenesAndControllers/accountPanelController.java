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
            if (Manager.loggedInAccount.getRole().equals(Role.buyer))
                credits.setText(String.valueOf(account.getBalance()));
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
        ((Seller) account).setCompanyName(AlertBox.sentText);
        company.setText(AlertBox.sentText);
        AlertBox.sentText = null;
    }

    public void changeUserName() {
        AlertBox.getNewInformation("Enter your new Username : ", "Username", "Change your Username");
        account.setUsername(AlertBox.sentText);
        userName.setText(AlertBox.sentText);
        AlertBox.sentText = null;
    }

    public void changePassword() {
        AlertBox.getNewInformation("Enter your new password : ", "Password", "Change your Password");
        account.setPassword(AlertBox.sentText);
        AlertBox.sentText = null;
    }

    public void changeFirstName() {
        AlertBox.getNewInformation("Enter your new First name : ", "First name", "Change your First name");
        account.setFirstName(AlertBox.sentText);
        firstName.setText(AlertBox.sentText);
        AlertBox.sentText = null;
    }

    public void changeLastName() {
        AlertBox.getNewInformation("Enter your new Last name : ", "Last name", "Change your Last name");
        account.setLastName(AlertBox.sentText);
        lastName.setText(AlertBox.sentText);
        AlertBox.sentText = null;
    }

    public void changeEmail() {
        AlertBox.getNewInformation("Enter your new Email : ", "Email@Gmail.com", "Change your Email");
        account.setUsername(AlertBox.sentText);
        email.setText(AlertBox.sentText);
        AlertBox.sentText = null;
    }

    public void changePhoneNumber() {
        AlertBox.getNewInformation("Enter your new Phone number : ", "09.........", "Change your Phone number");
        account.setUsername(AlertBox.sentText);
        phoneNumber.setText(AlertBox.sentText);
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

}
