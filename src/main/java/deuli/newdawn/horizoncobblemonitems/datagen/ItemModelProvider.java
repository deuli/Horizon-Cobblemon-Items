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
    }
}
