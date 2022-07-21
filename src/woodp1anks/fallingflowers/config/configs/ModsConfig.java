package woodp1anks.fallingflowers.config.configs;

import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.Mod;

public class ModsConfig extends Config {
    public ModsConfig() {
        super("Mods");
    }

    @Override
    public void syncStart() {
        for (Mod mod : FallingFlowers.modManager.getMods()) {
            if (get(mod.getName() + "-enabled") == null) {
                mod.setEnabled(false);
            } else {
                mod.setEnabled(Boolean.parseBoolean(get(mod.getName() + "-enabled")));
            }
            if (get(mod.getName() + "-key") == null) {
                mod.setKey(0);
            } else {
                mod.setKey(Integer.parseInt(get(mod.getName() + "-key")));
            }
        }
    }

    @Override
    public void syncStop() {
        for (Mod mod : FallingFlowers.modManager.getMods()) {
            set(mod.getName() + "-enabled", String.valueOf(mod.isEnabled()));
            set(mod.getName() + "-key", String.valueOf(mod.getKey()));
        }
    }

    @Override
    public void syncDefault() {
        for (Mod mod : FallingFlowers.modManager.getMods()) {
            mod.setKey(0);
            mod.setEnabled(false);
        }
    }
}
