package net.bichal.automotion.datagen;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MOLYBDENUM_SMELTABLES = List.of(ModItems.RAW_MOLYBDENUM,
            ModBlocks.MOLYBDENUM_ORE, ModBlocks.DEEPSLATE_MOLYBDENUM_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    public void generate(Consumer<RecipeJsonProvider> consumer) {

    }

    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, MOLYBDENUM_SMELTABLES, RecipeCategory.MISC, ModItems.MOLYBDENUM_INGOT, 0.7f, 200, "molybdenum");
        offerBlasting(exporter, MOLYBDENUM_SMELTABLES, RecipeCategory.MISC, ModItems.MOLYBDENUM_INGOT, 0.7f, 100, "molybdenum");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOLYBDENUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.MOLYBDENUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_MOLYBDENUM, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('R', ModItems.MOLYBDENUM_INGOT)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.MOLYBDENUM_INGOT), conditionsFromItem(ModItems.MOLYBDENUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_MOLYBDENUM)));
    }
}
