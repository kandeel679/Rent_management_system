package java_;
import java.util.HashMap;
import java.util.Map;
public class Signin {
    private String userName;
    private String password;
    public Signin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public boolean CheckUser(){
        return false;
    }
    public Map<String,String> CreatObj(){
        Map<String,String> map = new HashMap<>();
        return map;
    }
}
