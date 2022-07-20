package woodp1anks.fallingflowers.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.Command;
import woodp1anks.fallingflowers.mod.Mod;

import java.security.Key;
import java.util.Locale;

public class BindCommand extends Command {
    public BindCommand() {
        super("bind", new String[]{"bind","b"}, new String[]{"mod","key"}, "bind a module to a key.");
    }

    @Override
    public void run(String[] args) {
        Mod mod = FallingFlowers.modManager.getMod(args[0]);
        if (mod != null) {
            int key = Keyboard.getKeyIndex(args[1].toUpperCase(Locale.ROOT));
            if (key != 0) {
                mod.setKey(key);
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §b" + mod.getName() + "§a was bind to key §b" + args[1]));
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis key isn't exist!"));
            }
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis mod isn't exist!"));
        }
    }
}
