package net.bichal.automotion.recipe;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

public class HighTemperatureFurnaceRecipeSerializer implements RecipeSerializer<HighTemperatureFurnaceRecipe> {
    @Override
    public HighTemperatureFurnaceRecipe read(Identifier id, JsonObject json) {
        String group = JsonHelper.getString(json, "group", "");
        Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(json, "ingredient"));
        ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
        float experience = JsonHelper.getFloat(json, "experience", 0.0F);
        int cookTime = JsonHelper.getInt(json, "cookingtime", 200);

        return new HighTemperatureFurnaceRecipe(id, group, CookingRecipeCategory.MISC, ingredient, result, experience, cookTime);
    }

    @Override
    public HighTemperatureFurnaceRecipe read(Identifier id, PacketByteBuf buf) {
        String group = buf.readString();
        Ingredient ingredient = Ingredient.fromPacket(buf);
        ItemStack result = buf.readItemStack();
        float experience = buf.readFloat();
        int cookingTime = buf.readInt();

        return new HighTemperatureFurnaceRecipe(id, group, CookingRecipeCategory.MISC, ingredient, result, experience, cookingTime);
    }

    @Override
    public void write(PacketByteBuf buf, HighTemperatureFurnaceRecipe recipe) {
        buf.writeString(recipe.getGroup());
        recipe.getIngredients().get(0).write(buf);
        buf.writeItemStack(recipe.getOutput(DynamicRegistryManager.EMPTY));
        buf.writeFloat(recipe.getExperience());
        buf.writeInt(recipe.getCookTime());
    }
}
