package deuli.newdawn.horizoncobblemonitems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class Util {
    public static boolean appendHoverText(List<Component> componentList, ItemStack itemStack, Object... args) {
        return componentList.add(Component.translatable(itemStack.getItem().getDescriptionId() + ".tooltip", args).withStyle(ChatFormatting.GRAY));
    }
}
