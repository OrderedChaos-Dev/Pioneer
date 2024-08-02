package dev.orderedchaos.pioneer.common.world.surfacerules;

import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.Random;

public record RandomThresholdConditionSource(float threshold) implements SurfaceRules.ConditionSource {
  public static final KeyDispatchDataCodec<RandomThresholdConditionSource> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.create((x) -> {
    return x.group(PrimitiveCodec.FLOAT.fieldOf("threshold").forGetter(RandomThresholdConditionSource::threshold)).apply(x, RandomThresholdConditionSource::new);
  }));

  private static final long SEED = 69420L;
  private static final Random RANDOM = new Random(SEED);

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
  public KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() {
    return CODEC;
  }
}