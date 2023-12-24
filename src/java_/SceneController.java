package java_;

import java.io.IOException;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
public class SceneController implements Initializable {
    @FXML private TextField usernametext;
    @FXML private TextField phonenumtext;
    @FXML private TextField emailtext;
    @FXML private TextField phyaddtext;
    @FXML private TextField fristnametext;
    @FXML private TextField passwordtext;
    @FXML private TextField lastnametext;
    @FXML private Label wronglabel;
    @FXML private ChoiceBox<String> accType;
    private String[] Types = {"LandLord","Tenant"};
   
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SWitchToRegisterScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("RegisterScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void RegisterUser(ActionEvent event) throws IOException {
        try {
            String username = validateUsername(usernametext.getText());
            int phoneNumber = validatePhoneNumber(phonenumtext.getText());
            String email = validateEmail(emailtext.getText());
            String physicalAddress = validatePhysicalAddress(phyaddtext.getText());
            String firstName = validateName(fristnametext.getText());
            String password = validatePassword(passwordtext.getText());
            String lastName = validateName(lastnametext.getText());
            

            System.out.println("Username: " + username);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Physical Address: " + physicalAddress);
            System.out.println("First Name: " + firstName);
            System.out.println("Password: " + password);
            System.out.println("Last Name: " + lastName);

            Person p = new Person(username, password, email, 0, physicalAddress, String.valueOf(phoneNumber), firstName, lastName);
            Register r = new Register(p);
            r.sendData();
            usernametext.clear();
            phonenumtext.clear();
            emailtext.clear();
            phyaddtext.clear();
            fristnametext.clear();
            lastnametext.clear();
            passwordtext.clear();

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void SigninUser(ActionEvent event) throws IOException{
        try {
              
        
          
                
            String username = validateUsername(usernametext.getText());
            String password = passwordtext.getText();
            Signin s = new Signin(username, password);
           
            if ("LandLord".equals(accType.getValue())) {
                System.out.println("Landlord");
                Person p = s.SIGN_IN(0);
                if (CheckUser(p)) {
                    LandLord l = (LandLord) p;
                    LandlordSceneController LandlordScene = new LandlordSceneController(l);
                    LandlordScene.SwitchToLandlordScene(event);
                    LandlordScene.setUser(l);
                }else{
                    ShowLabel();
                }
                // Additional code for LandLord
            } else {
                System.out.println("Tenant");
                Person p = s.SIGN_IN(1);
                if (CheckUser(p)) {
                    Tenant t = (Tenant) p;
                    TenantScenecontroller TenantScene = new TenantScenecontroller(t);
                    TenantScene.SwitchToTenantScene(event);
                    TenantScene.setUser(t);
                }
                else{
                    ShowLabel();
                }
                // Additional code for Tenant
                
            }
        
    
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
      
    }
    public boolean CheckUser(Person p){
        if (p==null) {
            return false;
        }else{
            return true;
        }
    }
    public void ShowLabel(){
        wronglabel.setText("Wrong username or passord");
    }
    //validationMethods
        private String validateUsername(String username) throws ValidationException {
            if (username.length() < 3 || username.length() > 20) {

                throw new ValidationException("Username must be between 3 and 20 characters.");
            }
        
            return username;
        }
        
        private int validatePhoneNumber(String phoneNumber) throws ValidationException {
            try {
                return Integer.parseInt(phoneNumber);
            } catch (NumberFormatException e) {
                throw new ValidationException("Invalid phone number format.");
            }
        }
        
        private String validateEmail(String email) throws ValidationException {
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                throw new ValidationException("Invalid email format.");
            }
            return email;
        }
        
        private String validatePhysicalAddress(String address) throws ValidationException {
            if (address.length() < 5 || address.length() > 100) {
                throw new ValidationException("Physical address must be between 5 and 100 characters.");
            }
            return address;
        }
        
        private String validateName(String name) throws ValidationException {
            if (name.length() < 2 || name.length() > 30) {
                throw new ValidationException("Name must be between 2 and 30 characters.");
            }
            return name;
        }
        
        private String validatePassword(String password) throws ValidationException {
            if (password.length() < 6 || password.length() > 30) {
                throw new ValidationException("Password must be between 6 and 30 characters.");
            }
            return password;
        }


    public void BackToSignin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("SigninScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accType.getItems().addAll(Types);
        accType.setValue(Types[0]);
    }

  
}
