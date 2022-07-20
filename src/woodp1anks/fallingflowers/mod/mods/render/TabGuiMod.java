package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

import java.awt.*;
import java.util.List;

public class TabGuiMod extends Mod {
    private int bgR;
    private int bgG = 255;
    private int bgB;
    private int bgA = 255;
    private int selBgR;
    private int selBgG;
    private int selBgB = 255;
    private int selBgA = 255;
    private int cateTxtR;
    private int cateTxtG;
    private int cateTxtB = 255;
    private int cateTxtA = 255;
    private int eTxtR;
    private int eTxtG = 255;
    private int eTxtB;
    private int eTxtA = 255;
    private int dTxtR;
    private int dTxtG;
    private int dTxtB;
    private int dTxtA = 255;
    private int expend;

    private int currentCategory;
    private int currentMod;
    private boolean isInModList;

    public TabGuiMod() {
        super("TabGui", "TabGui", "gui that can let toggle a module", Category.Render);
    }

    @Override
    public void onKeyPressed(int key) {
        if (key == Keyboard.KEY_UP && !isInModList) {
            if (currentCategory > 0) {
                currentCategory--;
            }
        }
        if (key == Keyboard.KEY_UP && isInModList) {
            if (currentMod > 0) {
                currentMod--;
            }
        }
        if (key == Keyboard.KEY_DOWN && !isInModList) {
            if (currentCategory < Category.values().length - 1) {
                currentCategory++;
            }
        }
        if (key == Keyboard.KEY_DOWN && isInModList) {
            if (currentMod < FallingFlowers.modManager.getMods(Category.values()[currentCategory]).size() - 1) {
                currentMod++;
            }
        }
        if (key == Keyboard.KEY_RETURN || key == Keyboard.KEY_RIGHT) {
            if (isInModList) {
                Mod mod = FallingFlowers.modManager.getMods(Category.values()[currentCategory]).get(currentMod);
                mod.setEnabled(!mod.isEnabled());
            }
            isInModList = true;
        }
        if (key == Keyboard.KEY_LEFT) {
            isInModList = false;
            currentMod = 0;
        }
    }

    @Override
    public void onRender2D() {
        drawTabGui(8,32);
    }

    public void drawTabGui(int x,int y) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        String maxCategory = "";
        for (Category value : Category.values()) {
            if (font.getStringWidth(value.name()) > font.getStringWidth(maxCategory)) {
                maxCategory = value.name();
            }
        }
        Gui.drawRect(x,y,x + font.getStringWidth(maxCategory) + expend,y + font.FONT_HEIGHT * Category.values().length,new Color(bgR,bgG,bgB,bgA).getRGB());
        int cateY = y;
        int i = 0;
        for (Category value : Category.values()) {
            if (i == currentCategory) {
                Gui.drawRect(x,cateY,x + font.getStringWidth(maxCategory) + expend,cateY + font.FONT_HEIGHT,new Color(selBgR,selBgG,selBgB,selBgA).getRGB());
                if (isInModList) {
                    String maxMod = "";
                    List<Mod> mods = FallingFlowers.modManager.getMods(Category.values()[currentCategory]);
                    for (Mod mod : mods) {
                        if (font.getStringWidth(mod.getName()) > font.getStringWidth(maxMod)) {
                            maxMod = mod.getName();
                        }
                    }
                    Gui.drawRect(x + font.getStringWidth(maxCategory) + expend + 3,cateY,x + font.getStringWidth(maxCategory) + expend + 3 + font.getStringWidth(maxMod) + expend,cateY + font.FONT_HEIGHT * mods.size(),new Color(bgR,bgG,bgB,bgA).getRGB());
                    int modY = cateY;
                    int j = 0;
                    for (Mod mod : mods) {
                        if (j == currentMod) {
                            Gui.drawRect(x + font.getStringWidth(maxCategory) + expend + 3,modY,x + font.getStringWidth(maxCategory) + expend + 3 + font.getStringWidth(maxMod) + expend,modY + font.FONT_HEIGHT,new Color(selBgR,selBgG,selBgB,selBgA).getRGB());
                        }
                        font.drawStringWithShadow(mod.getName(),x + font.getStringWidth(maxCategory) + expend + 3,modY,mod.isEnabled() ? new Color(eTxtR,eTxtG,eTxtB,eTxtA).getRGB() : new Color(dTxtR,dTxtG,dTxtB,dTxtA).getRGB());
                        j++;
                        modY += font.FONT_HEIGHT;
                    }
                }
            }
            font.drawStringWithShadow(value.name(),x,cateY,new Color(cateTxtR,cateTxtG,cateTxtB,cateTxtA).getRGB());
            cateY += font.FONT_HEIGHT;
            i++;
        }
    }

    public int getExpend() {
        return expend;
    }

    public void setExpend(int expend) {
        this.expend = expend;
    }

    public int getBgA() {
        return bgA;
    }

    public int getBgB() {
        return bgB;
    }

    public int getBgG() {
        return bgG;
    }

    public int getBgR() {
        return bgR;
    }

    public int getCateTxtA() {
        return cateTxtA;
    }

    public int getCateTxtB() {
        return cateTxtB;
    }

    public int getCateTxtG() {
        return cateTxtG;
    }

    public int getCateTxtR() {
        return cateTxtR;
    }

    public int getdTxtA() {
        return dTxtA;
    }

    public int getdTxtB() {
        return dTxtB;
    }

    public int getdTxtG() {
        return dTxtG;
    }

    public int getdTxtR() {
        return dTxtR;
    }

    public int geteTxtA() {
        return eTxtA;
    }

    public int geteTxtB() {
        return eTxtB;
    }

    public int geteTxtG() {
        return eTxtG;
    }

    public int geteTxtR() {
        return eTxtR;
    }

    public int getSelBgA() {
        return selBgA;
    }

    public int getSelBgB() {
        return selBgB;
    }

    public int getSelBgG() {
        return selBgG;
    }

    public int getSelBgR() {
        return selBgR;
    }

    public void setBgA(int bgA) {
        this.bgA = bgA;
    }

    public void setBgB(int bgB) {
        this.bgB = bgB;
    }

    public void setBgG(int bgG) {
        this.bgG = bgG;
    }

    public void setBgR(int bgR) {
        this.bgR = bgR;
    }

    public void setCateTxtA(int cateTxtA) {
        this.cateTxtA = cateTxtA;
    }

    public void setCateTxtB(int cateTxtB) {
        this.cateTxtB = cateTxtB;
    }

    public void setCateTxtG(int cateTxtG) {
        this.cateTxtG = cateTxtG;
    }

    public void setCateTxtR(int cateTxtR) {
        this.cateTxtR = cateTxtR;
    }

    public void setdTxtA(int dTxtA) {
        this.dTxtA = dTxtA;
    }

    public void setdTxtB(int dTxtB) {
        this.dTxtB = dTxtB;
    }

    public void setdTxtG(int dTxtG) {
        this.dTxtG = dTxtG;
    }

    public void setdTxtR(int dTxtR) {
        this.dTxtR = dTxtR;
    }

    public void seteTxtA(int eTxtA) {
        this.eTxtA = eTxtA;
    }

    public void seteTxtB(int eTxtB) {
        this.eTxtB = eTxtB;
    }

    public void seteTxtG(int eTxtG) {
        this.eTxtG = eTxtG;
    }

    public void seteTxtR(int eTxtR) {
        this.eTxtR = eTxtR;
    }

    public void setSelBgA(int selBgA) {
        this.selBgA = selBgA;
    }

    public void setSelBgB(int selBgB) {
        this.selBgB = selBgB;
    }

    public void setSelBgG(int selBgG) {
        this.selBgG = selBgG;
    }

    public void setSelBgR(int selBgR) {
        this.selBgR = selBgR;
    }
}
