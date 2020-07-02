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
import model.DiscountCode;
import model.Good;

import java.io.IOException;

public class manageDiscountCodesController {

    @FXML
    TextField code;
    @FXML
    TextField start;
    @FXML
    TextField end;
    @FXML
    TextField percentage;
    @FXML
    TextField maxAmount;
    @FXML
    TextField field;
    @FXML
    TextField newInfo;
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
        products.addAll(DiscountCode.getAllDiscountCodes());
        return products;
    }

   public void addDiscountCode() {

   }

    public void deleteCode() {
        ObservableList<DiscountCode> removedProduct , allProducts;
        allProducts = discountCodeTable.getItems();
        removedProduct = discountCodeTable.getSelectionModel().getSelectedItems();

        removedProduct.forEach(DiscountCode.getAllDiscountCodes()::remove);
        removedProduct.forEach(allProducts::remove);
    }


    public void edit() throws AdministratorManager.DiscountCodeDoesNotExist {

        DiscountCode selectedCode = discountCodeTable.getSelectionModel().getSelectedItem();

        AdministratorManager.editCodedDiscount(selectedCode.getCode(), field.getText(), newInfo.getText());
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

}
