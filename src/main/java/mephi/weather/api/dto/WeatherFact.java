package mephi.weather.api.dto;

import mephi.weather.api.serializer.WeatherFactDeserializer;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = WeatherFactDeserializer.class)
public class WeatherFact {
    private final int temp;

    public WeatherFact(int temp) {
        this.temp = temp;
    }

    public int temp() {
        return this.temp;
    }

    @Override()
    public String toString() {
        return "WeatherFact(temp='" + temp + "')";
    }
}
