package spooketti.smashketti.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class ClientCameraMixin {


    @Inject(method = "update", at = @At("RETURN"))
    private void modifyCamera(CallbackInfo ci) {
        Camera camera = (Camera) (Object) this;
        MinecraftClient client = MinecraftClient.getInstance();
        if(client.player != null && camera.isThirdPerson()) {
                setRotation(-90, 0);
                setPos(client.player.getX()-2,client.player.getEyeY(),client.player.getZ());
        }
    }

    @Shadow
    protected abstract void setRotation(float yaw, float pitch);

    @Shadow
    protected abstract void setPos(double x, double y, double z);

}