package ScenesAndControllers;

import controller.BuyerManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Buyer;
import model.Role;

import java.io.IOException;


public class singleProductSceneController {

    @FXML
    Label name;
    @FXML
    Label seller;
    @FXML
    Label brand;
    @FXML
    Label description;
    @FXML
    Label price;
    @FXML
    Label averageScore;
    @FXML
    ImageView image;
    @FXML
    MenuBar menuBar;

    @FXML
    private void initialize() {

        name.setText(ProductsMenuController.selectedGood.getName());
        brand.setText(ProductsMenuController.selectedGood.getBrand());
        averageScore.setText(String.valueOf(ProductsMenuController.selectedGood.getAverageScore()));
        seller.setText(ProductsMenuController.selectedGood.getSeller().getUsername());
        description.setText(ProductsMenuController.selectedGood.getDescription());
        price.setText(String.valueOf(ProductsMenuController.selectedGood.getPrice()));
        image.setImage(ProductsMenuController.selectedGood.getImage());

    }

    public void backButton(ActionEvent event) throws IOException {
        ProductsMenuController.selectedGood = null;
        Parent login = FXMLLoader.load(getClass().getResource("ProductsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    public void addToCart() {
        if (Manager.loggedInAccount != null && Manager.loggedInAccount.getRole().equals(Role.buyer)) {
            BuyerManager.addProductToCart((Buyer) Manager.loggedInAccount, ProductsMenuController.selectedGood);
        } else {
            AlertBox.display("you need to login with a buyer account first");
        }
    }

    public void goToAccountPanel() throws IOException {
        if (Manager.loggedInAccount == null) {
            MainMenuController.primaryStage = (Stage) menuBar.getScene().getWindow();
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            Parent login = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
            Scene loginScene = new Scene(login);
            window.setScene(loginScene);
            window.showAndWait();
        } else {
            Parent login;
            if (Manager.loggedInAccount.getRole().equals(Role.seller)) {
                login = FXMLLoader.load(getClass().getResource("sellerAccountPanelScene.fxml"));
            }else if (Manager.loggedInAccount.getRole().equals(Role.buyer)) {
                login = FXMLLoader.load(getClass().getResource("buyerAccountPanelScene.fxml"));
            }else{
                login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
            }
            Scene loginScene = new Scene(login);
            Stage window = (Stage) menuBar.getScene().getWindow();
            window.setScene(loginScene);
        }

    }

    public void goToShoppingCart() throws IOException {
        if (Manager.loggedInAccount == null) {
            MainMenuController.primaryStage = (Stage) menuBar.getScene().getWindow();
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            Parent login = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
            Scene loginScene = new Scene(login);
            window.setScene(loginScene);
            window.showAndWait();
        } else if (Manager.loggedInAccount.getRole().equals(Role.buyer)){
            Parent login = FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
            Scene loginScene = new Scene(login);
            Stage window = (Stage) menuBar.getScene().getWindow();
            window.setScene(loginScene);
        } else {
            AlertBox.display("you need to login with a buyer account first");
        }
    }

    public void signOutOrIn() throws IOException {
        if (Manager.loggedInAccount == null) {
            MainMenuController.primaryStage = (Stage) menuBar.getScene().getWindow();
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            Parent login = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
            Scene loginScene = new Scene(login);
            window.setScene(loginScene);
            window.showAndWait();
        } else {
            Manager.loggedInAccount = null;
            AlertBox.display("Signed out successfully");
        }
    }

    public void showComments(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("CommentsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

}
