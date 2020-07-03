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
import model.SellLog;
import model.Seller;

import java.io.IOException;

public class ViewSellLogsController {

    @FXML
    TableColumn<SellLog, String> buyerColumn;
    @FXML
    TableColumn<SellLog, Double > amountColumn;
    @FXML
    TableColumn<SellLog, Double> productsColumn;
    @FXML
    TableColumn<SellLog, String > dateColumn;
    @FXML
    TableView<SellLog> sellTable;


    @FXML
    private void initialize() {

        buyerColumn.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amountReceived"));
        productsColumn.setCellValueFactory(new PropertyValueFactory<>("deductedAmount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("stringDate"));

        sellTable.setItems(products());
    }

    private ObservableList<SellLog> products() {
        ObservableList<SellLog> products = FXCollections.observableArrayList();
        products.addAll(((Seller) Manager.loggedInAccount).getSellLogs());
        return products;
    }


    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("sellerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

}
