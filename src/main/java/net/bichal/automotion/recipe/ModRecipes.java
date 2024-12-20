package net.bichal.automotion.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;

import static net.bichal.automotion.Automotion.*;

public class ModRecipes {
    public static final RecipeType<HighTemperatureFurnaceRecipe> HIGH_TEMPERATURE_FURNACE_RECIPE_TYPE =
            RecipeType.register("automotion:high_temperature_furnace");

    public static final RecipeSerializer<HighTemperatureFurnaceRecipe> HIGH_TEMPERATURE_FURNACE_SERIALIZER =
            RecipeSerializer.register("automotion:high_temperature_furnace", new HighTemperatureFurnaceRecipeSerializer());

    public static void registerRecipes() {
        LOGGER.info("[{}] Recipes registered!", upperCaseFirst(MOD_ID));
    }
}

