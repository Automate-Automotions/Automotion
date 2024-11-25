package net.bichal.automotion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool molybdenumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOLYBDENUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MOLYBDENUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOLYBDENUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOLYBDENUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MOLYBDENUM, Models.GENERATED);
    }
}
