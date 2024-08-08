package spooketti.smashketti.moves;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import spooketti.smashketti.packet.smashAttackPayload;

public class SmashAttack {
    private static final KeyBinding smashAttack = KeyBindingHelper. registerKeyBinding(
            new KeyBinding("key.smashketti.smash",
                    InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R,
                    "key.smashketti.smashcontrol"));
    private static int smashAttackFrames = 0;


    public static void smashAttackLogic(MinecraftClient client)
    {
        if (smashAttack.isPressed()) {
            smashAttackFrames++;
            client.player.sendMessage(Text.literal("charging"), false);

        }
        else if(smashAttackFrames > 0)
        {
            smashAttackFrames = 0;
            client.player.sendMessage(Text.literal("let go"), false);
        }
    };

    private void sendSmashPacket(boolean charging)
    {
        ClientPlayNetworking.send(new smashAttackPayload(charging,smashAttackFrames));
    }
}



}
