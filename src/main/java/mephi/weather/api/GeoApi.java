package mephi.weather.api;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import mephi.weather.service.Config;

public class GeoApi {
    private final String API_URL = "https://geocode-maps.yandex.ru/v1";
    private final String API_KEY;

    private final HttpClient client = HttpClient.newHttpClient();

    public GeoApi() {
        API_KEY = Config.getValue("GEO_API_KEY");
    }

    public HttpResponse<String> getCoordResponse(String addr) throws IOException, InterruptedException {
        URI uri = buildGeoUrl(addr);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    private URI buildGeoUrl(String address) {
        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
        String queryString = String.format(
                "apikey=%s&geocode=%s&format=json&lang=ru_RU&results=1",
                API_KEY,
                encodedAddress);

        URI uri = URI.create(API_URL + "?" + queryString);

        return uri;
    }
}
