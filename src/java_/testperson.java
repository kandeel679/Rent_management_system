package java_;

public class testperson {
    private String usereName;
    private String email;
    private String password;
    public testperson(String usereName, String email, String password) {
        this.usereName = usereName;
        this.email = email;
        this.password = password;
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
    
}
