package woodp1anks.fallingflowers.mod.mods.world;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import woodp1anks.fallingflowers.mod.Category;
import woodp1anks.fallingflowers.mod.Mod;

public class BridgeAssistMod extends Mod {
    public BridgeAssistMod() {
        super("BridgeAssist", null, "let you bridge automatically", Category.World);
    }

    @Override
    public void onRender3D() {
        EnumFacing facing = Minecraft.getMinecraft().objectMouseOver.sideHit;
        if (facing == EnumFacing.NORTH || facing == EnumFacing.EAST || facing == EnumFacing.SOUTH || facing == EnumFacing.WEST) {
            Minecraft.getMinecraft().rightClickMouse();
        }
    }

    @Override
    public void onRender2D() {
        EnumFacing facing = Minecraft.getMinecraft().objectMouseOver.sideHit;
        if (facing == EnumFacing.NORTH || facing == EnumFacing.EAST || facing == EnumFacing.SOUTH || facing == EnumFacing.WEST) {
            Minecraft.getMinecraft().rightClickMouse();
        }
    }

    @Override
    public void onUpdate() {
        EnumFacing facing = Minecraft.getMinecraft().objectMouseOver.sideHit;
        if (facing == EnumFacing.NORTH || facing == EnumFacing.EAST || facing == EnumFacing.SOUTH || facing == EnumFacing.WEST) {
            Minecraft.getMinecraft().rightClickMouse();
        }
    }
}

