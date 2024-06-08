import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CustomConverterImpl implements JsonSerializer <Skill> {
    @Override
    public JsonElement serialize (Skill skill, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject object = new JsonObject();

        object.addProperty("skill", skill.getSkill());
        object.addProperty("status", skill.getStatus());

        return object;
    }
}
