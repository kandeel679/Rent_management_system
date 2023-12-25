package java_;
import java.time.LocalDate;
import java.util.HashMap;


public class Invoice {
    private Tenant tenant;
    private Apartment rentedApartment;
    private LandLord landlord;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private double amount;

    public Invoice(Tenant tenant,LandLord landlord, Apartment rentedApartment, double amount, int dueYear,int dueMonth,int dueDay) {
        this.tenant = tenant;
        this.rentedApartment = rentedApartment;
        this.amount = amount;
        this.issueDate = LocalDate.now();
        this.dueDate = LocalDate.of(dueYear, dueMonth, dueDay);
    }
    

    public Tenant getTenant() {
        return tenant;
    }
    
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    
    public Apartment getRentedApartment() {
        return rentedApartment;
    }
    
    public void setRentedApartment(Apartment rentedApartment) {
        this.rentedApartment = rentedApartment;
    }
    
    public LocalDate getIssueDate() {
        return issueDate;
    }
    
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double calculateTotalAmount() {
        return amount;
    }

    public HashMap<String, Object> displayInvoice() {
        HashMap<String, Object> invoiceInfo = new HashMap<>();
        invoiceInfo.put("Tenant", tenant.getUserName());
        invoiceInfo.put("Rented Apartment", rentedApartment.getLocation());
        invoiceInfo.put("Issue Date", issueDate);
        invoiceInfo.put("Due Date", dueDate);
        invoiceInfo.put("Amount", amount);
        return invoiceInfo;
    }
}

