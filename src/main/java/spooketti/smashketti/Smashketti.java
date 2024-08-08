package spooketti.smashketti;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spooketti.smashketti.packet.smashAttackPayload;

public class Smashketti implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("smashketti");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		PayloadTypeRegistry.playC2S().register(smashAttackPayload.ID, smashAttackPayload.smashAttackPacketCODEC);
		ServerPlayNetworking.registerGlobalReceiver(smashAttackPayload.ID, (payload, context) ->{
			context.player().sendMessage(Text.literal("recieved"));
		});
		LOGGER.info("Hello Fabric world!");
		//test

	}
}