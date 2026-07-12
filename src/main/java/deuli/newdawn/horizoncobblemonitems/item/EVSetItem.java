package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.EVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import deuli.newdawn.horizoncobblemonitems.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class EVSetItem extends AbstractHorizonItem {
    private final int evSetAmount;
    private final Set<Stat> targetStats;

    public EVSetItem(Rarity rarity, int evSetAmount, Set<Stat> targetStats) {
        super(rarity);
        this.evSetAmount = evSetAmount;
        this.targetStats = targetStats;
    }

    private boolean canChangeEV(Pokemon pokemon, Stat stat) {
        if (pokemon.getEvs().getOrDefault(stat) != evSetAmount) {
            int total = 0;
            for (Stat currentStat : Stats.Companion.getPERMANENT()) {
                if (currentStat != stat)
                    total += pokemon.getEvs().getOrDefault(currentStat);
                else
                    total += evSetAmount;
            }

            return total <= EVs.MAX_TOTAL_VALUE;
        }

        return false;
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return targetStats.stream().anyMatch(stat -> canChangeEV(pokemon, stat));
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        targetStats.forEach(stat -> {
            if (canChangeEV(pokemon, stat)) {
                pokemon.setEV(stat, evSetAmount);
            }
        });

        Util.consume(itemStack, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.MEDICINE_FEATHER_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack, evSetAmount);
    }
}
