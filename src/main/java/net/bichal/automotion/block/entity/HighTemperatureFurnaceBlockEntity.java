package net.bichal.automotion.block.entity;

import net.bichal.automotion.item.ModItems;
import net.bichal.automotion.screen.HighTemperatureFurnaceScreenHandler;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HighTemperatureFurnaceBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private int burnTime = 0;
    private int smeltTime = 0;
    private int maxBurnTime = 0;
    private final PropertyDelegate propertyDelegate;

    public HighTemperatureFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HIGH_TEMPERATURE_FURNACE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> burnTime;
                    case 1 -> smeltTime;
                    case 2 -> getMaxSmeltTime();
                    case 3 -> maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> burnTime = value;
                    case 1 -> smeltTime = value;
                    case 3 -> maxBurnTime = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    public int getMaxSmeltTime() {
        return 100;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        burnTime = nbt.getInt("BurnTime");
        smeltTime = nbt.getInt("SmeltTime");
        maxBurnTime = nbt.getInt("MaxBurnTime");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("BurnTime", burnTime);
        nbt.putInt("SmeltTime", smeltTime);
        nbt.putInt("MaxBurnTime", maxBurnTime);
    }

    public static void tick(World world, BlockPos pos, BlockState state, HighTemperatureFurnaceBlockEntity entity) {
        boolean wasLit = state.get(Properties.LIT);
        boolean hasFuel = entity.burnTime > 0;
        boolean canSmelt = entity.canSmelt();

        if (!world.isClient) {
            if (wasLit != hasFuel) {
                world.setBlockState(pos, state.with(Properties.LIT, hasFuel), 3);
            }
        }

        if (hasFuel && canSmelt) {
            entity.smeltTime++;
            if (entity.smeltTime >= entity.getMaxSmeltTime()) {
                entity.processSmelting();
                entity.smeltTime = 0;
            }
        } else {
            entity.smeltTime = 0;
        }

        if (hasFuel) {
            entity.burnTime--;
        } else if (!entity.inventory.get(1).isEmpty() && canSmelt) {
            entity.consumeFuel();
        }

        if (world.isClient && hasFuel) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;
            world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
        }
    }

    private boolean canSmelt() {
        ItemStack input = inventory.get(0);
        if (input.isEmpty()) return false;

        ItemStack result = ItemStack.EMPTY;


        if (input.isOf(ModItems.RAW_CHROMIUM)) {
            result = new ItemStack(ModItems.CHROMIUM_INGOT);
        } else if (input.isOf(ModItems.RAW_THORIUM)) {
            result = new ItemStack(ModItems.THORIUM_INGOT);
        }

        if (result.isEmpty()) return false;

        ItemStack output = inventory.get(2);
        return output.isEmpty() || (output.isOf(result.getItem()) && output.getCount() < output.getMaxCount());
    }

    private void consumeFuel() {
        ItemStack fuel = inventory.get(1);
        if (!fuel.isEmpty()) {
            Integer fuelBurnTime = FuelRegistry.INSTANCE.get(fuel.getItem());
            if (fuelBurnTime != null) {
                this.burnTime = fuelBurnTime;
                this.maxBurnTime = fuelBurnTime;
                fuel.decrement(1);
            }
        }
    }

    private void processSmelting() {
        ItemStack input = inventory.get(0);
        ItemStack output = inventory.get(2);

        if (!input.isEmpty()) {
            ItemStack result = ItemStack.EMPTY;

            if (input.isOf(ModItems.RAW_CHROMIUM)) {
                result = new ItemStack(ModItems.CHROMIUM_INGOT);
            } else if (input.isOf(ModItems.RAW_THORIUM)) {
                result = new ItemStack(ModItems.THORIUM_INGOT);
            }

            if (!result.isEmpty()) {
                if (output.isEmpty()) {
                    inventory.set(2, result);
                } else if (output.isOf(result.getItem())) {
                    output.increment(1);
                }
                input.decrement(1);
            }
        }
    }

    public PropertyDelegate getPropertyDelegate() {
        return propertyDelegate;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new HighTemperatureFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return this.world != null && this.world.getBlockEntity(this.pos) == this &&
                player.squaredDistanceTo(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.high_temperature_furnace");
    }
}
