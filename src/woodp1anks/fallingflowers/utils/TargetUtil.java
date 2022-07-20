package woodp1anks.fallingflowers.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;

public class TargetUtil {
    private static EntityLivingBase target;

    private static int keepTargetLength;
    private static int ticks;

    private static boolean playerCanBeTarget;
    private static boolean animalCanBeTarget;
    private static boolean modCanBeTarget;

    public static void update() {
        if (ticks > keepTargetLength) {
            for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase livingBase = (EntityLivingBase) entity;
                    if (livingBase != Minecraft.getMinecraft().thePlayer && !livingBase.isDead && livingBase.getHealth() > 0 &&
                    livingBase.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) < 3) {
                        boolean isTarget = false;
                        if (TargetUtil.playerCanBeTarget) {
                            if (livingBase instanceof EntityPlayerSP) {
                                isTarget = true;
                            }
                        }

                        if (TargetUtil.animalCanBeTarget) {
                            if (livingBase instanceof EntityAnimal) {
                                isTarget = true;
                            }
                        }

                        if (TargetUtil.modCanBeTarget) {
                            if (livingBase instanceof EntityMob) {
                                isTarget = true;
                            }
                        }

                        if (isTarget) {
                            if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity(livingBase) < Minecraft.getMinecraft().thePlayer.getDistanceToEntity(TargetUtil.target)) {
                                TargetUtil.target = livingBase;
                            }
                        }
                    }
                }
            }
        }
        ticks++;
    }

    public EntityLivingBase getTarget() {
        return target;
    }

    public void setTarget(EntityLivingBase target,int keepTargetLength) {
        this.target = target;
        TargetUtil.keepTargetLength = keepTargetLength;
        TargetUtil.ticks = 0;
    }

    public boolean isAnimalCanBeTarget() {
        return animalCanBeTarget;
    }

    public boolean isModCanBeTarget() {
        return modCanBeTarget;
    }

    public boolean isPlayerCanBeTarget() {
        return playerCanBeTarget;
    }

    public void setAnimalCanBeTarget(boolean animalCanBeTarget) {
        this.animalCanBeTarget = animalCanBeTarget;
    }

    public static void setKeepTargetLength(int keepTargetLength) {
        TargetUtil.keepTargetLength = keepTargetLength;
    }

    public void setModCanBeTarget(boolean modCanBeTarget) {
        this.modCanBeTarget = modCanBeTarget;
    }
}
