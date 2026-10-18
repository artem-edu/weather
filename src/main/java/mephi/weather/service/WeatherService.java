package mephi.weather.service;

import java.io.IOException;
import java.net.http.HttpResponse;

import mephi.weather.api.WeatherApi;
import mephi.weather.api.dto.Point;
import mephi.weather.api.dto.Weather;
import tools.jackson.databind.ObjectMapper;

public class WeatherService {
    private final WeatherApi client = new WeatherApi();
    private final ObjectMapper mapper = new ObjectMapper();

    public Weather getWeather(Point point, int limit) throws IOException, InterruptedException {
        HttpResponse<String> response = client.getWeatherResponse(point, limit);
        Weather weather = mapper.readValue(response.body(), Weather.class);
        // TODO: обработать ошибку

        return weather;
    }
}
