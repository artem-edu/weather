package mephi.weather.service;

import java.io.IOException;
import java.net.http.HttpResponse;

import mephi.weather.api.GeoApi;
import mephi.weather.api.dto.GeoApiError;
import mephi.weather.api.dto.Point;
import mephi.weather.api.exception.GeoApiException;
import tools.jackson.databind.ObjectMapper;

public class GeoService {
    private final GeoApi client = new GeoApi();
    private final ObjectMapper mapper = new ObjectMapper();

    public Point getPoint(String addr) throws IOException, InterruptedException {
        HttpResponse<String> response = client.getCoordResponse(addr);

        if (response.statusCode() == 200) {
            String resp = response.body();
            Point point = mapper.readValue(resp, Point.class);
            return point;
        }

        GeoApiError apiError = mapper.readValue(response.body(), GeoApiError.class);
        throw new GeoApiException(apiError);
    }

}
