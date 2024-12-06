package net.bichal.automotion;

import net.bichal.automotion.screen.HighTemperatureFurnaceScreen;
import net.bichal.automotion.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class AutomotionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.HIGH_TEMPERATURE_FURNACE, HighTemperatureFurnaceScreen::new);
    }
}
