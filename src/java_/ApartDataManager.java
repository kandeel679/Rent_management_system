package java_;

public interface ApartDataManager {
    public enum ApartmentType {
        Studio,
        oneBedroom,
        twoBedroom,
        threebedroom;
       
    }
    static final double managementFee = 300;
    abstract void AddApartment();
    abstract LandLord GetLandlordById();
} 
