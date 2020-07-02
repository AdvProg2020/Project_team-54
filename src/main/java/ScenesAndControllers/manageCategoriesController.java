package ScenesAndControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Account;
import model.Category;
import model.Good;

import java.io.IOException;

public class manageCategoriesController {

    @FXML
    TableView<Category> categoryTable;
    @FXML
    TableColumn<Category, String> categoryColumn;
    @FXML
    TextField name;
    @FXML
    TextField parentName;

    @FXML
    private void initialize() {

        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        categoryTable.setItems(products());
    }

    private ObservableList<Category> products() {
        ObservableList<Category> products = FXCollections.observableArrayList();
        products.addAll(Category.getAllCategories());
        return products;
    }

    public void addCategory() {
        if (parentName.getText().equals(""))
            categoryTable.getItems().add(new Category(name.getText(), null));
        else
            categoryTable.getItems().add(new Category(name.getText(), Category.getCategoryWithName(parentName.getText())));
    }

    public void deleteSelectedCategory() {
        ObservableList<Category> removedProduct , allProducts;
        allProducts = categoryTable.getItems();
        removedProduct = categoryTable.getSelectionModel().getSelectedItems();

        removedProduct.forEach(Category.allCategories::remove);
        removedProduct.forEach(allProducts::remove);
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

}
