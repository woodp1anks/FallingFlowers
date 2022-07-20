package woodp1anks.fallingflowers.config.configs.render;

import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.mods.render.ZoomMod;

public class ZoomConfig extends Config {
    public ZoomConfig() {
        super("Zoom");
    }

    @Override
    public void syncStart() {
        ZoomMod zoomMod = (ZoomMod) FallingFlowers.modManager.getMod("Zoom");
        zoomMod.setFov(Float.parseFloat(get("fov")));
    }

    @Override
    public void syncStop() {
        ZoomMod zoomMod = (ZoomMod) FallingFlowers.modManager.getMod("Zoom");
        set("fov", String.valueOf(zoomMod.getFov()));
    }

    @Override
    public void syncDefault() {
        ZoomMod zoomMod = (ZoomMod) FallingFlowers.modManager.getMod("Zoom");
        zoomMod.setFov(30);
    }
}
