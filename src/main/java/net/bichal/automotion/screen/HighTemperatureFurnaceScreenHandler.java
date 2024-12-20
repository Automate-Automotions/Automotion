package net.bichal.automotion.screen;

import net.bichal.automotion.recipe.ModRecipes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class HighTemperatureFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
    private final PropertyDelegate delegate;

    public HighTemperatureFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.HIGH_TEMPERATURE_FURNACE, ModRecipes.HIGH_TEMPERATURE_FURNACE_RECIPE_TYPE, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory, inventory, delegate);
        this.delegate = delegate;
    }

    public int getFuelProgress() {
        int burnTime = delegate.get(0);
        int maxBurnTime = delegate.get(1);
        return maxBurnTime != 0 ? burnTime * 13 / maxBurnTime : 0;
    }

    public int getSmeltProgress() {
        int cookTime = delegate.get(2);
        int totalCookTime = delegate.get(3);
        return totalCookTime != 0 && cookTime != 0 ? cookTime * 24 / totalCookTime : 0;
    }
}
