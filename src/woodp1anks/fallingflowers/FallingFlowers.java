package woodp1anks.fallingflowers;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import woodp1anks.fallingflowers.command.CommandManager;
import woodp1anks.fallingflowers.config.ConfigManager;
import woodp1anks.fallingflowers.mod.ModManager;

import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FallingFlowers {
    public static final String NAME = "FallingFlowers";
    public static final String VERSION = "b1";
    public static final String AUTHOR = "woodp1anks";

    public static ModManager modManager;
    public static ConfigManager configManager;
    public static CommandManager commandManager;

    public static void start() {
        modManager = new ModManager();
        configManager = new ConfigManager();
        commandManager = new CommandManager();

        modManager.load();
        configManager.load();
        commandManager.load();

        if (!Paths.get(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(),FallingFlowers.NAME).toFile().exists()) {
            configManager.save();
            configManager.load();
        }

        Display.setTitle(NAME + " " + VERSION + " - " + AUTHOR);
    }

    public static void stop() {
        configManager.save();
    }
}
