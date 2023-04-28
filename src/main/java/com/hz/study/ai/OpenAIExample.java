package com.hz.study.ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class OpenAIExample {

    public static void main(String[] args) throws Exception {

        // Set up the HTTP request
        URL url = new URL("https://api.openai.com/v1/engines/davinci-codex/completions");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        // Set up the API key and request parameters
        String apiKey = "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";
        String prompt = "How do I write a Java program to calculate discounts?";
        String data = "{\n\"prompt\": \"" + prompt + "\",\n\"max_tokens\": 10,\n\"temperature\": 0.5\n}";
        String auth = Base64.getEncoder().encodeToString(apiKey.getBytes());

        // Add the API key and request parameters to the HTTP headers
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);
        con.setRequestProperty("OpenAI-Integration", "java-sdk");
        con.setRequestProperty("User-Agent", "OpenAI-Java-Client");

        // Send the HTTP request
        con.setDoOutput(true);
        con.getOutputStream().write(data.getBytes("UTF-8"));

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Process the response
        String result = response.toString();
        System.out.println(result);

    }
}
