package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

import java.awt.*;

public class LogoMod extends Mod {
    public LogoMod() {
        super("Logo", null,"a logo of this client", Category.Render);
        setKey(Keyboard.KEY_L);
    }

    @Override
    public void onRender2D() {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

        font.drawStringWithShadow(FallingFlowers.NAME,8,8, Color.pink.getRGB());
        font.drawStringWithShadow(FallingFlowers.VERSION,8 + font.getStringWidth(FallingFlowers.NAME) + 4,8,Color.LIGHT_GRAY.getRGB());
        font.drawStringWithShadow("by " + FallingFlowers.AUTHOR,8,8 + font.FONT_HEIGHT + 3,Color.ORANGE.getRGB());
    }
}
