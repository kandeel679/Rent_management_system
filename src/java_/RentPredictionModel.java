package java_;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RentPredictionModel {
    private double area;
    private int year;
    private int floor;
    private double prediction;
    public RentPredictionModel(double area, int year, int floor) {
        this.area = area;
        this.year = year;
        this.floor = floor;
    }
    public double Predict() {
        try {
            URL url = new URL("http://127.0.0.1:5000/rent");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
    
            String postData = "{" +
                    "\"year\": " + this.year + "," +
                    "\"area\": " + this.area + "," +
                    "\"floor\": " + this.floor +
                    "}";
            System.out.println("Request Payload: " + postData);
    
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
                wr.write(postDataBytes);
            }
    
            // Close the output stream before reading from the input stream
            connection.getOutputStream().close();
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
    
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
    
            String res = response.toString();
            String cleanedData = res.replaceAll("[{}\"]", "");
            String cleanedData1 = cleanedData.replaceAll("[:\\[\\] ]", "");
    
            System.out.println("Response:" + Double.parseDouble(cleanedData1));
            return Double.parseDouble(cleanedData1);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
}
