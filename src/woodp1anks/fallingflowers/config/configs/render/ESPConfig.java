package woodp1anks.fallingflowers.config.configs.render;

import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.mods.render.ESPMod;

public class ESPConfig extends Config {
    public ESPConfig() {
        super("ESP");
    }

    @Override
    public void syncStart() {
        ESPMod espMod = (ESPMod) FallingFlowers.modManager.getMod("ESP");
        espMod.setPlayerDisplay(Boolean.parseBoolean(get("playerdisplay")));
        espMod.setAnimalDisplay(Boolean.parseBoolean(get("animaldisplay")));
        espMod.setMobDisplay(Boolean.parseBoolean(get("mobdisplay")));
    }

    @Override
    public void syncStop() {
        ESPMod espMod = (ESPMod) FallingFlowers.modManager.getMod("ESP");
        set("playerdisplay", String.valueOf(espMod.isPlayerDisplay()));
        set("animaldisplay", String.valueOf(espMod.isAnimalDisplay()));
        set("mobdisplay", String.valueOf(espMod.isMobDisplay()));
    }

    @Override
    public void syncDefault() {
        ESPMod espMod = (ESPMod) FallingFlowers.modManager.getMod("ESP");
        espMod.setPlayerDisplay(true);
        espMod.setMobDisplay(false);
        espMod.setAnimalDisplay(false);
    }
}
