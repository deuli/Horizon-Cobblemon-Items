package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
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

public class BottleCapItem extends AbstractHorizonItem {
    private final int ivSetAmount;
    private final Set<Stat> targetStats;

    public BottleCapItem(Rarity rarity, int ivSetAmount, Set<Stat> targetStats) {
        super(rarity);
        this.ivSetAmount = ivSetAmount;
        this.targetStats = targetStats;
    }

    private boolean canChangeIV(@NotNull Pokemon pokemon, Stat stat) {
        return pokemon.getIvs().getEffectiveBattleIV(stat) != ivSetAmount;
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return targetStats.stream().anyMatch(stat -> canChangeIV(pokemon, stat));
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        targetStats.forEach(stat -> {
            if (canChangeIV(pokemon, stat)) {
                pokemon.hyperTrainIV(stat, ivSetAmount);
            }
        });

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.MEDICINE_PILLS_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack, ivSetAmount);
    }
}
