package net.bichal.automotion.datagen;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOLYBDENUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THORIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MOLYBDENUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOLYBDENUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_THORIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THORIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_THORIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_THORIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_CHROMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHROMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CHROMIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOLYBDENUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MOLYBDENUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOLYBDENUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.THORIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_THORIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.THORIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHROMIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CHROMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHROMIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUTHENIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOLFRAM_INGOT, Models.GENERATED);
    }
}
