package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GenderChangePotionItem extends AbstractHorizonItem {
    public GenderChangePotionItem() {
        super(Rarity.UNCOMMON);
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        return pokemon.getGender() != Gender.GENDERLESS;
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        if (pokemon.getGender() != Gender.GENDERLESS)
            pokemon.setGender(pokemon.getGender() == Gender.MALE ? Gender.FEMALE : Gender.MALE);

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(SoundEvents.HONEY_DRINK, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }
}
