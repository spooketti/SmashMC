package spooketti.smashketti;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spooketti.smashketti.moves.DoubleJump;
import spooketti.smashketti.moves.Grab;
import spooketti.smashketti.moves.SmashAttack;
import spooketti.smashketti.packet.doubleJumpPayload;
import spooketti.smashketti.packet.grabPayload;
import spooketti.smashketti.packet.smashAttackPayload;
import spooketti.smashketti.potion.PotionRegister;
import spooketti.smashketti.special.DownSpecial;
import spooketti.smashketti.special.NeutralSpecial;
import spooketti.smashketti.special.SideSpecial;
import spooketti.smashketti.special.UpSpecial;


public class Smashketti implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("smashketti");
	public static final UpSpecial UP_SPECIAL = new UpSpecial(new Item.Settings());
	public static final SideSpecial SIDE_SPECIAL = new SideSpecial(new Item.Settings());
	public static final DownSpecial DOWN_SPECIAL = new DownSpecial(new Item.Settings());
	public static final NeutralSpecial NEUTRAL_SPECIAL = new NeutralSpecial(new Item.Settings());

	private void registerPayloads()
	{
		PayloadTypeRegistry.playC2S().register(smashAttackPayload.ID, smashAttackPayload.smashAttackPacketCODEC);
		ServerPlayNetworking.registerGlobalReceiver(smashAttackPayload.ID, (payload, context) ->{
			SmashAttack.ChargeParticle(context.player());
		});

		PayloadTypeRegistry.playC2S().register(doubleJumpPayload.ID, doubleJumpPayload.doubleJumpPacketCODEC);
		ServerPlayNetworking.registerGlobalReceiver(doubleJumpPayload.ID, (payload, context) -> DoubleJump.DoubleJumpAction(context.player()));

		PayloadTypeRegistry.playC2S().register(grabPayload.ID, grabPayload.grabPacketCODEC);
		ServerPlayNetworking.registerGlobalReceiver(grabPayload.ID, (payload, context) -> Grab.GrabMove(context.player()));
	}

	private void registerItems()
	{
		Registry.register(Registries.ITEM, Identifier.of("smashketti", "up_special"), UP_SPECIAL);
		Registry.register(Registries.ITEM, Identifier.of("smashketti", "side_special"), SIDE_SPECIAL);
		Registry.register(Registries.ITEM, Identifier.of("smashketti", "down_special"), DOWN_SPECIAL);
		Registry.register(Registries.ITEM, Identifier.of("smashketti", "neutral_special"), NEUTRAL_SPECIAL);
	}


	@Override
	public void onInitialize() {
		registerPayloads();
		PotionRegister.registerPotions();
		registerItems();
		LOGGER.info("Hello Fabric world!");
		//test

	}
}