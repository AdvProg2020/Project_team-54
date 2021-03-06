package ScenesAndControllers;

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
import javafx.stage.Stage;
import model.Account;

import java.io.IOException;

public class manageAccountsController {




    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField email;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField role;
    @FXML
    TableView<Account> accountTable;
    @FXML
    TableColumn<Account, String> usernameColumn;
    @FXML
    TableColumn<Account, String> firstNameColumn;
    @FXML
    TableColumn<Account, String> lastNameColumn;
    @FXML
    TableColumn<Account, String> phoneNumberColumn;
    @FXML
    TableColumn<Account, String> emailColumn;


    @FXML
    private void initialize() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        accountTable.setItems(accounts());
    }

    private ObservableList<Account> accounts() {
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        accounts.addAll(Manager.allActiveAccounts);
        return accounts;
    }

    public void addAccount() throws Exception {
        if (Manager.register(username.getText(),password.getText(),firstName.getText(),lastName.getText(),email.getText(),phoneNumber.getText(),null, role.getText()) == 0) {
            accountTable.setItems(accounts());
        }
    }

    public void deleteProduct() {
        ObservableList<Account> removedProduct , allProducts;
        allProducts = accountTable.getItems();
        removedProduct = accountTable.getSelectionModel().getSelectedItems();
        removedProduct.forEach(Manager.allActiveAccounts::remove);
        removedProduct.forEach(allProducts::remove);
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }
}
