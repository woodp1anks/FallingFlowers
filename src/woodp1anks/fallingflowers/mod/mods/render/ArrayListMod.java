package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

import java.awt.*;
import java.util.List;

public class ArrayListMod extends Mod {
    private int r;
    private int g;
    private int b;
    private int a;

    public ArrayListMod() {
        super("ArrayList", "ArrayList","see all mods that is enabled.", Category.Render);
        setKey(Keyboard.KEY_P);
    }

    @Override
    public void onRender2D() {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int width = scaledResolution.getScaledWidth();
        int height = scaledResolution.getScaledHeight();

        List<Mod> enabledMods = FallingFlowers.modManager.getEnabledMods();
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        enabledMods.sort(((o1, o2) -> font.getStringWidth(o2.getName()) - font.getStringWidth(o1.getName())));

        int y = 8;
        for (Mod mod : enabledMods) {
            font.drawStringWithShadow(mod.getName(),width - font.getStringWidth(mod.getName()) - 8,y, new Color(r,g,b,a).getRGB());
            y += font.FONT_HEIGHT + 3;
        }
    }

    public int getB() {
        return b;
    }

    public int getG() {
        return g;
    }

    public int getR() {
        return r;
    }

    public int getA() {
        return a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setA(int a) {
        this.a = a;
    }
}
