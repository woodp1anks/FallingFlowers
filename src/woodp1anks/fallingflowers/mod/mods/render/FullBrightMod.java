package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

public class FullBrightMod extends Mod {
    public FullBrightMod() {
        super("FullBright", null,"let the world been light.", Category.Render);
    }

    @Override
    public void onRender2D() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
    }
}
