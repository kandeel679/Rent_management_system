package java_;

import java.util.HashMap;

public abstract class Person {
    protected String UserName;
    protected String FirstName;
    protected String LastName;
    protected String EmailAddress;
    protected String PhoneNumber;
    protected String Password;
    protected String PhysicalAddress;
    protected double Balance;

    public Person(String UserName,String EmailAddress,String Password, String FirstName, String LastName,  String PhoneNumber,  String PhysicalAddress,double Balance) {
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
        return this.Balance;
       }
    }
    public double makePayment(double amount){
        if (amount > this.Balance){
            return -1; 
        }
        else {
            this.Balance += amount; 
            return this.Balance;
        }
    }
    
    public abstract HashMap<String,String> DisplayApart();


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