package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;
import woodp1anks.fallingflowers.utils.TargetUtil;

public class TargetCommand extends Command {
    public TargetCommand() {
        super("target", new String[]{"target","t"}, new String[]{"entityType(player/mob/animal)"}, "set entity type that can be a target.");
    }

    @Override
    public void run(String[] args) {
        if (args[0].equalsIgnoreCase("player")) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §eNow §b" + args[0] + "§e can" + (!TargetUtil.isPlayerCanBeTarget() ? "§a be §e" : "§c not be§e ") + "a target!"));
            TargetUtil.setPlayerCanBeTarget(!TargetUtil.isPlayerCanBeTarget());
        } else if (args[0].equalsIgnoreCase("mob")) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §eNow §b" + args[0] + "§e can" + (!TargetUtil.isModCanBeTarget() ? "§a be §e" : "§c not be §e ") + "a target!"));
            TargetUtil.setModCanBeTarget(!TargetUtil.isModCanBeTarget());
        } else if (args[0].equalsIgnoreCase("animal")) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §eNow §b" + args[0] + "§e can" + (!TargetUtil.isAnimalCanBeTarget() ? "§a be §e" : "§c not be §e") + "a target!"));
            TargetUtil.setAnimalCanBeTarget(!TargetUtil.isAnimalCanBeTarget());
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7||§c this target type is not exist!"));
        }
    }
}
