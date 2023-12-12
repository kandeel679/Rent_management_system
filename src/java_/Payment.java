package java_;



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

    public void generateInvoice(int dueYear,int dueMonth,int dueDay) {
        if (this.tenant.makePayment(this.selectedApartment.getDepositeAmount())==-1) {
            this.isPaymentComplete = false;
            
        }else{
            this.invoice = new Invoice(this.tenant,this.landlord,this.selectedApartment, this.selectedApartment.getDepositeAmount(),dueYear, dueMonth, dueDay);
            this.landlord.AddBalance(this.selectedApartment.getDepositeAmount());
            this.tenant.chooseApartment(this.selectedApartment);
            this.isPaymentComplete = true;
        }
    }

    public Invoice Checkout(){
        if (isPaymentComplete) {
            
            return this.invoice;
        }else{
            return null;
        }
    }
    
    
    // public HashMap<String, String> completeOrder() {
    //     HashMap<String, String> orderDetails = new HashMap<>();
    //         orderDetails.put("TenantName", tenant.getLastName());
    //         orderDetails.put("LandlordName", landlord.getLastName());
    //         orderDetails.put("ApartmentAddress", selectedApartment.getLocation());
    //         orderDetails.put("PaymentStatus", String.valueOf(isPaymentComplete));
        

    //     return orderDetails;
    // }
}
