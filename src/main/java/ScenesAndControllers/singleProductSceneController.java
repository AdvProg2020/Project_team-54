package ScenesAndControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import ScenesAndControllers.ProductsMenuController;
import javafx.scene.image.ImageView;


public class singleProductSceneController {

    @FXML
    Label name;
    @FXML
    Label seller;
    @FXML
    Label brand;
    @FXML
    Label description;
    @FXML
    Label price;
    @FXML
    Label averageScore;
    @FXML
    ImageView image;

    @FXML
    private void initialize() {

        name.setText(ProductsMenuController.selectedGood.getName());
        brand.setText(ProductsMenuController.selectedGood.getBrand());
        averageScore.setText(String.valueOf(ProductsMenuController.selectedGood.getAverageScore()));
        seller.setText(ProductsMenuController.selectedGood.getSeller().getUsername());
        description.setText(ProductsMenuController.selectedGood.getDescription());
        price.setText(String.valueOf(ProductsMenuController.selectedGood.getPrice()));
        image.setImage(ProductsMenuController.selectedGood.getImage());

    }


}
