package java_;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddApartmentController implements Initializable  {
    // ... other code ...

    private LandLord user;
    @FXML
    private ChoiceBox<String> accType;
    @FXML
    private ChoiceBox<String> typeapart;
    private String[] Types = {"Studio","oneBedroom","twoBedroom","threebedroom"};
    @FXML private TextField areatext;
    @FXML private TextField yeartext;
    @FXML private TextField floortext;
    @FXML private TextField locatointext;
    @FXML private TextField renttext;
    @FXML private TextField deposittext;


    public void setUser(LandLord user) {
        this.user = user;
    }
    
    public void BackToLandlordScene(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LandLordScene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    public void SubmeitApartment(ActionEvent event) throws IOException {
        try {
            double area = validateDouble(areatext, "Area");
            String location = validateText(locatointext, "Location");
            int year = validateInt(yeartext, "Year");
            int floor = validateInt(floortext, "Floor");
            double rent = validateDouble(renttext, "Rent");
            double deposit = validateDouble(deposittext, "Deposit");
            String type = typeapart.getValue();
            System.out.println(type);
            
    
            Apartment a = new Apartment(Apartment.getApartmentNewID(),type , location,area, year, floor,user.getUserName(), rent, deposit, LocalDate.now().toString());
            a.AddApartment();
            locatointext.clear();
            areatext.clear();
            yeartext.clear();
            floortext.clear();
            renttext.clear();
            deposittext.clear();
            typeapart.getSelectionModel().clearSelection();
    
          
        } catch (ValidationException e) {
            // Handle validation-specific exceptions
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions that may occur during the submission
            e.printStackTrace();  // Print the stack trace for debugging (replace with appropriate handling)
        }
    }
    
    private double validateDouble(TextField textField, String fieldName) throws ValidationException {
        String value = textField.getText().trim();
        if (value.isEmpty()) {
            throw new ValidationException(fieldName + " cannot be empty");
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            throw new ValidationException(fieldName + " must be a valid number");
        }
    }
    
    private int validateInt(TextField textField, String fieldName) throws ValidationException {
        String value = textField.getText().trim();
        if (value.isEmpty()) {
            throw new ValidationException(fieldName + " cannot be empty");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new ValidationException(fieldName + " must be a valid integer");
        }
    }
    

    private String validateText(TextField textField, String fieldName) throws ValidationException {
            String value = textField.getText().trim();
            if (value.isEmpty()) {
                throw new ValidationException(fieldName + " cannot be empty");
            }
            // Add more validation rules as needed
            return value;
        }
      



      @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Optional: Initialization logic here
        typeapart.getItems().addAll(Types);
        typeapart.setValue(Types[0]);
    }

    // ... other code ...
}
