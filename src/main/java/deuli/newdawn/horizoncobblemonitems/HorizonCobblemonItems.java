package deuli.newdawn.horizoncobblemonitems;

import com.mojang.logging.LogUtils;
import deuli.newdawn.horizoncobblemonitems.registry.Aliases;
import deuli.newdawn.horizoncobblemonitems.registry.HCICreativeModeTabs;
import deuli.newdawn.horizoncobblemonitems.registry.HCIDataComponentTypes;
import deuli.newdawn.horizoncobblemonitems.registry.HCIItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(HorizonCobblemonItems.MOD_ID)
public class HorizonCobblemonItems {
    public static final String MOD_ID = "horizoncobblemonitems";
    public static final Logger LOGGER = LogUtils.getLogger();

    public HorizonCobblemonItems(IEventBus modEventBus) {
        HCIItems.ITEMS.register(modEventBus);
        Aliases.addAliases();
        HCICreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        HCIDataComponentTypes.DATA_COMPONENT_TYPES.register(modEventBus);
    }
}
