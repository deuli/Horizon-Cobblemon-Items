package deuli.newdawn.horizoncobblemonitems;

import deuli.newdawn.horizoncobblemonitems.registry.HCIDataComponentTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Util {
    public static void appendHoverText(List<Component> componentList, ItemStack itemStack, Object... args) {
        componentList.add(Component.translatable(itemStack.getItem().getDescriptionId() + ".tooltip", args).withStyle(ChatFormatting.GRAY));

        if (itemStack.getComponents().has(HCIDataComponentTypes.INFINITE.get()) && itemStack.getComponents().get(HCIDataComponentTypes.INFINITE.get()).showInTooltip())
            componentList.add(Component.translatable("item.infinite").withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    public static @NotNull String getKey(Item item, String sub) {
        return item.getDescriptionId() + "." + sub;
    }

    public static @NotNull String getTooltipKey(Item item, String sub) {
        return item.getDescriptionId() + ".tooltip." + sub;
    }

    public static void consume(ItemStack itemStack, Player player) {
        if (!itemStack.getComponents().has(HCIDataComponentTypes.INFINITE.get()))
            itemStack.consume(1, player);
    }
}
