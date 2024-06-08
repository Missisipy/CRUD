import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;

public class CustomConverter implements JsonSerializer <Developer> {
    @Override
    public JsonElement serialize(Developer developer, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject object = new JsonObject();

        object.addProperty("idValue", developer.getID());
        object.addProperty("firstName", developer.getFirstName());
        object.addProperty("lastName", developer.getLastName());
        object.addProperty("skills", developer.getSkills());
        object.addProperty("speciality", developer.getSpeciality());
        object.addProperty("status", developer.getStatus());

        return object;
    }
}
