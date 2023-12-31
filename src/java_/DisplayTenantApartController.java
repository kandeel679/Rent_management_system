package java_;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DisplayTenantApartController implements Initializable {
    @FXML
    private Label idtext;
    @FXML
    private Label typetext;
    @FXML
    private Label loctext;
    @FXML
    private Label areatext;
    @FXML
    private Label floortext;
    @FXML
    private Label yeartext;
    @FXML
    private Label ownertext;
    @FXML
    private Label renttext;
    @FXML
    private Label depostittext;
    @FXML
    private Label placetext;


    private Tenant user;
    private Apartment aprt;

    public DisplayTenantApartController(){
        // this.initializeControllerDisplay();
    }

    public void BackToTenantScene(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantScene.fxml"));
        Parent root = loader.load();

        TenantScenecontroller controller = loader.getController();
        controller.setUser(user); 
    
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public void DisplayApart() {
        setApartInfo();
        if (aprt != null) { 
            idtext.setText(String.valueOf(aprt.getApartmentID()));
            typetext.setText(aprt.getStringApartmentType());
            loctext.setText(aprt.getLocation());
            areatext.setText(String.valueOf(aprt.getArea()));
            floortext.setText(String.valueOf(aprt.getFloor()));
            yeartext.setText(String.valueOf(aprt.getYearBuilt()));
            ownertext.setText(aprt.getOwnerName());
            renttext.setText(String.valueOf(aprt.getRentAmount()));
            depostittext.setText(String.valueOf(aprt.getDepositeAmount()));
            placetext.setText(aprt.getPlacementDate());
        } else {
            // Handle the case where aprt is null
            System.out.println("aprt is null");
        }
    }
    public void setApartInfo(){
        if (user != null) {
            int selectedApartId = user.getselectedApartId();

            if (selectedApartId == -1) {
                 
            }else{
                aprt = Apartment.getApartmentByid(user.getselectedApartId());
            }
        } else {
            System.out.println("user is null in info");
            // Handle the case where user is null, perhaps by logging an error or taking appropriate action.
        }
       
    }
    // public void initializeControllerDisplay() {
    //     setApartInfo();
    //     // Ensure that the user is not null before displaying apartment info
    //     if (user != null) {
    //         DisplayApart();
    //     } else {
    //         System.out.println("user is null");
    //         // Handle the case where user is null (e.g., log an error or take appropriate action)
    //     }
    // }
    // public void DisplayNoApartmentYet(){
       
    // }

    public void setUser(Tenant user){
        this.user= user;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //    aprtListview.getItems().addAll(Location);
        
        // DisplayApart();kan
    }
}
