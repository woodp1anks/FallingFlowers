package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import woodp1anks.fallingflowers.mod.Mod;

public class FullBrightMod extends Mod {
    public FullBrightMod() {
        super("FullBright", true);
    }

    @Override
    public void onRender() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
    }
}
