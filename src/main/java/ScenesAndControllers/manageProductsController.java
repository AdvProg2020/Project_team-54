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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import model.Account;
import model.Good;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class manageProductsController {

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
    TextField name;
    @FXML
    TextField brand;
    @FXML
    TextField price;
    @FXML
    TextField seller;
    @FXML
    TextField description;
    @FXML
    TextField id;
    @FXML
    ImageView image;

    @FXML
    private void initialize() {
        desColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
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

    public void addProduct() {
        productsTable.getItems().add(new Good(image.getImage(), Integer.parseInt(id.getText()), name.getText(), brand.getText(), Double.parseDouble(price.getText()), Account.getAccountWithUsername("rezas"), true, null, description.getText()));
    }

    public void deleteProduct() {
        ObservableList<Good> removedProduct , allProducts;
        allProducts = productsTable.getItems();
        removedProduct = productsTable.getSelectionModel().getSelectedItems();

        removedProduct.forEach(Good.allProducts::remove);
        removedProduct.forEach(allProducts::remove);
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDragDropped(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        image.setImage(img);
    }


}
