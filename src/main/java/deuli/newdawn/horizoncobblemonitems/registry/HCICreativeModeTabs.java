package deuli.newdawn.horizoncobblemonitems.registry;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionColored;
import net.mcexpanded.fancytabsections.Section.SectionTextured;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jline.utils.Colors;

import java.awt.*;

public class HCICreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HorizonCobblemonItems.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HCI_TAB = CREATIVE_MODE_TABS.register("horizon_cobblemon_items_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.horizoncobblemonitems"))
                    .icon(() -> HCIItems.GOLDEN_BOTTLE_CAP.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        HCICreativeModeTabs.CREATIVE_MODE_TABS.register(eventBus);

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("bottle_caps"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.bottle_caps"))
                        .setBannerColor(new Color(0xF8E981).getRGB())
                        .setTextColor(new Color(0xF81D1D).getRGB())
                        .add(HCIItems.GOLDEN_BOTTLE_CAP)
                        .add(HCIItems.VOID_BOTTLE_CAP)

                        .add(HCIItems.SILVER_BOTTLE_CAP)
                        .add(HCIItems.HEALTH_BOTTLE_CAP)
                        .add(HCIItems.MIGHTY_BOTTLE_CAP)
                        .add(HCIItems.TOUGH_BOTTLE_CAP)
                        .add(HCIItems.SMART_BOTTLE_CAP)
                        .add(HCIItems.COURAGE_BOTTLE_CAP)
                        .add(HCIItems.QUICK_BOTTLE_CAP)

                        .add(HCIItems.OBSIDIAN_BOTTLE_CAP)
                        .add(HCIItems.SICKLY_BOTTLE_CAP)
                        .add(HCIItems.WEAK_BOTTLE_CAP)
                        .add(HCIItems.BRITTLE_BOTTLE_CAP)
                        .add(HCIItems.NUMB_BOTTLE_CAP)
                        .add(HCIItems.COWARD_BOTTLE_CAP)
                        .add(HCIItems.SLOW_BOTTLE_CAP)

                        .add(HCIItems.WOODEN_BOTTLE_CAP)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionTextured(HorizonCobblemonItems.rl("carats"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.carats"))
                        .add(HCIItems.PRISMATIC_CARAT)
                        .add(HCIItems.YELLOW_CARAT)
                        .add(HCIItems.RED_CARAT)
                        .add(HCIItems.BLUE_CARAT)
                        .add(HCIItems.PINK_CARAT)
                        .add(HCIItems.GREEN_CARAT)
                        .add(HCIItems.CYAN_CARAT)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("ev"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.ev"))
                        .setBannerColor(new Color(0xB7B75A).getRGB())
                        .add(HCIItems.AXIOM_BERRY)
                        .add(HCIItems.DISTORTED_POMEG_BERRY)
                        .add(HCIItems.DISTORTED_KELPSY_BERRY)
                        .add(HCIItems.DISTORTED_QUALOT_BERRY)
                        .add(HCIItems.DISTORTED_HONDEW_BERRY)
                        .add(HCIItems.DISTORTED_GREPA_BERRY)
                        .add(HCIItems.DISTORTED_TAMATO_BERRY)

                        .add(HCIItems.SHADOW_HEALTH_FEATHER)
                        .add(HCIItems.SHADOW_MUSCLE_FEATHER)
                        .add(HCIItems.SHADOW_RESIST_FEATHER)
                        .add(HCIItems.SHADOW_GENIUS_FEATHER)
                        .add(HCIItems.SHADOW_CLEVER_FEATHER)
                        .add(HCIItems.SHADOW_SWIFT_FEATHER)

                        .add(HCIItems.HEALTH_PHOENIX_FEATHER)
                        .add(HCIItems.MUSCLE_PHOENIX_FEATHER)
                        .add(HCIItems.RESIST_PHOENIX_FEATHER)
                        .add(HCIItems.GENIUS_PHOENIX_FEATHER)
                        .add(HCIItems.CLEVER_PHOENIX_FEATHER)
                        .add(HCIItems.SWIFT_PHOENIX_FEATHER)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("level"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.level"))
                        .setBannerColor(new Color(0x33A6D6).getRGB())
                        .add(HCIItems.COMMON_CANDY)
                        .add(HCIItems.UNCOMMON_CANDY)
                        .add(HCIItems.ULTRA_RARE_CANDY)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("riding"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.riding"))
                        .setBannerColor(new Color(0x53C29E).getRGB())
                        .add(HCIItems.ULTIMATE_MAC_AND_CHEESE)
                        .add(HCIItems.SPICY_MAC_AND_CHEESE)
                        .add(HCIItems.DRY_MAC_AND_CHEESE)
                        .add(HCIItems.SWEET_MAC_AND_CHEESE)
                        .add(HCIItems.SOUR_MAC_AND_CHEESE)
                        .add(HCIItems.BITTER_MAC_AND_CHEESE)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("moves"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.moves"))
                        .setBannerColor(new Color(0x53C8D5).getRGB())
                        .add(HCIItems.OMNIPOTENT_HIDDEN_MACHINE)
                        .add(HCIItems.TM_HIDDEN_MACHINE)
                        .add(HCIItems.EGG_HIDDEN_MACHINE)
                        .add(HCIItems.TUTOR_HIDDEN_MACHINE)
                        .add(HCIItems.LEGACY_HIDDEN_MACHINE)
                        .add(HCIItems.SPECIAL_HIDDEN_MACHINE)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("friendship"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.friendship"))
                        .setBannerColor(new Color(0xFF4766).getRGB())
                        .add(HCIItems.POKE_TREAT)
                        .add(HCIItems.STALE_POKE_TREAT)
        );

        FancyTabSections.addSection(HorizonCobblemonItems.rl("horizon_cobblemon_items_tab"),
                new SectionColored(HorizonCobblemonItems.rl("other"))
                        .setTitle(Component.translatable("itemGroup.horizoncobblemonitems.other"))
                        .setBannerColor(new Color(0x141414).getRGB())
                        .setTextColor(new Color(0xFCDA31).getRGB())
                        .add(HCIItems.BASKET_BALL)
                        .add(HCIItems.DEVOLUTION_SPRAY)
                        .add(HCIItems.GENDER_CHANGE_POTION)
                        .add(HCIItems.MAGIC_8_BALL)
                        .add(HCIItems.BLACK_HOLE_PONIGIRI)
                        .add(HCIItems.PORYPHONE)
                        .add(HCIItems.PORYPHONE2)
                        .add(HCIItems.DAWN_BALL)
                        .add(HCIItems.BATTLE_GLOVE)
        );
    }
}
