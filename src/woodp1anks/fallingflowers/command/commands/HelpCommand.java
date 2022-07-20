package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;

import java.util.Arrays;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", new String[]{"help","h"}, new String[]{}, "display all commands.");
    }

    @Override
    public void run(String[] args) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7>==========================="));
        for (Command command : FallingFlowers.commandManager.getCommandList()) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§e" + command.getName() + " §a" + Arrays.toString(command.getAliases()) + " §b" + Arrays.toString(command.getArgsName()) + " §7" + command.getDescription()));
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7==========================================="));
    }
}
