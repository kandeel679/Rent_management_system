package java_;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Register {
    private testperson user;

    public Register(testperson user) {
        this.user = user;
    }

    public void sendData() {
        try {
            // URL of your local server endpoint    
            String serverUrl = "http://127.0.0.1:5000/register";
            URL url = new URL(serverUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            String postData = "{" +
                "\"username\": \"" + user.getUsereName() + "\"," +
                "\"password\": \"" + user.getPassword() + "\"," +
                "\"email\": \"" + user.getEmail() + "\"," +
                "\"first_name\": \"" + user.getFirstName() + "\"," +
                "\"last_name\": \"" + user.getLastName() + "\"," +
                "\"physical_add\": \"" + user.getPhysicalAdd() + "\"," +
                "\"balance\": " + user.getBalanc() + "," +
                "\"phone_num\": \"" + user.getPhoneNum() + "\"" +
                "}";

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

            
            System.out.println("Server Response: " + response.toString());

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
