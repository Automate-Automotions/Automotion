package net.bichal.automotion.datagen;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOLYBDENUM_BLOCK);
        addDrop(ModBlocks.RAW_MOLYBDENUM_BLOCK);

        addDrop(ModBlocks.THORIUM_BLOCK);
        addDrop(ModBlocks.RAW_THORIUM_BLOCK);

        addDrop(ModBlocks.RAW_CHROMIUM_BLOCK);

        addDrop(ModBlocks.HIGH_TEMPERATURE_FURNACE);

        addDrop(ModBlocks.MOLYBDENUM_ORE, copperLikeOreDrops(ModBlocks.MOLYBDENUM_ORE, ModItems.RAW_MOLYBDENUM));
        addDrop(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE, ModItems.RAW_MOLYBDENUM));

        addDrop(ModBlocks.CHROMIUM_ORE, copperLikeOreDrops(ModBlocks.CHROMIUM_ORE, ModItems.RAW_CHROMIUM));
        addDrop(ModBlocks.DEEPSLATE_CHROMIUM_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_CHROMIUM_ORE, ModItems.RAW_CHROMIUM));

        addDrop(ModBlocks.THORIUM_ORE, copperLikeOreDrops(ModBlocks.THORIUM_ORE, ModItems.RAW_THORIUM));
        addDrop(ModBlocks.DEEPSLATE_THORIUM_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_THORIUM_ORE, ModItems.RAW_THORIUM));
        addDrop(ModBlocks.NETHER_THORIUM_ORE, copperLikeOreDrops(ModBlocks.NETHER_THORIUM_ORE, ModItems.RAW_THORIUM));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
