package net.bichal.automotion;

import net.bichal.automotion.block.ModBlocks;
import net.bichal.automotion.block.entity.ModBlockEntities;
import net.bichal.automotion.item.ModItemGroups;
import net.bichal.automotion.item.ModItems;
import net.bichal.automotion.recipe.ModRecipes;
import net.bichal.automotion.screen.ModScreenHandlers;
import net.bichal.automotion.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Automotion implements ModInitializer {
    public static String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

    public static final String MOD_ID = "automotion";

    public static final Logger LOGGER = LoggerFactory.getLogger(upperCaseFirst(MOD_ID));

    @Override
    public void onInitialize() {
        LOGGER.info("[{}] Has been initialized!", upperCaseFirst(MOD_ID));
        ModWorldGeneration.generateModWorldGen();

        ModItemGroups.registerModItemGroups();
        ModItems.registerModItems();

        ModRecipes.registerRecipes();

        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();

        ModScreenHandlers.registerScreenHandlers();
    }
}
