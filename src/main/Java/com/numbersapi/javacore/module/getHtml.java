package com.numbersapi.javacore.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class getHtml {
    public static String getRandomNumb() throws IOException, URISyntaxException {

        int number = (int) (Math.random() * 100500) + 1;
        String apiUrl = "http://numbersapi.com/" + number + "/trivia";

        URI uri = new URI(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");
        System.out.println("GET: " + uri);
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        StringBuilder content = new StringBuilder();
        String inputLine;


        while ((inputLine = in.readLine()) != null)
        {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        return content.toString();
    }
}
