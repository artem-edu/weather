package mephi.weather.api.exception;

import mephi.weather.api.dto.WeatherApiError;

public class WeatherApiException extends RuntimeException {
    private final WeatherApiError weatherApiError;

    public WeatherApiException(WeatherApiError weatherApiError) {
        super(weatherApiError.message);
        this.weatherApiError = weatherApiError;
    }

    public WeatherApiError getError() {
        return this.weatherApiError;
    }
}
