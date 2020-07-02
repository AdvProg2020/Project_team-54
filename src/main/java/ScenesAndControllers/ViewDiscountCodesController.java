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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Buyer;
import model.DiscountCode;

import java.io.IOException;

public class ViewDiscountCodesController {

    @FXML
    TableColumn<DiscountCode, String> codeColumn;
    @FXML
    TableColumn<DiscountCode, String > startColumn;
    @FXML
    TableColumn<DiscountCode, String> endColumn;
    @FXML
    TableColumn<DiscountCode, Double > percentageColumn;
    @FXML
    TableColumn<DiscountCode,Double> maxAmountColumn;
    @FXML
    TableView<DiscountCode> discountCodeTable;


    @FXML
    private void initialize() {

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        maxAmountColumn.setCellValueFactory(new PropertyValueFactory<>("maxAmount"));

        discountCodeTable.setItems(products());
    }

    private ObservableList<DiscountCode> products() {
        ObservableList<DiscountCode> products = FXCollections.observableArrayList();
        products.addAll(((Buyer) Manager.loggedInAccount).getAllDiscountCodes());
        return products;
    }


    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

}
