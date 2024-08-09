package spooketti.smashketti.moves;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class DoubleJump
{
    public static void DoubleJumpAction(ServerPlayerEntity player)
    {
        player.sendMessage(Text.literal("from the south side "));
        player.addVelocity(0, 1, 0);
    }
}
