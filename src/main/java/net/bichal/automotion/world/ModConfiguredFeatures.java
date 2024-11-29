package net.bichal.automotion.world;

import net.bichal.automotion.Automotion;
import net.bichal.automotion.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOLYBDENUM_ORE_KEY = registerKey("molybdenum_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORIUM_ORE_KEY = registerKey("thorium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_THORIUM_ORE_KEY = registerKey("nether_thorium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHROMIUM_ORE_KEY = registerKey("chromium_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.NETHER_CARVER_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldMolybdenumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.MOLYBDENUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_MOLYBDENUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldThoriumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.THORIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_THORIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldChromiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.CHROMIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_CHROMIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherThoriumOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_THORIUM_ORE.getDefaultState()));

        register(context, MOLYBDENUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMolybdenumOres, 6));
        register(context, NETHER_THORIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherThoriumOres, 9));
        register(context, THORIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldThoriumOres, 8));
        register(context, CHROMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldChromiumOres, 6));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Automotion.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
