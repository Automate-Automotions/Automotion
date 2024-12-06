package net.bichal.automotion.screen;

import net.bichal.automotion.item.ModItems;
import net.bichal.automotion.screen.slot.FuelSlot;
import net.bichal.automotion.screen.slot.OutputSlot;
import net.bichal.automotion.screen.slot.InputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class HighTemperatureFurnaceScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public HighTemperatureFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.HIGH_TEMPERATURE_FURNACE, syncId);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);

        
        this.addSlot(new InputSlot(inventory, 0, 56, 17)); 
        this.addSlot(new FuelSlot(inventory, 1, 56, 53)); 
        this.addSlot(new OutputSlot(inventory, 2, 116, 35)); 

        addPlayerInventory(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    private boolean canSmelt(ItemStack stack) {
        return stack.isOf(ModItems.RAW_CHROMIUM) || stack.isOf(ModItems.RAW_THORIUM);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasStack()) {
            ItemStack stack = slot.getStack();
            originalStack = stack.copy();

            if (index < 3) {
                if (!this.insertItem(stack, 3, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.canSmelt(stack)) {
                    if (!this.insertItem(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (FuelRegistry.INSTANCE.get(stack.getItem()) != null) {
                    if (!this.insertItem(stack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 30) {
                    if (!this.insertItem(stack, 30, this.slots.size(), false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
            
            if (stack.getCount() == originalStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, stack);
        }

        return originalStack;
    }

    public boolean isBurning() {
        return this.propertyDelegate.get(0) > 0;
    }

    public int getSmeltProgress() {
        int smeltTime = this.propertyDelegate.get(1);
        int totalSmeltTime = this.propertyDelegate.get(2);
        return smeltTime != 0 && totalSmeltTime != 0 ? smeltTime * 24 / totalSmeltTime : 0;
    }

    public int getFuelProgress() {
        int burnTime = this.propertyDelegate.get(0);
        int totalBurnTime = this.propertyDelegate.get(3);
        return burnTime != 0 && totalBurnTime != 0 ? burnTime * 13 / totalBurnTime : 0;
    }
}