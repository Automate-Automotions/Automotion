package net.bichal.automotion.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;

public class HighTemperatureFurnaceRecipe extends AbstractCookingRecipe {
    public HighTemperatureFurnaceRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(ModRecipes.HIGH_TEMPERATURE_FURNACE_RECIPE_TYPE, id, group, category, input, output, experience, cookTime);
    }

    public ItemStack getOutput() {
        return this.output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.HIGH_TEMPERATURE_FURNACE_SERIALIZER;
    }
}