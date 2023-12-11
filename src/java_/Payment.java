package java_;

import java.util.HashMap;

public class Payment {
    private Tenant tenant;
    private LandLord landlord;
    private Apartment selectedapart;
    private Invoice invoice;
    private boolean Payment;
    public Payment(Tenant tenant, LandLord landlord, Apartment selectedapart) {
        this.tenant = tenant;
        this.landlord = landlord;
        this.selectedapart = selectedapart;
    }
    public boolean CheackApart(){

        // code ~~>>
        
        return false;
    }
    public boolean Balance(){

        // code ~~>>
        
        return false;
    }
    public Invoice generateInvoice(){

        // code ~~>>
        
        return this.invoice;
    }


    public HashMap<String,String> completeOrder(){

        // code ~~>>

        HashMap<String,String> h = new HashMap<>();
        return h;

    }


}
