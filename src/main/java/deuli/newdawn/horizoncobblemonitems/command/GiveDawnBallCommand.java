package deuli.newdawn.horizoncobblemonitems.command;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.command.argument.PokemonPropertiesArgumentType;
import com.mojang.brigadier.context.CommandContext;
import deuli.newdawn.horizoncobblemonitems.registry.HCIDataComponentTypes;
import deuli.newdawn.horizoncobblemonitems.registry.HCIItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class GiveDawnBallCommand {
    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("givedawnball")
                        .requires(stack -> stack.hasPermission(2))
                        .then(Commands.argument("pokemon", PokemonPropertiesArgumentType.Companion.properties())
                                .executes(GiveDawnBallCommand::giveDawnBall)
                        )
        );
    }

    private static int giveDawnBall(CommandContext<CommandSourceStack> context) {
        PokemonProperties pokemonProperties = PokemonPropertiesArgumentType.Companion.getPokemonProperties(context, "pokemon");
        ItemStack stack = new ItemStack(HCIItems.DAWN_BALL.get());
        if (!stack.has(HCIDataComponentTypes.POKEMON_PROPERTIES))
            stack.set(HCIDataComponentTypes.POKEMON_PROPERTIES, pokemonProperties.asString(" "));

        ServerPlayer player = context.getSource().getPlayer();
        if (player != null) {
            Component hoverableText = stack.getHoverName();
            player.addItem(stack);
            context.getSource().sendSuccess(() ->
                    Component.literal("Gave 1 ")
                            .append(hoverableText)
                            .append(" to " + player.getName().getString()), true);
            return 1;
        } else {
            context.getSource().sendFailure(Component.literal("Player not found. (You don't exist?)"));
            return -1;
        }
    }
}
