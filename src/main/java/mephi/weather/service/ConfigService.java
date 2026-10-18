package mephi.weather.service;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigService {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getValue(String key) {
        return dotenv.get(key); 
    }

    public static String getValue(String key, String defaultValue) {
        return dotenv.get(key, defaultValue);
    }
}
