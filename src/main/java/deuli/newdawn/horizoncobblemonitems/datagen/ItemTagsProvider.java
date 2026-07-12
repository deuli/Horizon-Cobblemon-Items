package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import deuli.newdawn.horizoncobblemonitems.registry.HCIItemTags;
import deuli.newdawn.horizoncobblemonitems.registry.HCIItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTagsProvider extends net.minecraft.data.tags.ItemTagsProvider {
    public ItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(output, lookupProvider, blockTags.contentsGetter(), HorizonCobblemonItems.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(HCIItemTags.BOTTLE_CAPS)
                .add(
                        HCIItems.GOLDEN_BOTTLE_CAP.get(),
                        HCIItems.VOID_BOTTLE_CAP.get(),
                        HCIItems.WOODEN_BOTTLE_CAP.get()
                )
                .addTag(HCIItemTags.SILVER_BOTTLE_CAPS)
                .addTag(HCIItemTags.OBSIDIAN_BOTTLE_CAPS);

        tag(HCIItemTags.SPECIFIC_SILVER_BOTTLE_CAPS)
                .add(
                        HCIItems.HEALTH_BOTTLE_CAP.get(),
                        HCIItems.MIGHTY_BOTTLE_CAP.get(),
                        HCIItems.TOUGH_BOTTLE_CAP.get(),
                        HCIItems.SMART_BOTTLE_CAP.get(),
                        HCIItems.COURAGE_BOTTLE_CAP.get(),
                        HCIItems.QUICK_BOTTLE_CAP.get()
                );

        tag(HCIItemTags.SILVER_BOTTLE_CAPS)
                .add(HCIItems.SILVER_BOTTLE_CAP.get())
                .addTag(HCIItemTags.SPECIFIC_SILVER_BOTTLE_CAPS);

        tag(HCIItemTags.SPECIFIC_OBSIDIAN_BOTTLE_CAPS)
                .add(
                        HCIItems.SICKLY_BOTTLE_CAP.get(),
                        HCIItems.WEAK_BOTTLE_CAP.get(),
                        HCIItems.BRITTLE_BOTTLE_CAP.get(),
                        HCIItems.NUMB_BOTTLE_CAP.get(),
                        HCIItems.COWARD_BOTTLE_CAP.get(),
                        HCIItems.SLOW_BOTTLE_CAP.get()
                );

        tag(HCIItemTags.OBSIDIAN_BOTTLE_CAPS)
                .add(HCIItems.OBSIDIAN_BOTTLE_CAP.get())
                .addTag(HCIItemTags.SPECIFIC_OBSIDIAN_BOTTLE_CAPS);

        tag(HCIItemTags.CANDIES)
                .add(
                        HCIItems.COMMON_CANDY.get(),
                        HCIItems.UNCOMMON_CANDY.get(),
                        HCIItems.ULTRA_RARE_CANDY.get()
                );

        tag(HCIItemTags.FLAVOR_MAC_AND_CHEESE)
                .add(
                        HCIItems.SPICY_MAC_AND_CHEESE.get(),
                        HCIItems.DRY_MAC_AND_CHEESE.get(),
                        HCIItems.SWEET_MAC_AND_CHEESE.get(),
                        HCIItems.SOUR_MAC_AND_CHEESE.get(),
                        HCIItems.BITTER_MAC_AND_CHEESE.get()
                );

        tag(HCIItemTags.MAC_AND_CHEESE)
                .add(HCIItems.ULTIMATE_MAC_AND_CHEESE.get())
                .addTag(HCIItemTags.FLAVOR_MAC_AND_CHEESE);

        tag(HCIItemTags.DISTORTED_BERRIES)
                .add(
                        HCIItems.DISTORTED_POMEG_BERRY.get(),
                        HCIItems.DISTORTED_KELPSY_BERRY.get(),
                        HCIItems.DISTORTED_QUALOT_BERRY.get(),
                        HCIItems.DISTORTED_HONDEW_BERRY.get(),
                        HCIItems.DISTORTED_GREPA_BERRY.get(),
                        HCIItems.DISTORTED_TAMATO_BERRY.get()
                );

        tag(HCIItemTags.BERRIES)
                .add(HCIItems.AXIOM_BERRY.get())
                .addTag(HCIItemTags.DISTORTED_BERRIES);

        tag(HCIItemTags.SHADOW_FEATHERS)
                .add(
                        HCIItems.SHADOW_HEALTH_FEATHER.get(),
                        HCIItems.SHADOW_MUSCLE_FEATHER.get(),
                        HCIItems.SHADOW_RESIST_FEATHER.get(),
                        HCIItems.SHADOW_GENIUS_FEATHER.get(),
                        HCIItems.SHADOW_CLEVER_FEATHER.get(),
                        HCIItems.SHADOW_SWIFT_FEATHER.get()
                );

        tag(HCIItemTags.PHOENIX_FEATHERS)
                .add(
                        HCIItems.HEALTH_PHOENIX_FEATHER.get(),
                        HCIItems.MUSCLE_PHOENIX_FEATHER.get(),
                        HCIItems.RESIST_PHOENIX_FEATHER.get(),
                        HCIItems.GENIUS_PHOENIX_FEATHER.get(),
                        HCIItems.CLEVER_PHOENIX_FEATHER.get(),
                        HCIItems.SWIFT_PHOENIX_FEATHER.get()
                );

        tag(HCIItemTags.FEATHERS)
                .addTag(HCIItemTags.SHADOW_FEATHERS)
                .addTag(HCIItemTags.PHOENIX_FEATHERS);

        tag(HCIItemTags.POKE_TREATS)
                .add(
                        HCIItems.POKE_TREAT.get(),
                        HCIItems.STALE_POKE_TREAT.get()
                );

        tag(HCIItemTags.COLOR_CARATS)
                .add(
                        HCIItems.YELLOW_CARAT.get(),
                        HCIItems.RED_CARAT.get(),
                        HCIItems.BLUE_CARAT.get(),
                        HCIItems.PINK_CARAT.get(),
                        HCIItems.GREEN_CARAT.get(),
                        HCIItems.CYAN_CARAT.get()
                );

        tag(HCIItemTags.CARATS)
                .add(HCIItems.PRISMATIC_CARAT.get())
                .addTag(HCIItemTags.COLOR_CARATS);

        tag(HCIItemTags.PORYPHONES)
                .add(
                        HCIItems.PORYPHONE.get(),
                        HCIItems.PORYPHONE2.get()
                );

        tag(HCIItemTags.SET_HIDDEN_MACHINES)
                .add(
                        HCIItems.TM_HIDDEN_MACHINE.get(),
                        HCIItems.EGG_HIDDEN_MACHINE.get(),
                        HCIItems.TUTOR_HIDDEN_MACHINE.get(),
                        HCIItems.LEGACY_HIDDEN_MACHINE.get(),
                        HCIItems.SPECIAL_HIDDEN_MACHINE.get()
                );

        tag(HCIItemTags.HIDDEN_MACHINES)
                .add(HCIItems.OMNIPOTENT_HIDDEN_MACHINE.get())
                .addTag(HCIItemTags.SET_HIDDEN_MACHINES);

        tag(HCIItemTags.IV_ITEMS)
                .addTag(HCIItemTags.BOTTLE_CAPS)
                .addTag(HCIItemTags.CARATS);

        tag(HCIItemTags.EV_ITEMS)
                .addTag(HCIItemTags.BERRIES)
                .addTag(HCIItemTags.FEATHERS);
    }
}
