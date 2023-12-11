package java_;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Register
            // LandLord l = new LandLord("ali2003", "ali@gmail.com", "1234", "ali", "hosam", "01001010101", "sab3", 0)    ;
            // Register R = new Register(l);
            // R.sendData();

        //Signin and casting the person into landlord
            // Signin s = new Signin("ali2003", "1234");
            // Person p1 = s.SIGN_IN(0);
            // LandLord l = (LandLord)p1;
            // System.out.println(l.l);
            // System.out.println(p1.getEmailAddress());

        // ai model for predicting the reantal amount 
            // RentPredictionModel r = new RentPredictionModel(350,2003,6);
            // r.Predict();

        // getting the data from the file to add it into a new apartment 
                // try {
                // Path filePath = Paths.get("C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\DataBase_Files\\apart.txt");
                // List<String> lines = Files.readAllLines(filePath);
                // for (String line : lines) {
                //      String[] data = line.split(",");
                //      System.err.println(data[2]);
                //      Apartment a = new Apartment(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                //      ArrayList<Apartment> apartlist = new ArrayList<>();
                //      apartlist.add(a);
            
                // }

                // } catch (Exception e) {
                //     e.printStackTrace();
                // }
        }
}
