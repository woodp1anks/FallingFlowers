package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;
import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.mod.Mod;

public class SetCommand extends Command {
    public SetCommand() {
        super("set", new String[]{"set","s"}, new String[]{"modName","argName","arg"}, "change a module's settings.");
    }

    @Override
    public void run(String[] args) {
        Mod mod = FallingFlowers.modManager.getMod(args[0]);
        if (mod != null) {
            Config config = mod.getConfig();
            if (config != null) {
                if (config.get(args[1]) != null) {
                    config.set(args[1],args[2]);
                    config.syncStart();
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §b" + args[1] + "§a was been set to §b" + args[2]));
                } else {
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis key didn't exist!"));
                }
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cYou didn't need set anything about this mod."));
            }
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis mod is not exist!"));
        }
    }
}
