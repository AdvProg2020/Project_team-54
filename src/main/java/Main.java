import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import javax.print.attribute.standard.Media;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        createSomeObjects();
        if (Manager.getAllManagers().size() == 0) {
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

//        AudioClip theme = new AudioClip("file:///D:/Projects/AP/Tamrin3/javafx/src/sample/sounds/main.wav");
//        theme.play();
//        String ssound = "sound.mp3";
//        Media sound = new Media("images/Sound1.wav");
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();

        Image appleImage = new Image("images/apple.jpg");
        Image bananaImage = new Image("images/banana.jpg");
        Image peachImage = new Image("images/peach.jpg");
        Image shoeImage = new Image("images/shoe.jpg");
        Image hatImage = new Image("images/hat.jpg");
        Image iphoneImage = new Image("images/iphone.jpg");
        Image waterMelonImage = new Image("images/watermelon.jpg");
        Image handsfreeImage = new Image("images/handsfree.jpg");
        new model.Manager("mamad", "mohammad" , "hashemi", "1 ", "mhht@gmail.com", "mohi", Role.administrator);
        new Seller("rezas", "reza" , "soumi", "rez@gmail.com", "2", "bigrez","sharif", Role.seller);
        new Buyer("pooya", "pooya" , "pooyyyyaa", "pooya@gmail.com", "3", "poopa", Role.buyer);
        Category fruits  = new Category("fruits", null);
        Category phones  = new Category("phones", null);
        Category digital = new Category("digital",null);
        Good banana = new Good(1, "banana", "digikala", 4000, Account.getAccountWithUsername("rezas") , true, fruits, "very good for health");
        banana.setImage(bananaImage);
        Good apple = new Good(2, "apple", "digikala", 1000, Account.getAccountWithUsername("rezas") , true, fruits, "very good for breakfast");
        apple.setImage(appleImage);
        Good waterMelon = new Good(3, "water melon", "digikala", 15000, Account.getAccountWithUsername("rezas") , true, fruits, "very juicy and sweet");
        waterMelon.setImage(waterMelonImage);
        Good iphone = new Good(4, "iphone 11 pro max", "Iphone", 25000000, Account.getAccountWithUsername("rezas") , true, phones, "the next generation of iphones");
        iphone.setImage(iphoneImage);
//        Good galaxy = new Good(5, "Galaxy S20 ultra", "Samsung", 15000000, Account.getAccountWithUsername("rezas") , true, fruits, "a brand new galaxy phone");
        Good handsfree = new Good(6, "handsfree", "AKG", 15000, Account.getAccountWithUsername("rezas") , true, digital, "better experience");
        handsfree.setImage(handsfreeImage);
        Good peach = new Good(7, "peach", "tarebar", 10000, Account.getAccountWithUsername("rezas") , true, fruits, "peachy peachy!");
        peach.setImage(peachImage);

    }

}
