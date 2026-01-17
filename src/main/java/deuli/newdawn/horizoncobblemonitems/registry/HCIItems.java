package deuli.newdawn.horizoncobblemonitems.registry;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.riding.stats.RidingStat;
import com.cobblemon.mod.common.pokemon.EVs;
import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import deuli.newdawn.horizoncobblemonitems.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

public class HCIItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HorizonCobblemonItems.MOD_ID);

    public static final DeferredItem<Item> GOLDEN_BOTTLE_CAP = ITEMS.register("golden_bottle_cap", () -> new BottleCapItem(Rarity.EPIC, 31, Stats.Companion.getPERMANENT()));
    public static final DeferredItem<Item> VOID_BOTTLE_CAP = ITEMS.register("void_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Stats.Companion.getPERMANENT()));

    public static final DeferredItem<Item> SILVER_BOTTLE_CAP = ITEMS.register("silver_bottle_cap", () -> new SilverBottleCapItem(31));
    public static final DeferredItem<Item> HEALTH_BOTTLE_CAP = ITEMS.register("health_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 31, Set.of(Stats.HP)));
    public static final DeferredItem<Item> MIGHTY_BOTTLE_CAP = ITEMS.register("mighty_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 31, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> TOUGH_BOTTLE_CAP = ITEMS.register("tough_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 31, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> SMART_BOTTLE_CAP = ITEMS.register("smart_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 31, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> COURAGE_BOTTLE_CAP = ITEMS.register("courage_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 31, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> QUICK_BOTTLE_CAP = ITEMS.register("quick_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 31, Set.of(Stats.SPEED)));

    public static final DeferredItem<Item> OBSIDIAN_BOTTLE_CAP = ITEMS.register("obsidian_bottle_cap", () -> new SilverBottleCapItem(0));
    public static final DeferredItem<Item> SICKLY_BOTTLE_CAP = ITEMS.register("sickly_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Set.of(Stats.HP)));
    public static final DeferredItem<Item> WEAK_BOTTLE_CAP = ITEMS.register("weak_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> BRITTLE_BOTTLE_CAP = ITEMS.register("brittle_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> NUMB_BOTTLE_CAP = ITEMS.register("numb_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> COWARD_BOTTLE_CAP = ITEMS.register("coward_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> SLOW_BOTTLE_CAP = ITEMS.register("slow_bottle_cap", () -> new BottleCapItem(Rarity.RARE, 0, Set.of(Stats.SPEED)));

    public static final DeferredItem<Item> WOODEN_BOTTLE_CAP = ITEMS.register("wooden_bottle_cap", () -> new WoodenBottleCapItem(Stats.Companion.getPERMANENT()));

    public static final DeferredItem<Item> BASKET_BALL = ITEMS.register("basket_ball", BasketBallItem::new);

    public static final DeferredItem<Item> DEVOLUTION_SPRAY = ITEMS.register("devolution_spray", DevolutionSprayItem::new);

    public static final DeferredItem<Item> COMMON_CANDY = ITEMS.register("common_candy", () -> new LevelItem(Rarity.COMMON, 1));
    public static final DeferredItem<Item> UNCOMMON_CANDY = ITEMS.register("uncommon_candy", () -> new UncommonCandyItem(1));
    public static final DeferredItem<Item> ULTRA_RARE_CANDY = ITEMS.register("ultra_rare_candy", () -> new LevelItem(Rarity.EPIC, Cobblemon.config.getMaxPokemonLevel()));

    public static final DeferredItem<Item> ULTIMATE_MAC_AND_CHEESE = ITEMS.register("ultimate_mac_and_cheese", () -> new MacAndCheeseItem(Rarity.RARE, Set.of(RidingStat.ACCELERATION, RidingStat.SKILL, RidingStat.SPEED, RidingStat.STAMINA, RidingStat.JUMP)));
    public static final DeferredItem<Item> SPICY_MAC_AND_CHEESE = ITEMS.register("spicy_mac_and_cheese", () -> new MacAndCheeseItem(Rarity.UNCOMMON, Set.of(RidingStat.ACCELERATION)));
    public static final DeferredItem<Item> DRY_MAC_AND_CHEESE = ITEMS.register("dry_mac_and_cheese", () -> new MacAndCheeseItem(Rarity.UNCOMMON, Set.of(RidingStat.SKILL)));
    public static final DeferredItem<Item> SWEET_MAC_AND_CHEESE = ITEMS.register("sweet_mac_and_cheese", () -> new MacAndCheeseItem(Rarity.UNCOMMON, Set.of(RidingStat.SPEED)));
    public static final DeferredItem<Item> SOUR_MAC_AND_CHEESE = ITEMS.register("sour_mac_and_cheese", () -> new MacAndCheeseItem(Rarity.UNCOMMON, Set.of(RidingStat.STAMINA)));
    public static final DeferredItem<Item> BITTER_MAC_AND_CHEESE = ITEMS.register("bitter_mac_and_cheese", () -> new MacAndCheeseItem(Rarity.UNCOMMON, Set.of(RidingStat.JUMP)));

    public static final DeferredItem<Item> GENDER_CHANGE_POTION = ITEMS.register("gender_change_potion", GenderChangePotionItem::new);

    public static final DeferredItem<Item> DAWN_BALL = ITEMS.register("dawn_ball", DawnBall::new);

    public static final DeferredItem<Item> AXIOM_BERRY = ITEMS.register("axiom_berry", () -> new EVSetItem(Rarity.RARE, 0, Stats.Companion.getPERMANENT()));
    public static final DeferredItem<Item> DISTORTED_POMEG_BERRY = ITEMS.register("distorted_pomeg_berry", () -> new EVSetItem(Rarity.RARE, 0, Set.of(Stats.HP)));
    public static final DeferredItem<Item> DISTORTED_KELPSY_BERRY = ITEMS.register("distorted_kelpsy_berry", () -> new EVSetItem(Rarity.RARE, 0, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> DISTORTED_QUALOT_BERRY = ITEMS.register("distorted_qualot_berry", () -> new EVSetItem(Rarity.RARE, 0, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> DISTORTED_HONDEW_BERRY = ITEMS.register("distorted_hondew_berry", () -> new EVSetItem(Rarity.RARE, 0, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> DISTORTED_GREPA_BERRY = ITEMS.register("distorted_grepa_berry", () -> new EVSetItem(Rarity.RARE, 0, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> DISTORTED_TAMATO_BERRY = ITEMS.register("distorted_tamato_berry", () -> new EVSetItem(Rarity.RARE, 0, Set.of(Stats.SPEED)));

    public static final DeferredItem<Item> SHADOW_HEALTH_FEATHER = ITEMS.register("shadow_health_feather", () -> new EVDecreaseItem(Stats.HP, -1));
    public static final DeferredItem<Item> SHADOW_MUSCLE_FEATHER = ITEMS.register("shadow_muscle_feather", () -> new EVDecreaseItem(Stats.ATTACK, -1));
    public static final DeferredItem<Item> SHADOW_RESIST_FEATHER = ITEMS.register("shadow_resist_feather", () -> new EVDecreaseItem(Stats.DEFENCE, -1));
    public static final DeferredItem<Item> SHADOW_GENIUS_FEATHER = ITEMS.register("shadow_genius_feather", () -> new EVDecreaseItem(Stats.SPECIAL_ATTACK, -1));
    public static final DeferredItem<Item> SHADOW_CLEVER_FEATHER = ITEMS.register("shadow_clever_feather", () -> new EVDecreaseItem(Stats.SPECIAL_DEFENCE, -1));
    public static final DeferredItem<Item> SHADOW_SWIFT_FEATHER = ITEMS.register("shadow_swift_feather", () -> new EVDecreaseItem(Stats.SPEED, -1));

    public static final DeferredItem<Item> HEALTH_PHOENIX_FEATHER = ITEMS.register("health_phoenix_feather", () -> new EVSetItem(Rarity.EPIC, EVs.MAX_STAT_VALUE, Set.of(Stats.HP)));
    public static final DeferredItem<Item> MUSCLE_PHOENIX_FEATHER = ITEMS.register("muscle_phoenix_feather", () -> new EVSetItem(Rarity.EPIC, EVs.MAX_STAT_VALUE, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> RESIST_PHOENIX_FEATHER = ITEMS.register("resist_phoenix_feather", () -> new EVSetItem(Rarity.EPIC, EVs.MAX_STAT_VALUE, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> GENIUS_PHOENIX_FEATHER = ITEMS.register("genius_phoenix_feather", () -> new EVSetItem(Rarity.EPIC, EVs.MAX_STAT_VALUE, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> CLEVER_PHOENIX_FEATHER = ITEMS.register("clever_phoenix_feather", () -> new EVSetItem(Rarity.EPIC, EVs.MAX_STAT_VALUE, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> SWIFT_PHOENIX_FEATHER = ITEMS.register("swift_phoenix_feather", () -> new EVSetItem(Rarity.EPIC, EVs.MAX_STAT_VALUE, Set.of(Stats.SPEED)));

    public static final DeferredItem<Item> MAGIC_8_BALL = ITEMS.register("magic_8_ball", Magic8BallItem::new);

    public static final DeferredItem<Item> POKE_TREAT = ITEMS.register("poke_treat", () -> new PokeTreatItem(Rarity.RARE, Cobblemon.config.getMaxPokemonFriendship()));
    public static final DeferredItem<Item> STALE_POKE_TREAT = ITEMS.register("stale_poke_treat", () -> new PokeTreatItem(Rarity.UNCOMMON, 0));

    public static final DeferredItem<Item> BLACK_HOLE_PONIGIRI = ITEMS.register("black_hole_ponigiri", () -> new BlackHolePonigiri(0));

    public static final DeferredItem<Item> PRISMATIC_CARAT = ITEMS.register("prismatic_carat", () -> new CaratItem(Rarity.EPIC, Stats.Companion.getPERMANENT()));
    public static final DeferredItem<Item> YELLOW_CARAT = ITEMS.register("yellow_carat", () -> new CaratItem(Rarity.RARE, Set.of(Stats.HP)));
    public static final DeferredItem<Item> RED_CARAT = ITEMS.register("red_carat", () -> new CaratItem(Rarity.RARE, Set.of(Stats.ATTACK)));
    public static final DeferredItem<Item> BLUE_CARAT = ITEMS.register("blue_carat", () -> new CaratItem(Rarity.RARE, Set.of(Stats.DEFENCE)));
    public static final DeferredItem<Item> PINK_CARAT = ITEMS.register("pink_carat", () -> new CaratItem(Rarity.RARE, Set.of(Stats.SPECIAL_ATTACK)));
    public static final DeferredItem<Item> GREEN_CARAT = ITEMS.register("green_carat", () -> new CaratItem(Rarity.RARE, Set.of(Stats.SPECIAL_DEFENCE)));
    public static final DeferredItem<Item> CYAN_CARAT = ITEMS.register("cyan_carat", () -> new CaratItem(Rarity.RARE, Set.of(Stats.SPEED)));
}
