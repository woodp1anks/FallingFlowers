package woodp1anks.fallingflowers.mod.mods.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;
import woodp1anks.fallingflowers.utils.TargetUtil;

import java.util.ArrayList;
import java.util.List;

public class AntiBot extends Mod {
    private final List<Integer> players = new ArrayList<>();

    private World world;

    public AntiBot() {
        super("AntiBot", null, "let target cant be bot", Category.Misc);
    }

    @Override
    public void onUpdate() {
        if (world == null) {
            world = Minecraft.getMinecraft().theWorld;
        }

        if (world != Minecraft.getMinecraft().theWorld) {
            System.out.println("asd");
            for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
                if (entity instanceof EntityPlayer) {
                    players.add(entity.getEntityId());
                }
            }
            world = Minecraft.getMinecraft().theWorld;
        }

        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
                if (livingBase != Minecraft.getMinecraft().thePlayer && !livingBase.isDead && livingBase.getHealth() > 0 &&
                        livingBase.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) < 3) {
                    boolean isTarget = false;
                    if (TargetUtil.isPlayerCanBeTarget()) {
                        if (livingBase instanceof EntityPlayer) {

                            isTarget = true;
                        }
                    }

                    if (TargetUtil.isAnimalCanBeTarget()) {
                        if (livingBase instanceof EntityAnimal) {
                            isTarget = true;
                        }
                    }

                    if (TargetUtil.isModCanBeTarget()) {
                        if (livingBase instanceof EntityMob) {
                            isTarget = true;
                        }
                    }

                    if (isTarget) {
                        if (TargetUtil.getTarget() == null) {
                            if (players.contains(livingBase.getEntityId())) {
                                TargetUtil.setTarget(livingBase,5);
                            }
                        }
                        double targetDistance;
                        if (TargetUtil.getTarget() == null) {
                            targetDistance = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(livingBase);
                        } else {
                            targetDistance = TargetUtil.getTarget().getDistanceToEntity(Minecraft.getMinecraft().thePlayer);
                        }
                        if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity(livingBase) < targetDistance && TargetUtil.getTarget() != null) {
                            if (players.contains(livingBase.getEntityId())) {
                                TargetUtil.setTarget(livingBase,5);
                            }
                        }
                    }
                }
            }
        }
    }
}
