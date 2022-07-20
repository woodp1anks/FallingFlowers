package woodp1anks.fallingflowers.config.configs.render;

import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.mods.render.BoxDisplayMod;

import java.awt.*;

public class BoxDisplayConfig extends Config {
    public BoxDisplayConfig() {
        super("BoxDisplay");
    }

    @Override
    public void syncStart() {
        BoxDisplayMod boxDisplayMod = (BoxDisplayMod) FallingFlowers.modManager.getMod("BoxDisplay");
        boxDisplayMod.setR(Integer.parseInt(get("r")));
        boxDisplayMod.setG(Integer.parseInt(get("g")));
        boxDisplayMod.setB(Integer.parseInt(get("b")));
        boxDisplayMod.setA(Integer.parseInt(get("a")));
    }

    @Override
    public void syncStop() {
        BoxDisplayMod boxDisplayMod = (BoxDisplayMod) FallingFlowers.modManager.getMod("BoxDisplay");
        set("r", String.valueOf(boxDisplayMod.getR()));
        set("g", String.valueOf(boxDisplayMod.getG()));
        set("b", String.valueOf(boxDisplayMod.getB()));
        set("a", String.valueOf(boxDisplayMod.getA()));
    }

    @Override
    public void syncDefault() {
        BoxDisplayMod boxDisplayMod = (BoxDisplayMod) FallingFlowers.modManager.getMod("BoxDisplay");
        boxDisplayMod.setR(Color.pink.getRed());
        boxDisplayMod.setG(Color.pink.getGreen());
        boxDisplayMod.setB(Color.pink.getBlue());
        boxDisplayMod.setA(Color.pink.getAlpha());
    }
}
