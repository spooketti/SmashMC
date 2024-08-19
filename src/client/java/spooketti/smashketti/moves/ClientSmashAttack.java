package spooketti.smashketti.moves;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import spooketti.smashketti.SmashkettiClient;
import spooketti.smashketti.packet.smashAttackPayload;

public class ClientSmashAttack {
    private static int smashAttackFrames = 0;


    public static void smashAttackLogic(MinecraftClient client)
    {
        if(client.player == null || !client.player.isOnGround())
        {
            return;
        }

        if (SmashkettiClient.smashAttack.isPressed()) {
            smashAttackFrames++;
            //client.player.sendMessage(Text.literal("charging"), false);
            sendSmashPacket(true);

        }
        else if(smashAttackFrames > 0)
        {
            sendSmashPacket(false);
            smashAttackFrames = 0;
        }
    }

    private static void sendSmashPacket(boolean charging)
    {
        ClientPlayNetworking.send(new smashAttackPayload(charging,smashAttackFrames));
    }
}
