package java_;

public interface ApartDataManager {
    public enum ApartmentType {
        Studio,
        oneBedroom,
        twoBedroom,
        threebedroom;
       
    }
       abstract void AddApartment();
    abstract LandLord GetLandlordById();
    
} 
