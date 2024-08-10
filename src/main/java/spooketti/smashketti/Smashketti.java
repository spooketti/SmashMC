package spooketti.smashketti;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spooketti.smashketti.moves.DoubleJump;
import spooketti.smashketti.moves.SmashAttack;
import spooketti.smashketti.packet.doubleJumpPayload;
import spooketti.smashketti.packet.smashAttackPayload;
import spooketti.smashketti.potion.PotionRegister;
import spooketti.smashketti.potion.SmashEffect;

import java.awt.*;


public class Smashketti implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("smashketti");

	private void registerPayloads()
	{
		PayloadTypeRegistry.playC2S().register(smashAttackPayload.ID, smashAttackPayload.smashAttackPacketCODEC);
		ServerPlayNetworking.registerGlobalReceiver(smashAttackPayload.ID, (payload, context) ->{
//			context.player().sendMessage(Text.literal("recieved"));
			SmashAttack.ChargeParticle(context.player());
		});

		PayloadTypeRegistry.playC2S().register(doubleJumpPayload.ID, doubleJumpPayload.doubleJumpPacketCODEC);
		ServerPlayNetworking.registerGlobalReceiver(doubleJumpPayload.ID, (payload, context) ->{
			DoubleJump.DoubleJumpAction(context.player());
		});


	}

	public static final StatusEffect smashEffect = new SmashEffect();

	@Override
	public void onInitialize() {
		registerPayloads();
		PotionRegister.registerPotions();
		Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("smashketti","smash_effect"),smashEffect);
		LOGGER.info("Hello Fabric world!");
		//test

	}
}