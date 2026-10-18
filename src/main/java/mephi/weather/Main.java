package mephi.weather;

import mephi.weather.api.dto.Point;
import mephi.weather.api.dto.WeatherFact;
import mephi.weather.service.GeoService;
import mephi.weather.service.WeatherService;

public class Main {
    public static void main(String[] args) {
        GeoService geoService = new GeoService();
        WeatherService weatherService = new WeatherService();
        try {
            Point point = geoService.getPoint("Москва");
            WeatherFact data = weatherService.getWeather(point);
            System.out.println("result: " + data.temp());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}