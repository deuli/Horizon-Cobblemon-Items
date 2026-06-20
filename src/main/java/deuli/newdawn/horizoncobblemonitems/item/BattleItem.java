package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.battles.BattleBuilder;
import com.cobblemon.mod.common.battles.BattleStartError;
import deuli.newdawn.horizoncobblemonitems.Util;
import kotlin.Unit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public class BattleItem extends Item {

    public BattleItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker instanceof ServerPlayer attackerPlayer)) return false;
        if (!(target instanceof ServerPlayer targetPlayer)) return false;
        if (attackerPlayer.getCooldowns().isOnCooldown(this)) return false;

        BattleBuilder.INSTANCE.pvp1v1(attackerPlayer, targetPlayer)
                .ifSuccessful(pokemonBattle -> {
                    attackerPlayer.getCooldowns().addCooldown(this, 2000);
                    return Unit.INSTANCE;
                })
                .ifErrored(erroredBattleStart -> {
                    Iterator<BattleStartError> errorIterator = erroredBattleStart.getErrors().iterator();
                    if (errorIterator.hasNext()) {
                        attackerPlayer.displayClientMessage(errorIterator.next().getMessageFor(attacker).withStyle(ChatFormatting.RED), true);
                    } else {
                        attackerPlayer.displayClientMessage(Component.translatable(Util.getKey(this, "unknown_error")).withStyle(ChatFormatting.RED), true);
                    }
                    return Unit.INSTANCE;
                });

        return false;
    }

    public void appendHoverText(ItemStack itemStack, @NotNull TooltipContext tooltipContext, List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
        Util.appendHoverText(componentList, itemStack);
    }
}
