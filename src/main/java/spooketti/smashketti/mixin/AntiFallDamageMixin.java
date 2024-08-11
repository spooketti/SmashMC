package spooketti.smashketti.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import spooketti.smashketti.potion.PotionRegister;

import java.util.Collection;

@Mixin(LivingEntity.class)
public abstract class AntiFallDamageMixin {

    @Shadow public abstract Collection<StatusEffectInstance> getStatusEffects();

    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @ModifyVariable(at = @At("HEAD"), method = "handleFallDamage", ordinal = 1, argsOnly = true)
    private float cancelFallDamage(float fallDistance) {
        if(this.hasStatusEffect(PotionRegister.SMASH_EFFECT))
        {
            return 0;
        }
        return fallDistance;
    }

}