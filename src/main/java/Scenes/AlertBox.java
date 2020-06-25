package Scenes;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;


public class AlertBox {

    public static void display(String massage) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(massage);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(label, closeButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);

        window.setTitle("Massage");
        window.setMinWidth(230);
        window.setScene(scene);
        window.showAndWait();
    }
}
