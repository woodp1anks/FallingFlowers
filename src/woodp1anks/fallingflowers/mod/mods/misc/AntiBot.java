package woodp1anks.fallingflowers.mod.mods.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;
import woodp1anks.fallingflowers.utils.TargetUtil;

import java.util.ArrayList;
import java.util.List;

public class AntiBot extends Mod {
    private final List<Integer> players = new ArrayList<>();

    public AntiBot() {
        super("AntiBot", null, "let target cant be bot", Category.Misc);
    }

    @Override
    public void onUpdate() {
        if (Minecraft.getMinecraft().ingameGUI.getChatGUI().getSentMessages().size() > 0) {
            if (Minecraft.getMinecraft().ingameGUI.getChatGUI().getSentMessages().get(Minecraft.getMinecraft().ingameGUI.getChatGUI().getSentMessages().size() - 1).equalsIgnoreCase("a")) {
                System.out.println("asd");
                for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
                    if (entity instanceof EntityPlayerSP) {
                        players.add(((EntityPlayerSP) entity).getEntityId());
                    }
                }
            }
        }
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
                if (livingBase != Minecraft.getMinecraft().thePlayer && !livingBase.isDead && livingBase.getHealth() > 0 &&
                        livingBase.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) < 3) {
                    boolean isTarget = false;
                    if (TargetUtil.isPlayerCanBeTarget()) {
                        if (livingBase instanceof EntityPlayerSP) {
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
                        double targetDistance = TargetUtil.getTarget().getDistanceToEntity(Minecraft.getMinecraft().thePlayer);
                        if (TargetUtil.getTarget() == null) {
                            if (players.contains(livingBase.getEntityId())) {
                                TargetUtil.setTarget(livingBase,5);
                            }
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
