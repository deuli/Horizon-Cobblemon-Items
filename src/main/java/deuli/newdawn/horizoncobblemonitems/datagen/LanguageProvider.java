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
        tooltip(HorizonCobblemonItems.GOLDEN_BOTTLE_CAP, "Sets all of the Pokémon's effective IV stats to %s");
        addItem(HorizonCobblemonItems.VOID_BOTTLE_CAP, "Void Bottle Cap");
        tooltip(HorizonCobblemonItems.VOID_BOTTLE_CAP, "Sets all of the Pokémon's effective IV stats to %s");

        addItem(HorizonCobblemonItems.SILVER_BOTTLE_CAP, "Silver Bottle Cap");
        tooltip(HorizonCobblemonItems.SILVER_BOTTLE_CAP, "Sets one of the Pokémon's effective IV stat to %s");
        addItem(HorizonCobblemonItems.HEALTH_BOTTLE_CAP, "Health Bottle Cap");
        tooltip(HorizonCobblemonItems.HEALTH_BOTTLE_CAP, "Sets the Pokémon's effective HP IV stat to %s");
        addItem(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP, "Mighty Bottle Cap");
        tooltip(HorizonCobblemonItems.MIGHTY_BOTTLE_CAP, "Sets the Pokémon's effective Attack IV stat to %s");
        addItem(HorizonCobblemonItems.TOUGH_BOTTLE_CAP, "Tough Bottle Cap");
        tooltip(HorizonCobblemonItems.TOUGH_BOTTLE_CAP, "Sets the Pokémon's effective Defense IV stat to %s");
        addItem(HorizonCobblemonItems.SMART_BOTTLE_CAP, "Smart Bottle Cap");
        tooltip(HorizonCobblemonItems.SMART_BOTTLE_CAP, "Sets the Pokémon's effective Special Attack IV stat to %s");
        addItem(HorizonCobblemonItems.COURAGE_BOTTLE_CAP, "Courage Bottle Cap");
        tooltip(HorizonCobblemonItems.COURAGE_BOTTLE_CAP, "Sets the Pokémon's effective Special Defense IV stat to %s");
        addItem(HorizonCobblemonItems.QUICK_BOTTLE_CAP, "Quick Bottle Cap");
        tooltip(HorizonCobblemonItems.QUICK_BOTTLE_CAP, "Sets the Pokémon's effective Speed IV stat to %s");

        addItem(HorizonCobblemonItems.OBSIDIAN_BOTTLE_CAP, "Obsidian Bottle Cap");
        tooltip(HorizonCobblemonItems.OBSIDIAN_BOTTLE_CAP, "Sets one of the Pokémon's effective IV stat to %s");
        addItem(HorizonCobblemonItems.SICKLY_BOTTLE_CAP, "Sickly Bottle Cap");
        tooltip(HorizonCobblemonItems.SICKLY_BOTTLE_CAP, "Sets the Pokémon's effective HP IV stat to %s");
        addItem(HorizonCobblemonItems.WEAK_BOTTLE_CAP, "Weak Bottle Cap");
        tooltip(HorizonCobblemonItems.WEAK_BOTTLE_CAP, "Sets the Pokémon's effective Attack IV stat to %s");
        addItem(HorizonCobblemonItems.BRITTLE_BOTTLE_CAP, "Brittle Bottle Cap");
        tooltip(HorizonCobblemonItems.BRITTLE_BOTTLE_CAP, "Sets the Pokémon's effective Defense IV stat to %s");
        addItem(HorizonCobblemonItems.NUMB_BOTTLE_CAP, "Numb Bottle Cap");
        tooltip(HorizonCobblemonItems.NUMB_BOTTLE_CAP, "Sets the Pokémon's effective Special Attack IV stat to %s");
        addItem(HorizonCobblemonItems.COWARD_BOTTLE_CAP, "Coward Bottle Cap");
        tooltip(HorizonCobblemonItems.COWARD_BOTTLE_CAP, "Sets the Pokémon's effective Special Defense IV stat to %s");
        addItem(HorizonCobblemonItems.SLOW_BOTTLE_CAP, "Slow Bottle Cap");
        tooltip(HorizonCobblemonItems.SLOW_BOTTLE_CAP, "Sets the Pokémon's effective Speed IV stat to %s");

        addItem(HorizonCobblemonItems.BASKET_BALL, "Baskét Ball");
        tooltip(HorizonCobblemonItems.BASKET_BALL, "Turns the Pokémon into a shiny Pokémon");

        addItem(HorizonCobblemonItems.DEVOLUTION_SPRAY, "Devolution Spray");
        tooltip(HorizonCobblemonItems.DEVOLUTION_SPRAY, "Devolves a Pokémon into their previous evolution");

        addItem(HorizonCobblemonItems.ULTRA_RARE_CANDY, "Ultra Rare Candy");
        tooltip(HorizonCobblemonItems.ULTRA_RARE_CANDY, "Increases a Pokémon's level to the max");

        addItem(HorizonCobblemonItems.ULTIMATE_MAC_AND_CHEESE, "Ultimate Mac and Cheese");
        tooltip(HorizonCobblemonItems.ULTIMATE_MAC_AND_CHEESE, "Sets all of the Pokémon's riding stat to the max");
        addItem(HorizonCobblemonItems.SPICY_MAC_AND_CHEESE, "Spicy Mac and Cheese");
        tooltip(HorizonCobblemonItems.SPICY_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HorizonCobblemonItems.DRY_MAC_AND_CHEESE, "Dry Mac and Cheese");
        tooltip(HorizonCobblemonItems.DRY_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HorizonCobblemonItems.SWEET_MAC_AND_CHEESE, "Sweet Mac and Cheese");
        tooltip(HorizonCobblemonItems.SWEET_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HorizonCobblemonItems.SOUR_MAC_AND_CHEESE, "Sour Mac and Cheese");
        tooltip(HorizonCobblemonItems.SOUR_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HorizonCobblemonItems.BITTER_MAC_AND_CHEESE, "Bitter Mac and Cheese");
        tooltip(HorizonCobblemonItems.BITTER_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");

        addItem(HorizonCobblemonItems.GENDER_CHANGE_POTION, "Gender Change Potion");
        tooltip(HorizonCobblemonItems.GENDER_CHANGE_POTION, "Changes the Pokémon's gender");

        addItem(HorizonCobblemonItems.DAWN_BALL, "Dawn Ball");

        addItem(HorizonCobblemonItems.VOID_FEATHER, "Void Feather");
        tooltip(HorizonCobblemonItems.VOID_FEATHER, "Resets all of the Pokémon's EVs to %s");

        addItem(HorizonCobblemonItems.HEALTH_PHOENIX_FEATHER, "Health Phoenix Feather");
        tooltip(HorizonCobblemonItems.HEALTH_PHOENIX_FEATHER, "Sets the Pokémon's HP EVs to %s");
        addItem(HorizonCobblemonItems.MUSCLE_PHOENIX_FEATHER, "Muscle Phoenix Feather");
        tooltip(HorizonCobblemonItems.MUSCLE_PHOENIX_FEATHER, "Sets the Pokémon's Attack EVs to %s");
        addItem(HorizonCobblemonItems.RESIST_PHOENIX_FEATHER, "Resist Phoenix Feather");
        tooltip(HorizonCobblemonItems.RESIST_PHOENIX_FEATHER, "Sets the Pokémon's Defense EVs to %s");
        addItem(HorizonCobblemonItems.GENIUS_PHOENIX_FEATHER, "Genius Phoenix Feather");
        tooltip(HorizonCobblemonItems.GENIUS_PHOENIX_FEATHER, "Sets the Pokémon's Sp. Atk EVs to %s");
        addItem(HorizonCobblemonItems.CLEVER_PHOENIX_FEATHER, "Clever Phoenix Feather");
        tooltip(HorizonCobblemonItems.CLEVER_PHOENIX_FEATHER, "Sets the Pokémon's Sp. Defense EVs to %s");
        addItem(HorizonCobblemonItems.SWIFT_PHOENIX_FEATHER, "Swift Phoenix Feather");
        tooltip(HorizonCobblemonItems.SWIFT_PHOENIX_FEATHER, "Sets the Pokémon's Speed EVs to %s");
    }

    public void tooltip(Supplier<? extends Item> key, String tooltip) {
        this.add("item." + key.get().getDescriptionId() + ".tooltip", tooltip);
    }
}
