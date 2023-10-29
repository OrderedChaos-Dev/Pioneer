package pioneer.common.world.surfacerules;

import java.util.Random;

import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.ConditionSource;

public record RandomThresholdConditionSource(float threshold) implements SurfaceRules.ConditionSource {
	public static final KeyDispatchDataCodec<RandomThresholdConditionSource> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.create((x) -> {
		return x.group(PrimitiveCodec.FLOAT.fieldOf("threshold").forGetter(RandomThresholdConditionSource::threshold)).apply(x, RandomThresholdConditionSource::new);
	}));

	private static final Random RANDOM = new Random();

	@Override
	public SurfaceRules.Condition apply(SurfaceRules.Context t) {
		class RandomCondition implements SurfaceRules.Condition {

			@Override
			public boolean test() {
				return RANDOM.nextFloat() < threshold;
			}

		}
		return new RandomCondition();
	}

	@Override
	public KeyDispatchDataCodec<? extends ConditionSource> codec() {
		return CODEC;
	}
}
