package woodp1anks.fallingflowers.mod;

import woodp1anks.fallingflowers.mod.mods.combat.AuraMod;
import woodp1anks.fallingflowers.mod.mods.combat.VelocityMod;
import woodp1anks.fallingflowers.mod.mods.misc.AntiBot;
import woodp1anks.fallingflowers.mod.mods.movement.SprintMod;
import woodp1anks.fallingflowers.mod.mods.render.*;
import woodp1anks.fallingflowers.mod.mods.world.BridgeAssistMod;

import java.util.ArrayList;
import java.util.List;

public class ModManager {
    private final List<Mod> mods = new ArrayList<>();

    public List<Mod> getMods() {
        return mods;
    }

    public List<Mod> getEnabledMods() {
        List<Mod> enabledMods = new ArrayList<>();
        for (Mod mod : getMods()) {
            if (mod.isEnabled()) {
                enabledMods.add(mod);
            }
        }
        return enabledMods;
    }

    public void load() {
        mods.add(new LogoMod());
        mods.add(new SprintMod());
        mods.add(new ArrayListMod());
        mods.add(new ZoomMod());
        mods.add(new FullBrightMod());
        mods.add(new TabGuiMod());
        mods.add(new BridgeAssistMod());
        mods.add(new AuraMod());
        mods.add(new AntiBot());
        mods.add(new VelocityMod());
        mods.add(new ESPMod());
    }

    public void toggleBoundedModules(int key) {
        for (Mod mod : getMods()) {
            if (key == mod.getKey()) {
                mod.setEnabled(!mod.isEnabled());
            }
        }
    }

    public Mod getMod(String name) {
        for (Mod mod : getMods()) {
            if (mod.getName().equalsIgnoreCase(name)) {
                return mod;
            }
        }
        return null;
    }

    public Mod getEnabledMod(String name) {
        for (Mod mod : getEnabledMods()) {
            if (mod.getName().equalsIgnoreCase(name)) {
                return mod;
            }
        }
        return null;
    }

    public List<Mod> getMods(Category category) {
        List<Mod> mods1 = new ArrayList<>();
        for (Mod mod : mods) {
            if (mod.getCategory() == category) {
                mods1.add(mod);
            }
        }
        return mods1;
    }

    public List<Mod> getEnabledMods(Category category) {
        List<Mod> mods1 = new ArrayList<>();
        for (Mod mod : mods) {
            if (mod.getCategory() == category && mod.isEnabled()) {
                mods1.add(mod);
            }
        }
        return mods1;
    }
}
