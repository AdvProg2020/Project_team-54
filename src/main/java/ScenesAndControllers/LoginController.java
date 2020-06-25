package ScenesAndControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Role;

import java.io.IOException;

public class LoginController {

    @FXML
    TextField username;
    @FXML
    PasswordField password;

    public void login(ActionEvent event) throws Exception {
        if(Manager.login(username.getText(), password.getText()) != null) {
            Parent login;
            if (Manager.loggedInAccount.getRole().equals(Role.seller)) {
                login = FXMLLoader.load(getClass().getResource("sellerAccountPanelScene.fxml"));
            }else if (Manager.loggedInAccount.getRole().equals(Role.buyer)) {
                login = FXMLLoader.load(getClass().getResource("BuyerAccountPanelScene.fxml"));
            }else{
                login = FXMLLoader.load(getClass().getResource("ManagerAccountPanelScene.fxml"));
            }
            Scene accountScene = new Scene(login);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            MainMenuController.primaryStage.setScene(accountScene);
            window.close();
        }

    }

    public void goToSignUpScene(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("signUpScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }
}
