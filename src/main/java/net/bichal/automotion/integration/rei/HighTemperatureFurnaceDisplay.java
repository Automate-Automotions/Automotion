package net.bichal.automotion.integration.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.bichal.automotion.recipe.HighTemperatureFurnaceRecipe;

import java.util.Collections;
import java.util.List;

public class HighTemperatureFurnaceDisplay extends BasicDisplay {
    private final HighTemperatureFurnaceRecipe recipe;

    public HighTemperatureFurnaceDisplay(HighTemperatureFurnaceRecipe recipe) {
        super(
                Collections.singletonList(EntryIngredients.ofIngredient(recipe.getIngredients().get(0))),
                Collections.singletonList(EntryIngredients.of(recipe.getOutput()))
        );
        this.recipe = recipe;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return Collections.singletonList(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return Collections.singletonList(EntryIngredients.of(recipe.getOutput()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return HighTemperatureFurnaceCategory.ID;
    }

    public HighTemperatureFurnaceRecipe getRecipe() {
        return recipe;
    }
}
