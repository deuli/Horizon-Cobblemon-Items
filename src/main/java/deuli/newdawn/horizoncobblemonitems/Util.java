package deuli.newdawn.horizoncobblemonitems;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Util {
    public static boolean appendHoverText(List<Component> componentList, ItemStack itemStack, Object... args) {
        return componentList.add(Component.translatable(itemStack.getItem().getDescriptionId() + ".tooltip", args).withStyle(ChatFormatting.GRAY));
    }

    public static @NotNull String getKey(Item item, String sub) {
        return item.getDescriptionId() + "." + sub;
    }

    public static @NotNull String getTooltipKey(Item item, String sub) {
        return item.getDescriptionId() + ".tooltip." + sub;
    }

    public static void consume(ItemStack itemStack, Player player) {
        if (!itemStack.getComponents().has(DataComponents.UNBREAKABLE))
            itemStack.consume(1, player);
    }
}
