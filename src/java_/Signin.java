package java_;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.net.URL;
import java.nio.charset.StandardCharsets;
public class Signin {
    private String userName;
    private String password;
    private Person user;
    public Signin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Person SIGN_IN(int AccountType){
        ArrayList<String> user  = this.getUserFromDatabase();
        if (user.get(0).equals("null")) {
            return null;
        }else{
            if (AccountType == 0) {
                String username = user.get(0);
                String password = user.get(1);
                String email = user.get(2);
                double balance = Double.parseDouble(user.get(3));
                String physicalAdd = user.get(4);
                String phoneNum = user.get(5);
                String firstName = user.get(6);
                String lastName = user.get(7);
                this.user = new LandLord(username, password, email, balance, physicalAdd, phoneNum, firstName, lastName);
            }else {
                String username = user.get(0);
                String password = user.get(1);
                String email = user.get(2);
                double balance = Double.parseDouble(user.get(3));
                String physicalAdd = user.get(4);
                String phoneNum = user.get(5);
                String firstName = user.get(6);
                String lastName = user.get(7);
                String aprtid = user.get(8);
                //until the Tenant class be ready to use it in 
                
                if (aprtid.equals("null")) {
                    this.user = new Tenant(username, password, email, balance, physicalAdd, phoneNum, firstName, lastName);
                }else{
                    this.user = new Tenant(username, password, email, balance, physicalAdd, phoneNum, firstName, lastName,Integer.parseInt(aprtid));

                }
            }
        }
        return this.user;
    }

    private ArrayList<String> getUserFromDatabase(){
        ArrayList<String> userData = new ArrayList<>();
    try {
        URL url = new URL("http://127.0.0.1:5000/signin");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       
        connection.setRequestMethod("POST");

        
        connection.setRequestProperty("Content-Type", "application/json");

        
        connection.setDoOutput(true);

        
        String postData = "{" +
                "\"username\": \"" + this.userName + "\"," +
                "\"password\": \"" + this.password + "\"" +
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

        String res = response.toString();
        String cleanedData = res.replaceAll("[{}\"]", "");
        String cleanedData1 = cleanedData.replaceAll("[:\\[\\] ]", "");  
        String[] dataArray = cleanedData1.split(",");
        
        for (String element : dataArray) {
            userData.add(element.trim());
        }
        
        System.out.println("Response:" + userData);
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userData;
}

  
}
