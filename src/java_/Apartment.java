package java_;


public class Apartment {
    private int ApartmentID;
    private String Location;
    private String ApartmentDescribtion;
    private double Area;
    private int YearBuilt;
    private int Floor;
    private LandLord ApartmentOwner;
    private String OwnerName;
    private double RentAmount;
    private double DepositeAmount;
    private String PlacementDate;
    
    public Apartment(int ApartmentID,  String Location, String ApartmentDescribtion, double Area, int YearBuilt, int Floor,
                     LandLord ApartmentOwner, double RentAmount, double DepositeAmount, String PlacementDate) {
        this.ApartmentID = ApartmentID; 
        this.Location = Location;
        this.ApartmentDescribtion = ApartmentDescribtion;
        this.Area = Area;
        this.YearBuilt = YearBuilt;
        this.Floor = Floor;
        this.ApartmentOwner = ApartmentOwner;
        this.RentAmount = RentAmount;
        this.DepositeAmount = DepositeAmount;
        this.PlacementDate = PlacementDate;
        
    }
    public String getOwnerName() {
        return OwnerName;
    }
    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }
    public Apartment(int ApartmentID,  String Location, String ApartmentDescribtion, double Area, int YearBuilt, int Floor,
                     String OwnerName, double RentAmount, double DepositeAmount, String PlacementDate) {
        this.ApartmentID = ApartmentID; 
        this.Location = Location;
        this.ApartmentDescribtion = ApartmentDescribtion;
        this.Area = Area;
        this.YearBuilt = YearBuilt;
        this.Floor = Floor;
        this.OwnerName = OwnerName;
        this.RentAmount = RentAmount;
        this.DepositeAmount = DepositeAmount;
        this.PlacementDate = PlacementDate;
        
    }


public boolean isRented(){
    return false;
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

    public String getApartmentDescribtion() {
        return ApartmentDescribtion;
    }

    public void setApartmentDescribtion(String apartmentDescribtion) {
        ApartmentDescribtion = apartmentDescribtion;
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

}
