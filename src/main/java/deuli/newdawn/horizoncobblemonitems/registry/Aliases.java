package deuli.newdawn.horizoncobblemonitems.registry;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class Aliases {
    public static void addAliases() {
        HCIItems.ITEMS.addAlias(cobblemonUtility("goldencap"), HCIItems.GOLDEN_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("voidcap"), HCIItems.VOID_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("hpsilvercap"), HCIItems.HEALTH_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("atksilvercap"), HCIItems.MIGHTY_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("defsilvercap"), HCIItems.TOUGH_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("spatksilvercap"), HCIItems.SMART_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("spdefsilvercap"), HCIItems.COURAGE_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("speedsilvercap"), HCIItems.QUICK_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("hpobsidiancap"), HCIItems.SICKLY_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("atkobsidiancap"), HCIItems.WEAK_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("defobsidiancap"), HCIItems.BRITTLE_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("spatkobsidiancap"), HCIItems.NUMB_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("spdefobsidiancap"), HCIItems.COWARD_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("speedobsidiancap"), HCIItems.SLOW_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("woodencap"), HCIItems.WOODEN_BOTTLE_CAP.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("shinycard"), HCIItems.BASKET_BALL.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("devolutionrelic"), HCIItems.DEVOLUTION_SPRAY.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("commoncandy"), HCIItems.UNCOMMON_CANDY.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("mastercandy"), HCIItems.ULTRA_RARE_CANDY.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("transmutationorb"), HCIItems.GENDER_CHANGE_POTION.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("voidfeather"), HCIItems.AXIOM_BERRY.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("ballsynchronizer"), HCIItems.MAGIC_8_BALL.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("poketreat"), HCIItems.POKE_TREAT.getId());
        HCIItems.ITEMS.addAlias(cobblemonUtility("stalepoketreat"), HCIItems.STALE_POKE_TREAT.getId());
    }

    private static @NotNull ResourceLocation cobblemonUtility(String path) {
        return ResourceLocation.fromNamespaceAndPath("cobblemon_utility", path);
    }
}
