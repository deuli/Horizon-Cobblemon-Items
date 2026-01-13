package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class LanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    public LanguageProvider(PackOutput output) {
        super(output, HorizonCobblemonItems.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.horizoncobblemonitems", "Horizon Cobblemon Items");

        addItem(HorizonCobblemonItems.GOLDEN_BOTTLE_CAP, "Golden Bottle Cap");
        addItem(HorizonCobblemonItems.VOID_BOTTLE_CAP, "Void Bottle Cap");

        addItem(HorizonCobblemonItems.SILVER_BOTTLE_CAP, "Silver Bottle Cap");
        addItem(HorizonCobblemonItems.HEALTH_BOTTLE_CAP, "Health Bottle Cap");
        addItem(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP, "Mighty Bottle Cap");
        addItem(HorizonCobblemonItems.TOUGH_BOTTLE_CAP, "Tough Bottle Cap");
        addItem(HorizonCobblemonItems.SMART_BOTTLE_CAP, "Smart Bottle Cap");
        addItem(HorizonCobblemonItems.COURAGE_BOTTLE_CAP, "Courage Bottle Cap");
        addItem(HorizonCobblemonItems.QUICK_BOTTLE_CAP, "Quick Bottle Cap");

        addItem(HorizonCobblemonItems.OBSIDIAN_BOTTLE_CAP, "Obsidian Bottle Cap");
        addItem(HorizonCobblemonItems.SICKLY_BOTTLE_CAP, "Sickly Bottle Cap");
        addItem(HorizonCobblemonItems.WEAK_BOTTLE_CAP, "Weak Bottle Cap");
        addItem(HorizonCobblemonItems.BRITTLE_BOTTLE_CAP, "Brittle Bottle Cap");
        addItem(HorizonCobblemonItems.NUMB_BOTTLE_CAP, "Numb Bottle Cap");
        addItem(HorizonCobblemonItems.COWARD_BOTTLE_CAP, "Coward Bottle Cap");
        addItem(HorizonCobblemonItems.SLOW_BOTTLE_CAP, "Slow Bottle Cap");

        addItem(HorizonCobblemonItems.BASKET_BALL, "Baskét Ball");

        addItem(HorizonCobblemonItems.DEVOLUTION_SPRAY, "Devolution Spray");

        tooltip(HorizonCobblemonItems.GOLDEN_BOTTLE_CAP, "Sets all of the Pokémon's effective IV stats to %1$s.");
        tooltip(HorizonCobblemonItems.VOID_BOTTLE_CAP, "Sets all of the Pokémon's effective IV stats to %1$s.");

        tooltip(HorizonCobblemonItems.SILVER_BOTTLE_CAP, "Sets one of the Pokémon's effective IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.HEALTH_BOTTLE_CAP, "Sets the Pokémon's effective HP IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP, "Sets the Pokémon's effective Attack IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.TOUGH_BOTTLE_CAP, "Sets the Pokémon's effective Defense IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.SMART_BOTTLE_CAP, "Sets the Pokémon's effective Special Attack IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.COURAGE_BOTTLE_CAP, "Sets the Pokémon's effective Special Defense IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.QUICK_BOTTLE_CAP, "Sets the Pokémon's effective Speed IV stat to %1$s.");

        tooltip(HorizonCobblemonItems.OBSIDIAN_BOTTLE_CAP, "Sets one of the Pokémon's effective IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.SICKLY_BOTTLE_CAP, "Sets the Pokémon's effective HP IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.WEAK_BOTTLE_CAP, "Sets the Pokémon's effective Attack IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.BRITTLE_BOTTLE_CAP, "Sets the Pokémon's effective Defense IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.NUMB_BOTTLE_CAP, "Sets the Pokémon's effective Special Attack IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.COWARD_BOTTLE_CAP, "Sets the Pokémon's effective Special Defense IV stat to %1$s.");
        tooltip(HorizonCobblemonItems.SLOW_BOTTLE_CAP, "Sets the Pokémon's effective Speed IV stat to %1$s.");

        tooltip(HorizonCobblemonItems.BASKET_BALL, "Turns the Pokémon into a shiny Pokémon.");

        tooltip(HorizonCobblemonItems.DEVOLUTION_SPRAY, "Devolves a Pokémon into their previous evolution.");
    }

    public void tooltip(Supplier<? extends Item> key, String tooltip) {
        this.add("item." + key.get().getDescriptionId() + ".tooltip", tooltip);
    }
}
