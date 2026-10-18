package mephi.weather.api.serializer;

import java.util.ArrayList;
import java.util.List;

import mephi.weather.api.dto.Weather;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

public class WeatherDeserializer extends StdDeserializer<Weather> {
    public WeatherDeserializer() {
        super(Weather.class);
    }

    @Override
    public Weather deserialize(JsonParser p, DeserializationContext ctx) throws JacksonException {
        JsonNode root = ctx.readTree(p);
        JsonNode temp = root.at("/fact/temp");
        JsonNode forecasts = root.at("/forecasts");

        List<Integer> averageTemperatures = new ArrayList<Integer>();

        if (forecasts.isArray()) {

            for (JsonNode forecast : forecasts) {
                JsonNode tempAvgOfDay = forecast.at("/parts/day/temp_avg");

                if (tempAvgOfDay.isNumber()) {
                    averageTemperatures.add(tempAvgOfDay.asInt());
                }
            }
        }

        return new Weather(
                root.toString(),
                temp.asInt(),
                averageTemperatures);

    }

}
