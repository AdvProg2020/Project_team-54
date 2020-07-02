package ScenesAndControllers;

import controller.AdministratorManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;
import model.Requests.Request;
import model.Requests.RequestEditOff;
import model.Requests.RequestOff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class manageOffsController {

    @FXML
    TextField id;
    @FXML
    TextField start;
    @FXML
    TextField end;
    @FXML
    TextField discount;
    @FXML
    TextField field;
    @FXML
    TextField newInfo;
    @FXML
    TableColumn<Off, Integer> idColumn;
    @FXML
    TableColumn<Off, String> startColumn;
    @FXML
    TableColumn<Off, String> endColumn;
    @FXML
    TableColumn<Off, Integer> discountColumn;
    @FXML
    TableView<Off> OffTable;
    @FXML
    TableView<Good> productsTable;
    @FXML
    TableColumn<Good, String> desColumn;
    @FXML
    TableColumn<Good, String> nameColumn;
    @FXML
    TableColumn<Good, Double> priceColumn;
    @FXML
    TableColumn<Good, Double> ratingColumn;



    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        desColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("averageScore"));

        productsTable.setItems(products());
        OffTable.setItems(offs());

        productsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    private ObservableList<Good> products() {
        ObservableList<Good> products = FXCollections.observableArrayList();
        products.addAll(((Seller) Manager.loggedInAccount).getAllProducts());
        return products;
    }


    private ObservableList<Off> offs() {
        ObservableList<Off> products = FXCollections.observableArrayList();
        products.addAll(((Seller) Manager.loggedInAccount).allOffs);
        return products;
    }



    public void deleteOff() {
        ObservableList<Off> removedProduct, allProducts;
        allProducts = OffTable.getItems();
        removedProduct = OffTable.getSelectionModel().getSelectedItems();
        removedProduct.forEach(Off.getAllOffs()::remove);
        removedProduct.forEach(((Seller) Manager.loggedInAccount).allOffs::remove);
        removedProduct.forEach(allProducts::remove);
    }

    public void addOff() {
        ArrayList<Good> selectedProducts = new ArrayList<>(productsTable.getSelectionModel().getSelectedItems());
        new RequestOff((Seller) Manager.loggedInAccount, Integer.parseInt(id.getText()), selectedProducts, start.getText(), end.getText(), Integer.parseInt(discount.getText()));
        AlertBox.display("request sent");
    }



    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("sellerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    public void edit() {
        new RequestEditOff(OffTable.getSelectionModel().getSelectedItem(), field.getText(), newInfo.getText(),(Seller) Manager.loggedInAccount);
        AlertBox.display("request sent");
    }


}
