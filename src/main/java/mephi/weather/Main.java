package mephi.weather;

import mephi.weather.api.dto.Point;
import mephi.weather.service.GeoService;

public class Main {
    public static void main(String[] args) {
        GeoService geoService = new GeoService();
        try {
            Point point = geoService.getPoint("Москва");
            System.out.print(point);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}