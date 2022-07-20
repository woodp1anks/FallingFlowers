package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

public class ZoomMod extends Mod {
    private int toggleKey = Keyboard.KEY_C;
    private float fov = 30;

    private boolean toggled;
    private float normalFov;

    public ZoomMod() {
        super("Zoom", "Zoom","allows you zoom to see something better.", Category.Render);
    }

    @Override
    public void onKeyPressed(int key) {
        if (!Keyboard.isKeyDown(getToggleKey()) && toggled) {
            toggled = false;
            Minecraft.getMinecraft().gameSettings.fovSetting = normalFov;
        }
        if (Keyboard.isKeyDown(getToggleKey())) {
            Minecraft.getMinecraft().gameSettings.fovSetting = fov;
        }
        if (!Keyboard.isKeyDown(getToggleKey())) {
            normalFov = Minecraft.getMinecraft().gameSettings.fovSetting;
        }
        toggled = Keyboard.isKeyDown(getToggleKey());
    }

    public int getToggleKey() {
        return toggleKey;
    }

    public float getFov() {
        return fov;
    }

    public void setToggleKey(int toggleKey) {
        this.toggleKey = toggleKey;
    }

    public void setFov(float fov) {
        this.fov = fov;
    }
}
