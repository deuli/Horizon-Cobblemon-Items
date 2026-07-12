package deuli.newdawn.horizoncobblemonitems.registry;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class HCIItemTags {
    public static final TagKey<Item> BOTTLE_CAPS = createTag("bottle_caps");
    public static final TagKey<Item> SPECIFIC_SILVER_BOTTLE_CAPS = createTag("specific_silver_bottle_caps");
    public static final TagKey<Item> SILVER_BOTTLE_CAPS = createTag("silver_bottle_caps");
    public static final TagKey<Item> SPECIFIC_OBSIDIAN_BOTTLE_CAPS = createTag("specific_obsidian_bottle_caps");
    public static final TagKey<Item> OBSIDIAN_BOTTLE_CAPS = createTag("obsidian_bottle_caps");

    public static final TagKey<Item> CANDIES = createTag("candies");

    public static final TagKey<Item> FLAVOR_MAC_AND_CHEESE = createTag("flavor_mac_and_cheese");
    public static final TagKey<Item> MAC_AND_CHEESE = createTag("mac_and_cheese");

    public static final TagKey<Item> DISTORTED_BERRIES = createTag("distorted_berries");
    public static final TagKey<Item> BERRIES = createTag("berries");

    public static final TagKey<Item> SHADOW_FEATHERS = createTag("shadow_feathers");
    public static final TagKey<Item> PHOENIX_FEATHERS = createTag("phoenix_feathers");
    public static final TagKey<Item> FEATHERS = createTag("feathers");

    public static final TagKey<Item> POKE_TREATS = createTag("poke_treats");

    public static final TagKey<Item> COLOR_CARATS = createTag("color_carats");
    public static final TagKey<Item> CARATS = createTag("carats");

    public static final TagKey<Item> PORYPHONES = createTag("poryphones");

    public static final TagKey<Item> SET_HIDDEN_MACHINES = createTag("set_hidden_machines");
    public static final TagKey<Item> HIDDEN_MACHINES = createTag("hidden_machines");

    private static TagKey<Item> createTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(HorizonCobblemonItems.MOD_ID, path));
    }
}
