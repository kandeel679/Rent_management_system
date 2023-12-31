package java_;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

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

public class ApartSearchSceneController implements Initializable {
    private Tenant user;
    Parent root;
    Stage stage;
    Scene scene;

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
    @FXML
    private Label text;

    @FXML
    private ListView<String> aprtListview;

    private ArrayList<Apartment> ApartmentList;
    private Apartment ApartmentSelected; 
    private ArrayList<String> ApartlistTolistview;
    @FXML 
    private ChoiceBox<String> displayby;
   
    
    private String[] aprtProp = {"Location","Area","Year","Rent","Deposit","Floor"};
    

    public void BackToTenantScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantScene.fxml"));
        root = loader.load();

        TenantScenecontroller controller = loader.getController();
        controller.setUser(user);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    public void getApartmentsList() {
        this.ApartmentList = AprtSearch.getApartmentList();
        ApartlistTolistview = new ArrayList<>();
        if (aprtListview != null) { 
            aprtListview.getItems().clear(); 
            if (ApartmentList != null) {
                for (Apartment aprt : ApartmentList) {
                    try {
                        if (!(aprt.IsApartmentTaken().equals("1"))) {
                            // int apartmentId = aprt.getApartmentID();
                            
                            String combinedInfo = String.valueOf(aprt.getApartmentID())+" --> "+DisplayByX(aprt,displayby.getValue());
                            System.out.println(combinedInfo);
                            ApartlistTolistview.add(combinedInfo);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing id for apartment: " + aprt.getApartmentID());
                    }
                }
                
                aprtListview.getItems().addAll(ApartlistTolistview);
            }
        }
    }
    public void SwitchToPaymentView(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentScene.fxml"));
        Parent root = loader.load();
    
        
        PaymentSceneController controller = loader.getController();
        
      
        controller.setTenant(user); 
        controller.setSelectedApartment(ApartmentSelected);
        controller.setLandlord(ApartmentSelected.GetLandlordById());
        controller.setPage();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void OnChangeDisplay(){
        getApartmentsList();    
        text.setText(displayby.getValue());
    }
    public void Click() {
        aprtListview.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                
                
                String SelecetedaprtFromListView = aprtListview.getSelectionModel().getSelectedItem();
                if (SelecetedaprtFromListView != null) {
                    int ID = Integer.parseInt(SelecetedaprtFromListView.split(" --> ")[0]);
                    this.ApartmentSelected = Apartment.getApartmentByid(ID);
                            idtext.setText(String.valueOf(ID));
                            typetext.setText(ApartmentSelected.getStringApartmentType());
                            loctext.setText(ApartmentSelected.getLocation());
                            areatext.setText(String.valueOf(ApartmentSelected.getArea()));
                            floortext.setText(String.valueOf(ApartmentSelected.getFloor()));
                            yeartext.setText(String.valueOf(ApartmentSelected.getYearBuilt()));
                            ownertext.setText(ApartmentSelected.getOwnerName());
                            renttext.setText(String.valueOf(ApartmentSelected.getRentAmount()));
                            depostittext.setText(String.valueOf(ApartmentSelected.getDepositeAmount()));
                            placetext.setText(ApartmentSelected.getPlacementDate());
                }
                    
          
                
                }   
        );
    }

    public void setUser(Tenant user) {
        this.user = user;
    }

    public void initializeingChoiceBoxes(){
        displayby.getItems().addAll(aprtProp);
        displayby.setValue(aprtProp[0]); 

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeingChoiceBoxes();
        Click();
        getApartmentsList();
        text.setText(displayby.getValue());

    }
}
