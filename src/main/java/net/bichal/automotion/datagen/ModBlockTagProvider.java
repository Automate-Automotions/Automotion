package net.bichal.automotion.datagen;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.ORES)
                .add(ModBlocks.MOLYBDENUM_ORE)
                .add(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE)
                .add(ModBlocks.NETHER_THORIUM_ORE)
                .add(ModBlocks.THORIUM_ORE)
                .add(ModBlocks.DEEPSLATE_THORIUM_ORE)
                .add(ModBlocks.DEEPSLATE_CHROMIUM_ORE)
                .add(ModBlocks.CHROMIUM_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_MOLYBDENUM_BLOCK)
                .add(ModBlocks.MOLYBDENUM_BLOCK)
                .add(ModBlocks.MOLYBDENUM_ORE)
                .add(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE)
                .add(ModBlocks.THORIUM_BLOCK)
                .add(ModBlocks.NETHER_THORIUM_ORE)
                .add(ModBlocks.THORIUM_ORE)
                .add(ModBlocks.DEEPSLATE_THORIUM_ORE)
                .add(ModBlocks.RAW_CHROMIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_CHROMIUM_ORE)
                .add(ModBlocks.CHROMIUM_ORE)
                .add(ModBlocks.HIGH_TEMPERATURE_FURNACE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.HIGH_TEMPERATURE_FURNACE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.THORIUM_BLOCK)
                .add(ModBlocks.NETHER_THORIUM_ORE)
                .add(ModBlocks.THORIUM_ORE)
                .add(ModBlocks.DEEPSLATE_THORIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_MOLYBDENUM_BLOCK)
                .add(ModBlocks.MOLYBDENUM_BLOCK)
                .add(ModBlocks.MOLYBDENUM_ORE)
                .add(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE)
                .add(ModBlocks.RAW_CHROMIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_CHROMIUM_ORE)
                .add(ModBlocks.CHROMIUM_ORE);
    }
}
