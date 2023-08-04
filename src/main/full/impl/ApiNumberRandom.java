package full.impl;

import full.TextProvider;
import properties.Properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiNumberRandom implements TextProvider {
    private final Properties properties ;
    @Override
    public String getContent() throws IOException{
        URL url = new URL(properties.getUrl().formatted(getRandom()));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String text = in.readLine();

        in.close();
        return text;
    }

    private int getRandom()
        {
            return (int) (Math.random() * (properties.getMaxNumber() + 1));
    }

    public ApiNumberRandom(Properties properties) {
        this.properties = properties;
    }
}
