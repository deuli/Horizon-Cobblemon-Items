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
        basicItem(HorizonCobblemonItems.HEALTH_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.TOUGH_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.SMART_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.COURAGE_BOTTLE_CAP.get());
        basicItem(HorizonCobblemonItems.QUICK_BOTTLE_CAP.get());
    }
}
