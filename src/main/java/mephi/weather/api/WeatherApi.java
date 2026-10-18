package mephi.weather.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

import mephi.weather.api.dto.Point;
import mephi.weather.service.Config;

public class WeatherApi {
    private final String API_URL = "https://api.weather.yandex.ru/v2/forecast";
    private final String API_KEY;

    private final HttpClient client = HttpClient.newHttpClient();

    public WeatherApi() {
        API_KEY = Config.getValue("WEATHER_API_KEY");
    }

    public HttpResponse<String> getWeatherResponse(Point point) throws IOException, InterruptedException {
        URI uri = buildUrl(point);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Yandex-Weather-Key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    private URI buildUrl(Point point) {
        String queryString = String.format(Locale.US, "lat=%.5f&lon=%.5f", point.lat(), point.lon());
        System.out.println(queryString);
        URI uri = URI.create(API_URL + "?" + queryString);

        return uri;
    }
}
