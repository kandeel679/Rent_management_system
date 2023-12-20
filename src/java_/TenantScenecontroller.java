package java_;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TenantScenecontroller implements Initializable{
    private Tenant user;
    Parent root;
    Stage stage;
    Scene scene;





    public TenantScenecontroller(Tenant user){
        this.user = user;
    }
    public TenantScenecontroller() {
        
    }

    public void SwitchToTenantScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantScene.fxml"));
        root = loader.load();
        // Get the controller instance
        TenantScenecontroller controller = loader.getController();
        // Call the public setUser method on the controller
        controller.setUser(user);  // Set the user before switching the scene
    
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToTenantApartmentScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayTenantAprt.fxml"));
        Parent root = loader.load();
    
        // Get the controller instance
        DisplayTenantApartController controller = loader.getController();
    
        // Call the public setUser method on the controller
        controller.setUser(user);  // Check that 'user' is not null here
    
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwtichToSearchScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApartSearchScene.fxml"));
        root = loader.load();
    
        // Get the controller instance
        ApartSearchSceneController controller = loader.getController();
    
        // Call the public setUser method on the controller
        controller.setUser(user);  // Check that 'user' is not null here
    
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwtichTOuserprofile(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserProfileScene.fxml"));
        Parent root = loader.load();
    
        // Get the controller instance
        UserProfileSceneController controller = loader.getController();
    
        // Call the public setUser method on the controller
        controller.setUser(user);  // Check that 'user' is not null here
        controller.setuserdata();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Logout(ActionEvent event )throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SigninScene.fxml"));
          root = loader.load();
      
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
      }
    
    
    
    public void setUser(Tenant user) {
        this.user = user;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
