package mephi.weather.api.dto;

public class Weather {
    public  final WeatherFact fact;
    public  final String rawJson;

    public Weather(WeatherFact fact, String rawJson) {
        this.fact = fact;
        this.rawJson = rawJson;

    }
}
