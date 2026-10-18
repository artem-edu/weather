package mephi.weather.api.serializer;

import mephi.weather.api.dto.Point;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

public class PointDeserializer extends StdDeserializer<Point> {

    public PointDeserializer() {
        super(Point.class);
    }

    @Override
    public Point deserialize(JsonParser p, DeserializationContext ctx) {
        JsonNode root = ctx.readTree(p);

        JsonNode featureMember = root.at("/response/GeoObjectCollection/featureMember");

        if (featureMember.isArray() && !featureMember.isEmpty()) {
            String pos = featureMember.get(0).at("/GeoObject/Point/pos").asString();

            if (!pos.isEmpty()) {
                String[] coords = pos.split(" ");

                double lon = Double.parseDouble(coords[0]);
                double lat = Double.parseDouble(coords[1]);
                return new Point(lat, lon);
            }
        }

        throw new RuntimeException("Координаты не найдены");
    }

}
