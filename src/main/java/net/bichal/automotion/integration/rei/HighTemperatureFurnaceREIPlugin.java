package net.bichal.automotion.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.recipe.HighTemperatureFurnaceRecipe;

public class HighTemperatureFurnaceREIPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new HighTemperatureFurnaceCategory(), config -> {
            config.addWorkstations(EntryStacks.of(ModBlocks.HIGH_TEMPERATURE_FURNACE));
        });
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(
                HighTemperatureFurnaceRecipe.class,
                recipe -> true,
                HighTemperatureFurnaceDisplay::new
        );
    }
}
