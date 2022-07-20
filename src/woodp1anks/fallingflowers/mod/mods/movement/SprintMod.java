package woodp1anks.fallingflowers.mod.mods.movement;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

public class SprintMod extends Mod {
    public SprintMod() {
        super("Sprint", null,"let you always sprint", Category.Movement);
        setKey(Keyboard.KEY_X);
    }

    @Override
    public void onUpdate() {
        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
            Minecraft.getMinecraft().thePlayer.setSprinting(true);
        }
    }
}
