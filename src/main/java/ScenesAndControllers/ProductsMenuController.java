package ScenesAndControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import model.Good;


public class ProductsMenuController {

    @FXML
    TableView<Good> productsTable;
    @FXML
    TableColumn<Good, Image> imageColumn;
    @FXML
    TableColumn<Good, String> nameColumn;
    @FXML
    TableColumn<Good, Double> priceColumn;
    @FXML
    TableColumn<Good, Double> ratingColumn;


    @FXML
    private void initialize() {

        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("averageScore"));

        productsTable.setItems(products());
    }

    private ObservableList<Good> products() {
        ObservableList<Good> products = FXCollections.observableArrayList();
        products.addAll(Good.allProducts);
        return products;
    }




}
