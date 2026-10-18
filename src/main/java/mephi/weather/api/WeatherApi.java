package mephi.weather.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Locale;

import mephi.weather.api.dto.Point;
import mephi.weather.service.ConfigService;

public class WeatherApi {
    private final String API_URL = "https://api.weather.yandex.ru/v2/forecast";
    private final String API_KEY;

    private final HttpClient httpClient;

    public WeatherApi(HttpClient httpClient) {
        this.httpClient = httpClient;
        API_KEY = ConfigService.getValue("WEATHER_API_KEY");
    }

    public HttpResponse<String> getWeatherResponse(Point point, int limit) throws IOException, InterruptedException {
        URI uri = buildUrl(point, limit);
        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(10))
                .uri(uri)
                .header("X-Yandex-Weather-Key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    private URI buildUrl(Point point, int limit) {
        String queryString = String.format(
                Locale.US,
                "lat=%.5f&lon=%.5f&limit=%d",
                point.lat(),
                point.lon(),
                limit);
        URI uri = URI.create(API_URL + "?" + queryString);

        return uri;
    }
}
