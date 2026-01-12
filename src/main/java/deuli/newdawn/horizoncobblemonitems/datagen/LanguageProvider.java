package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.data.PackOutput;

public class LanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    public LanguageProvider(PackOutput output) {
        super(output, HorizonCobblemonItems.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(HorizonCobblemonItems.GOLDEN_BOTTLE_CAP, "Golden Bottle Cap");
    }
}
