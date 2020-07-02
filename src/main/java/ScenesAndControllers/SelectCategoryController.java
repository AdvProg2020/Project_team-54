package ScenesAndControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Category;

import java.util.ArrayList;

public class SelectCategoryController {

    @FXML
    ChoiceBox<String> categories;

    public static String categoryName;

    @FXML
    private void initialize() {
        ArrayList<Category> categoryArrayList = Category.getAllCategories();

        for (Category category : categoryArrayList) {
            categories.getItems().add(category.getName());
        }

    }

    public void select(ActionEvent event) {
        categoryName = categories.getValue();
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

}
