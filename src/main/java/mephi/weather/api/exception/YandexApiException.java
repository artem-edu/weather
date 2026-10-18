package mephi.weather.api.exception;

import mephi.weather.api.dto.GeoApiError;

public class YandexApiException extends RuntimeException {
    private final GeoApiError apiError;

    public YandexApiException(GeoApiError apiError) {
        super(apiError.message());
        this.apiError = apiError;
    }

    public GeoApiError getError() {
        return this.apiError;
    }
}
