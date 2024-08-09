package spooketti.smashketti.mixin.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import spooketti.smashketti.packet.doubleJumpPayload;
import spooketti.smashketti.packet.smashAttackPayload;

@Mixin(ClientPlayerEntity.class)
public class ClientDoubleJumpMixin {

	private boolean canDoubleJump = true;
	private int doubleJumpCD = 2;
	private boolean jumpDebounce = false;
	private boolean newJump = false;

	@Inject(at = @At("HEAD"), method = "tickMovement")
	private void init(CallbackInfo info) {
		ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;

		if (player.input.jumping != jumpDebounce) {
			jumpDebounce = !jumpDebounce;
			newJump = jumpDebounce;
		}

		if(player.isOnGround() || player.isClimbing()) {
			canDoubleJump = true;
			doubleJumpCD = 2;
		}
		else if(newJump && canDoubleJump && doubleJumpCD <= 0)
		{/*
			if(Math.abs(player.getVelocity().y) > 2 )
			{
				player.addVelocity(0,1,0);
			}
			else
			{
				player.setVelocity(0, 1, 0);
			}
			*/
			player.setVelocity(player.getVelocity().x, 1, player.getVelocity().z);
			canDoubleJump = false;
			ClientPlayNetworking.send(new doubleJumpPayload());
		}
		else
		{
			doubleJumpCD--;
		}
		newJump = false;
	}
}