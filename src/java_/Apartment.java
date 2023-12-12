package java_;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Apartment implements ApartDataManager {
    
    
    private int ApartmentID;
    private ApartmentType apartmentType;
    private String StringApartmentType;
    private String Location;
    private double Area;
    private int YearBuilt;
    private int Floor;
    private LandLord ApartmentOwner;
    private String OwnerName;
    private double RentAmount;
    private double DepositeAmount;
    private String PlacementDate;
    
    // for creating a new Apartment
    public Apartment(int apartmentID, ApartmentType apartmentType, String location, double area, int yearBuilt,
    int floor, LandLord apartmentOwner, double rentAmount, double depositeAmount,
    String placementDate) {
        ApartmentID = apartmentID;
        this.apartmentType = apartmentType;
        Location = location;
        Area = area;
        YearBuilt = yearBuilt;
        Floor = floor;
        ApartmentOwner = apartmentOwner;
        this.OwnerName = this.ApartmentOwner.getUserName();
        RentAmount = rentAmount;
        DepositeAmount = depositeAmount;
        PlacementDate = placementDate;
    }
    public Apartment(int apartmentID, ApartmentType apartmentType, String location, double area, int yearBuilt,
    int floor, String ownerName, double rentAmount, double depositeAmount,
    String placementDate) {
        ApartmentID = apartmentID;
        this.apartmentType = apartmentType;
        Location = location;
        Area = area;
        YearBuilt = yearBuilt;
        Floor = floor;
        this.OwnerName = ownerName;
        RentAmount = rentAmount;
        DepositeAmount = depositeAmount;
        PlacementDate = placementDate;
    }
    public Apartment(int apartmentID, String StringApartmentType, String location, double area, int yearBuilt,
            int floor, String OwnerName, double rentAmount, double depositeAmount,String placementDate) {
        ApartmentID = apartmentID;
        this.StringApartmentType = StringApartmentType;
        Location = location;
        Area = area;
        YearBuilt = yearBuilt;
        Floor = floor;
        this.OwnerName = OwnerName;
        RentAmount = rentAmount;
        DepositeAmount = depositeAmount;
        PlacementDate = placementDate;
    }
    public String getOwnerName() {
        return OwnerName;
    }
    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }



  @Override
  public void AddApartment() {
    try {
        // URL of your local server endpoint    
        String serverUrl = "http://127.0.0.1:5000/addapartment";
        URL url = new URL(serverUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        // Create JSON data for the apartment
        String postData = "{" +
            "\"apartmentID\": " + this.getApartmentID() + "," +
            "\"apartmentType\": \"" + this.getApartmentType() + "\"," +
            "\"location\": \"" + this.getLocation() + "\"," +
            "\"area\": " + this.getArea() + "," +
            "\"year\": " + this.getYearBuilt() + "," +
            "\"floor\": " + this.getFloor() + "," +
            "\"apartmentOwnerUsername\": \"" + this.getOwnerName() + "\"," +
            "\"rentamount\": " + this.getRentAmount() + "," +
            "\"depositamount\": " + this.getDepositeAmount() + "," +
            "\"PlacementDate\": \"" + this.getPlacementDate() + "\"" +
            "}";
            System.out.println(postData);

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

        System.out.println("Server Response: " + response.toString());

        connection.disconnect();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

   


public LandLord GetLandlordById(){
    LandLord L;
    try {
        URL url = new URL("http://127.0.0.1:5000/getLandlordByusername");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       
        connection.setRequestMethod("POST");

        
        connection.setRequestProperty("Content-Type", "application/json");

        
        connection.setDoOutput(true);

        
        String postData = "{" +
                "\"username\": \"" + this.OwnerName + "\"" +
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
        String cleanedData = res.replaceAll("[{}\"]", "");
        String cleanedData1 = cleanedData.replaceAll("[:\\[\\] ]", "");  
        String[] dataArray = cleanedData1.split(",");
        
        // StringBuilder res = response.replace(0,17,"");
        // String res2 = res.toString().replaceAll("}","").replaceAll(" ", "");
        L =new LandLord(dataArray[0], dataArray[1], dataArray[2], Double.parseDouble(dataArray[3]), dataArray[4], dataArray[5],dataArray[6],dataArray[7]);

        System.out.println("Response:" + L);
        
        return L;
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    
}





    // getters and setters
    public int getApartmentID() {
        return ApartmentID;
    }

    public void setApartmentID(int apartmentID) {
        ApartmentID = apartmentID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    

    public double getArea() {
        return Area;
    }

    public void setArea(double area) {
        Area = area;
    }

    public int getYearBuilt() {
        return YearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        YearBuilt = yearBuilt;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public LandLord getApartmentOwner() {
        return ApartmentOwner;
    }

    public void setApartmentOwner(LandLord apartmentOwner) {
        ApartmentOwner = apartmentOwner;
    }

    public double getRentAmount() {
        return RentAmount;
    }

    public void setRentAmount(double rentAmount) {
        RentAmount = rentAmount;
    }

    public double getDepositeAmount() {
        return DepositeAmount;
    }

    public void setDepositeAmount(double depositeAmount) {
        DepositeAmount = depositeAmount;
    }


    public String getPlacementDate() {
        return PlacementDate;
    }

    public void setPlacementDate(String placementDate) {
        PlacementDate = placementDate;
    }
    public String getId() {
        return null;
    }
    public String getOtherData() {
        return null;
    }
    public ApartmentType getApartmentType() {
        return apartmentType;
    }
    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }


}
