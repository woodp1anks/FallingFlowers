package woodp1anks.fallingflowers.config;

import net.minecraft.client.Minecraft;
import woodp1anks.fallingflowers.config.configs.ModsConfig;
import woodp1anks.fallingflowers.config.configs.render.ArrayListConfig;
import woodp1anks.fallingflowers.config.configs.render.BoxDisplayConfig;
import woodp1anks.fallingflowers.config.configs.render.ZoomConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private final List<Config> configs = new ArrayList<Config>() {{
        add(new ModsConfig());
        add(new ArrayListConfig());
        add(new ZoomConfig());
        add(new BoxDisplayConfig());
    }};

    public List<Config> getConfigs() {
        return configs;
    }

    public Config getConfig(String name) {
        for (Config config : getConfigs()) {
            if (config.getName().equalsIgnoreCase(name)) {
                return config;
            }
        }
        return null;
    }

    public void load() {
        for (Config config : getConfigs()) {
            if (config.getPath().toFile().exists()) {
                config.load();
            } else {
                config.syncDefault();
            }
        }
    }

    public void save() {
        for (Config config : getConfigs()) {
            if (!config.getPath().toFile().exists()) {
                try {
                    if (!config.getPath().getParent().getParent().toFile().exists()) {
                        Files.createDirectory(config.getPath().getParent().getParent());
                    }
                    if (!config.getPath().getParent().toFile().exists()) {
                        Files.createDirectory(config.getPath().getParent());
                    }
                    config.getPath().toFile().createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            config.save();
        }
    }
}
