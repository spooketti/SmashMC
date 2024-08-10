package spooketti.smashketti.potion;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.OminousBottleItem;

public class SmashEffect extends StatusEffect {
    public SmashEffect()
    {
        super(
                StatusEffectCategory.BENEFICIAL,
                0xea48cc
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }

}

