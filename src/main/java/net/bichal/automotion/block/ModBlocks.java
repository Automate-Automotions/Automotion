package net.bichal.automotion.block;

import net.bichal.automotion.Automotion;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;

public class ModBlocks {
    public static final Block MOLYBDENUM_BLOCK = createBlock("molybdenum_block",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.GRAY)
                    .requiresTool()
                    .strength(7.0F, 8.0F)
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block RAW_MOLYBDENUM_BLOCK = createBlock("raw_molybdenum_block",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.0F, 7.0F)
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block MOLYBDENUM_ORE = createBlock("molybdenum_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(5.5F, 6.0F)
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block DEEPSLATE_MOLYBDENUM_ORE = createBlock("deepslate_molybdenum_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(MOLYBDENUM_ORE)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(6.5F, 7.0F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
            ));

    public static final Block THORIUM_BLOCK = createBlock("thorium_block",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .requiresTool()
                    .strength(5.25F, 6.25F)
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block RAW_THORIUM_BLOCK = createBlock("raw_thorium_block",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.LIGHT_BLUE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block THORIUM_ORE = createBlock("thorium_ore",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.LIGHT_BLUE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 5.0F)
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block DEEPSLATE_THORIUM_ORE = createBlock("deepslate_thorium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(THORIUM_ORE)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(5.5F, 6.0F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
            ));

    private static Block createBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Automotion.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Automotion.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
    }
}