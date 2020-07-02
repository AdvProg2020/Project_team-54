package ScenesAndControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Off;

import java.io.IOException;

public class SelectOffController {

    @FXML
    ChoiceBox<String> offs;

    public static Off selectedOff;

    @FXML
    private void initialize() {
        for (Off off : Off.getAllOffs()) {
            offs.getItems().add(String.valueOf(off.getId()));
        }
    }

    public void select(ActionEvent event) throws IOException {
        selectedOff = Off.getOffById(Integer.parseInt(offs.getValue()));

        Parent login = FXMLLoader.load(getClass().getResource("OffScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }

    public void back(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }
}
