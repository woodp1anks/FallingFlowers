package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

import java.awt.*;

public class BoxDisplayMod extends Mod {
    private int r;
    private int g;
    private int b;
    private int a;

    public BoxDisplayMod() {
        super("BoxDisplay", "BoxDisplay", "display all hit boxes.", Category.Render);
    }

    @Override
    public void onRender3D() {
        double renderPosX = Minecraft.getMinecraft().getRenderManager().renderPosX;
        double renderPosY = Minecraft.getMinecraft().getRenderManager().renderPosY;
        double renderPosZ = Minecraft.getMinecraft().getRenderManager().renderPosZ;

        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity != Minecraft.getMinecraft().thePlayer) {
                AxisAlignedBB entityBoundingBox = entity.getEntityBoundingBox();
                RenderGlobal.func_181563_a(new AxisAlignedBB(
                        entityBoundingBox.minX - renderPosX,
                        entityBoundingBox.minY - renderPosY,
                        entityBoundingBox.minZ - renderPosZ,
                        entityBoundingBox.maxX - renderPosX,
                        entityBoundingBox.maxY - renderPosY,
                        entityBoundingBox.maxZ - renderPosZ
                ), r,g,b,a);
            }
        }
    }

    public int getA() {
        return a;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }
}
