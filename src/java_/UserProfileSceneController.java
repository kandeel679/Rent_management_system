package java_;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserProfileSceneController {
    private Person user;
    @FXML
    private Label usernametext;
    @FXML
    private Label fristnametext;
    @FXML
    private Label lastnametext;
    @FXML
    private Label emailtext;
    @FXML
    private Label phonenumbertext;
    @FXML
    private Label balance;
    @FXML
    private TextField v1;



    public void BackToLandlordScene(ActionEvent event)throws IOException{

        if (this.user instanceof LandLord) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LandLordScene.fxml"));
            Parent root = loader.load();
        
            LandlordSceneController controller = loader.getController();
        
            controller.setUser((LandLord)user);  
        
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantScene.fxml"));
            Parent root = loader.load();
        
            TenantScenecontroller controller = loader.getController();
        
            controller.setUser((Tenant)user);  
        
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void BackToTenantScene(ActionEvent event)throws IOException{
    }
    public void setuserdata(){
        HashMap<String,String> data = this.user.getUserData();
        usernametext.setText(data.get("username"));
        fristnametext.setText(data.get("firstname"));
        lastnametext.setText(data.get("lastname"));
        emailtext.setText(data.get("email"));
        phonenumbertext.setText(data.get("phonenum"));
        balance.setText(data.get("balance"));
    }

    public void addintoacc(){
        String value=v1.getText();
        if(!value.matches("\\d*")){
            System.out.println("is not number");
        }else{
            double num=Double.parseDouble(value);
            this.user.AddBalance(num);
            System.out.println("is number");
        }
    }
    public void setUser(Person user){
        this.user = user;
    }
}
