package woodp1anks.fallingflowers.command;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.fallingflowers.FallingFlowers;
import woodp1anks.fallingflowers.command.commands.HelpCommand;
import woodp1anks.fallingflowers.command.commands.ToggleCommand;

import java.util.*;

public class CommandManager {
    private final List<Command> commandList = new ArrayList<>();

    public void load() {
        commandList.add(new HelpCommand());
        commandList.add(new ToggleCommand());
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public boolean update(String message) {
        if (message.charAt(0) == '~') {
            String substring = message.substring(1);
            String[] s = substring.split(" ");
            String name = s[0];
            Command command = getCommand(name);

            if (command != null) {
                List<String> args = new ArrayList<>();
                Collections.addAll(args,s);
                args.remove(0);
                command.baseRun(args.toArray(new String[0]));
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§c§l" + FallingFlowers.NAME + " §7|| §cThis command is not exist!"));
            }

            return true;
        }

        return false;
    }

    public Command getCommand(String name) {
        for (Command command : commandList) {
            if (command.getName().equalsIgnoreCase(name)) {
                return command;
            }
            for (String alias : command.getAliases()) {
                if (alias.equalsIgnoreCase(name)) {
                    return command;
                }
            }
        }
        return null;
    }
}
