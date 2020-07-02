package ScenesAndControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Category;
import model.Good;
import model.Role;

import java.io.IOException;


public class ProductsMenuController {

    @FXML
    TableView<Good> productsTable;
    @FXML
    TableColumn<Good, Image> desColumn;
    @FXML
    TableColumn<Good, String> nameColumn;
    @FXML
    TableColumn<Good, Double> priceColumn;
    @FXML
    TableColumn<Good, Double> ratingColumn;
    @FXML
    MenuBar menuBar;

    public static Good selectedGood;
    public static Good firstSelectedGoodForCompare;
    public static Good secondSelectedGoodForCompare;

    @FXML
    private void initialize() {

        desColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("averageScore"));

        productsTable.setItems(products());
    }


    public void category() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(getClass().getResource("SelectCategoryWindow.fxml"));
        Scene loginScene = new Scene(login);
        window.setScene(loginScene);
        window.showAndWait();

        ObservableList<Good> products = FXCollections.observableArrayList();
        products.addAll(Category.getCategoryWithName(SelectCategoryController.categoryName).getGoods());
        SelectCategoryController.categoryName = null;
        productsTable.setItems(products);
    }

    public void filter() {

    }



    private ObservableList<Good> products() {
        ObservableList<Good> products = FXCollections.observableArrayList();
        products.addAll(Good.allProducts);
        return products;
    }

    public void showProduct(ActionEvent event) throws IOException {
        selectedGood = productsTable.getSelectionModel().getSelectedItem();
        Parent login = FXMLLoader.load(getClass().getResource("SingleProductScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
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

    public void compareProducts(ActionEvent event) throws IOException {
        if (firstSelectedGoodForCompare == null) {
            firstSelectedGoodForCompare = productsTable.getSelectionModel().getSelectedItem();
            AlertBox.display("choose another item to compare with this one");
        } else {
            secondSelectedGoodForCompare = productsTable.getSelectionModel().getSelectedItem();
            Parent login = FXMLLoader.load(getClass().getResource("CompareScene.fxml"));
            Scene loginScene = new Scene(login);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
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

    public void goToMainMenu(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }


}
