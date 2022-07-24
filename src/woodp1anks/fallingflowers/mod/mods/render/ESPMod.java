package woodp1anks.fallingflowers.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

public class ESPMod extends Mod {
    private boolean playerDisplay;
    private boolean mobDisplay;
    private boolean animalDisplay;

    public ESPMod() {
        super("ESP", "ESP", "let you see players trough walls", Category.Render);
    }

    @Override
    public void onRender3D() {
        //GL11.glBlendFunc(770,771);
        //GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(3.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        //GL11.glDepthMask(false);

        double renderPosX = Minecraft.getMinecraft().getRenderManager().renderPosX;
        double renderPosY = Minecraft.getMinecraft().getRenderManager().renderPosY;
        double renderPosZ = Minecraft.getMinecraft().getRenderManager().renderPosZ;

        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            boolean canESP = false;

            if (animalDisplay && entity instanceof EntityAnimal) {
                canESP = true;
            }

            if (mobDisplay && entity instanceof EntityMob) {
                canESP = true;
            }

            if (playerDisplay && entity instanceof EntityPlayer) {
                canESP = true;
            }

            if (canESP) {

                GL11.glColor4d(
                        0.8999,
                        0.5,
                        0,0.5F
                );

                if (entity != Minecraft.getMinecraft().thePlayer) {
                    AxisAlignedBB entityBoundingBox = entity.getEntityBoundingBox();
                    RenderGlobal.func_181561_a(new AxisAlignedBB(
                            entityBoundingBox.minX - renderPosX,
                            entityBoundingBox.minY - renderPosY,
                            entityBoundingBox.minZ - renderPosZ,
                            entityBoundingBox.maxX - renderPosX,
                            entityBoundingBox.maxY - renderPosY,
                            entityBoundingBox.maxZ - renderPosZ
                    ));
                }
            }

        }

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        //GL11.glDepthMask(true);
        //GL11.glDisable(GL11.GL_BLEND);
    }

    public boolean isAnimalDisplay() {
        return animalDisplay;
    }

    public boolean isMobDisplay() {
        return mobDisplay;
    }

    public boolean isPlayerDisplay() {
        return playerDisplay;
    }

    public void setAnimalDisplay(boolean animalDisplay) {
        this.animalDisplay = animalDisplay;
    }

    public void setMobDisplay(boolean mobDisplay) {
        this.mobDisplay = mobDisplay;
    }

    public void setPlayerDisplay(boolean playerDisplay) {
        this.playerDisplay = playerDisplay;
    }
}


