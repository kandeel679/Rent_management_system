package java_;

public class testperson {
    private static int id = 0;
    private String usereName;
    private String email;
    private String password;
    private String FirstName;
    private String LastName;
    private String PhysicalAdd;
    private double balanc;
    private String phoneNum;
    public testperson(String usereName, String email, String password, String firstName, String lastName,
            String physicalAdd, double balanc, String phoneNum) {

        this.usereName = usereName;
        this.email = email;
        this.password = password;
        FirstName = firstName;
        LastName = lastName;
        PhysicalAdd = physicalAdd;
        this.balanc = balanc;
        this.phoneNum = phoneNum;
        testperson.id++;
    }
    public String getUsereName() {
        return usereName;
    }
    public void setUsereName(String usereName) {
        this.usereName = usereName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getPhysicalAdd() {
        return PhysicalAdd;
    }
    public void setPhysicalAdd(String physicalAdd) {
        PhysicalAdd = physicalAdd;
    }
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        testperson.id = id;
    }
    public double getBalanc() {
        return balanc;
    }
    public void setBalanc(double balanc) {
        this.balanc = balanc;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


}
