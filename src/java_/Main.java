package java_;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.* ;
import javafx.stage.Stage;

public class Main extends Application {
 

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SigninScene.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("PropTrackR");
        primaryStage.setScene(scene); 
        primaryStage.setResizable(false);
        // main color: #263F73
        // Image icon = new Image("C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\java_\\Property_Real_Estate_logo_5.png");
        // primaryStage.getIcons().add(icon);

        primaryStage.show();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
}
