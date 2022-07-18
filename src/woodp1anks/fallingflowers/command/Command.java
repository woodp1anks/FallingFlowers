package woodp1anks.fallingflowers.command;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.fallingflowers.FallingFlowers;

public abstract class Command {
    private final String name;
    private final String[] aliases;
    private final String[] argsName;
    private final String description;

    public Command(String name, String[] aliases, String[] argsName, String description) {
        this.name = name;
        this.aliases = aliases;
        this.argsName = argsName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String[] getArgsName() {
        return argsName;
    }

    public void baseRun(String[] args) {
        if (argsName.length == args.length) {
            run(args);
        } else {
            StringBuilder stringBuilder = new StringBuilder("§c§l" + FallingFlowers.NAME + "§7 ||§c check your command! §a§l~" + name);
            for (String s : argsName) {
                stringBuilder.append(" §a§l").append(s);
            }
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(stringBuilder.toString()));
        }
    }

    public abstract void run(String[] args);

    public String getName() {
        return name;
    }

    public String[] getAliases() {
        return aliases;
    }
}
