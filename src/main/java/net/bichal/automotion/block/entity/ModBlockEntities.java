package net.bichal.automotion.block.entity;

import net.bichal.automotion.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.bichal.automotion.Automotion.*;

public class ModBlockEntities {
    public static final BlockEntityType<HighTemperatureFurnaceBlockEntity> HIGH_TEMPERATURE_FURNACE_ENTITY;
    static {
        HIGH_TEMPERATURE_FURNACE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier("automotion", "high_temperature_furnace"),
                BlockEntityType.Builder.create(HighTemperatureFurnaceBlockEntity::new, ModBlocks.HIGH_TEMPERATURE_FURNACE).build(null));
    }


    public static void registerBlockEntities() {
        LOGGER.info("[{}] Block Entities registered!", upperCaseFirst(MOD_ID));
    }
}
