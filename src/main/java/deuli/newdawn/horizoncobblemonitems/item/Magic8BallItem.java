package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.item.CobblemonItem;
import com.cobblemon.mod.common.item.PokeBallItem;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Magic8BallItem extends CobblemonItem implements PokemonSelectingItem {

    public Magic8BallItem() {
        super(new Properties());
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    private static boolean canSwapBall(ItemStack itemStack, @NotNull Pokemon pokemon) {
        return itemStack.getItem() instanceof PokeBallItem pokeBallItem && !pokemon.getCaughtBall().equals(pokeBallItem.getPokeBall());
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        ServerPlayer ownerPlayer = pokemon.getOwnerPlayer();
        return ownerPlayer != null && canSwapBall(ownerPlayer.getOffhandItem(), pokemon);
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        ItemStack offhandItem = serverPlayer.getOffhandItem();
        if (canSwapBall(offhandItem, pokemon))
            pokemon.setCaughtBall(((PokeBallItem)offhandItem.getItem()).getPokeBall());

        itemStack.consume(1, serverPlayer);
        offhandItem.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.ITEM_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer)
            if (serverPlayer.getOffhandItem().getItem() instanceof PokeBallItem)
                return use(serverPlayer, player.getItemInHand(hand));
            else
                serverPlayer.sendSystemMessage(Component.translatable(getDescriptionId() + ".fail").withStyle(ChatFormatting.RED), true);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        componentList.add(Component.translatable(itemStack.getItem().getDescriptionId() + ".tooltip").withStyle(ChatFormatting.GRAY));
    }
}
