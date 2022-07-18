package woodp1anks.fallingflowers.config.configs.render;

import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.mods.render.ArrayListMod;

import java.awt.*;
import java.util.Collections;

public class ArrayListConfig extends Config {
    public ArrayListConfig() {
        super("ArrayList");
    }

    @Override
    public void syncStart() {
        ArrayListMod arrayListMod = (ArrayListMod) FallingFlowers.modManager.getMod("ArrayList");
        arrayListMod.setR(Integer.parseInt(get("r")));
        arrayListMod.setG(Integer.parseInt(get("g")));
        arrayListMod.setB(Integer.parseInt(get("b")));
        arrayListMod.setA(Integer.parseInt(get("a")));
    }

    @Override
    public void syncStop() {
        ArrayListMod arrayListMod = (ArrayListMod) FallingFlowers.modManager.getMod("ArrayList");
        set("r", String.valueOf(arrayListMod.getR()));
        set("g", String.valueOf(arrayListMod.getG()));
        set("b", String.valueOf(arrayListMod.getG()));
        set("a", String.valueOf(arrayListMod.getA()));
    }

    @Override
    public void syncDefault() {
        ArrayListMod arrayListMod = (ArrayListMod) FallingFlowers.modManager.getMod("ArrayList");
        arrayListMod.setR(Color.pink.getRed());
        arrayListMod.setG(Color.pink.getGreen());
        arrayListMod.setB(Color.pink.getBlue());
        arrayListMod.setA(Color.pink.getAlpha());
    }
}
