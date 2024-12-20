package net.bichal.automotion.block.entity;

import net.bichal.automotion.recipe.ModRecipes;
import net.bichal.automotion.screen.HighTemperatureFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class HighTemperatureFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public HighTemperatureFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HIGH_TEMPERATURE_FURNACE_ENTITY, pos, state, ModRecipes.HIGH_TEMPERATURE_FURNACE_RECIPE_TYPE);
    }

    @Override
    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) * 2;
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.high_temperature_furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public PropertyDelegate getPropertyDelegate() {
        return this.propertyDelegate;
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new HighTemperatureFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
