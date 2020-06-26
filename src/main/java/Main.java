import model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        createSomeObjects();
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

    private void createSomeObjects() {
        new model.Manager("mamad", "mohammad" , "hashemi", "mhht@gmail.com", "1", "mohi", Role.administrator);
        new Seller("rezas", "reza" , "soumi", "rez@gmail.com", "2", "bigrez","sharif", Role.seller);
        new Buyer("pooya", "pooya" , "pooyyyyaa", "pooya@gmail.com", "3", "poopa", Role.buyer);
        Category fruits  = new Category("fruits", null);
        Category phones  = new Category("phones", null);
        new Good(1, "banana", "digikala", 4000, Account.getAccountWithUsername("rezas") , true, fruits, "very good for health");
        new Good(2, "apple", "digikala", 1000, Account.getAccountWithUsername("rezas") , true, fruits, "very good for breakfast");
        new Good(3, "water melon", "digikala", 15000, Account.getAccountWithUsername("rezas") , true, fruits, "very juicy and sweet");
        new Good(4, "iphone 11 pro max", "Iphone", 25000000, Account.getAccountWithUsername("rezas") , true, fruits, "the next generation of iphones");
        new Good(5, "Galaxy S20 ultra", "Samsung", 15000000, Account.getAccountWithUsername("rezas") , true, fruits, "a brand new galaxy phone");
    }
}
