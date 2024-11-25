package net.bichal.automotion.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        RegistryKey<PlacedFeature> MY_ORE_PLACED_KEY = RegistryKey.of(
                RegistryKeys.PLACED_FEATURE,
                new Identifier("automotion", "thorium_ore_placed")
        );

        BiomeModifications.addFeature(
                ctx -> ctx.getBiome().getCategory() == Biome.Category.DESERT, // Cambia esto por el bioma deseado
                GenerationStep.Feature.UNDERGROUND_ORES,
                MY_ORE_PLACED_KEY
        );
        ;
    }
}
