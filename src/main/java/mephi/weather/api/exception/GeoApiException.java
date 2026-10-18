package mephi.weather.api.exception;

import mephi.weather.api.dto.GeoApiError;

public class GeoApiException extends RuntimeException {
    private final GeoApiError apiError;

    public GeoApiException(GeoApiError apiError) {
        super(apiError.message);
        this.apiError = apiError;
    }

    public GeoApiError getError() {
        return this.apiError;
    }
}
