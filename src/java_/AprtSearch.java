package java_;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.List;
import java.util.ArrayList;




public class AprtSearch {
    private ArrayList<Apartment> ApartmentList;
    private Person User;
    public AprtSearch( Person user) {
        User = user;
    }
    public static ArrayList<Apartment> getApartmentList(){
        ArrayList<Apartment> aparts = new ArrayList<>();
        try {
        URL url = new URL("http://127.0.0.1:5000/getapartments");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       
        connection.setRequestMethod("GET");

        
        connection.setRequestProperty("Content-Type", "application/json");

        
        connection.setDoOutput(true);

        
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

        for (String apartment : dataArray) {
            String[] Listofprop = apartment.split("_");
            
            int apartmentID = Integer.parseInt(Listofprop[0]);
            String apartmentType = Listofprop[1];
            String location = Listofprop[2];
            double area = Double.parseDouble(Listofprop[3]);
            int yearBuilt = Integer.parseInt(Listofprop[4]);
            int floor = Integer.parseInt(Listofprop[5]);
            String ownerName = Listofprop[6];
            double rentAmount = Double.parseDouble(Listofprop[7]);
            double depositAmount = Double.parseDouble(Listofprop[8]);
            String placementDate = Listofprop[9];;
        
            aparts.add(new Apartment(apartmentID, apartmentType, location, area, yearBuilt, floor, ownerName, rentAmount, depositAmount, placementDate));
        } 
        
       
        
        // System.out.println("Response:" +this.ApartmentList.get(1).getOwnerName());
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
        return aparts;
    }
    

}
