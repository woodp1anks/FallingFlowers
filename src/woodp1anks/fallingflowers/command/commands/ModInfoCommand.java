package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;
import woodp1anks.fallingflowers.mod.Mod;

import java.util.Map;

public class ModInfoCommand extends Command {
    public ModInfoCommand() {
        super("modInfo", new String[]{"modInfo","mi"}, new String[]{"mod"}, "display a mod's info.");
    }

    @Override
    public void run(String[] args) {
        Mod mod = FallingFlowers.modManager.getMod(args[0]);
        if (mod != null) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7>======================"));
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText((mod.isEnabled() ? "§a" : "§c") + mod.getName() + " §e" + Keyboard.getKeyName(mod.getKey()) + " §7" + mod.getDescription()));
            try {
                for (Map.Entry<String, String> entry : mod.getConfig().getMap().entrySet()) {
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§3" + entry.getKey() + " §b" + entry.getValue()));
                }
            } catch (NullPointerException ex) {}
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7======================================"));
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis mod is not exist!"));
        }
    }
}
