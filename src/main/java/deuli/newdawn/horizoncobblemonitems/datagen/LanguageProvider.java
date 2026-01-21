package deuli.newdawn.horizoncobblemonitems.datagen;

import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import deuli.newdawn.horizoncobblemonitems.registry.HCIItems;
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

        addItem(HCIItems.GOLDEN_BOTTLE_CAP, "Golden Bottle Cap");
        tooltip(HCIItems.GOLDEN_BOTTLE_CAP, "Sets all of the Pokémon's effective IV stats to %s");
        addItem(HCIItems.VOID_BOTTLE_CAP, "Void Bottle Cap");
        tooltip(HCIItems.VOID_BOTTLE_CAP, "Resets all of the Pokémon's effective IV stats to %s");

        addItem(HCIItems.SILVER_BOTTLE_CAP, "Silver Bottle Cap");
        tooltip(HCIItems.SILVER_BOTTLE_CAP, "Sets one of the Pokémon's effective IV stat to %s");
        addItem(HCIItems.HEALTH_BOTTLE_CAP, "Health Bottle Cap");
        tooltip(HCIItems.HEALTH_BOTTLE_CAP, "Sets the Pokémon's effective HP IV stat to %s");
        addItem(HCIItems.MIGHTY_BOTTLE_CAP, "Mighty Bottle Cap");
        tooltip(HCIItems.MIGHTY_BOTTLE_CAP, "Sets the Pokémon's effective Attack IV stat to %s");
        addItem(HCIItems.TOUGH_BOTTLE_CAP, "Tough Bottle Cap");
        tooltip(HCIItems.TOUGH_BOTTLE_CAP, "Sets the Pokémon's effective Defense IV stat to %s");
        addItem(HCIItems.SMART_BOTTLE_CAP, "Smart Bottle Cap");
        tooltip(HCIItems.SMART_BOTTLE_CAP, "Sets the Pokémon's effective Special Attack IV stat to %s");
        addItem(HCIItems.COURAGE_BOTTLE_CAP, "Courage Bottle Cap");
        tooltip(HCIItems.COURAGE_BOTTLE_CAP, "Sets the Pokémon's effective Special Defense IV stat to %s");
        addItem(HCIItems.QUICK_BOTTLE_CAP, "Quick Bottle Cap");
        tooltip(HCIItems.QUICK_BOTTLE_CAP, "Sets the Pokémon's effective Speed IV stat to %s");

        addItem(HCIItems.OBSIDIAN_BOTTLE_CAP, "Obsidian Bottle Cap");
        tooltip(HCIItems.OBSIDIAN_BOTTLE_CAP, "Resets one of the Pokémon's effective IV stat to %s");
        addItem(HCIItems.SICKLY_BOTTLE_CAP, "Sickly Bottle Cap");
        tooltip(HCIItems.SICKLY_BOTTLE_CAP, "Resets the Pokémon's effective HP IV stat to %s");
        addItem(HCIItems.WEAK_BOTTLE_CAP, "Weak Bottle Cap");
        tooltip(HCIItems.WEAK_BOTTLE_CAP, "Resets the Pokémon's effective Attack IV stat to %s");
        addItem(HCIItems.BRITTLE_BOTTLE_CAP, "Brittle Bottle Cap");
        tooltip(HCIItems.BRITTLE_BOTTLE_CAP, "Resets the Pokémon's effective Defense IV stat to %s");
        addItem(HCIItems.NUMB_BOTTLE_CAP, "Numb Bottle Cap");
        tooltip(HCIItems.NUMB_BOTTLE_CAP, "Resets the Pokémon's effective Special Attack IV stat to %s");
        addItem(HCIItems.COWARD_BOTTLE_CAP, "Coward Bottle Cap");
        tooltip(HCIItems.COWARD_BOTTLE_CAP, "Resets the Pokémon's effective Special Defense IV stat to %s");
        addItem(HCIItems.SLOW_BOTTLE_CAP, "Slow Bottle Cap");
        tooltip(HCIItems.SLOW_BOTTLE_CAP, "Resets the Pokémon's effective Speed IV stat to %s");

        addItem(HCIItems.WOODEN_BOTTLE_CAP, "Wooden Bottle Cap");
        tooltip(HCIItems.WOODEN_BOTTLE_CAP, "Randomizes all of the Pokémon's effective IV stats");

        addItem(HCIItems.BASKET_BALL, "Baskét Ball");
        tooltip(HCIItems.BASKET_BALL, "Turns the Pokémon into a shiny Pokémon");

        addItem(HCIItems.DEVOLUTION_SPRAY, "Devolution Spray");
        tooltip(HCIItems.DEVOLUTION_SPRAY, "Devolves a Pokémon into their previous evolution");

        addItem(HCIItems.COMMON_CANDY, "Common Candy");
        tooltip(HCIItems.COMMON_CANDY, "Resets a Pokémon's level to %s");
        addItem(HCIItems.UNCOMMON_CANDY, "Uncommon Candy");
        tooltip(HCIItems.UNCOMMON_CANDY, "Lowers a Pokémon's level by one");
        addItem(HCIItems.ULTRA_RARE_CANDY, "Ultra Rare Candy");
        tooltip(HCIItems.ULTRA_RARE_CANDY, "Increases a Pokémon's level to the max");

        addItem(HCIItems.ULTIMATE_MAC_AND_CHEESE, "Ultimate Mac and Cheese");
        tooltip(HCIItems.ULTIMATE_MAC_AND_CHEESE, "Sets all of the Pokémon's riding stat to the max");
        addItem(HCIItems.SPICY_MAC_AND_CHEESE, "Spicy Mac and Cheese");
        tooltip(HCIItems.SPICY_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HCIItems.DRY_MAC_AND_CHEESE, "Dry Mac and Cheese");
        tooltip(HCIItems.DRY_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HCIItems.SWEET_MAC_AND_CHEESE, "Sweet Mac and Cheese");
        tooltip(HCIItems.SWEET_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HCIItems.SOUR_MAC_AND_CHEESE, "Sour Mac and Cheese");
        tooltip(HCIItems.SOUR_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");
        addItem(HCIItems.BITTER_MAC_AND_CHEESE, "Bitter Mac and Cheese");
        tooltip(HCIItems.BITTER_MAC_AND_CHEESE, "Sets the Pokémon's %s stat to the max");

        addItem(HCIItems.GENDER_CHANGE_POTION, "Gender Change Potion");
        tooltip(HCIItems.GENDER_CHANGE_POTION, "Changes the Pokémon's gender");

        addItem(HCIItems.DAWN_BALL, "Dawn Ball");
        tooltip(HCIItems.DAWN_BALL, "contains", "Contains");
        tooltip(HCIItems.DAWN_BALL, "level", "Level");
        tooltip(HCIItems.DAWN_BALL, "min_perfect_ivs", "Min Perfect IVs");
        tooltip(HCIItems.DAWN_BALL, "error", "MissingNo.");
        itemResult(HCIItems.DAWN_BALL, "success", "%s was added to your party!");
        itemResult(HCIItems.DAWN_BALL, "fail", "Seems like this %s is empty...");

        addItem(HCIItems.AXIOM_BERRY, "Axiom Berry");
        tooltip(HCIItems.AXIOM_BERRY, "Resets all of the Pokémon's EVs to %s");
        addItem(HCIItems.DISTORTED_POMEG_BERRY, "Distorted Pomeg Berry");
        tooltip(HCIItems.DISTORTED_POMEG_BERRY, "Resets the Pokémon's HP EVs to %s");
        addItem(HCIItems.DISTORTED_KELPSY_BERRY, "Distorted Kelpsy Berry");
        tooltip(HCIItems.DISTORTED_KELPSY_BERRY, "Resets the Pokémon's Attack EVs to %s");
        addItem(HCIItems.DISTORTED_QUALOT_BERRY, "Distorted Qualot Berry");
        tooltip(HCIItems.DISTORTED_QUALOT_BERRY, "Resets the Pokémon's Defense EVs to %s");
        addItem(HCIItems.DISTORTED_HONDEW_BERRY, "Distorted Hondew Berry");
        tooltip(HCIItems.DISTORTED_HONDEW_BERRY, "Resets the Pokémon's Special Attack EVs to %s");
        addItem(HCIItems.DISTORTED_GREPA_BERRY, "Distorted Grepa Berry");
        tooltip(HCIItems.DISTORTED_GREPA_BERRY, "Resets the Pokémon's Special Defense EVs to %s");
        addItem(HCIItems.DISTORTED_TAMATO_BERRY, "Distorted Tamato Berry");
        tooltip(HCIItems.DISTORTED_TAMATO_BERRY, "Resets the Pokémon's HP Speed to %s");

        addItem(HCIItems.SHADOW_HEALTH_FEATHER, "Shadow Health Feather");
        tooltip(HCIItems.SHADOW_HEALTH_FEATHER, "Lowers the Pokémon's HP EVs by %s");
        addItem(HCIItems.SHADOW_MUSCLE_FEATHER, "Shadow Muscle Feather");
        tooltip(HCIItems.SHADOW_MUSCLE_FEATHER, "Lowers the Pokémon's Attack EVs by %s");
        addItem(HCIItems.SHADOW_RESIST_FEATHER, "Shadow Resist Feather");
        tooltip(HCIItems.SHADOW_RESIST_FEATHER, "Lowers the Pokémon's Defense EVs by %s");
        addItem(HCIItems.SHADOW_GENIUS_FEATHER, "Shadow Genius Feather");
        tooltip(HCIItems.SHADOW_GENIUS_FEATHER, "Lowers the Pokémon's Sp. Atk EVs by %s");
        addItem(HCIItems.SHADOW_CLEVER_FEATHER, "Shadow Clever Feather");
        tooltip(HCIItems.SHADOW_CLEVER_FEATHER, "Lowers the Pokémon's Sp. Defense EVs by %s");
        addItem(HCIItems.SHADOW_SWIFT_FEATHER, "Shadow Swift Feather");
        tooltip(HCIItems.SHADOW_SWIFT_FEATHER, "Lowers the Pokémon's Speed EVs by %s");

        addItem(HCIItems.HEALTH_PHOENIX_FEATHER, "Health Phoenix Feather");
        tooltip(HCIItems.HEALTH_PHOENIX_FEATHER, "Sets the Pokémon's HP EVs to %s");
        addItem(HCIItems.MUSCLE_PHOENIX_FEATHER, "Muscle Phoenix Feather");
        tooltip(HCIItems.MUSCLE_PHOENIX_FEATHER, "Sets the Pokémon's Attack EVs to %s");
        addItem(HCIItems.RESIST_PHOENIX_FEATHER, "Resist Phoenix Feather");
        tooltip(HCIItems.RESIST_PHOENIX_FEATHER, "Sets the Pokémon's Defense EVs to %s");
        addItem(HCIItems.GENIUS_PHOENIX_FEATHER, "Genius Phoenix Feather");
        tooltip(HCIItems.GENIUS_PHOENIX_FEATHER, "Sets the Pokémon's Sp. Atk EVs to %s");
        addItem(HCIItems.CLEVER_PHOENIX_FEATHER, "Clever Phoenix Feather");
        tooltip(HCIItems.CLEVER_PHOENIX_FEATHER, "Sets the Pokémon's Sp. Defense EVs to %s");
        addItem(HCIItems.SWIFT_PHOENIX_FEATHER, "Swift Phoenix Feather");
        tooltip(HCIItems.SWIFT_PHOENIX_FEATHER, "Sets the Pokémon's Speed EVs to %s");

        addItem(HCIItems.MAGIC_8_BALL, "Magic 8 Ball");
        tooltip(HCIItems.MAGIC_8_BALL, "Swaps the Pokémon's current ball to the ball in the player's offhand");
        itemResult(HCIItems.MAGIC_8_BALL, "fail", "You're not holding a Poké Ball in your offhand");

        addItem(HCIItems.POKE_TREAT, "Poké Treat");
        tooltip(HCIItems.POKE_TREAT, "Maxes a Pokémon's friendship");
        addItem(HCIItems.STALE_POKE_TREAT, "Stale Poké Treat");
        tooltip(HCIItems.STALE_POKE_TREAT, "Resets a Pokémon's friendship to %s");

        addItem(HCIItems.BLACK_HOLE_PONIGIRI, "Black Hole Ponigiri");
        tooltip(HCIItems.BLACK_HOLE_PONIGIRI, "Resets a Pokémon's fullness to %s");

        addItem(HCIItems.PRISMATIC_CARAT, "Prismatic Carat");
        tooltip(HCIItems.PRISMATIC_CARAT, "Transforms a Pokémon's effective IV stats into their actual IV stats");
        addItem(HCIItems.YELLOW_CARAT, "Yellow Carat");
        tooltip(HCIItems.YELLOW_CARAT, "Transforms a Pokémon's effective HP IV stat into their actual IV HP stat");
        addItem(HCIItems.RED_CARAT, "Red Carat");
        tooltip(HCIItems.RED_CARAT, "Transforms a Pokémon's effective IV Attack stat into their actual IV Attack stat");
        addItem(HCIItems.BLUE_CARAT, "Blue Carat");
        tooltip(HCIItems.BLUE_CARAT, "Transforms a Pokémon's effective IV Defense stat into their actual IV Defense stat");
        addItem(HCIItems.PINK_CARAT, "Pink Carat");
        tooltip(HCIItems.PINK_CARAT, "Transforms a Pokémon's effective IV Special Attack stat into their actual IV Special Attack stat");
        addItem(HCIItems.GREEN_CARAT, "Green Carat");
        tooltip(HCIItems.GREEN_CARAT, "Transforms a Pokémon's effective IV Special Defense stat into their actual IV Special Defense stat");
        addItem(HCIItems.CYAN_CARAT, "Cyan Carat");
        tooltip(HCIItems.CYAN_CARAT, "Transforms a Pokémon's effective IV Speed stat into their actual IV Speed stat");

        addItem(HCIItems.PORYPHONE, "Poryphone");
        tooltip(HCIItems.PORYPHONE, "Brings the Pokémon model in the player's offhand to life");
        addItem(HCIItems.PORYPHONE2, "Poryphone2");
        tooltip(HCIItems.PORYPHONE2, "Adds the Pokémon model in the player's offhand to the player's party");

        addItem(HCIItems.OMNIPOTENT_HIDDEN_MACHINE, "Omnipotent Hidden Machine");
        tooltip(HCIItems.OMNIPOTENT_HIDDEN_MACHINE, "Teaches the Pokémon all of their moves");
        addItem(HCIItems.TM_HIDDEN_MACHINE, "TM Hidden Machine");
        tooltip(HCIItems.TM_HIDDEN_MACHINE, "Teaches the Pokémon all of their TM moves");
        addItem(HCIItems.EGG_HIDDEN_MACHINE, "Egg Hidden Machine");
        tooltip(HCIItems.EGG_HIDDEN_MACHINE, "Teaches the Pokémon all of their egg moves");
        addItem(HCIItems.TUTOR_HIDDEN_MACHINE, "Tutor Hidden Machine");
        tooltip(HCIItems.TUTOR_HIDDEN_MACHINE, "Teaches the Pokémon all of their tutor moves");
        addItem(HCIItems.LEGACY_HIDDEN_MACHINE, "Legacy Hidden Machine");
        tooltip(HCIItems.LEGACY_HIDDEN_MACHINE, "Teaches the Pokémon all of their legacy moves");
        addItem(HCIItems.SPECIAL_HIDDEN_MACHINE, "Special Hidden Machine");
        tooltip(HCIItems.SPECIAL_HIDDEN_MACHINE, "Teaches the Pokémon all of their special moves");
    }

    public void tooltip(Supplier<? extends Item> key, String tooltip) {
        this.add(key.get().getDescriptionId() + ".tooltip", tooltip);
    }

    public void tooltip(Supplier<? extends Item> key, String sub, String tooltip) {
        this.add(key.get().getDescriptionId() + ".tooltip." + sub, tooltip);
    }

    public void itemResult(Supplier<? extends Item> key, String result, String text) {
        this.add(key.get().getDescriptionId() + "." + result, text);
    }
}
