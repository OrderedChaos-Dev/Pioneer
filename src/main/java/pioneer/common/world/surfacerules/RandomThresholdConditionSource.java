package pioneer.common.world.surfacerules;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.Condition;
import net.minecraft.world.level.levelgen.SurfaceRules.ConditionSource;
import net.minecraft.world.level.levelgen.SurfaceRules.Context;

public record RandomThresholdConditionSource(float threshold) implements SurfaceRules.ConditionSource {
	public static final Codec<RandomThresholdConditionSource> CODEC = RecordCodecBuilder.create((x) -> {
		return x.group(Codec.FLOAT.fieldOf("threshold").forGetter(RandomThresholdConditionSource::threshold)).apply(x, RandomThresholdConditionSource::new);
	});
	
	private static final Random RANDOM = new Random();

	@Override
	public Condition apply(Context t) {
		class RandomCondition implements SurfaceRules.Condition {

			@Override
			public boolean test() {
				return RANDOM.nextFloat() < threshold;
			}
			
		}
		return new RandomCondition();
	}

	@Override
	public Codec<? extends ConditionSource> codec() {
		return CODEC;
	}
}
