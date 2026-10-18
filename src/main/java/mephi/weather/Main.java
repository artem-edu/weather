package mephi.weather;

import mephi.weather.api.dto.Point;
import mephi.weather.api.dto.Weather;
import mephi.weather.service.GeoService;
import mephi.weather.service.WeatherService;

public class Main {
    public static void main(String[] args) {
        GeoService geoService = new GeoService();
        WeatherService weatherService = new WeatherService();
        try {
            Point point = geoService.getPoint("Москва");
            Weather data = weatherService.getWeather(point);
            
            System.out.println("RawJson: " + data.rawJson);
            System.out.println("Fact temp: " + data.fact.temp());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}