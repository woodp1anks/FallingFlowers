package woodp1anks.fallingflowers.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import woodp1anks.fallingflowers.FallingFlowers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Config {
    private final String name;
    private Map<String,String> map = new HashMap<>();

    public Config(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return Paths.get(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), FallingFlowers.NAME,"configs",getName() + ".json");
    }

    public String get(String key) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(key)) {
                return entry.getValue().toLowerCase(Locale.ROOT);
            }
        }
        return null;
    }

    public void set(String key,String value) {
        boolean keyExist = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(key)) {
                entry.setValue(value);
                keyExist = true;
            }
        }
        if (!keyExist) {
            map.put(key,value);
        }
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void load() {
        JsonObject jsonObject;
        try {
            jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            set(entry.getKey(),entry.getValue().getAsString());
        }
        syncStart();
    }

    public void syncStart() {

    }

    public void save() {
        syncStop();
        JsonObject jsonObject;
        try {
            jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        for (Map.Entry<String,String> mapEntry : getMap().entrySet()) {
            if (!jsonObject.has(mapEntry.getKey())) {
                jsonObject.addProperty(mapEntry.getKey(),mapEntry.getValue());
            }
            if (!jsonObject.get(mapEntry.getKey()).getAsString().equals(mapEntry.getValue())) {
                jsonObject.addProperty(mapEntry.getKey(),mapEntry.getValue());
            }
        }
        try {
            Files.write(getPath(),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void syncStop() {

    }

    public void syncDefault() {

    }
}
