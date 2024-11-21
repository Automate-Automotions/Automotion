package net.bichal.automotion.item;

import net.bichal.automotion.Automotion;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final ItemGroup MOLYBDENUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Automotion.MOD_ID, "molybdenum_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.automotion"))
                    .icon(() -> new ItemStack(ModItems.MOLYBDENUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_MOLYBDENUM);
                        entries.add(ModItems.MOLYBDENUM_INGOT);
                    }).build());

    public static void registerModItemGroups() {
        Automotion.LOGGER.info("Registering Item Groups for " + Automotion.MOD_ID + "...");
    }
}
