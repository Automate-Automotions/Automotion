package net.bichal.automotion.datagen;

import net.bichal.automotion.item.ModItems;
import net.bichal.automotion.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.RAW)
                .add(ModItems.RAW_MOLYBDENUM)
                .add(ModItems.RAW_THORIUM)
                .add(ModItems.RAW_CHROMIUM);
    }
}
