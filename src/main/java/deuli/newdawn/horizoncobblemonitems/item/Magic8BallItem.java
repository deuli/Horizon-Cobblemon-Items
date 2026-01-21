package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.item.PokeBallItem;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Magic8BallItem extends AbstractHorizonItem {

    public Magic8BallItem() {
        super(new Properties());
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
            pokemon.setCaughtBall(((PokeBallItem) offhandItem.getItem()).getPokeBall());

        itemStack.consume(1, serverPlayer);
        offhandItem.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.ITEM_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }
}
