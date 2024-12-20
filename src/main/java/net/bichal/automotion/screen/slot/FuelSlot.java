package net.bichal.automotion.screen.slot;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class FuelSlot extends Slot {
    public FuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        // Solo permite colocar combustibles
        return FuelRegistry.INSTANCE.get(stack.getItem()) != null;
    }
}