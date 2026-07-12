package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.item.PokemonItem;
import com.cobblemon.mod.common.pokemon.*;
import deuli.newdawn.horizoncobblemonitems.Util;
import kotlin.Pair;
import kotlin.Unit;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class PoryphoneItem extends Item {
    private final boolean addToParty;

    public PoryphoneItem(Rarity rarity, boolean addToParty) {
        super(new Properties().rarity(rarity));
        this.addToParty = addToParty;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stackInHand = player.getItemInHand(hand);
        if (level.isClientSide) return InteractionResultHolder.pass(stackInHand);

        ItemStack offHand = player.getOffhandItem();
        if (offHand.getItem() instanceof PokemonItem pokemonItem) {
            Pair<Species, Set<String>> speciesAndAspects = pokemonItem.getSpeciesAndAspects(offHand);
            if (speciesAndAspects != null && speciesAndAspects.component1() != null) {
                Pokemon pokemon = pokemonItem.asPokemon(offHand);
                if (pokemon != null) {
                    if (addToParty) {
                        PlayerPartyStore party = Cobblemon.INSTANCE.getStorage().getParty((ServerPlayer) player);
                        party.add(pokemon);
                    } else {
                        pokemon.sendOut((ServerLevel) level, player.position(), null, pokemonEntity -> {
                            pokemonEntity.playSound(SoundEvents.TRIAL_SPAWNER_SPAWN_MOB);
                            return Unit.INSTANCE;
                        });
                    }

                    level.playSound(null, player.getOnPos(), CobblemonSounds.POKEDEX_OPEN, SoundSource.PLAYERS, 0.2F, 1);
                    player.getCooldowns().addCooldown(stackInHand.getItem(), 20);
                    Util.consume(stackInHand, player);
                    offHand.consume(1, player);
                }
            }
        }

        return InteractionResultHolder.fail(stackInHand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack);
    }
}
