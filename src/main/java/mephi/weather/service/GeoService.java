package mephi.weather.service;

import java.net.http.HttpResponse;

import mephi.weather.api.GeoApi;
import mephi.weather.api.dto.ApiError;
import mephi.weather.api.dto.Point;
import mephi.weather.api.exception.YandexApiException;
import tools.jackson.databind.ObjectMapper;

public class GeoService {
    private final GeoApi client = new GeoApi();
    private final ObjectMapper mapper = new ObjectMapper();

    public Point getPoint(String addr) {
        try {
            HttpResponse<String> response = client.getCoordResponse(addr);

            if (response.statusCode() == 200) {
                String resp = response.body();
                Point point = mapper.readValue(resp, Point.class);
                return point;
            }

            ApiError apiError = mapper.readValue(response.body(), ApiError.class);

            throw new YandexApiException(apiError);

        } catch (YandexApiException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
