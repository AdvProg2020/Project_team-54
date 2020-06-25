package ScenesAndControllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Role;

import java.io.IOException;


public class MainMenuController {

    public void goToAccountPanel(ActionEvent event) throws IOException {

        if (Manager.loggedInAccount == null) {
            Stage window = new Stage();
            Parent login = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
            Scene loginScene = new Scene(login);
            window.setScene(loginScene);
            window.showAndWait();
        } else {
            Parent login;
            if (Manager.loggedInAccount.getRole().equals(Role.seller)) {
                login = FXMLLoader.load(getClass().getResource("sellerAccountPanelScene.fxml"));
            }else if (Manager.loggedInAccount.getRole().equals(Role.buyer)) {
                login = FXMLLoader.load(getClass().getResource("BuyerAccountPanelScene.fxml"));
            }else{
                login = FXMLLoader.load(getClass().getResource("ManagerAccountPanelScene.fxml"));
            }
            Scene loginScene = new Scene(login);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
        }

    }

    public void goToProductsPage(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("mainMenuScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    public void goToSalePage() {
        //TODO
    }

    public void exit(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

}
