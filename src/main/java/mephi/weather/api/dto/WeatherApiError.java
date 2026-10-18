package mephi.weather.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherApiError {
    public final String message;

    @JsonCreator
    public WeatherApiError(@JsonProperty("message") String message) {
        this.message = message;
    }
}
