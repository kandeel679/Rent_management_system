package java_;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// import javafx.beans.InvalidationListener;
// import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DisplayApartmentController implements Initializable {
    private LandLord user;
    @FXML
    private ListView<Integer> aprtListview;

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
    private ArrayList<Apartment> apartlist;
    private ArrayList<Integer>Location;
    private String currentaprt;
    public DisplayApartmentController(){
            this.initializeControllerDisplay();
        }
    public void BackToLandlordScene(ActionEvent event) throws IOException{   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LandLordScene.fxml"));
        Parent root = loader.load();
    
        // Get the controller instance
        LandlordSceneController controller = loader.getController();
    
        // Call the public setUser method on the controller
        controller.setUser(user);  // Check that 'user' is not null here
    
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getApartmentList() {

        if (user != null) {
            user.getApartments();
            this.apartlist = user.DisplayAparts();
        }
    }
    
    public void setLocationString() {
        Location = new ArrayList<>();
        if (apartlist != null) {
            for (Apartment aprt : apartlist) {
                try {
                    int apartmentId = aprt.getApartmentID();
                    Location.add(apartmentId);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing id for apartment: " + aprt.getApartmentID());
                }
            }
            aprtListview.getItems().addAll(Location);
        }
    }
    
    public void initializeControllerDisplay() {
        getApartmentList();
        setLocationString();
    }
    public void Click() {
        aprtListview.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {

                int id = aprtListview.getSelectionModel().getSelectedItem();
                for (Apartment aprt : apartlist) {
                    if (aprt.getApartmentID()==id) {
                        idtext.setText(String.valueOf(id));
                        typetext.setText(aprt.getStringApartmentType());
                        loctext.setText(aprt.getLocation());
                        areatext.setText(String.valueOf(aprt.getArea()));
                        floortext.setText(String.valueOf(aprt.getFloor()));
                        yeartext.setText(String.valueOf(aprt.getYearBuilt()));
                        ownertext.setText(aprt.getOwnerName());
                        renttext.setText(String.valueOf(aprt.getRentAmount()));
                        depostittext.setText(String.valueOf(aprt.getDepositeAmount()));
                        placetext.setText(aprt.getPlacementDate());
                    }
                }
                
            }
        );
    }
    
    public void setUser(LandLord user) {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //    aprtListview.getItems().addAll(Location);
        Click();
    }
    
}
