package woodp1anks.fallingflowers.config.configs.render;

import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.mods.render.TabGuiMod;

import java.awt.*;

public class TabGuiConfig extends Config {
    public TabGuiConfig() {
        super("TabGui");
    }

    @Override
    public void syncStart() {
        TabGuiMod tabGuiMod = (TabGuiMod) FallingFlowers.modManager.getMod("TabGui");
        tabGuiMod.setBgA(Integer.parseInt(get("bga")));
        tabGuiMod.setBgB(Integer.parseInt(get("bgb")));
        tabGuiMod.setBgG(Integer.parseInt(get("bgg")));
        tabGuiMod.setBgR(Integer.parseInt(get("bgr")));
        tabGuiMod.setCateTxtA(Integer.parseInt(get("catetxta")));
        tabGuiMod.setCateTxtB(Integer.parseInt(get("catetxtb")));
        tabGuiMod.setCateTxtG(Integer.parseInt(get("catetxtg")));
        tabGuiMod.setCateTxtR(Integer.parseInt(get("catetxtr")));
        tabGuiMod.setdTxtA(Integer.parseInt(get("dtxta")));
        tabGuiMod.setdTxtB(Integer.parseInt(get("dtxtb")));
        tabGuiMod.setdTxtG(Integer.parseInt(get("dtxtg")));
        tabGuiMod.setdTxtR(Integer.parseInt(get("dtxtr")));
        tabGuiMod.seteTxtA(Integer.parseInt(get("etxta")));
        tabGuiMod.seteTxtB(Integer.parseInt(get("etxtb")));
        tabGuiMod.seteTxtG(Integer.parseInt(get("etxtg")));
        tabGuiMod.seteTxtR(Integer.parseInt(get("etxtr")));
        tabGuiMod.setSelBgA(Integer.parseInt(get("selbga")));
        tabGuiMod.setSelBgB(Integer.parseInt(get("selbgb")));
        tabGuiMod.setSelBgG(Integer.parseInt(get("selbgg")));
        tabGuiMod.setSelBgR(Integer.parseInt(get("selbgr")));
        tabGuiMod.setExpend(Integer.parseInt(get("expend")));
    }

    @Override
    public void syncStop() {
        TabGuiMod tabGuiMod = (TabGuiMod) FallingFlowers.modManager.getMod("TabGui");
        set("bga", String.valueOf(tabGuiMod.getBgA()));
        set("bgb", String.valueOf(tabGuiMod.getBgB()));
        set("bgr", String.valueOf(tabGuiMod.getBgR()));
        set("bgg", String.valueOf(tabGuiMod.getBgG()));
        set("selbgr", String.valueOf(tabGuiMod.getSelBgR()));
        set("selbgg", String.valueOf(tabGuiMod.getSelBgG()));
        set("selbgb", String.valueOf(tabGuiMod.getSelBgB()));
        set("selbga", String.valueOf(tabGuiMod.getSelBgA()));
        set("catetxtr", String.valueOf(tabGuiMod.getCateTxtR()));
        set("catetxtg", String.valueOf(tabGuiMod.getCateTxtG()));
        set("catetxtb", String.valueOf(tabGuiMod.getCateTxtB()));
        set("catetxta", String.valueOf(tabGuiMod.getCateTxtA()));
        set("dtxtr", String.valueOf(tabGuiMod.getdTxtR()));
        set("dtxtg", String.valueOf(tabGuiMod.getdTxtG()));
        set("dtxtb", String.valueOf(tabGuiMod.getdTxtB()));
        set("dtxta", String.valueOf(tabGuiMod.getdTxtA()));
        set("etxtr", String.valueOf(tabGuiMod.geteTxtR()));
        set("etxtg", String.valueOf(tabGuiMod.geteTxtG()));
        set("etxtb", String.valueOf(tabGuiMod.geteTxtB()));
        set("etxta", String.valueOf(tabGuiMod.geteTxtA()));
        set("expend", String.valueOf(tabGuiMod.getExpend()));
    }

    @Override
    public void syncDefault() {
        TabGuiMod tabGuiMod = (TabGuiMod) FallingFlowers.modManager.getMod("TabGui");
        tabGuiMod.setExpend(5);
        tabGuiMod.setSelBgR(Color.pink.getRed());
        tabGuiMod.setSelBgG(Color.pink.getGreen());
        tabGuiMod.setSelBgB(Color.pink.getBlue());
        tabGuiMod.setSelBgA(170);
        tabGuiMod.setBgR(150);
        tabGuiMod.setBgG(150);
        tabGuiMod.setBgB(150);
        tabGuiMod.setBgA(100);
        tabGuiMod.setCateTxtR(0);
        tabGuiMod.setCateTxtG(255);
        tabGuiMod.setCateTxtB(255);
        tabGuiMod.setCateTxtA(255);
        tabGuiMod.seteTxtR(140);
        tabGuiMod.seteTxtG(255);
        tabGuiMod.seteTxtB(140);
        tabGuiMod.seteTxtA(255);
        tabGuiMod.setdTxtR(255);
        tabGuiMod.setdTxtG(80);
        tabGuiMod.setdTxtB(80);
        tabGuiMod.setdTxtA(255);
    }
}
