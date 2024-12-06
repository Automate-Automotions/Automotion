package net.bichal.automotion.screen.slot;

import net.bichal.automotion.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class InputSlot extends Slot {
    public InputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        // Solo permite colocar Raw Chromium, Raw Thorium o Raw Molybdenum
        return stack.isOf(ModItems.RAW_CHROMIUM) || stack.isOf(ModItems.RAW_THORIUM) || stack.isOf(ModItems.RAW_MOLYBDENUM);
    }
}
