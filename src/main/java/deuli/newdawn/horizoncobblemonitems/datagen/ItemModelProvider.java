package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HorizonCobblemonItems.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(HorizonCobblemonItems.GOLDEN_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.VOID_BOTTLE_CAP.get());

        basicItem(HorizonCobblemonItems.SILVER_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.HEALTH_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.TOUGH_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.SMART_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.COURAGE_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.QUICK_BOTTLE_CAP.get());

        basicItem(HorizonCobblemonItems.OBSIDIAN_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.SICKLY_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.WEAK_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.BRITTLE_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.NUMB_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.COWARD_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.SLOW_BOTTLE_CAP.get());

        basicItem(HorizonCobblemonItems.DEVOLUTION_SPRAY.get());

        basicItem(HorizonCobblemonItems.ULTRA_RARE_CANDY.get());

        basicItem(HorizonCobblemonItems.ULTIMATE_MAC_AND_CHEESE.get());
        basicItem(HorizonCobblemonItems.SPICY_MAC_AND_CHEESE.get());
        basicItem(HorizonCobblemonItems.DRY_MAC_AND_CHEESE.get());
        basicItem(HorizonCobblemonItems.SWEET_MAC_AND_CHEESE.get());
        basicItem(HorizonCobblemonItems.SOUR_MAC_AND_CHEESE.get());
        basicItem(HorizonCobblemonItems.BITTER_MAC_AND_CHEESE.get());

        basicItem(HorizonCobblemonItems.GENDER_CHANGE_POTION.get());

        basicItem(HorizonCobblemonItems.AXIOM_BERRY.get());
        basicItem(HorizonCobblemonItems.DISTORTED_POMEG_BERRY.get());
        basicItem(HorizonCobblemonItems.DISTORTED_KELPSY_BERRY.get());
        basicItem(HorizonCobblemonItems.DISTORTED_QUALOT_BERRY.get());
        basicItem(HorizonCobblemonItems.DISTORTED_HONDEW_BERRY.get());
        basicItem(HorizonCobblemonItems.DISTORTED_GREPA_BERRY.get());
        basicItem(HorizonCobblemonItems.DISTORTED_TAMATO_BERRY.get());

        basicItem(HorizonCobblemonItems.SHADOW_HEALTH_FEATHER.get());
        basicItem(HorizonCobblemonItems.SHADOW_MUSCLE_FEATHER.get());
        basicItem(HorizonCobblemonItems.SHADOW_RESIST_FEATHER.get());
        basicItem(HorizonCobblemonItems.SHADOW_GENIUS_FEATHER.get());
        basicItem(HorizonCobblemonItems.SHADOW_CLEVER_FEATHER.get());
        basicItem(HorizonCobblemonItems.SHADOW_SWIFT_FEATHER.get());

        basicItem(HorizonCobblemonItems.HEALTH_PHOENIX_FEATHER.get());
        basicItem(HorizonCobblemonItems.MUSCLE_PHOENIX_FEATHER.get());
        basicItem(HorizonCobblemonItems.RESIST_PHOENIX_FEATHER.get());
        basicItem(HorizonCobblemonItems.GENIUS_PHOENIX_FEATHER.get());
        basicItem(HorizonCobblemonItems.CLEVER_PHOENIX_FEATHER.get());
        basicItem(HorizonCobblemonItems.SWIFT_PHOENIX_FEATHER.get());

        basicItem(HorizonCobblemonItems.MAGIC_8_BALL.get());
    }
}
