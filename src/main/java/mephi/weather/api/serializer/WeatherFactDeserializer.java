package mephi.weather.api.serializer;

import mephi.weather.api.dto.WeatherFact;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

public class WeatherFactDeserializer extends StdDeserializer<WeatherFact> {
    public WeatherFactDeserializer() {
        super(WeatherFact.class);
    }

    @Override
    public WeatherFact deserialize(JsonParser p, DeserializationContext ctx) throws JacksonException {
        JsonNode root = ctx.readTree(p);
        JsonNode temp = root.at("/fact/temp");
        if (temp.isNumber()) {
            return new WeatherFact(temp.asInt());
        }

        throw new RuntimeException("Ошибка парсинга"); 

    }

}
