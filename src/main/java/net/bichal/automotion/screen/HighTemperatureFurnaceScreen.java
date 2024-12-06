package net.bichal.automotion.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HighTemperatureFurnaceScreen extends HandledScreen<HighTemperatureFurnaceScreenHandler> {

    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/gui/container/furnace.png");

    public HighTemperatureFurnaceScreen(HighTemperatureFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        int titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
        context.drawText(this.textRenderer, this.title, titleX, 6, 0x404040, false);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);

        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);

        if (this.handler.isBurning()) {
            int progress = this.handler.getSmeltProgress();
            context.drawTexture(TEXTURE, this.x + 79, this.y + 35, 176, 14, progress + 1, 16);
        }

        int fuelHeight = this.handler.getFuelProgress();
        context.drawTexture(TEXTURE, this.x + 56, this.y + 36 + 12 - fuelHeight, 176, 12 - fuelHeight, 14, fuelHeight);
    }


}
