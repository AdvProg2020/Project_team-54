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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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
    TableColumn<DiscountCode, String> startColumn;
    @FXML
    TableColumn<DiscountCode, String> endColumn;
    @FXML
    TableColumn<DiscountCode, Double> percentageColumn;
    @FXML
    TableColumn<DiscountCode, Double> maxAmountColumn;
    @FXML
    TableView<DiscountCode> discountCodeTable;
    @FXML
    TableView<Buyer> accountTable;
    @FXML
    TableColumn<Buyer, String> usernameColumn;
    @FXML
    TableColumn<Buyer, String> firstNameColumn;
    @FXML
    TableColumn<Buyer, String> lastNameColumn;
    @FXML
    TableColumn<Buyer, String> phoneNumberColumn;
    @FXML
    TableColumn<Buyer, String> emailColumn;
    @FXML
    TextField discountCodeForAdd;


    @FXML
    private void initialize() {
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        maxAmountColumn.setCellValueFactory(new PropertyValueFactory<>("maxAmount"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        accountTable.setItems(accounts());
        discountCodeTable.setItems(products());
    }

    private ObservableList<Buyer> accounts() {
        ObservableList<Buyer> accounts = FXCollections.observableArrayList();
        for (Account account : Manager.allActiveAccounts) {
            if (account.getRole().equals(Role.buyer))
                accounts.add((Buyer) account);
        }
        return accounts;
    }

    private ObservableList<DiscountCode> products() {
        ObservableList<DiscountCode> products = FXCollections.observableArrayList();
        products.addAll(DiscountCode.getAllDiscountCodes());
        return products;
    }

    public void addDiscountCode() {
        discountCodeTable.getItems().add(new DiscountCode(code.getText(), start.getText(), end.getText(), Double.parseDouble(percentage.getText()), Double.parseDouble(maxAmount.getText())));
    }

    public void deleteCode() {
        ObservableList<DiscountCode> removedProduct, allProducts;
        allProducts = discountCodeTable.getItems();
        removedProduct = discountCodeTable.getSelectionModel().getSelectedItems();

        removedProduct.forEach(DiscountCode.getAllDiscountCodes()::remove);
        removedProduct.forEach(allProducts::remove);
    }


    public void edit() throws AdministratorManager.DiscountCodeDoesNotExist {

        DiscountCode selectedCode = discountCodeTable.getSelectionModel().getSelectedItem();

        AdministratorManager.editCodedDiscount(selectedCode.getCode(), field.getText(), newInfo.getText());
        discountCodeTable.refresh();
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    public void addBuyerToCode() {
        ArrayList<Buyer> buyers = new ArrayList<>(accountTable.getSelectionModel().getSelectedItems());
        AdministratorManager.addBuyerToCode(buyers , Objects.requireNonNull(DiscountCode.getDiscountCodeWithCode(discountCodeForAdd.getText())));
        AlertBox.display("added successfully");
    }

}
