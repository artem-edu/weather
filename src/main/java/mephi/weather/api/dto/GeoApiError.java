package mephi.weather.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoApiError {
    public final int statusCode;
    public final String error;
    public final String message;

    @JsonCreator
    public GeoApiError(
            @JsonProperty("statusCode") int statusCode,
            @JsonProperty("error") String error,
            @JsonProperty("message") String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }
}
