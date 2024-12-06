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
        offerBlasting(exporter, MOLYBDENUM_SMELTABLES, RecipeCategory.MISC, ModItems.MOLYBDENUM_INGOT, .75f, 250, "molybdenum");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOLYBDENUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.MOLYBDENUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.THORIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.THORIUM_BLOCK);

        generateNuggetRecipes(exporter, ModItems.MOLYBDENUM_INGOT, ModItems.MOLYBDENUM_NUGGET, "molybdenum");
        generateNuggetRecipes(exporter, ModItems.THORIUM_INGOT, ModItems.THORIUM_NUGGET, "thorium");
        generateNuggetRecipes(exporter, ModItems.CHROMIUM_INGOT, ModItems.CHROMIUM_NUGGET, "chromium");
    }

    /**
     * @param exporter     The recipe exporter
     * @param ingot        The ingot item
     * @param nugget       The nugget item
     * @param materialName The material name (used for identifiers)
     */
    private void generateNuggetRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible ingot, ItemConvertible nugget, String materialName) {
        // Nugget to Ingot
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ingot, 1)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .input('N', nugget)
                .criterion("has_" + materialName + "_nugget", conditionsFromItem(nugget))
                .offerTo(exporter, new Identifier("automotion", materialName + "_nugget_to_ingot"));

        // Ingot to Nugget
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, nugget, 9)
                .input(ingot)
                .criterion("has_" + materialName + "_ingot", conditionsFromItem(ingot))
                .offerTo(exporter, new Identifier("automotion", materialName + "_ingot_to_nugget"));
    }
}