package java_;

import java.util.ArrayList;
import java.util.HashMap;

public class LandLord extends Person{
    private ArrayList<Apartment> Apartments;
    
    
    
    
    public LandLord(String UserName, String Password, String EmailAddress, double Balance, String PhysicalAddress,
            String PhoneNumber, String FirstName, String LastName) {
        super(UserName, Password, EmailAddress, Balance, PhysicalAddress, PhoneNumber, FirstName, LastName);
    }


    public void getApartments(){
       
        ArrayList<Apartment> alltheApartments = AprtSearch.getApartmentList();
        this.Apartments =new ArrayList<>();
        for (Apartment apartment : alltheApartments) {
            if (this.UserName.equals(apartment.getOwnerName())) {
                this.Apartments.add(apartment);
            }
        }
        ;
    }
    
   
    public void removeApartmentById(int apartmentId) {
   
    }
  
    
    public ArrayList<Apartment> DisplayAparts(){
       
     return this.Apartments;
    }

   
}
