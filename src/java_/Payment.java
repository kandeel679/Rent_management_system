package java_;

import java.util.HashMap;

public class Payment {
    private Tenant tenant;
    private LandLord landlord;
    private Apartment selectedApartment;
    private Invoice invoice;
    private boolean isPaymentComplete;

    public Payment(Tenant tenant, LandLord landlord, Apartment selectedApartment) {
        this.tenant = tenant;
        this.landlord = landlord;
        this.selectedApartment = selectedApartment;
    }

    public Invoice generateInvoice(int dueYear,int dueMonth,int dueDay) {
        // Assuming Invoice class has a constructor that takes relevant parameters
        if (this.tenant.makePayment(this.selectedApartment.getDepositeAmount())==-1) {
            this.isPaymentComplete = false;
            return this.invoice;
        }else{
            this.invoice = new Invoice(this.tenant,this.selectedApartment, this.selectedApartment.getDepositeAmount(),dueYear, dueMonth, dueDay);
            this.isPaymentComplete = true;
        }
        // You can add more logic here to calculate the invoice details based on your requirements
        return this.invoice;
    }

    public HashMap<String, String> completeOrder() {
        HashMap<String, String> orderDetails = new HashMap<>();
            orderDetails.put("TenantName", tenant.getLastName());
            orderDetails.put("LandlordName", landlord.getLastName());
            orderDetails.put("ApartmentAddress", selectedApartment.getLocation());
            orderDetails.put("PaymentStatus", String.valueOf(isPaymentComplete));
        

        return orderDetails;
    }
}
