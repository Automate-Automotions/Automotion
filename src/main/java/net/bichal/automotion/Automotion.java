package net.bichal.automotion;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.item.ModItemGroups;
import net.bichal.automotion.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.Version.getVersion;

public class Automotion implements ModInitializer {
    public static final String MOD_ID = "automotion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Automotion mod has been initialized! Version: {}", getVersion());
        ModItemGroups.registerModItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}