package ScenesAndControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class CompareController {

    @FXML
    ImageView image1;
    @FXML
    Label price1;
    @FXML
    Label brand1;
    @FXML
    Label description1;
    @FXML
    Label rating1;
    @FXML
    ImageView image2;
    @FXML
    Label price2;
    @FXML
    Label brand2;
    @FXML
    Label description2;
    @FXML
    Label rating2;

    @FXML
    private void initialize() {
        image1.setImage(ProductsMenuController.firstSelectedGoodForCompare.getImage());
        image2.setImage(ProductsMenuController.secondSelectedGoodForCompare.getImage());
        price1.setText(String.valueOf(ProductsMenuController.firstSelectedGoodForCompare.getPrice()));
        price2.setText(String.valueOf(ProductsMenuController.secondSelectedGoodForCompare.getPrice()));
        rating1.setText(String.valueOf(ProductsMenuController.firstSelectedGoodForCompare.getAverageScore()));
        rating2.setText(String.valueOf(ProductsMenuController.secondSelectedGoodForCompare.getAverageScore()));
        description1.setText(ProductsMenuController.firstSelectedGoodForCompare.getDescription());
        description2.setText(ProductsMenuController.secondSelectedGoodForCompare.getDescription());
        brand1.setText(ProductsMenuController.firstSelectedGoodForCompare.getBrand());
        brand2.setText(ProductsMenuController.secondSelectedGoodForCompare.getBrand());

    }

    public void backButton(ActionEvent event) throws IOException {
        ProductsMenuController.firstSelectedGoodForCompare = null;
        ProductsMenuController.secondSelectedGoodForCompare = null;
        Parent login = FXMLLoader.load(getClass().getResource("ProductsScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }


}
