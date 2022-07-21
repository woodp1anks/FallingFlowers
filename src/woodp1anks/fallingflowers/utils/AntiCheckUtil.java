package woodp1anks.fallingflowers.utils;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.mod.Mod;

public class AntiCheckUtil {
    public static int arrows;
    public static int ticks;

    public static boolean startHide;
    public static boolean hided2D;
    public static boolean hided3D;

    public static void update() {
        ticks++;
        if (ticks >= 20) {
            arrows = 0;
            ticks = 0;
        }
    }

    public static void check() {
        if (Minecraft.getMinecraft().thePlayer == null) {
            AntiCheckUtil.hide();
        }
    }

    public static void hide() {
        for (Mod enabledMod : FallingFlowers.modManager.getEnabledMods()) {
            enabledMod.setEnabled(false);
        }
        Display.setTitle("Minecraft 1.8.8");
        System.out.println("LMAO FUCKING wdsj.net ");
        AntiCheckUtil.startHide = true;
    }

    public static void hide2() {
        if (hided2D && hided3D) {
            try {
                Thread.sleep(191981011);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
