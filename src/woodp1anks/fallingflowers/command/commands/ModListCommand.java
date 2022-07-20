package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;
import woodp1anks.fallingflowers.mod.Mod;

import java.security.Key;

public class ModListCommand extends Command {
    public ModListCommand() {
        super("modList", new String[]{"modList","ml","m"}, new String[0], "list all mods and its info.");
    }

    @Override
    public void run(String[] args) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7>===================="));
        for (Mod mod : FallingFlowers.modManager.getMods()) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText((mod.isEnabled() ? "§a": "§c") + mod.getName() + " §e" + Keyboard.getKeyName(mod.getKey()) + " §7" + mod.getDescription()));
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7===================================="));
    }
}
