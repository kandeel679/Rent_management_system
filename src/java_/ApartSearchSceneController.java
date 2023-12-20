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
    private ListView<Integer> aprtListview;

    private ArrayList<Apartment> ApartmentList;
    private ArrayList<Integer> ID;
    private int id;

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

    public void getApartmentsList() {
        this.ApartmentList = AprtSearch.getApartmentList();
        ID = new ArrayList<>();
        if (aprtListview != null) { // Check if aprtListview is not null
            aprtListview.getItems().clear(); // Clear existing items
            if (ApartmentList != null) {
                for (Apartment aprt : ApartmentList) {
                    try {
                        if (!(aprt.IsApartmentTaken().equals("1"))) {
                            int apartmentId = aprt.getApartmentID();
                            ID.add(apartmentId);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing id for apartment: " + aprt.getApartmentID());
                    }
                }
                aprtListview.getItems().addAll(ID);
            }
        }
    }
    public void SwitchToPaymentView(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentScene.fxml"));
        Parent root = loader.load();
    
       
        PaymentSceneController controller = loader.getController();
    
      
        controller.setTenant(user); 
        Apartment a = Apartment.getApartmentByid(this.id);
        controller.setSelectedApartment(a);
        controller.setLandlord(a.GetLandlordById());
        controller.setPage();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Click() {
        aprtListview.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {

                    this.id = aprtListview.getSelectionModel().getSelectedItem();
                    for (Apartment aprt : ApartmentList) {
                        if (aprt.getApartmentID() == id) {
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

    public void setUser(Tenant user) {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Click();
        getApartmentsList(); // Initialize the apartment list
    }
}
