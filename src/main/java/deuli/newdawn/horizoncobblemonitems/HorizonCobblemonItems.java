package deuli.newdawn.horizoncobblemonitems;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.riding.stats.RidingStat;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import deuli.newdawn.horizoncobblemonitems.item.*;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.Set;
import java.util.function.UnaryOperator;

@Mod(HorizonCobblemonItems.MOD_ID)
public class HorizonCobblemonItems {
    public static final String MOD_ID = "horizoncobblemonitems";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MOD_ID);

    public static final DeferredItem<Item> GOLDEN_BOTTLE_CAP = ITEMS.register("golden_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.HP, Stats.ATTACK, Stats.DEFENCE, Stats.SPECIAL_ATTACK, Stats.SPECIAL_DEFENCE, Stats.SPEED)));
    public static final DeferredItem<Item> VOID_BOTTLE_CAP = ITEMS.register("void_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.HP, Stats.ATTACK, Stats.DEFENCE, Stats.SPECIAL_ATTACK, Stats.SPECIAL_DEFENCE, Stats.SPEED)));

    public static final DeferredItem<Item> SILVER_BOTTLE_CAP = ITEMS.register("silver_bottle_cap", () -> new SilverBottleCapItem(31));
    public static final DeferredItem<Item> HEALTH_BOTTLE_CAP = ITEMS.register("health_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.HP)));
    public static final DeferredItem<Item> MIGHTY_BOTTLE_CAP = ITEMS.register("mighty_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> TOUGH_BOTTLE_CAP = ITEMS.register("tough_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> SMART_BOTTLE_CAP = ITEMS.register("smart_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> COURAGE_BOTTLE_CAP = ITEMS.register("courage_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> QUICK_BOTTLE_CAP = ITEMS.register("quick_bottle_cap", () -> new BottleCapItem(31, Set.of(Stats.SPEED)));

    public static final DeferredItem<Item> OBSIDIAN_BOTTLE_CAP = ITEMS.register("obsidian_bottle_cap", () -> new SilverBottleCapItem(0));
    public static final DeferredItem<Item> SICKLY_BOTTLE_CAP = ITEMS.register("sickly_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.HP)));
    public static final DeferredItem<Item> WEAK_BOTTLE_CAP = ITEMS.register("weak_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> BRITTLE_BOTTLE_CAP = ITEMS.register("brittle_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> NUMB_BOTTLE_CAP = ITEMS.register("numb_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> COWARD_BOTTLE_CAP = ITEMS.register("coward_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> SLOW_BOTTLE_CAP = ITEMS.register("slow_bottle_cap", () -> new BottleCapItem(0, Set.of(Stats.SPEED)));

    public static final DeferredItem<Item> BASKET_BALL = ITEMS.register("basket_ball", BasketBallItem::new);

    public static final DeferredItem<Item> DEVOLUTION_SPRAY = ITEMS.register("devolution_spray", DevolutionSprayItem::new);

    public static final DeferredItem<Item> ULTRA_RARE_CANDY = ITEMS.register("ultra_rare_candy", () -> new LevelItem(Cobblemon.config.getMaxPokemonLevel()));

    public static final DeferredItem<Item> ULTIMATE_MAC_AND_CHEESE = ITEMS.register("ultimate_mac_and_cheese", () -> new MacAndCheeseItem(Set.of(RidingStat.ACCELERATION, RidingStat.SKILL, RidingStat.SPEED, RidingStat.STAMINA, RidingStat.JUMP)));
    public static final DeferredItem<Item> SPICY_MAC_AND_CHEESE = ITEMS.register("spicy_mac_and_cheese", () -> new MacAndCheeseItem(Set.of(RidingStat.ACCELERATION)));
    public static final DeferredItem<Item> DRY_MAC_AND_CHEESE = ITEMS.register("dry_mac_and_cheese", () -> new MacAndCheeseItem(Set.of(RidingStat.SKILL)));
    public static final DeferredItem<Item> SWEET_MAC_AND_CHEESE = ITEMS.register("sweet_mac_and_cheese", () -> new MacAndCheeseItem(Set.of(RidingStat.SPEED)));
    public static final DeferredItem<Item> SOUR_MAC_AND_CHEESE = ITEMS.register("sour_mac_and_cheese", () -> new MacAndCheeseItem(Set.of(RidingStat.STAMINA)));
    public static final DeferredItem<Item> BITTER_MAC_AND_CHEESE = ITEMS.register("bitter_mac_and_cheese", () -> new MacAndCheeseItem(Set.of(RidingStat.JUMP)));

    public static final DeferredItem<Item> GENDER_CHANGE_POTION = ITEMS.register("gender_change_potion", GenderChangePotionItem::new);

    public static final DeferredItem<Item> DAWN_BALL = ITEMS.register("dawn_ball", DawnBall::new);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HCI_TAB = CREATIVE_MODE_TABS.register("horizon_cobblemon_items_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.horizoncobblemonitems"))
                    .icon(() -> GOLDEN_BOTTLE_CAP.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(GOLDEN_BOTTLE_CAP.get());
                        output.accept(VOID_BOTTLE_CAP.get());

                        output.accept(SILVER_BOTTLE_CAP.get());
                        output.accept(HEALTH_BOTTLE_CAP.get());
                        output.accept(MIGHTY_BOTTLE_CAP.get());
                        output.accept(TOUGH_BOTTLE_CAP.get());
                        output.accept(SMART_BOTTLE_CAP.get());
                        output.accept(COURAGE_BOTTLE_CAP.get());
                        output.accept(QUICK_BOTTLE_CAP.get());

                        output.accept(OBSIDIAN_BOTTLE_CAP.get());
                        output.accept(SICKLY_BOTTLE_CAP.get());
                        output.accept(WEAK_BOTTLE_CAP.get());
                        output.accept(BRITTLE_BOTTLE_CAP.get());
                        output.accept(NUMB_BOTTLE_CAP.get());
                        output.accept(COWARD_BOTTLE_CAP.get());
                        output.accept(SLOW_BOTTLE_CAP.get());

                        output.accept(BASKET_BALL.get());

                        output.accept(DEVOLUTION_SPRAY.get());

                        output.accept(ULTRA_RARE_CANDY.get());

                        output.accept(ULTIMATE_MAC_AND_CHEESE.get());
                        output.accept(SPICY_MAC_AND_CHEESE.get());
                        output.accept(DRY_MAC_AND_CHEESE.get());
                        output.accept(SWEET_MAC_AND_CHEESE.get());
                        output.accept(SOUR_MAC_AND_CHEESE.get());
                        output.accept(BITTER_MAC_AND_CHEESE.get());

                        output.accept(GENDER_CHANGE_POTION.get());

                        output.accept(DAWN_BALL.get());
                    })
                    .build()
    );


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> POKEMON_PROPERTIES = register("pokemon_properties", builder -> builder.persistent(Codec.STRING));

    public HorizonCobblemonItems(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        DATA_COMPONENT_TYPES.register(modEventBus);
    }

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return DATA_COMPONENT_TYPES.register(name, () -> builder.apply(DataComponentType.builder()).build());
    }
}
