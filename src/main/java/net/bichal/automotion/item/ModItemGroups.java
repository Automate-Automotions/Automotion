package net.bichal.automotion.item;

import net.bichal.automotion.Automotion;
import net.bichal.automotion.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final ItemGroup MOLYBDENUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Automotion.MOD_ID, "molybdenum_block"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.automotion"))
                    .icon(() -> new ItemStack(ModBlocks.MOLYBDENUM_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.MOLYBDENUM_BLOCK);
                        entries.add(ModBlocks.MOLYBDENUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE);
                        entries.add(ModBlocks.RAW_MOLYBDENUM_BLOCK);

                        entries.add(ModItems.RAW_MOLYBDENUM);
                        entries.add(ModItems.MOLYBDENUM_NUGGET);
                        entries.add(ModItems.MOLYBDENUM_INGOT);

                        entries.add(ModBlocks.THORIUM_BLOCK);
                        entries.add(ModBlocks.THORIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_THORIUM_ORE);
                        entries.add(ModBlocks.RAW_THORIUM_BLOCK);

                        entries.add(ModItems.RAW_THORIUM);
                        entries.add(ModItems.THORIUM_NUGGET);
                        entries.add(ModItems.THORIUM_INGOT);

                    }).build());

    public static void registerModItemGroups() {
        Automotion.LOGGER.info("Registering Item Groups for " + Automotion.MOD_ID + "...");
    }
}
