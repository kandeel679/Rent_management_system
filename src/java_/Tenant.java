package java_;

import java.util.HashMap;

public class Tenant extends Person {
    private String EmergencyPersonName;
    private String EmergencyPersonPhoneNum;
    private Apartment selectedApartment;

 

    public Tenant(String UserName, String EmailAddress, String Password, String FirstName, String LastName,
            String PhoneNumber, String PhysicalAddress, double Balance) {
        super(UserName, EmailAddress, Password, FirstName, LastName, PhoneNumber, PhysicalAddress, Balance);
    }
    public void chooseApartment(Apartment selectedApart) {
        this.selectedApartment = selectedApart;
    }
    public HashMap<String, String> DisplayApart() { 
        HashMap<String,String> userDetails = new HashMap<>();
        
        return userDetails; 
    }

    public boolean isAvailable(Apartment apart) {
        return false;
    }
    @Override
    public HashMap<String, String> getUserData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserData'");
    }
}