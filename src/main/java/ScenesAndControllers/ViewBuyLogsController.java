package ScenesAndControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.BuyLog;
import model.Buyer;

import java.io.IOException;

public class ViewBuyLogsController {

    @FXML
    TableColumn<BuyLog, String> paidColumn;
    @FXML
    TableColumn<BuyLog, String > disColumn;
    @FXML
    TableColumn<BuyLog, String> productsColumn;
    @FXML
    TableColumn<BuyLog, Double > dateColumn;
    @FXML
    TableView<BuyLog> buyTable;


    @FXML
    private void initialize() {

        paidColumn.setCellValueFactory(new PropertyValueFactory<>("amountPaid"));
        disColumn.setCellValueFactory(new PropertyValueFactory<>("discountApplied"));
        productsColumn.setCellValueFactory(new PropertyValueFactory<>("allProductsInOneString"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("stringDate"));

        buyTable.setItems(products());
    }

    private ObservableList<BuyLog> products() {
        ObservableList<BuyLog> products = FXCollections.observableArrayList();
        products.addAll(((Buyer) Manager.loggedInAccount).getBuyLog());
        return products;
    }


    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("BuyerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

}
