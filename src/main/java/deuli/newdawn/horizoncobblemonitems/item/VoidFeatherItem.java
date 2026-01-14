package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.item.CobblemonItem;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class VoidFeatherItem extends CobblemonItem implements PokemonSelectingItem {
    private final int evSetAmount;
    private final Set<Stat> targetStats;

    public VoidFeatherItem(int evSetAmount, Set<Stat> targetStats) {
        super(new Item.Properties());
        this.evSetAmount = evSetAmount;
        this.targetStats = targetStats;
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    private boolean canChangeEV(Pokemon pokemon, Stat stat) {
        Integer ev = pokemon.getEvs().get(stat);
        return ev != null && ev != evSetAmount;
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

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.MEDICINE_FEATHER_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer)
            return use(serverPlayer, player.getItemInHand(hand));

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        componentList.add(Component.translatable("item." + itemStack.getItem().getDescriptionId() + ".tooltip", evSetAmount).withStyle(ChatFormatting.GRAY));
    }
}
