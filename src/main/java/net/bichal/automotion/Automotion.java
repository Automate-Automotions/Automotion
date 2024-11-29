package net.bichal.automotion;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItemGroups;
import net.bichal.automotion.item.ModItems;
import net.bichal.automotion.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Automotion implements ModInitializer {
    public static final String MOD_ID = "automotion";
    public static final Logger LOGGER = LoggerFactory.getLogger("Automotion");

    @Override
    public void onInitialize() {
        LOGGER.info("[Automotion] Has been initialized!");
        ModWorldGeneration.generateModWorldGen();

        ModItemGroups.registerModItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

    }
}