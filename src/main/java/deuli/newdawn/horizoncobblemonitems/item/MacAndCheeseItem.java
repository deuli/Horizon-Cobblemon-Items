package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.api.riding.stats.RidingStat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.item.CobblemonItem;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.Pokemon;
import deuli.newdawn.horizoncobblemonitems.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class MacAndCheeseItem extends CobblemonItem implements PokemonSelectingItem {
    private final Set<RidingStat> targetStats;

    public MacAndCheeseItem(Rarity rarity, Set<RidingStat> targetStats) {
        super(new Item.Properties().rarity(rarity));
        this.targetStats = targetStats;
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    private boolean canChangeRidingStat(@NotNull Pokemon pokemon, RidingStat stat) {
        return pokemon.getRideBoost(stat) != pokemon.getMaxRideBoost(stat);
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return targetStats.stream().anyMatch(stat -> canChangeRidingStat(pokemon, stat));
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        targetStats.forEach(stat -> {
            if (canChangeRidingStat(pokemon, stat)) {
                pokemon.setRideBoost(stat, pokemon.getMaxRideBoost(stat));
            }
        });

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.MOCHI_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        return Util.use(this, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        if (targetStats.size() == 1) {
            RidingStat ridingStat = targetStats.stream().findFirst().get();
            Util.appendHoverText(componentList, itemStack, ridingStat.getDisplayName().withColor(ridingStat.getFlavour().getColour()));
        } else
            Util.appendHoverText(componentList, itemStack);
    }

}
