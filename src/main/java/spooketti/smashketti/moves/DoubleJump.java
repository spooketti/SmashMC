package spooketti.smashketti.moves;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class DoubleJump
{
    public static void DoubleJumpAction(ServerPlayerEntity player)
    {
        player.getServerWorld().spawnParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,player.getPos().x,player.getPos().y,player.getPos().z,
                5, 0, 0, 0,.2);
        player.getServerWorld().spawnParticles(ParticleTypes.CLOUD,player.getPos().x,player.getPos().y,player.getPos().z,
                20, 0, 0, 0,.2);

        NbtCompound data = new NbtCompound();
        data.putInt("testvalue",123);
        NbtCompound nbt = player.writeNbt(new NbtCompound());
        nbt.putInt("testvalue", (int)Math.floor(Math.random()*50));



    }
}
