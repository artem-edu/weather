package mephi.weather.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {
    private final int statusCode;
    private final String error;
    private final String message;

    @JsonCreator
    public ApiError(
            @JsonProperty("statusCode") int statusCode,
            @JsonProperty("error") String error,
            @JsonProperty("message") String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }

    public int statusCode() {
        return this.statusCode;
    }

    public String error() {
        return this.error;
    }

    public String message() {
        return this.message;
    }

    @Override
    public String toString() {
        return "ApiError{statusCode=" + statusCode + ", error='" + error + "', message='" + message + "'}";
    }
}
