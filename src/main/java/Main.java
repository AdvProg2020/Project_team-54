import model.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        if (Account.getAllAccounts().size() == 0) {
            Parent loginMenu = FXMLLoader.load(getClass().getResource("ScenesAndControllers/SignUpScene.fxml"));
            primaryStage.setTitle("Shopping App");
            primaryStage.setScene(new Scene(loginMenu));
            primaryStage.show();
        } else {
            Parent loginMenu = FXMLLoader.load(getClass().getResource("ScenesAndControllers/mainMenuScene.fxml"));
            primaryStage.setTitle("Shopping App");
            primaryStage.setScene(new Scene(loginMenu));
            primaryStage.show();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
