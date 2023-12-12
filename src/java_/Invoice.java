package java_;
import java.time.LocalDate;
import java.util.HashMap;


public class Invoice {
    private static int ID=0;
    private Tenant tenant;
    private Apartment rentedApartment;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private double amount;

    public Invoice(Tenant tenant, Apartment rentedApartment, double amount, int dueYear,int dueMonth,int dueDay) {
        Invoice.ID ++;
        this.tenant = tenant;
        this.rentedApartment = rentedApartment;
        this.amount = amount;
        this.issueDate = LocalDate.now();
        this.dueDate = LocalDate.of(dueYear, dueMonth, dueDay);
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        Invoice.ID = ID;
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
        invoiceInfo.put("ID", ID);
        invoiceInfo.put("Tenant", tenant.getLastName());
        invoiceInfo.put("Rented Apartment", rentedApartment.getLocation());
        invoiceInfo.put("Issue Date", issueDate);
        invoiceInfo.put("Due Date", dueDate);
        invoiceInfo.put("Amount", amount);
        return invoiceInfo;
    }
}