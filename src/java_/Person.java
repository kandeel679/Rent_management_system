package java_;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public abstract class Person implements UserProfile {
    protected String UserName;
    protected String FirstName;
    protected String LastName;
    protected String EmailAddress;
    protected String PhoneNumber;
    protected String Password;
    protected String PhysicalAddress;
    protected double Balance;

    public Person(String UserName,String Password,String EmailAddress,double Balance,String PhysicalAddress,  String PhoneNumber ,String FirstName, String LastName) {
        this.UserName = UserName;
        this.EmailAddress = EmailAddress;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.PhysicalAddress = PhysicalAddress;
        this.Balance = Balance;
    }



    public double AddBalance(double x){
        if (x<=0) {
            return -1;
        }
        else{
            this.Balance += x;
            this.updateBalance();
            return this.Balance;
       }
    }
    public double makePayment(double amount){
        if (amount > this.Balance){
            return -1; 
        }
        else {
            this.Balance -= amount; 
            this.updateBalance();
            return this.Balance;
        }
    }
    
    public void updateBalance(){
         try {
        URL url = new URL("http://127.0.0.1:5000/updatebalance");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       
        connection.setRequestMethod("POST");

        
        connection.setRequestProperty("Content-Type", "application/json");

        
        connection.setDoOutput(true);

        
        String postData = "{" +
                "\"username\": \"" + this.UserName + "\"," +
                "\"new_balance\": \"" + this.Balance + "\"" +
                "}";
        System.out.println("Request Payload: " + postData);


        // Get the output stream and write the data
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
            wr.write(postDataBytes);
        }

        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        
        // StringBuilder res = response.replace(0,17,"");
        // String res2 = res.toString().replaceAll("}","").replaceAll(" ", "");

        
        System.out.println("Response:" + response.toString());
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
    
@Override
public HashMap<String, String> getUserData() {
   HashMap<String,String> userdata = new HashMap<>();
   userdata.put("firstname", this.FirstName);
   userdata.put("username", this.UserName);
   userdata.put("lastname", this.LastName);
   userdata.put("email", this.EmailAddress);
   userdata.put("add", this.PhysicalAddress);
   userdata.put("phonenum", this.PhoneNumber);
   userdata.put("balance", String.valueOf(this.Balance));
   return userdata;
}

    //setters and getters
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhysicalAddress() {
        return PhysicalAddress;
    }

    public void setPhysicalAddress(String PhysicalAddress) {
        this.PhysicalAddress = PhysicalAddress;
    }


    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }






}