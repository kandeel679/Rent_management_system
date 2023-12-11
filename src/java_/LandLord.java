package java_;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LandLord extends Person{
    private ArrayList<Apartment> Apartments = new ArrayList<>();

    public LandLord(String UserName, String EmailAddress, String Password, String FirstName, String LastName,
            String PhoneNumber, String PhysicalAddress, double Balance) {
        super(UserName, EmailAddress, Password, FirstName, LastName, PhoneNumber, PhysicalAddress, Balance);
    }




    public ArrayList<Apartment> DisplayAparts(){

         try {
                Path filePath = Paths.get("C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\DataBase_Files\\apart.txt");
                List<String> lines = Files.readAllLines(filePath);
                for (String line : lines) {
                     String[] data = line.split(",");
                     System.err.println(data[2]);
                     Apartment a = new Apartment(Integer.parseInt(data[0]), data[1],data[2], Double.parseDouble(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]), data[6],Double.parseDouble(data[7]), Double.parseDouble(data[8]), Double.parseDouble(data[9]),data[10]);
                     Apartments.add(a);

                }

                } catch (Exception e) {
                    e.printStackTrace();
                }

        return Apartments ;
    }
}
