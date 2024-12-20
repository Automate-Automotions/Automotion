package net.bichal.automotion.datagen;

import com.google.gson.JsonObject;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class CustomCookingRecipeJsonBuilder {

    private final Ingredient ingredient;
    private final ItemConvertible result;
    private final float experience;
    private final int cookTime;
    private final RecipeSerializer<?> serializer;

    public CustomCookingRecipeJsonBuilder(Ingredient ingredient, ItemConvertible result, float experience, int cookTime, RecipeSerializer<?> serializer) {
        this.ingredient = ingredient;
        this.result = result;
        this.experience = experience;
        this.cookTime = cookTime;
        this.serializer = serializer;
    }

    public static CustomCookingRecipeJsonBuilder create(Ingredient ingredient, ItemConvertible result, float experience, int cookTime, RecipeSerializer<?> serializer) {
        return new CustomCookingRecipeJsonBuilder(ingredient, result, experience, cookTime, serializer);
    }

    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier id) {
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {
                json.add("ingredient", ingredient.toJson());

                JsonObject resultJson = new JsonObject();
                resultJson.addProperty("item", Registries.ITEM.getId(result.asItem()).toString());
                json.add("result", resultJson);

                // Add experience and cooking time
                json.addProperty("experience", experience);
                json.addProperty("cookingtime", cookTime);
            }

            @Override
            public Identifier getRecipeId() {
                return id;
            }

            @Override
            public RecipeSerializer<?> getSerializer() {
                return serializer;
            }

            @Override
            public JsonObject toAdvancementJson() {
                return null;
            }

            @Override
            public Identifier getAdvancementId() {
                return null;
            }
        });
    }
}
