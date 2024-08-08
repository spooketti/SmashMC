package spooketti.smashketti.moves;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import spooketti.smashketti.packet.smashAttackPayload;

public class SmashAttack {
    public static void ChargeParticle(ServerPlayerEntity player)
    {
        Vec3d eyePos = player.getEyePos();
        Vec3d lookVector = player.getRotationVector();
        Vec3d spawnPos = eyePos.add(lookVector.multiply(1));
        player.getServerWorld().spawnParticles(ParticleTypes.WITCH,spawnPos.x,spawnPos.y,spawnPos.z, 5, 0, 0, 0,.2);
        for(double i=0;i<1.5;i+=.5)
        {

            Vec3d smokeSpawnPos = player.getPos().subtract(lookVector.multiply(i));
             player.getServerWorld().spawnParticles(ParticleTypes.CLOUD,
                     smokeSpawnPos.x,player.getY()+(i/2),smokeSpawnPos.z,1,
                     0, 0,0, .01);
        }

    }
}
