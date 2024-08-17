package spooketti.smashketti.moves;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.TridentItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class Grab {

    public static void GrabMove(ServerPlayerEntity player)
    {
        Vec3d pos = player.getEyePos();
        Vec3d lookVector = player.getRotationVector();

        Vec3d spawnPos = pos.add(lookVector.multiply(1,0,1));
        Vec3d vertexOne = spawnPos.subtract(0.5,0.5,0.5);
        Vec3d vertexTwo = spawnPos.add(0.5,1.5,0.5);
        ServerWorld world = player.getServerWorld();


        /*
        ZombieEntity zombie = new ZombieEntity(player.getServerWorld());
        zombie.setPosition(spawnPos);
        player.getServerWorld().spawnEntity(zombie);
        */

        Box grabBox = new Box(vertexOne,vertexTwo);
        List<Entity> entities = world.getEntitiesByClass(Entity.class, grabBox, entity -> entity != player);
        if(entities.isEmpty())
        {
            return;
        }
        Entity entity = entities.getFirst();
        entity.setOnFireFor(5);
    }
}
