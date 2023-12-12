package java_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LandLord extends Person{
    private ArrayList<Apartment> Apartments = new ArrayList<>();
    
    public LandLord(String UserName, String EmailAddress, String Password, String FirstName, String LastName,
    String PhoneNumber, String PhysicalAddress, double Balance) {
        super(UserName, EmailAddress, Password, FirstName, LastName, PhoneNumber, PhysicalAddress, Balance);
    }
    
    public void addApartment(Apartment a){
        if(!Apartments.contains(a)){
            Apartments.add(a);
            appendToFile(a);
        }

    }
     private  void appendToFile(Apartment a) {
        // Specify the file path
        String PC_filePath = "C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\DataBase_Files\\apart.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PC_filePath, true))) {
            // Append the new Apartment data to the file
            String data = a.getApartmentID() + "," + a.getLocation() + a.getApartmentDescribtion() + "," + a.getArea() + a.getYearBuilt() + 
                        "," + a.getFloor() + a.getOwnerName() + "," + a.getRentAmount() +a.getDepositeAmount() + "," + a.getPlacementDate() + System.lineSeparator();
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeApartmentById(int apartmentId) {
        Apartment apartmentToRemove = null;

        // Find the apartment with the specified ID
        for (Apartment a : Apartments) {
            if (a.getApartmentID() == apartmentId) {
                apartmentToRemove = a;
                break;
            }
        }

        // Remove the apartment if found
        if (apartmentToRemove != null) {
            Apartments.remove(apartmentToRemove);
            deleteFromFile(apartmentToRemove);
        } else {
            System.out.println("Apartment with ID " + apartmentId + " not found.");
        }
    }
    public void deleteFromFile(Apartment a){
        String PC = "C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\DataBase_Files\\apart.txt";
                try {
                    Path filePath = Paths.get(PC);
                    List<String> lines = Files.readAllLines(filePath);
                    for (String line : lines) {
                        String[] data = line.split(",");
                        int id = Integer.parseInt(data[0]);
                        if(id == a.getApartmentID()){
                            
                        }
                       
                    }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

    }
    
    public ArrayList<Apartment> DisplayAparts(){
        ArrayList<Apartment> ApartmentList = new ArrayList<>();
        String PC = "C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\DataBase_Files\\apart.txt";
        try {
            Path filePath = Paths.get(PC);
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                 String[] data = line.split(",");
                 Apartment a = new Apartment(Integer.parseInt(data[0]), data[1],data[2], Double.parseDouble(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]), data[6],
                                             Double.parseDouble(data[7]), Double.parseDouble(data[8]), (String)data[9]);
                 ApartmentList.add(a);

            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return ApartmentList ;
    }

    @Override
    public HashMap<String, String> getUserData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserData'");
    }
}
