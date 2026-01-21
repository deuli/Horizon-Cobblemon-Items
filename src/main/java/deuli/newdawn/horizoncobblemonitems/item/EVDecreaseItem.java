package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.ItemEvSource;
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

public class EVDecreaseItem extends AbstractHorizonItem {
    private final Stat stat;
    private final int evDecreaseAmount;

    public EVDecreaseItem(Stat stat, int evDecreaseAmount) {
        super(Rarity.UNCOMMON);
        this.stat = stat;
        this.evDecreaseAmount = evDecreaseAmount;
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return pokemon.getEvs().getOrDefault(stat) > 0;
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        int evsGained = pokemon.getEvs().add(stat, evDecreaseAmount, new ItemEvSource(serverPlayer, itemStack, pokemon));
        System.out.println(evsGained);
        if (evsGained < 0) {
            PokemonEntity entity = pokemon.getEntity();
            if (entity != null)
                entity.playSound(CobblemonSounds.MEDICINE_FEATHER_USE, 1F, 1F);
            itemStack.consume(1, serverPlayer);
            return InteractionResultHolder.success(itemStack);
        } else
            return InteractionResultHolder.fail(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack, evDecreaseAmount);
    }
}
