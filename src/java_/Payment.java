package java_;



public class Payment {
    private Tenant tenant;
    private LandLord landlord;
    private Apartment selectedApartment;
    private Invoice invoice;
    private boolean isPaymentComplete;

    public boolean isPaymentComplete() {
        return isPaymentComplete;
    }

    public Payment(Tenant tenant, LandLord landlord, Apartment selectedApartment) {
        this.tenant = tenant;
        this.landlord = landlord;
        this.selectedApartment = selectedApartment;
    }

    public void generateInvoice() {
        if (this.tenant.makePayment(this.selectedApartment.getDepositeAmount())==-1) {
            this.isPaymentComplete = false;
        }else{
            this.invoice = new Invoice(this.tenant,this.landlord,this.selectedApartment, this.selectedApartment.getDepositeAmount());
            this.landlord.AddBalance(this.selectedApartment.getDepositeAmount());
            this.tenant.chooseApartment(this.selectedApartment);
            // this.tenant = this.selectedApartment.GetTenantByid(this.tenant.getUserName());
            // System.out.println(this.tenant.getselectedApartId());
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
