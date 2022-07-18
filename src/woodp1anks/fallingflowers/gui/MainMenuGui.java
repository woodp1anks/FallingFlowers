package woodp1anks.fallingflowers.gui;

import net.minecraft.client.gui.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import woodp1anks.fallingflowers.FallingFlowers;

import java.awt.*;
import java.io.IOException;

public class MainMenuGui extends GuiScreen {
    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 48 + 72 + 12, 98, 20, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, this.height / 4 + 48 + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 48, I18n.format("menu.singleplayer", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 48 + 24 * 1, I18n.format("menu.multiplayer", new Object[0])));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground(0);

        FontRenderer font = mc.fontRendererObj;
        mc.getTextureManager().bindTexture(new ResourceLocation("fallingflowers/background.png"));
        Gui.drawModalRectWithCustomSizedTexture(0,0,0,0,width,height,width,height);

        font.drawStringWithShadow(FallingFlowers.NAME,width / 2 - font.getStringWidth(FallingFlowers.NAME) / 2,height / 4 - font.FONT_HEIGHT / 2, Color.pink.getRGB());
        font.drawStringWithShadow("Minecraft 1.8.8",1,height - (font.FONT_HEIGHT) * 2 - 1,Color.LIGHT_GRAY.getRGB());
        font.drawStringWithShadow(FallingFlowers.NAME + " " + FallingFlowers.VERSION,1,height - font.FONT_HEIGHT - 1,Color.LIGHT_GRAY.getRGB());
        font.drawStringWithShadow("by " + FallingFlowers.AUTHOR,width - font.getStringWidth("by " + FallingFlowers.AUTHOR) - 1,height - font.FONT_HEIGHT - 1,Color.LIGHT_GRAY.getRGB());

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (button.id == 2)
        {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (button.id == 4)
        {
            this.mc.shutdown();
        }
    }
}
