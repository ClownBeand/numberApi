package service.impl;

import service.TextProvider;
import properties.Properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiNumberImpl implements TextProvider {
    private final Properties properties ;
    @Override
    public String getContent() {
        try {
            URL url = new URL(properties.getUrl().formatted(getRandom()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getRandom() {
        return (int) (Math.random() * (properties.getMaxNumber() + 1));
    }

    public ApiNumberImpl(Properties properties) {
        this.properties = properties;
    }
}
