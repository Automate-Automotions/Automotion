package net.bichal.automotion.datagen;

import com.google.gson.JsonObject;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class HighTemperatureFurnaceRecipeJsonBuilder {
    private final ItemConvertible input;
    private final ItemConvertible output;
    private final float experience;
    private final int cookTime;

    private HighTemperatureFurnaceRecipeJsonBuilder(ItemConvertible input, ItemConvertible output, float experience, int cookTime) {
        this.input = input;
        this.output = output;
        this.experience = experience;
        this.cookTime = cookTime;
    }

    public static HighTemperatureFurnaceRecipeJsonBuilder create(ItemConvertible input, ItemConvertible output, float experience, int cookTime) {
        return new HighTemperatureFurnaceRecipeJsonBuilder(input, output, experience, cookTime);
    }

    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier id) {
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {
                json.addProperty("type", "automotion:high_temperature_furnace");
                JsonObject ingredient = new JsonObject();
                ingredient.addProperty("item", input.asItem().toString());
                json.add("ingredient", ingredient);
                JsonObject result = new JsonObject();
                result.addProperty("item", output.asItem().toString());
                json.add("result", result);
                json.addProperty("experience", experience);
                json.addProperty("cooktime", cookTime);
            }

            @Override
            public Identifier getRecipeId() {
                return id;
            }

            public RecipeSerializer<?> getSerializer() {
                return null;
            }

            public @Nullable JsonObject toAdvancementJson() {
                return null;
            }

            public @Nullable Identifier getAdvancementId() {
                return null;
            }

            @Override
            public String toString() {
                return id.toString();
            }
        });
    }
}
