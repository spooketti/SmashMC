package spooketti.smashketti.potion;

import jdk.jshell.Snippet;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class PotionRegister {
    public static final RegistryEntry.Reference<Potion> SMASH_POTION =
            Registry.registerReference(Registries.POTION, Identifier.of("smashketti","smash_potion"),
                    new Potion(new StatusEffectInstance(StatusEffects.WITHER,3600,0)));


    public static void registerPotions()
    {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.STRENGTH, Items.BLAZE_POWDER,SMASH_POTION);
        });
    }
}
