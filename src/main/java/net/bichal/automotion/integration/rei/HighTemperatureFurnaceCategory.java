package net.bichal.automotion.integration.rei;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.bichal.automotion.block.ModBlocks;
import net.minecraft.text.Text;

import java.util.List;

public class HighTemperatureFurnaceCategory implements DisplayCategory<HighTemperatureFurnaceDisplay> {
    public static final CategoryIdentifier<HighTemperatureFurnaceDisplay> ID =
            CategoryIdentifier.of("automotion", "high_temperature_furnace");

    @Override
    public CategoryIdentifier<? extends HighTemperatureFurnaceDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("rei.category.automotion.high_temperature_furnace");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.HIGH_TEMPERATURE_FURNACE);
    }

    @Override
    public List<Widget> setupDisplay(HighTemperatureFurnaceDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);

        List<Widget> widgets = Lists.newArrayList();

        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 2))
                .entries(display.getInputEntries().get(0))
                .markInput());

        widgets.add(Widgets.createBurningFire(new Point(startPoint.x + 5, startPoint.y + 22))
                .animationDurationMS(5000));

        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 10))
                .animationDurationTicks(display.getRecipe().getCookTime()));

        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 10)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 10))
                .entries(display.getOutputEntries().get(0))
                .disableBackground()
                .markOutput());

        float experience = display.getRecipe().getExperience();
        int cookTime = display.getRecipe().getCookTime() / 20;

        String xpText = String.format("%.1f", experience).replace('.', ',');

        widgets.add(Widgets.createLabel(
                        new Point(bounds.getMinX() + 75, bounds.getMinY() + 5),
                        Text.translatable("rei.automotion.high_temperature_furnace.xp_info", xpText, cookTime)
                ).noShadow()
                .color(0xFF404040, 0xFFBBBBBB)
                .centered());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 60;
    }
}
