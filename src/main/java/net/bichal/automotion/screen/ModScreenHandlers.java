package net.bichal.automotion.screen;

import net.bichal.automotion.block.entity.HighTemperatureFurnaceBlockEntity;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<HighTemperatureFurnaceScreenHandler> HIGH_TEMPERATURE_FURNACE;

    static {
        HIGH_TEMPERATURE_FURNACE = Registry.register(Registries.SCREEN_HANDLER,
                new Identifier("automotion", "high_temperature_furnace"),
                new ScreenHandlerType<>((syncId, playerInventory) -> {
                    HighTemperatureFurnaceBlockEntity blockEntity = new HighTemperatureFurnaceBlockEntity(BlockPos.ORIGIN, Blocks.AIR.getDefaultState());
                    SimpleInventory inventory = new SimpleInventory(blockEntity.getItems().size());
                    for (int i = 0; i < blockEntity.getItems().size(); i++) {
                        inventory.setStack(i, blockEntity.getItems().get(i));
                    }
                    return new HighTemperatureFurnaceScreenHandler(syncId, playerInventory, inventory, blockEntity.getPropertyDelegate());
                }, null)
        );
    }

    public static void registerScreenHandlers() {
        System.out.println("[Automotion] Mod Screen Handlers registered!");
    }
}
