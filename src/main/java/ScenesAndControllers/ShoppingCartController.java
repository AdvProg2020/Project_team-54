package ScenesAndControllers;

import controller.BuyerManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Buyer;
import model.Good;
import model.Role;

import java.io.IOException;


public class ShoppingCartController {

    private static BuyerManager buyerManager = new BuyerManager((Buyer) Manager.loggedInAccount);


    @FXML
    MenuBar menuBar;
    @FXML
    TableView<Good> productsTable;
    @FXML
    TableColumn<Good, Image> desColumn;
    @FXML
    TableColumn<Good, String> nameColumn;
    @FXML
    TableColumn<Good, Double> priceColumn;
    @FXML
    TableColumn<Good, Integer> quantityColumn;
    @FXML
    Label total;
    @FXML
    TextField discountCode;




    @FXML
    private void initialize() {


        total.setText(String.valueOf(buyerManager.cartPrice()));


        desColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        productsTable.setItems(products());
    }


    private ObservableList<Good> products() {
        ObservableList<Good> products = FXCollections.observableArrayList();
        products.addAll(buyerManager.viewCart().keySet());
        return products;
    }

    public void increase() {
        Good product = productsTable.getSelectionModel().getSelectedItem();
        buyerManager.increaseProductInCart(product.getId());
        productsTable.refresh();
        total.setText(String.valueOf(buyerManager.cartPrice()));
    }
    public void decrease() {
        Good product = productsTable.getSelectionModel().getSelectedItem();
        buyerManager.decreaseProductInCart(product.getId());

        if (!buyerManager.viewCart().containsKey(product))
            productsTable.getItems().remove(product);
        else
            productsTable.refresh();
        total.setText(String.valueOf(buyerManager.cartPrice()));


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
                login = FXMLLoader.load(getClass().getResource("BuyerAccountPanelScene.fxml"));
            }else{
                login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
            }
            Scene loginScene = new Scene(login);
            Stage window = (Stage) menuBar.getScene().getWindow();
            window.setScene(loginScene);
        }

    }

    public void applyDiscount() {
        total.setText(String.valueOf(buyerManager.calculateDiscountPrice(discountCode.getText())));
    }

    public void buy() {
        if (buyerManager.buy((Buyer) Manager.loggedInAccount, buyerManager.viewCart(), Double.parseDouble(total.getText())) == 0)
            productsTable.getItems().clear();
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

    public void goToMainMenu(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }



}
