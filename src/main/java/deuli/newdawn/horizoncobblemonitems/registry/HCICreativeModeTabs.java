package deuli.newdawn.horizoncobblemonitems.registry;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HCICreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HorizonCobblemonItems.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HCI_TAB = CREATIVE_MODE_TABS.register("horizon_cobblemon_items_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.horizoncobblemonitems"))
                    .icon(() -> HCIItems.GOLDEN_BOTTLE_CAP.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(HCIItems.GOLDEN_BOTTLE_CAP.get());
                        output.accept(HCIItems.VOID_BOTTLE_CAP.get());

                        output.accept(HCIItems.SILVER_BOTTLE_CAP.get());
                        output.accept(HCIItems.HEALTH_BOTTLE_CAP.get());
                        output.accept(HCIItems.MIGHTY_BOTTLE_CAP.get());
                        output.accept(HCIItems.TOUGH_BOTTLE_CAP.get());
                        output.accept(HCIItems.SMART_BOTTLE_CAP.get());
                        output.accept(HCIItems.COURAGE_BOTTLE_CAP.get());
                        output.accept(HCIItems.QUICK_BOTTLE_CAP.get());

                        output.accept(HCIItems.OBSIDIAN_BOTTLE_CAP.get());
                        output.accept(HCIItems.SICKLY_BOTTLE_CAP.get());
                        output.accept(HCIItems.WEAK_BOTTLE_CAP.get());
                        output.accept(HCIItems.BRITTLE_BOTTLE_CAP.get());
                        output.accept(HCIItems.NUMB_BOTTLE_CAP.get());
                        output.accept(HCIItems.COWARD_BOTTLE_CAP.get());
                        output.accept(HCIItems.SLOW_BOTTLE_CAP.get());

                        output.accept(HCIItems.WOODEN_BOTTLE_CAP.get());

                        output.accept(HCIItems.BASKET_BALL.get());

                        output.accept(HCIItems.DEVOLUTION_SPRAY.get());

                        output.accept(HCIItems.COMMON_CANDY.get());
                        output.accept(HCIItems.UNCOMMON_CANDY.get());
                        output.accept(HCIItems.ULTRA_RARE_CANDY.get());

                        output.accept(HCIItems.ULTIMATE_MAC_AND_CHEESE.get());
                        output.accept(HCIItems.SPICY_MAC_AND_CHEESE.get());
                        output.accept(HCIItems.DRY_MAC_AND_CHEESE.get());
                        output.accept(HCIItems.SWEET_MAC_AND_CHEESE.get());
                        output.accept(HCIItems.SOUR_MAC_AND_CHEESE.get());
                        output.accept(HCIItems.BITTER_MAC_AND_CHEESE.get());

                        output.accept(HCIItems.GENDER_CHANGE_POTION.get());

                        output.accept(HCIItems.DAWN_BALL.get());

                        output.accept(HCIItems.AXIOM_BERRY.get());
                        output.accept(HCIItems.DISTORTED_POMEG_BERRY.get());
                        output.accept(HCIItems.DISTORTED_KELPSY_BERRY.get());
                        output.accept(HCIItems.DISTORTED_QUALOT_BERRY.get());
                        output.accept(HCIItems.DISTORTED_HONDEW_BERRY.get());
                        output.accept(HCIItems.DISTORTED_GREPA_BERRY.get());
                        output.accept(HCIItems.DISTORTED_TAMATO_BERRY.get());

                        output.accept(HCIItems.SHADOW_HEALTH_FEATHER.get());
                        output.accept(HCIItems.SHADOW_MUSCLE_FEATHER.get());
                        output.accept(HCIItems.SHADOW_RESIST_FEATHER.get());
                        output.accept(HCIItems.SHADOW_GENIUS_FEATHER.get());
                        output.accept(HCIItems.SHADOW_CLEVER_FEATHER.get());
                        output.accept(HCIItems.SHADOW_SWIFT_FEATHER.get());

                        output.accept(HCIItems.HEALTH_PHOENIX_FEATHER.get());
                        output.accept(HCIItems.MUSCLE_PHOENIX_FEATHER.get());
                        output.accept(HCIItems.RESIST_PHOENIX_FEATHER.get());
                        output.accept(HCIItems.GENIUS_PHOENIX_FEATHER.get());
                        output.accept(HCIItems.CLEVER_PHOENIX_FEATHER.get());
                        output.accept(HCIItems.SWIFT_PHOENIX_FEATHER.get());

                        output.accept(HCIItems.MAGIC_8_BALL.get());

                        output.accept(HCIItems.POKE_TREAT.get());
                        output.accept(HCIItems.STALE_POKE_TREAT.get());

                        output.accept(HCIItems.BLACK_HOLE_PONIGIRI.get());

                        output.accept(HCIItems.PRISMATIC_CARAT.get());
                        output.accept(HCIItems.YELLOW_CARAT.get());
                        output.accept(HCIItems.RED_CARAT.get());
                        output.accept(HCIItems.BLUE_CARAT.get());
                        output.accept(HCIItems.PINK_CARAT.get());
                        output.accept(HCIItems.GREEN_CARAT.get());
                        output.accept(HCIItems.CYAN_CARAT.get());
                    })
                    .build()
    );
}
