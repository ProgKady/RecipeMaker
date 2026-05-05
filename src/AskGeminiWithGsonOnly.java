

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class AskGeminiWithGsonOnly {

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta2/models/text-bison-001:generateText";
    private static final String API_KEY = "AIzaSyBbGgUUsluazKDutLPW2cUxLh0rsE5N0zg"; // Replace with your actual API key

    public static void main(String[] args) {
        try {
            // The question to ask Gemini
            String question = "What is the weather today?";

            // Create the JSON request body
            JsonObject prompt = new JsonObject();
            prompt.addProperty("text", question);

            JsonObject jsonRequest = new JsonObject();
            jsonRequest.add("prompt", prompt);

            // Send POST request to the Gemini API
            String response = sendPostRequest(API_URL + "?key=" + API_KEY, jsonRequest.toString());

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
            String answer = jsonResponse
                    .getAsJsonArray("candidates")
                    .get(0)
                    .getAsJsonObject()
                    .get("output")
                    .getAsString();

            System.out.println("Response from Gemini: " + answer);

            // Open the response in the browser
            openBrowserWithResponse(question, answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to send a POST request using HttpURLConnection
    private static String sendPostRequest(String urlString, String jsonInputString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        // Write JSON input to the request
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read the response from the API
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        return response.toString();
    }

    // Method to open the default browser with the question and response
    private static void openBrowserWithResponse(String question, String answer) throws Exception {
        String url = "https://www.example.com?question=" + question + "&response=" + answer;
        Desktop.getDesktop().browse(new URI(url));
    }
}
