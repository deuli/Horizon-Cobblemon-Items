package deuli.newdawn.horizoncobblemonitems;

import deuli.newdawn.horizoncobblemonitems.item.DawnBallItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
}
