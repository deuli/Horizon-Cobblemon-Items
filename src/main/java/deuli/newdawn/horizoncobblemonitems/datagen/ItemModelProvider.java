package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import deuli.newdawn.horizoncobblemonitems.registry.HCIItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HorizonCobblemonItems.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(HCIItems.GOLDEN_BOTTLE_CAP.get());
        basicItem(HCIItems.VOID_BOTTLE_CAP.get());

        basicItem(HCIItems.SILVER_BOTTLE_CAP.get());
        basicItem(HCIItems.HEALTH_BOTTLE_CAP.get());
        basicItem(HCIItems.MIGHTY_BOTTLE_CAP.get());
        basicItem(HCIItems.TOUGH_BOTTLE_CAP.get());
        basicItem(HCIItems.SMART_BOTTLE_CAP.get());
        basicItem(HCIItems.COURAGE_BOTTLE_CAP.get());
        basicItem(HCIItems.QUICK_BOTTLE_CAP.get());

        basicItem(HCIItems.OBSIDIAN_BOTTLE_CAP.get());
        basicItem(HCIItems.SICKLY_BOTTLE_CAP.get());
        basicItem(HCIItems.WEAK_BOTTLE_CAP.get());
        basicItem(HCIItems.BRITTLE_BOTTLE_CAP.get());
        basicItem(HCIItems.NUMB_BOTTLE_CAP.get());
        basicItem(HCIItems.COWARD_BOTTLE_CAP.get());
        basicItem(HCIItems.SLOW_BOTTLE_CAP.get());

        basicItem(HCIItems.WOODEN_BOTTLE_CAP.get());

        basicItem(HCIItems.DEVOLUTION_SPRAY.get());

        basicItem(HCIItems.COMMON_CANDY.get());
        basicItem(HCIItems.UNCOMMON_CANDY.get());
        basicItem(HCIItems.ULTRA_RARE_CANDY.get());

        basicItem(HCIItems.ULTIMATE_MAC_AND_CHEESE.get());
        basicItem(HCIItems.SPICY_MAC_AND_CHEESE.get());
        basicItem(HCIItems.DRY_MAC_AND_CHEESE.get());
        basicItem(HCIItems.SWEET_MAC_AND_CHEESE.get());
        basicItem(HCIItems.SOUR_MAC_AND_CHEESE.get());
        basicItem(HCIItems.BITTER_MAC_AND_CHEESE.get());

        basicItem(HCIItems.GENDER_CHANGE_POTION.get());

        basicItem(HCIItems.AXIOM_BERRY.get());
        basicItem(HCIItems.DISTORTED_POMEG_BERRY.get());
        basicItem(HCIItems.DISTORTED_KELPSY_BERRY.get());
        basicItem(HCIItems.DISTORTED_QUALOT_BERRY.get());
        basicItem(HCIItems.DISTORTED_HONDEW_BERRY.get());
        basicItem(HCIItems.DISTORTED_GREPA_BERRY.get());
        basicItem(HCIItems.DISTORTED_TAMATO_BERRY.get());

        basicItem(HCIItems.SHADOW_HEALTH_FEATHER.get());
        basicItem(HCIItems.SHADOW_MUSCLE_FEATHER.get());
        basicItem(HCIItems.SHADOW_RESIST_FEATHER.get());
        basicItem(HCIItems.SHADOW_GENIUS_FEATHER.get());
        basicItem(HCIItems.SHADOW_CLEVER_FEATHER.get());
        basicItem(HCIItems.SHADOW_SWIFT_FEATHER.get());

        basicItem(HCIItems.HEALTH_PHOENIX_FEATHER.get());
        basicItem(HCIItems.MUSCLE_PHOENIX_FEATHER.get());
        basicItem(HCIItems.RESIST_PHOENIX_FEATHER.get());
        basicItem(HCIItems.GENIUS_PHOENIX_FEATHER.get());
        basicItem(HCIItems.CLEVER_PHOENIX_FEATHER.get());
        basicItem(HCIItems.SWIFT_PHOENIX_FEATHER.get());

        basicItem(HCIItems.MAGIC_8_BALL.get());

        basicItem(HCIItems.POKE_TREAT.get());
        basicItem(HCIItems.STALE_POKE_TREAT.get());

        basicItem(HCIItems.BLACK_HOLE_PONIGIRI.get());

        basicItem(HCIItems.PRISMATIC_CARAT.get());
        basicItem(HCIItems.YELLOW_CARAT.get());
        basicItem(HCIItems.RED_CARAT.get());
        basicItem(HCIItems.BLUE_CARAT.get());
        basicItem(HCIItems.PINK_CARAT.get());
        basicItem(HCIItems.GREEN_CARAT.get());
        basicItem(HCIItems.CYAN_CARAT.get());

        basicItem(HCIItems.PORYPHONE.get());
        basicItem(HCIItems.PORYPHONE2.get());

        basicItem(HCIItems.OMNIPOTENT_HIDDEN_MACHINE.get());
        basicItem(HCIItems.TM_HIDDEN_MACHINE.get());
        basicItem(HCIItems.EGG_HIDDEN_MACHINE.get());
        basicItem(HCIItems.TUTOR_HIDDEN_MACHINE.get());
        basicItem(HCIItems.LEGACY_HIDDEN_MACHINE.get());
        basicItem(HCIItems.SPECIAL_HIDDEN_MACHINE.get());

        basicItem(HCIItems.BATTLE_GLOVE.get());
    }
}
