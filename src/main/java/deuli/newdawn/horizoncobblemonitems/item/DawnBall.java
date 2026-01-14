package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.abilities.Abilities;
import com.cobblemon.mod.common.api.abilities.AbilityTemplate;
import com.cobblemon.mod.common.api.pokemon.Natures;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Nature;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.PokemonStats;
import com.cobblemon.mod.common.util.MiscUtilsKt;
import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// TODO: Replace components with translation keys
public class DawnBall extends Item {
    public static final String SPACING = "   ";

    public DawnBall() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stackInHand = player.getItemInHand(hand);
        if (level.isClientSide) return InteractionResultHolder.pass(stackInHand);

        String pokemonComponent = stackInHand.get(HorizonCobblemonItems.POKEMON_PROPERTIES.get());
        if (pokemonComponent != null) {
            PokemonProperties properties = PokemonProperties.Companion.parse(pokemonComponent);
            if (properties.getSpecies() != null) {
                PlayerPartyStore party = Cobblemon.INSTANCE.getStorage().getParty((ServerPlayer) player);
                Pokemon pokemon = properties.create();
                player.sendSystemMessage(Component.literal(pokemon.getDisplayName(false).getString() + " was added to your party!"));
                level.playSound(null, player.getOnPos(), SoundEvent.createVariableRangeEvent(MiscUtilsKt.cobblemonResource("poke_ball.break")), SoundSource.NEUTRAL, 0.25F, 1);
                party.add(pokemon);

                stackInHand.consume(1, player);
                return InteractionResultHolder.success(stackInHand);
            }
        }

        player.displayClientMessage(Component.literal("Seems like this " + stackInHand.getItem().getName(stackInHand).getString() + " is empty...").withStyle(ChatFormatting.RED), true);
        return InteractionResultHolder.fail(stackInHand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipConComponent, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        String pokemonComponent = itemStack.getComponents().get(HorizonCobblemonItems.POKEMON_PROPERTIES.get());
        if (pokemonComponent != null) {
            components.add(Component.literal("Contains").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.UNDERLINE));

            PokemonProperties properties = PokemonProperties.Companion.parse(pokemonComponent);
            if (properties.getSpecies() != null) {
                boolean isShiny = properties.getShiny() != null && properties.getShiny();
                Gender gender = properties.getGender();

                MutableComponent shinyComponent = isShiny ? Component.literal((char) 9733 + " ").withStyle(ChatFormatting.GOLD) : Component.empty();
                MutableComponent nameComponent = Component.literal(properties.create().getDisplayName(false).getString());
                MutableComponent genderComponent = Component.empty();
                if (gender != null) {
                    switch (gender) {
                        case MALE ->
                                genderComponent = Component.literal(" " + (char) 9794).withStyle(ChatFormatting.DARK_BLUE);
                        case FEMALE ->
                                genderComponent = Component.literal(" " + (char) 9792).withStyle(ChatFormatting.LIGHT_PURPLE);
                    }
                }
                components.add(spacing().append(shinyComponent).append(nameComponent).append(genderComponent));

                Integer level = properties.getLevel();
                if (level != null)
                    components.add(spacing()
                            .append(Component.literal("Level: ").withStyle(ChatFormatting.AQUA))
                            .append(String.valueOf(level))
                    );

                String form = properties.getForm();
                if (form != null)
                    components.add(spacing().append("Form: ").append(form));

                String natureString = properties.getNature();
                if (natureString != null) {
                    ResourceLocation identifier = ResourceLocation.tryParse(natureString);
                    if (identifier != null) {
                        Nature nature = Natures.getNature(identifier);
                        if (nature != null)
                            components.add(spacing()
                                    .append(Component.literal("Nature: ").withStyle(ChatFormatting.YELLOW))
                                    .append(Component.translatable(nature.getDisplayName()))
                            );
                    }
                }

                String ability = properties.getAbility();
                if (ability != null) {
                    AbilityTemplate abilityTemplate = Abilities.get(ability);
                    if (abilityTemplate != null)
                        components.add(spacing()
                                .append(Component.literal("Ability: ").withStyle(ChatFormatting.GOLD))
                                .append(Component.translatable(abilityTemplate.getDisplayName()))
                        );
                }

                Integer minPerfectIVs = properties.getMinPerfectIVs();
                if (minPerfectIVs != null)
                    components.add(spacing()
                            .append(Component.literal("Min Perfect IVs: ").withColor(0xe084ff))
                            .append(String.valueOf(minPerfectIVs))
                    );

                addPokemonStatsTooltips(components, properties.getIvs(), "IVs", 0xab65c2);
                addPokemonStatsTooltips(components, properties.getEvs(), "EVs", 0xc2c265);
            } else {
                components.add(spacing().append(Component.literal("MissingNo.")));
            }
        }
    }

    private static MutableComponent spacing() {
        return Component.literal(SPACING);
    }

    private static MutableComponent spacing(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) sb.append(SPACING);
        return Component.literal(sb.toString());
    }

    private static MutableComponent getWithStyleStat(String stat) {
        MutableComponent statComponent;
        if (stat.equals("HP"))
            statComponent = Component.literal("HP: ").setStyle(Style.EMPTY.withColor(0x9ee865));
        else if (stat.equals("ATTACK"))
            statComponent = Component.literal("Attack: ").setStyle(Style.EMPTY.withColor(0xf5de69));
        else if (stat.equals("DEFENCE"))
            statComponent = Component.literal("Defence: ").setStyle(Style.EMPTY.withColor(0xf09a65));
        else if (stat.equals("SPECIAL_ATTACK"))
            statComponent = Component.literal("Sp. Attack: ").setStyle(Style.EMPTY.withColor(0x66d8f6));
        else if (stat.equals("SPECIAL_DEFENCE"))
            statComponent = Component.literal("Sp. Defence: ").setStyle(Style.EMPTY.withColor(0x899eea));
        else if (stat.equals("SPEED"))
            statComponent = Component.literal("Speed: ").setStyle(Style.EMPTY.withColor(0xe46cca));
        else
            statComponent = Component.literal(stat).withStyle(ChatFormatting.DARK_RED);

        return statComponent;
    }

    private static void addPokemonStatsTooltips(List<Component> tooltip, PokemonStats stats, String type, int color) {
        if (stats != null && stats.iterator().hasNext()) {
            tooltip.add(spacing().append(Component.literal(type).setStyle(Style.EMPTY.withColor(color).withUnderlined(true))));
            stats.forEach(entry -> tooltip.add(spacing(2)
                    .append(getWithStyleStat(String.valueOf(entry.getKey())))
                    .append(Component.literal(String.valueOf(entry.getValue()))
                            .setStyle(Style.EMPTY
                                    .withItalic(entry.getValue() == stats.getAcceptableRange().getEndInclusive())
                                    .withBold(entry.getValue() == stats.getAcceptableRange().getEndInclusive())
                            )
                    )
            ));
        }
    }
}
