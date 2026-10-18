package mephi.weather.service;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigService {
    public static String getValue(String key) {
        Dotenv dotenv = Dotenv.load();

        return dotenv.get(key);
    }

    public static String getValue(String key, String defaultValue) {
        Dotenv dotenv = Dotenv.load();

        return dotenv.get(key, defaultValue);
    }
}
