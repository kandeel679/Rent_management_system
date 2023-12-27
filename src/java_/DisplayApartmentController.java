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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DisplayApartmentController implements Initializable {
    private LandLord user;
    @FXML
    private ListView<String> aprtListview;

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
    private ArrayList<String>ApartlistTolistview;
    private String currentaprt;
    @FXML 
    private ChoiceBox<String> displayby;
    private String[] aprtProp = {"Location","Area","Year","Rent","Deposit","Floor"};
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
    public String DisplayByX(Apartment aprt, String X) {
        if ("Location".equals(X)) {
            return aprt.getLocation();
        } else if ("Area".equals(X)) {
            return Double.toString(aprt.getArea());
        } else if ("Year".equals(X)) {
            return Integer.toString(aprt.getYearBuilt());
        } else if ("Rent".equals(X)) {
            return Double.toString(aprt.getRentAmount());
        } else if ("Deposit".equals(X)) {
            return Double.toString(aprt.getDepositeAmount());
        } else if ("Floor".equals(X)) {
            return Integer.toString(aprt.getFloor());
        } else {
            return " ";
        }
    }
    public void setIDString() {
        ApartlistTolistview = new ArrayList<>();
        if (apartlist != null) {
            aprtListview.getItems().clear(); 
            for (Apartment aprt : apartlist) {
                try {
                    String combinedInfo = String.valueOf(aprt.getApartmentID())+" --> "+DisplayByX(aprt,displayby.getValue());
                    ApartlistTolistview.add(combinedInfo);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing id for apartment: " + aprt.getApartmentID());
                }
            }
            aprtListview.getItems().addAll(ApartlistTolistview);
        }
    }
    
    public void initializeControllerDisplay() {
        getApartmentList();
        setIDString();
    }
    public void Click() {
        aprtListview.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {

                String SelecetedaprtFromListView = aprtListview.getSelectionModel().getSelectedItem();
                int ID = Integer.parseInt(SelecetedaprtFromListView.split(" --> ")[0]);
                Apartment a = Apartment.getApartmentByid(ID);
                idtext.setText(String.valueOf(ID));
                typetext.setText(a.getStringApartmentType());
                loctext.setText(a.getLocation());
                areatext.setText(String.valueOf(a.getArea()));
                floortext.setText(String.valueOf(a.getFloor()));
                yeartext.setText(String.valueOf(a.getYearBuilt()));
                ownertext.setText(a.getOwnerName());
                renttext.setText(String.valueOf(a.getRentAmount()));
                depostittext.setText(String.valueOf(a.getDepositeAmount()));
                placetext.setText(a.getPlacementDate());
            
                
            }
        );
    }
    
    public void setUser(LandLord user) {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //    aprtListview.getItems().addAll(Location);
        displayby.getItems().addAll(aprtProp);
        displayby.setValue(aprtProp[0]); 
        Click();
    }
    
}
