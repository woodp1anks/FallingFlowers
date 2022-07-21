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
    private static boolean animalCanBeTarget = true;
    private static boolean modCanBeTarget;

    public static void update() {
        if (target != null) {
            EntityLivingBase livingBase = target;
            if (livingBase.isDead || livingBase.getHealth() <= 0 ||
                    livingBase.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) > 3) {
                target = null;
            }
        }
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
                            if (target == null) {
                                target = livingBase;
                            }
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

    public static EntityLivingBase getTarget() {
        return target;
    }

    public static void setTarget(EntityLivingBase target,int keepTargetLength) {
        TargetUtil.target = target;
        TargetUtil.keepTargetLength = keepTargetLength;
        TargetUtil.ticks = 0;
    }

    public static boolean isAnimalCanBeTarget() {
        return animalCanBeTarget;
    }

    public static boolean isModCanBeTarget() {
        return modCanBeTarget;
    }

    public static boolean isPlayerCanBeTarget() {
        return playerCanBeTarget;
    }

    public static void setAnimalCanBeTarget(boolean animalCanBeTarget) {
        TargetUtil.animalCanBeTarget = animalCanBeTarget;
    }

    public static void setModCanBeTarget(boolean modCanBeTarget) {
        TargetUtil.modCanBeTarget = modCanBeTarget;
    }

    public static void setPlayerCanBeTarget(boolean playerCanBeTarget) {
        TargetUtil.playerCanBeTarget = playerCanBeTarget;
    }
}
