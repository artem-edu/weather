package mephi.weather.api.dto;

import java.util.List;

import mephi.weather.api.serializer.WeatherDeserializer;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = WeatherDeserializer.class)
public class Weather {
    public final String rawJson;
    public final int fact;
    public final List<Integer> averageTemperatures;

    public Weather(
            String rawJson,
            int fact,
            List<Integer> averageTemperatures) {
        this.rawJson = rawJson;
        this.fact = fact;
        this.averageTemperatures = averageTemperatures;
    }
}
