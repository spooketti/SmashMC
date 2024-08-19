package spooketti.smashketti.moves;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import spooketti.smashketti.SmashkettiClient;
import spooketti.smashketti.packet.grabPayload;
import spooketti.smashketti.packet.smashAttackPayload;

public class ClientGrab
{
    private static boolean wasGrabbing = false;
    private static int grabDebounce = 5;
    public static void grabLogic(MinecraftClient client)
    {
        if(client.player == null)
        {
            return;
        }
        if (SmashkettiClient.grab.isPressed() && !wasGrabbing && grabDebounce <= 0 && client.player.isOnGround()) {
            grabDebounce = 20;
            client.player.setPitch(0);
            sendGrabPacket();
        }
        else
        {
            grabDebounce--;
        }
        wasGrabbing = SmashkettiClient.grab.isPressed();
    }

    private static void sendGrabPacket()
    {
        ClientPlayNetworking.send(new grabPayload());
    }
}
