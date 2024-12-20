package net.bichal.automotion.datagen;

import net.bichal.automotion.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static net.bichal.automotion.Automotion.MOD_ID;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.MOLYBDENUM_INGOT,
                        Text.translatable("advancement.automotion.got_molybdenum_ingot.title"),
                        Text.translatable("advancement.automotion.got_molybdenum_ingot.description"),
                        new Identifier("textures/gui/advancements/backgrounds/raw_thorium_block.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_molybdenum_ingot", InventoryChangedCriterion.Conditions.items(ModItems.MOLYBDENUM_INGOT))
                .build(consumer, MOD_ID + "/got_molybdenum_ingot");
    }
}
