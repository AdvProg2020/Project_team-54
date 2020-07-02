package ScenesAndControllers;

import controller.AdministratorManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Good;
import model.Requests.Request;
import model.Requests.RequestConfirmation;

import java.io.IOException;

public class ManageRequestController {

    @FXML
    TableView<Request> requestTable;
    @FXML
    TableColumn<Request, Integer> idColumn;
    @FXML
    TableColumn<Request, String> requestColumn;
    @FXML
    TableColumn<Request, RequestConfirmation> statusColumn;


    public void accept() {
        ObservableList<Request> selectedRequest;
        selectedRequest = requestTable.getSelectionModel().getSelectedItems();
        AdministratorManager.acceptRequestButton(selectedRequest.get(0).getId());

    }

    public void deny() {
        ObservableList<Request> selectedRequest;
        selectedRequest = requestTable.getSelectionModel().getSelectedItems();
        AdministratorManager.refuseRequestButton(selectedRequest.get(0).getId());
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("managerAccountPanelScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }
}
