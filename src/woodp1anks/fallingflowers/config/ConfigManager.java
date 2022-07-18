package woodp1anks.fallingflowers.config;

import net.minecraft.client.Minecraft;
import woodp1anks.fallingflowers.config.configs.ModsConfig;
import woodp1anks.fallingflowers.config.configs.render.ArrayListConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private final List<Config> configs = new ArrayList<Config>() {{
        add(new ModsConfig());
        add(new ArrayListConfig());
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
                    System.out.println(Minecraft.getMinecraft().mcDataDir.getAbsolutePath());
                    Files.createDirectory(config.getPath().getParent().getParent());
                    Files.createDirectory(config.getPath().getParent());
                    config.getPath().toFile().createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            config.save();
        }
    }
}
