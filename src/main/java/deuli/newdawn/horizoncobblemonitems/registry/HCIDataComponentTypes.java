package deuli.newdawn.horizoncobblemonitems.registry;

import com.mojang.serialization.Codec;
import deuli.newdawn.horizoncobblemonitems.HorizonCobblemonItems;
import deuli.newdawn.horizoncobblemonitems.component.HCIInfinite;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class HCIDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, HorizonCobblemonItems.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> POKEMON_PROPERTIES = register("pokemon_properties", builder -> builder.persistent(Codec.STRING));
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<HCIInfinite>> INFINITE = register("infinite", builder -> builder.persistent(HCIInfinite.CODEC).networkSynchronized(HCIInfinite.STREAM_CODEC));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return DATA_COMPONENT_TYPES.register(name, () -> builder.apply(DataComponentType.builder()).build());
    }
}
