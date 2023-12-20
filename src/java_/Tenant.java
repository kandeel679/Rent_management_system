package java_;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Tenant extends Person {
    private Apartment selectedApartment;
    private int aprtit;

 

   
    public Tenant(String UserName, String Password, String EmailAddress, double Balance, String PhysicalAddress,
            String PhoneNumber, String FirstName, String LastName) {
        super(UserName, Password, EmailAddress, Balance, PhysicalAddress, PhoneNumber, FirstName, LastName);
    }
    public Tenant(String UserName, String Password, String EmailAddress, double Balance, String PhysicalAddress,
            String PhoneNumber, String FirstName, String LastName,int aprtid) {//aprt id
        super(UserName, Password, EmailAddress, Balance, PhysicalAddress, PhoneNumber, FirstName, LastName);
        this.aprtit = aprtid;

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

    public int getselectedApartId(){
        if (this.aprtit ==0) {
            return -1;
        }else{
            return this.aprtit;
        }
    }


    public void chooseApartment(Apartment selectedApart) {
        this.selectedApartment = selectedApart;
        setApartmentid();
        this.selectedApartment.setApartmentistaken();
    }

    public void setApartmentid(){
        try {
        URL url = new URL("http://127.0.0.1:5000/setaprtid");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       
        connection.setRequestMethod("POST");

        
        connection.setRequestProperty("Content-Type", "application/json");

        
        connection.setDoOutput(true);

        
        String postData = "{" +
                "\"id\": \"" + selectedApartment.getApartmentID() + "\"," +
                "\"username\": \"" + this.getUserName() + "\"" +
            "}";
        System.out.println("Request Payload: " + postData);


        // Get the output stream and write the data
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
            wr.write(postDataBytes);
        }

        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String res = response.toString();

        System.out.println(res);
        // String cleanedData = res.replaceAll("[{}\"]", "");
        // String cleanedData1 = cleanedData.replaceAll("[:\\[\\] ]", "");  
        // String[] dataArray = cleanedData1.split(",");

        // System.out.println(cleanedData1);

        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    //until writeing the main file
    public boolean isAvailable(Apartment apart) {
        return false;
    }

}