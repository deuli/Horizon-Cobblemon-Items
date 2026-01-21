package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class WoodenBottleCapItem extends AbstractHorizonItem {
    private final Set<Stat> targetStats;

    public WoodenBottleCapItem(Set<Stat> targetStats) {
        super(Rarity.RARE);
        this.targetStats = targetStats;
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        targetStats.forEach(stat -> {
            pokemon.hyperTrainIV(stat, serverPlayer.getRandom().nextInt(0, IVs.MAX_VALUE));
        });

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.MEDICINE_PILLS_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }
}
