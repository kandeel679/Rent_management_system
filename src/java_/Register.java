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

            // Create a URL object
            URL url = new URL(serverUrl);

            // Open a connection to the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable input and output streams
            connection.setDoOutput(true);

            // Set content type
            connection.setRequestProperty("Content-Type", "application/json");

            // Replace this with your actual data to send
            // "+user.getEmail()+"
            String postData = "{\"username\": \""+user.getUsereName()+"\",\"password\":\""+user.getPassword()+"\",\"email\":\""+user.getEmail()+"\"}";

            // Get the output stream and write the data
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
                wr.write(postDataBytes);
            }

            // Read the response data
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the server response
            System.out.println("Server Response: " + response.toString());

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
