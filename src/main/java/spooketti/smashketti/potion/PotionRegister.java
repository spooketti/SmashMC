package spooketti.smashketti.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class PotionRegister {
    public static RegistryEntry<StatusEffect>SMASH_EFFECT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("smashketti","smash_effect"),new SmashEffect());

    public static void registerPotions()
    {

        RegistryEntry.Reference<Potion> SMASH_POTION =
                Registry.registerReference(Registries.POTION, Identifier.of("smashketti","smash_potion"),
                        new Potion(new StatusEffectInstance(SMASH_EFFECT,3600,0)));
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.STRENGTH, Items.BLAZE_POWDER,SMASH_POTION);
        });
    }
}
