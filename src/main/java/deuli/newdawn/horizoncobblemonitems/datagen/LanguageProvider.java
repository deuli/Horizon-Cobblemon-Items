package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.data.PackOutput;

public class LanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    public LanguageProvider(PackOutput output) {
        super(output, HorizonCobblemonItems.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.horizoncobblemonitems", "Horizon Cobblemon Items");

        addItem(HorizonCobblemonItems.GOLDEN_BOTTLE_CAP, "Golden Bottle Cap");
        addItem(HorizonCobblemonItems.HEALTH_BOTTLE_CAP, "Health Bottle Cap");
        addItem(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP, "Mighty Bottle Cap");
        addItem(HorizonCobblemonItems.TOUGH_BOTTLE_CAP, "Tough Bottle Cap");
        addItem(HorizonCobblemonItems.SMART_BOTTLE_CAP, "Smart Bottle Cap");
        addItem(HorizonCobblemonItems.COURAGE_BOTTLE_CAP, "Courage Bottle Cap");
        addItem(HorizonCobblemonItems.QUICK_BOTTLE_CAP, "Quick Bottle Cap");
        addItem(HorizonCobblemonItems.SICKLY_BOTTLE_CAP, "Sickly Bottle Cap");
        addItem(HorizonCobblemonItems.WEAK_BOTTLE_CAP, "Weak Bottle Cap");
        addItem(HorizonCobblemonItems.BRITTLE_BOTTLE_CAP, "Brittle Bottle Cap");
        addItem(HorizonCobblemonItems.NUMB_BOTTLE_CAP, "Numb Bottle Cap");
        addItem(HorizonCobblemonItems.COWARD_BOTTLE_CAP, "Coward Bottle Cap");
        addItem(HorizonCobblemonItems.SLOW_BOTTLE_CAP, "Slow Bottle Cap");
    }
}
