package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import deuli.newdawn.horizoncobblemonitems.Util;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ShinyItem extends AbstractHorizonItem {
    private final boolean shiny;

    public ShinyItem(Rarity rarity, boolean shiny) {
        super(rarity);
        this.shiny = shiny;
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return shiny && !pokemon.getShiny() || !shiny && pokemon.getShiny();
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        if (shiny && !pokemon.getShiny() || !shiny && pokemon.getShiny())
            pokemon.setShiny(shiny);

        Util.consume(itemStack, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.ITEM_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }
}
