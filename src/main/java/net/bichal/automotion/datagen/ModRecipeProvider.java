package net.bichal.automotion.datagen;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MOLYBDENUM_SMELTABLES = List.of(ModItems.RAW_MOLYBDENUM,
            ModBlocks.MOLYBDENUM_ORE, ModBlocks.DEEPSLATE_MOLYBDENUM_ORE);
    private static final List<ItemConvertible> THORIUM_SMELTABLES = List.of(ModItems.RAW_THORIUM,
            ModBlocks.THORIUM_ORE, ModBlocks.DEEPSLATE_THORIUM_ORE, ModBlocks.NETHER_THORIUM_ORE);
    private static final List<ItemConvertible> CHROMIUM_SMELTABLES = List.of(ModItems.RAW_CHROMIUM,
            ModBlocks.CHROMIUM_ORE, ModBlocks.DEEPSLATE_CHROMIUM_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, MOLYBDENUM_SMELTABLES, RecipeCategory.MISC, ModItems.MOLYBDENUM_INGOT, 0.75f, 220, "molybdenum");
        offerBlasting(exporter, MOLYBDENUM_SMELTABLES, RecipeCategory.MISC, ModItems.MOLYBDENUM_INGOT, 0.8f, 110, "molybdenum");
        offerSmelting(exporter, THORIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THORIUM_INGOT, 0.65f, 200, "thorium");
        offerBlasting(exporter, THORIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THORIUM_INGOT, 0.7f, 100, "thorium");
        offerSmelting(exporter, CHROMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_INGOT, 0.75f, 200, "chromium");
        offerBlasting(exporter, CHROMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_INGOT, 0.8f, 100, "chromium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOLYBDENUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.MOLYBDENUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.THORIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.THORIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOLYBDENUM_INGOT, 9)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.MOLYBDENUM_NUGGET)
                .criterion("has_molybdenum_nugget", conditionsFromItem(ModItems.MOLYBDENUM_NUGGET))
                .offerTo(exporter, new Identifier("automotion", "molybdenum_nugget_to_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOLYBDENUM_NUGGET, 1)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.MOLYBDENUM_INGOT)
                .criterion("has_molybdenum_ingot", conditionsFromItem(ModItems.MOLYBDENUM_INGOT))
                .offerTo(exporter, new Identifier("automotion", "molybdenum_ingot_to_nugget"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THORIUM_INGOT, 9)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.THORIUM_NUGGET)
                .criterion("has_thorium_nugget", conditionsFromItem(ModItems.THORIUM_NUGGET))
                .offerTo(exporter, new Identifier("automotion", "thorium_nugget_to_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THORIUM_NUGGET, 1)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.THORIUM_INGOT)
                .criterion("has_thorium_ingot", conditionsFromItem(ModItems.THORIUM_INGOT))
                .offerTo(exporter, new Identifier("automotion", "thorium_ingot_to_nugget"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHROMIUM_INGOT, 9)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.CHROMIUM_NUGGET)
                .criterion("has_chromium_nugget", conditionsFromItem(ModItems.CHROMIUM_NUGGET))
                .offerTo(exporter, new Identifier("automotion", "chromium_nugget_to_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHROMIUM_NUGGET, 1)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.CHROMIUM_INGOT)
                .criterion("has_chromium_ingot", conditionsFromItem(ModItems.CHROMIUM_INGOT))
                .offerTo(exporter, new Identifier("automotion", "chromium_ingot_to_nugget"));
    }
}
