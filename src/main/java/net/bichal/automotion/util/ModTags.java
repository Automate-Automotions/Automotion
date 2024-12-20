package net.bichal.automotion.util;

import net.bichal.automotion.Automotion;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> ORES = createBlockTag();

        private static TagKey<Block> createBlockTag() {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Automotion.MOD_ID, "ores"));
        }
    }

    public static class Items {
        public static final TagKey<Item> RAW = createItemTag();

        private static TagKey<Item> createItemTag() {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Automotion.MOD_ID, "raw"));
        }
    }

    public static void registerTags() {
    }
}
