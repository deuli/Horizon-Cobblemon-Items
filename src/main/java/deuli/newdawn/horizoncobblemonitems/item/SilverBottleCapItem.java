package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SilverBottleCapItem extends AbstractHorizonItem {
    private final int ivSetAmount;

    public SilverBottleCapItem(int ivSetAmount) {
        super(Rarity.RARE);
        this.ivSetAmount = ivSetAmount;
    }

    private boolean canChangeIV(@NotNull Pokemon pokemon, Stat stat) {
        return pokemon.getIvs().getEffectiveBattleIV(stat) != ivSetAmount;
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return Arrays.stream(Stats.values()).anyMatch(stat -> stat.getType() == Stat.Type.PERMANENT && canChangeIV(pokemon, stat));
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        ArrayList<Stat> targetStats = new ArrayList<>();
        for (Stat stat : Stats.values()) {
            if (stat.getType() == Stat.Type.PERMANENT && pokemon.getIvs().getEffectiveBattleIV(stat) != ivSetAmount)
                targetStats.add(stat);
        }

        Stat stat = targetStats.get(serverPlayer.getRandom().nextInt(targetStats.size()));
        if (canChangeIV(pokemon, stat))
            pokemon.hyperTrainIV(stat, ivSetAmount);

        Util.consume(itemStack, serverPlayer);
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
