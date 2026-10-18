package mephi.weather.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import mephi.weather.api.WeatherApi;
import mephi.weather.api.dto.Point;
import mephi.weather.api.dto.Weather;
import mephi.weather.api.dto.WeatherApiError;
import mephi.weather.api.exception.WeatherApiException;
import tools.jackson.databind.ObjectMapper;

public class WeatherService {
    private final WeatherApi weatherApi;
    private final ObjectMapper mapper;

    public WeatherService(HttpClient httpClient, ObjectMapper mapper) {
        this.mapper = mapper;
        this.weatherApi = new WeatherApi(httpClient);
    }

    public Weather getWeather(Point point, int limit) throws IOException, InterruptedException {
        HttpResponse<String> response = weatherApi.getWeatherResponse(point, limit);

        if (response.statusCode() == 200) {
            Weather weather = mapper.readValue(response.body(), Weather.class);
            return weather;
        }

        WeatherApiError weatherApiError = mapper.readValue(response.body(), WeatherApiError.class);
        throw new WeatherApiException(weatherApiError);
    }
}
