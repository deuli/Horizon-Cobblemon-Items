package deuli.newdawn.horizoncobblemonitems.item;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.abilities.Abilities;
import com.cobblemon.mod.common.api.abilities.AbilityTemplate;
import com.cobblemon.mod.common.api.pokemon.Natures;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Nature;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.PokemonStats;
import com.cobblemon.mod.common.util.MiscUtilsKt;
import deuli.newdawn.horizoncobblemonitems.registry.HCIDataComponentTypes;
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
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DawnBallItem extends Item {
    public static final String SPACING = "   ";

    public DawnBallItem() {
        super(new Item.Properties().rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stackInHand = player.getItemInHand(hand);
        if (level.isClientSide) return InteractionResultHolder.pass(stackInHand);

        String pokemonComponent = stackInHand.get(HCIDataComponentTypes.POKEMON_PROPERTIES.get());
        if (pokemonComponent != null) {
            PokemonProperties properties = PokemonProperties.Companion.parse(pokemonComponent);
            if (properties.getSpecies() != null) {
                PlayerPartyStore party = Cobblemon.INSTANCE.getStorage().getParty((ServerPlayer) player);
                Pokemon pokemon = properties.create();
                player.sendSystemMessage(Component.translatable(getKey("success"), pokemon.getDisplayName(false)));
                level.playSound(null, player.getOnPos(), SoundEvent.createVariableRangeEvent(MiscUtilsKt.cobblemonResource("poke_ball.break")), SoundSource.NEUTRAL, 0.25F, 1);
                party.add(pokemon);

                stackInHand.consume(1, player);
                return InteractionResultHolder.success(stackInHand);
            }
        } else {
            player.displayClientMessage(getFailComponent(stackInHand, getKey("empty")).withStyle(ChatFormatting.RED), true);
            level.playSound(null, player.getOnPos(), SoundEvent.createVariableRangeEvent(MiscUtilsKt.cobblemonResource("poke_ball.shake")), SoundSource.NEUTRAL, 0.25F, 0.8F);
            return InteractionResultHolder.fail(stackInHand);
        }

        player.displayClientMessage(getFailComponent(stackInHand, getKey("fail")).withStyle(ChatFormatting.RED), true);
        level.playSound(null, player.getOnPos(), SoundEvent.createVariableRangeEvent(MiscUtilsKt.cobblemonResource("poke_ball.shake")), SoundSource.NEUTRAL, 0.25F, 0.8F);
        return InteractionResultHolder.fail(stackInHand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipConComponent, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        String pokemonComponent = itemStack.getComponents().get(HCIDataComponentTypes.POKEMON_PROPERTIES.get());
        if (pokemonComponent != null) {
            components.add(Component.translatable(getTooltipKey("contains")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.UNDERLINE));

            PokemonProperties properties = PokemonProperties.Companion.parse(pokemonComponent);
            if (properties.getSpecies() != null) {
                boolean isShiny = properties.getShiny() != null && properties.getShiny();
                Gender gender = properties.getGender();

                MutableComponent shinyComponent = isShiny ? Component.literal("★ ").withStyle(ChatFormatting.RED) : Component.empty();
                MutableComponent nameComponent = properties.create().getDisplayName(false);
                MutableComponent genderComponent = Component.empty();
                if (gender != null) {
                    switch (gender) {
                        case MALE ->
                                genderComponent = Component.literal(" ♂").withStyle(ChatFormatting.DARK_BLUE);
                        case FEMALE ->
                                genderComponent = Component.literal(" ♀").withStyle(ChatFormatting.LIGHT_PURPLE);
                    }
                }
                components.add(spacing().append(shinyComponent).append(nameComponent).append(genderComponent));

                Integer level = properties.getLevel();
                if (level != null)
                    components.add(spacing()
                            .append(Component.translatable(getTooltipKey("level")).withStyle(ChatFormatting.AQUA))
                            .append(": ")
                            .append(String.valueOf(level))
                    );

                String form = properties.getForm();
                if (form != null)
                    components.add(spacing()
                            .append(Component.translatable("cobblemon.ui.pokedex.info.form"))
                            .append(": ")
                            .append(form)
                    );

                String natureString = properties.getNature();
                if (natureString != null) {
                    ResourceLocation identifier = ResourceLocation.tryParse(natureString);
                    if (identifier != null) {
                        Nature nature = Natures.getNature(identifier);
                        if (nature != null)
                            components.add(spacing()
                                    .append(Component.translatable("cobblemon.ui.info.nature").withStyle(ChatFormatting.YELLOW))
                                    .append(": ")
                                    .append(Component.translatable(nature.getDisplayName()))
                            );
                    }
                }

                String ability = properties.getAbility();
                if (ability != null) {
                    AbilityTemplate abilityTemplate = Abilities.get(ability);
                    if (abilityTemplate != null)
                        components.add(spacing()
                                .append(Component.translatable("cobblemon.ui.info.ability").withStyle(ChatFormatting.GOLD))
                                .append(": ")
                                .append(Component.translatable(abilityTemplate.getDisplayName()))
                        );
                }

                Integer minPerfectIVs = properties.getMinPerfectIVs();
                if (minPerfectIVs != null)
                    components.add(spacing()
                            .append(Component.translatable(getTooltipKey("min_perfect_ivs")).withColor(0xe084ff))
                            .append(": ")
                            .append(String.valueOf(minPerfectIVs))
                    );

                addPokemonStatsTooltips(components, properties.getIvs(), "ivs", 0xab65c2);
                addPokemonStatsTooltips(components, properties.getEvs(), "evs", 0xc2c265);
            } else {
                components.add(spacing().append(Component.translatable(getTooltipKey("error"))));
            }
        }
        else
            components.add(getFailComponent(itemStack, getTooltipKey("empty")).withStyle(ChatFormatting.RED));
    }

    private static MutableComponent spacing() {
        return Component.literal(SPACING);
    }

    private static MutableComponent spacing(int level) {
        return Component.literal(SPACING.repeat(Math.max(0, level)));
    }

    private static MutableComponent getWithStyleStat(Stat stat) {
        MutableComponent statComponent = stat.getDisplayName().copy().append(": ");
        switch (stat) {
            case Stats.HP -> statComponent.setStyle(Style.EMPTY.withColor(0x9ee865));
            case Stats.ATTACK -> statComponent.setStyle(Style.EMPTY.withColor(0xf5de69));
            case Stats.DEFENCE -> statComponent.setStyle(Style.EMPTY.withColor(0xf09a65));
            case Stats.SPECIAL_ATTACK -> statComponent.setStyle(Style.EMPTY.withColor(0x66d8f6));
            case Stats.SPECIAL_DEFENCE -> statComponent.setStyle(Style.EMPTY.withColor(0x899eea));
            case Stats.SPEED -> statComponent.setStyle(Style.EMPTY.withColor(0xe46cca));
            default -> statComponent.withStyle(ChatFormatting.DARK_RED);
        }

        return statComponent;
    }

    private static void addPokemonStatsTooltips(List<Component> tooltip, PokemonStats stats, String type, int color) {
        if (stats != null && stats.iterator().hasNext()) {
            tooltip.add(spacing().append(Component.translatable("cobblemon.ui.stats." + type).setStyle(Style.EMPTY.withColor(color).withUnderlined(true))));
            stats.forEach(entry -> tooltip.add(spacing(2)
                    .append(getWithStyleStat(entry.getKey()))
                    .append(Component.literal(String.valueOf(entry.getValue()))
                            .setStyle(Style.EMPTY
                                    .withItalic(entry.getValue() == stats.getAcceptableRange().getEndInclusive())
                                    .withBold(entry.getValue() == stats.getAcceptableRange().getEndInclusive())
                            )
                    )
            ));
        }
    }

    private @NotNull String getKey(String sub) {
        return getDescriptionId() + "." + sub;
    }

    private @NotNull String getTooltipKey(String sub) {
        return getDescriptionId() + ".tooltip." + sub;
    }

    private @NotNull MutableComponent getFailComponent(ItemStack itemStack, String translationKey) {
        return Component.translatable(translationKey, itemStack.getItem().getName(itemStack));
    }
}
