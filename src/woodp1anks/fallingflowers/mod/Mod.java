package woodp1anks.fallingflowers.mod;

import net.minecraft.network.Packet;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;

public class Mod {
    private final String name;
    private boolean enabled;
    private final Category category;
    private final String configName;
    private int key;
    private final String description;

    public Mod(String name, String configName, String description,Category category) {
        this.name = name;
        this.configName = configName;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getConfigName() {
        return configName;
    }

    public String getDescription() {
        return description;
    }

    public Config getConfig() {
        return FallingFlowers.configManager.getConfig(configName);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getKey() {
        return key;
    }

    public void onRender2D() {

    }

    public void onRender3D() {

    }

    public void onUpdate() {

    }

    public void onKeyPressed(int key) {

    }

    public void onPacket(Packet packet) {

    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }
}
