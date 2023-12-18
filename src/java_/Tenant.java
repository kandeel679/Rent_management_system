package java_;

import java.util.HashMap;

public class Tenant extends Person {
    private Apartment selectedApartment;

 

   
    public Tenant(String UserName, String Password, String EmailAddress, double Balance, String PhysicalAddress,
            String PhoneNumber, String FirstName, String LastName) {
        super(UserName, Password, EmailAddress, Balance, PhysicalAddress, PhoneNumber, FirstName, LastName);
    }
    public void chooseApartment(Apartment selectedApart) {
        this.selectedApartment = selectedApart;
    }
    public HashMap<String, String> DisplayApart() { 
        HashMap <String,String> aprt = new HashMap<>();
        if (this.selectedApartment!=null){
            aprt.put("ApartmentID", String.valueOf(this.selectedApartment.getApartmentID()));
            aprt.put("Location", this.selectedApartment.getLocation());
            // Assuming ApartmentDescribtion is a property of your Apartment class
            // aprt.put("ApartmentDescribtion", this.selectedApartment.getApartmentDescribtion);
            aprt.put("Area", String.valueOf(this.selectedApartment.getArea()));
            aprt.put("YearBuilt", String.valueOf(this.selectedApartment.getYearBuilt()));
            aprt.put("Floor", String.valueOf(this.selectedApartment.getFloor()));
            aprt.put("OwnerName", this.selectedApartment.getOwnerName());
            aprt.put("RentAmount", String.valueOf(this.selectedApartment.getRentAmount()));
            aprt.put("DepositeAmount", String.valueOf(this.selectedApartment.getDepositeAmount()));
            aprt.put("PlacementDate", this.selectedApartment.getPlacementDate());
            return aprt;
        }else{
            return aprt;
        }

         
    }
    //until writeing the main file
    public boolean isAvailable(Apartment apart) {
        return false;
    }

}