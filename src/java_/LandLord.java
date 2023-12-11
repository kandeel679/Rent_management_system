package java_;

import java.util.ArrayList;
import java.util.HashMap;

public class LandLord extends Person{
    private ArrayList<Object> Apartments = new ArrayList<>();
    public int l = 0;
    

    public LandLord(String UserName, String EmailAddress, String Password, String FirstName, String LastName,
            String PhoneNumber, String PhysicalAddress, double Balance) {
        super(UserName, EmailAddress, Password, FirstName, LastName, PhoneNumber, PhysicalAddress, Balance);
    }




    public HashMap<String,String> DisplayApart(){
        
        HashMap<String,String> Apartments_Details = new HashMap<>();
        Apartments_Details.put("lol",";");
        Apartments_Details.put("ahmed","12312");

        return Apartments_Details ;
    }
}
