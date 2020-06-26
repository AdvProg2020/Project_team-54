package ScenesAndControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Account;

public class buyerAccountPanelController {

    private static Account account;

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
    private void initialize() {
        account = Manager.loggedInAccount;
        userName.setText(account.getUsername());
        firstName.setText(account.getFirstName());
        lastName.setText(account.getLastName());
        email.setText(account.getEmail());
        phoneNumber.setText(account.getPhoneNumber());
        credits.setText(String.valueOf(account.getBalance()));
    }


    public void changeUserName() {
        AlertBox.getNewInformation("Enter your new username : ", "Username", "Change your username");
        account.setUsername(AlertBox.sentText);
        AlertBox.sentText = null;
    }

}
