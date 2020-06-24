package view2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage = null;
    private Image mainImage = new Image("images/background.jpg");
    private BackgroundImage mainBackgroundImage = new BackgroundImage(mainImage, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        primaryStage.setTitle("OnlineShopping!");
        primaryStage.setScene(new Scene(root,900,600));
        primaryStage.show();

        this.mainStage = primaryStage;

        Pane root = new Pane();
        mainStage.setTitle("Online Shopping");

        Button allProducts = new Button("All Products");
        allProducts.setLayoutX(500);
        allProducts.setLayoutY(200);


        Button registerButton = new Button("Register");
        registerButton.setLayoutX(500);
        registerButton.setLayoutY(250);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(500);
        loginButton.setLayoutY(300);

        Button exitButton = new Button("Exit");
        exitButton.setLayoutX(500);
        exitButton.setLayoutY(350);
        exitButton.setOnAction(e -> mainStage.close());

        root.getChildren().add(allProducts);
        root.getChildren().add(registerButton);
        root.getChildren().add(loginButton);
        root.getChildren().add(exitButton);

        root.setBackground(new Background(mainBackgroundImage));
        mainStage.setScene(new Scene(root, 1300, 600));
        mainStage.setResizable(false);
        mainStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

