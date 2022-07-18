package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;
import woodp1anks.fallingflowers.mod.Mod;

public class ToggleCommand extends Command {
    public ToggleCommand() {
        super("toggle", new String[]{"toggle","t"},new String[]{"modName"}, "toggle a module's on/off");
    }

    @Override
    public void run(String[] args) {
        Mod mod = FallingFlowers.modManager.getMod(args[0]);
        if (mod != null) {
            mod.setEnabled(!mod.isEnabled());
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7||§a This mod has been toggled!"));
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis mod is not exist!"));
        }
    }
}
