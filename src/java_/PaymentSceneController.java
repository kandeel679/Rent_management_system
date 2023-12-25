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

public class PaymentSceneController implements Initializable {
    private Tenant tenant;
    private LandLord landlord;
    private Apartment selectedapartment;


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
    private Label BalanceText;
    @FXML
    private Label ManagementFeeText;
    @FXML
    private Label TotalAmountText;
    @FXML
    private Label successfullytext;
    @FXML
    private Label Failed;


    public void BackToTenantScene(ActionEvent event)throws IOException{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ApartSearchScene.fxml"));
        Parent root = loader.load();

        ApartSearchSceneController controller = loader.getController();
        controller.setUser(tenant); 
    
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    
    public void SetApartment(){
        idtext.setText(String.valueOf(selectedapartment.getApartmentID()));
        typetext.setText(selectedapartment.getStringApartmentType());
        loctext.setText(selectedapartment.getLocation());
        areatext.setText(String.valueOf(selectedapartment.getArea()));
        floortext.setText(String.valueOf(selectedapartment.getFloor()));
        yeartext.setText(String.valueOf(selectedapartment.getYearBuilt()));
        ownertext.setText(selectedapartment.getOwnerName());
        renttext.setText(String.valueOf(selectedapartment.getRentAmount()));
        depostittext.setText(String.valueOf(selectedapartment.getDepositeAmount()));
        placetext.setText(selectedapartment.getPlacementDate());
        
    }
    
    public void SetBalance(){
        double balance = tenant.getBalance(); 
        BalanceText.setText(balance+"$");
    }
    public void calactot(){
        double depost = selectedapartment.getDepositeAmount();
        double Mfee = depost*0.032;
        ManagementFeeText.setText(Mfee+"$");
        TotalAmountText.setText(depost+Mfee+"$");
    }
    public void setPage(){
        SetApartment();
        SetBalance();
        calactot();
    }



    public void RENT(){
        Payment p = new Payment(tenant, landlord, selectedapartment);
        p.generateInvoice(2060, 1, 25);
        this.tenant = selectedapartment.GetTenantByid(this.tenant.getUserName());
        if (p.isPaymentComplete()) {
            // Payment completed successfully!
            System.out.println("payment is complete!");
            successfullytext.setText("Payment completed successfully!");
        }else{
            // Payment failed, Check your balance.
            System.out.println("Payment failed, Check your balance.");
            Failed.setText("Payment failed, Check your balance.");
        }
    }







    @Override
    public void initialize(URL location, ResourceBundle resources) {
            System.out.println("Inside the initialize of TA");
        }
        



    //Setters and getters
        public void setTenant(Tenant t){tenant = t;}
        public Tenant getTenant(){return tenant;}
        public void setLandlord(LandLord l) {landlord=l;}
        public LandLord getLandlord() { return landlord ;}
        public void setSelectedApartment(Apartment a) {selectedapartment = a;}
        public Apartment getSelectedApartment() {return selectedapartment;}
}
