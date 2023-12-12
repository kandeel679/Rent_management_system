package java_;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AprtSearch {
    private ArrayList<Apartment> ApartmentList;
    private Person User;
    public AprtSearch(ArrayList<Apartment> apartmentList, Person user) {
        ApartmentList = apartmentList;
        User = user;
    }
    public void getAprtmentlist(){
         try {
            Path filePath = Paths.get("../File/apart.txt");
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
