package woodp1anks.fallingflowers.mod.mods.combat;

import net.minecraft.client.Minecraft;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

public class VelocityMod extends Mod {
    public VelocityMod() {
        super("Velocity", "Velocity", "let velocity you get be smaller", Category.Combat);
    }

    @Override
    public void onUpdate() {
        if (Minecraft.getMinecraft().thePlayer.hurtTime > 0 && Minecraft.getMinecraft().thePlayer.onGround) {
            Minecraft.getMinecraft().thePlayer.motionY = 0.42;
        }
    }
}
