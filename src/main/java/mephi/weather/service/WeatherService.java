package mephi.weather.service;

import java.net.http.HttpResponse;

import mephi.weather.api.WeatherApi;
import mephi.weather.api.dto.Point;
import mephi.weather.api.dto.WeatherFact;
import tools.jackson.databind.ObjectMapper;

public class WeatherService {
    private final WeatherApi client = new WeatherApi();
    private final ObjectMapper mapper = new ObjectMapper();

    public WeatherFact getWeather(Point point) {
        try {
            HttpResponse<String> response = client.getWeatherResponse(point);
            WeatherFact weatherFact = mapper.readValue(response.body(), WeatherFact.class);

            return weatherFact;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
