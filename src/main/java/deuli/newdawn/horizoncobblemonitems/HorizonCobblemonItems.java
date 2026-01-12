package deuli.newdawn.horizoncobblemonitems;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.mojang.logging.LogUtils;
import deuli.newdawn.horizoncobblemonitems.item.BottleCapItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.Set;

@Mod(HorizonCobblemonItems.MOD_ID)
public class HorizonCobblemonItems {
    public static final String MOD_ID = "horizoncobblemonitems";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredItem<Item> GOLDEN_BOTTLE_CAP = ITEMS.register("golden_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.HP, Stats.ATTACK, Stats.DEFENCE, Stats.SPECIAL_ATTACK, Stats.SPECIAL_DEFENCE, Stats.SPEED)));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HCI_TAB = CREATIVE_MODE_TABS.register("horizon_cobblemon_items_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.horizoncobblemonitems")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> GOLDEN_BOTTLE_CAP.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(GOLDEN_BOTTLE_CAP.get());
    }).build());

    public HorizonCobblemonItems(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
