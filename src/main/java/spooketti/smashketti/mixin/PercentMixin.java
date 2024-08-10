package spooketti.smashketti.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import spooketti.smashketti.util.SaveEntityData;

@Mixin(Entity.class)
public abstract class PercentMixin implements SaveEntityData {

    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData()
    {
        if(this.persistentData == null)
        {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(at = @At("HEAD"), method = "writeNbt")
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if(persistentData != null)
        {
            nbt.put("smashketti.smash_data",persistentData);
        }
    }

    @Inject(at = @At("HEAD"), method = "readNbt")
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo ci) {
       if(nbt.contains("smashketti.smash_data",10))
       {
           persistentData = nbt.getCompound("smashketti.smash_data");
       }
    }
}