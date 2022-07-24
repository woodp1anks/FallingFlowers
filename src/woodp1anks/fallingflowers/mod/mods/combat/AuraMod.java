package woodp1anks.fallingflowers.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;
import woodp1anks.fallingflowers.utils.RotationUtil;
import woodp1anks.fallingflowers.utils.TargetUtil;

import java.util.Random;

public class AuraMod extends Mod {
    private int minCps = 5;
    private int maxCps = 8;
    private int speed = 1;

    private int ticks;
    private int rotatedTimes;

    public AuraMod() {
        super("Aura", "Aura", "Automatically attack every target in the aura", Category.Combat);
    }

    @Override
    public void onRender3D() {
        EntityLivingBase livingBase = TargetUtil.getTarget();
        EntityPlayerSP playerSP = Minecraft.getMinecraft().thePlayer;
        if (livingBase != null) {
            float targetYaw = RotationUtil.getRotationsYaw(livingBase.posX, livingBase.posZ);
            float targetPitch = RotationUtil.getRotationsPitch(livingBase.posX,livingBase.posY,livingBase.posZ);
            playerSP.rotationYaw = targetYaw;
            playerSP.rotationPitch = targetPitch;
        }
    }

    @Override
    public void onUpdate() {
        if (TargetUtil.getTarget() != null) {
            int cps = minCps + new Random().nextInt(maxCps - minCps);
            int hitTicks = 20 / cps;

            if (ticks >= hitTicks) {
                Minecraft.getMinecraft().thePlayer.swingItem();
                Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, TargetUtil.getTarget());
                ticks = 0;
            }
        }
        ticks++;
    }

    public int getMaxCps() {
        return maxCps;
    }

    public int getMinCps() {
        return minCps;
    }

    public int getSpeed() {
        return speed;
    }

    public void setMaxCps(int maxCps) {
        this.maxCps = maxCps;
    }

    public void setMinCps(int minCps) {
        this.minCps = minCps;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
