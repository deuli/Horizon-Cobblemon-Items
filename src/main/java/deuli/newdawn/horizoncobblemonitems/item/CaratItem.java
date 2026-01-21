package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class CaratItem extends AbstractHorizonItem {
    private final Set<Stat> targetStats;

    public CaratItem(Rarity rarity, Set<Stat> targetStats) {
        super(rarity);
        this.targetStats = targetStats;
    }

    private boolean canLimitBreakIV(@NotNull Pokemon pokemon, Stat stat) {
        Integer iv = pokemon.getIvs().get(stat);
        return iv != null && iv != pokemon.getIvs().getEffectiveBattleIV(stat);
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return targetStats.stream().anyMatch(stat -> canLimitBreakIV(pokemon, stat));
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        targetStats.forEach(stat -> {
            if (canLimitBreakIV(pokemon, stat)) {
                pokemon.setIV(stat, pokemon.getIvs().getHyperTrainedIVs().get(stat));
                pokemon.getIvs().getHyperTrainedIVs().remove(stat);
            }
        });

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.MEDICINE_PILLS_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }
}
