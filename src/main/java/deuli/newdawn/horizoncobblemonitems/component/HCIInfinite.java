package deuli.newdawn.horizoncobblemonitems.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record HCIInfinite(boolean showInTooltip) {
    public static final Codec<HCIInfinite> CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.BOOL.optionalFieldOf("show_in_tooltip", true).forGetter(HCIInfinite::showInTooltip)).apply(instance, HCIInfinite::new));
    public static final StreamCodec<ByteBuf, HCIInfinite> STREAM_CODEC = ByteBufCodecs.BOOL.map(HCIInfinite::new, HCIInfinite::showInTooltip);
}
