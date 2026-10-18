package mephi.weather.api.dto;

import mephi.weather.api.serializer.PointDeserializer;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PointDeserializer.class)
public class Point {
    private final double lat;
    private final double lon;

    public Point(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double log() {
        return this.lon;
    }

    public double lat() {
        return this.lat;
    }

    @Override()
    public String toString() {
        return "Point{lat='" + lat + "', lon='" + lon + "'}";
    }
}
