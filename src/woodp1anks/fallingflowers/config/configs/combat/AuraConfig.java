package woodp1anks.fallingflowers.config.configs.combat;

import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.mods.combat.AuraMod;

public class AuraConfig extends Config {
    public AuraConfig() {
        super("Aura");
    }

    @Override
    public void syncStart() {
        AuraMod auraMod = (AuraMod) FallingFlowers.modManager.getMod("Aura");
        auraMod.setMinCps(Integer.parseInt(get("mincps")));
        auraMod.setMaxCps(Integer.parseInt(get("maxcps")));
    }

    @Override
    public void syncStop() {
        AuraMod auraMod = (AuraMod) FallingFlowers.modManager.getMod("Aura");
        set("mincps", String.valueOf(auraMod.getMinCps()));
        set("maxcps", String.valueOf(auraMod.getMaxCps()));
    }

    @Override
    public void syncDefault() {
        AuraMod auraMod = (AuraMod) FallingFlowers.modManager.getMod("Aura");
        auraMod.setMinCps(5);
        auraMod.setMaxCps(8);
    }
}
