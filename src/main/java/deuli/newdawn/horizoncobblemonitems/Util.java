package deuli.newdawn.horizoncobblemonitems;

import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Util {
    public static @NotNull InteractionResultHolder<ItemStack> use(PokemonSelectingItem item, @NotNull Player player, @NotNull InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer)
            return item.use(serverPlayer, player.getItemInHand(hand));

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    public static boolean appendHoverText(List<Component> componentList, ItemStack itemStack) {
        return componentList.add(Component.translatable(itemStack.getItem().getDescriptionId() + ".tooltip").withStyle(ChatFormatting.GRAY));
    }

    public static boolean appendHoverText(List<Component> componentList, ItemStack itemStack, Object... args) {
        return componentList.add(Component.translatable(itemStack.getItem().getDescriptionId() + ".tooltip", args).withStyle(ChatFormatting.GRAY));
    }
}
