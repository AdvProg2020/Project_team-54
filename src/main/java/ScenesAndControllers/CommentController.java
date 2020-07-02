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
import model.Buyer;
import model.Comment;
import model.Good;
import model.Requests.RequestAddComment;
import model.Role;

import java.io.IOException;

public class CommentController {

    @FXML
    TableView<Comment> commentTable;
    @FXML
    TableColumn<Comment, String> accountColumn;
    @FXML
    TableColumn<Comment, String> commentColumn;
    @FXML
    TextField comment;

    @FXML
    private void initialize() {
        accountColumn.setCellValueFactory(new PropertyValueFactory<>("accountName"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        commentTable.setItems(comments());
    }

    private ObservableList<Comment> comments() {
        ObservableList<Comment> comment = FXCollections.observableArrayList();
        comment.addAll(ProductsMenuController.selectedGood.getComments());
        return comment;
    }

    public void postComment() {

        if (Manager.loggedInAccount != null && Manager.loggedInAccount.getRole().equals(Role.buyer)) {
            commentTable.getItems().add(new Comment(Manager.loggedInAccount, ProductsMenuController.selectedGood, comment.getText()));
            comment.clear();
            AlertBox.display("your comment has been added");
        } else
            AlertBox.display("you need to login with a buyer account first");
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("singleProductScene.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
    }



}
