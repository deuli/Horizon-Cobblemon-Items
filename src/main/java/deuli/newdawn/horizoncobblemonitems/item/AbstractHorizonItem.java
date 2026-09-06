package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.item.CobblemonItem;
import com.cobblemon.mod.common.item.battle.BagItem;
import deuli.newdawn.horizoncobblemonitems.Util;
import deuli.newdawn.horizoncobblemonitems.registry.HCIDataComponentTypes;
import net.minecraft.ChatFormatting;
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

public abstract class AbstractHorizonItem extends CobblemonItem implements PokemonSelectingItem {
    public AbstractHorizonItem() {
        super(new Item.Properties());
    }

    public AbstractHorizonItem(Item.Properties properties) {
        super(properties);
    }

    public AbstractHorizonItem(Rarity rarity) {
        super(new Item.Properties().rarity(rarity));
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer)
            return use(serverPlayer, player.getItemInHand(hand), false);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack);
    }
}
