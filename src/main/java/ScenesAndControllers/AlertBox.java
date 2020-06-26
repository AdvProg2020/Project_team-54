package ScenesAndControllers;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;


public class AlertBox {

    public static String sentText;

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

        window.setTitle("Error");
        window.setMinWidth(250);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void getNewInformation(String value, String promptText, String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(value);
        TextField textField = new TextField();
        textField.setPrefWidth(200);
        textField.setPromptText(promptText);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> {sentText = textField.getText(); window.close();});

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(label,textField, closeButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);

        window.setTitle(title);
        window.setMinWidth(350);
        window.setScene(scene);
        window.showAndWait();
    }
}
