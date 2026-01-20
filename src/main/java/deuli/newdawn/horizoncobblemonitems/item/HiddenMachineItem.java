package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.api.moves.BenchedMove;
import com.cobblemon.mod.common.api.moves.MoveTemplate;
import com.cobblemon.mod.common.api.pokemon.moves.Learnset;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HiddenMachineItem extends CobblemonItem implements PokemonSelectingItem {
    private final Set<MoveType> moveTypes;

    public HiddenMachineItem(Rarity rarity, Set<MoveType> moveTypes) {
        super(new Properties().rarity(rarity));
        this.moveTypes = moveTypes;
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    private boolean canLearnMove(@NotNull Pokemon pokemon, MoveTemplate moveTemplate) {
        ArrayList<BenchedMove> benchedMoves = new ArrayList<>();
        pokemon.getBenchedMoves().iterator().forEachRemaining(benchedMoves::add);
        return pokemon.getMoveSet().getMoves().stream().noneMatch(move -> move.getName().equals(moveTemplate.getName())) &&
                benchedMoves.stream().noneMatch(benchedMove -> benchedMove.getMoveTemplate().equals(moveTemplate));
    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack stack, @NotNull Pokemon pokemon) {
        ArrayList<MoveTemplate> moves = new ArrayList<>();
        moveTypes.forEach(moveType -> moves.addAll(getMoveTemplates(pokemon, moveType)));
        return moves.stream().anyMatch(moveTemplate -> canLearnMove(pokemon, moveTemplate));
    }

    @Override
    public @Nullable InteractionResultHolder<ItemStack> applyToPokemon(@NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (!canUseOnPokemon(itemStack, pokemon)) {
            return InteractionResultHolder.fail(itemStack);
        }

        ArrayList<BenchedMove> benchedMoves = new ArrayList<>();
        moveTypes.forEach(move -> {
            List<MoveTemplate> moves = getMoveTemplates(pokemon, move);
            for (MoveTemplate moveTemplate : moves)
                if (canLearnMove(pokemon, moveTemplate))
                    benchedMoves.add(new BenchedMove(moveTemplate, 0));
        });
        if (!benchedMoves.isEmpty())
            pokemon.getBenchedMoves().addAll(benchedMoves);

        itemStack.consume(1, serverPlayer);
        PokemonEntity entity = pokemon.getEntity();
        if (entity != null)
            entity.playSound(CobblemonSounds.ITEM_USE, 1F, 1F);

        return InteractionResultHolder.success(itemStack);
    }

    private static @NotNull List<MoveTemplate> getMoveTemplates(@NotNull Pokemon pokemon, MoveType move) {
        List<MoveTemplate> moves;
        Learnset moveSet = pokemon.getForm().getMoves();
        switch (move) {
            case LEVEL -> {
                ArrayList<MoveTemplate> moveTemplateArrayList = new ArrayList<>();
                for (List<MoveTemplate> levelMoves : moveSet.getLevelUpMoves().values())
                    moveTemplateArrayList.addAll(levelMoves);
                moves = moveTemplateArrayList;
            }
            case TM -> moves = moveSet.getTmMoves();
            case EGG -> moves = moveSet.getEggMoves();
            case TUTOR -> moves = moveSet.getTutorMoves();
            case LEGACY -> moves = moveSet.getLegacyMoves();
            case SPECIAL -> moves = moveSet.getSpecialMoves();
            case FORM_CHANGE -> moves = moveSet.getFormChangeMoves();
            default -> moves = List.of();
        }

        return moves;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer)
            return use(serverPlayer, player.getItemInHand(hand));

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack);
    }

    public enum MoveType {
        LEVEL,
        TM,
        EGG,
        TUTOR,
        LEGACY,
        SPECIAL,
        FORM_CHANGE
    }
}
