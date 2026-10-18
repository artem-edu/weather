package mephi.weather.api.exception;

import mephi.weather.api.dto.ApiError;

public class YandexApiException extends RuntimeException {
    private final ApiError apiError;

    public YandexApiException(ApiError apiError) {
        super(apiError.message());
        this.apiError = apiError;
    }

    public ApiError getError() {
        return this.apiError;
    }
}
