package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.common.world.modification.chunk.ChunkGeneratorModifierProvider;
import com.teamabnormals.blueprint.common.world.modification.chunk.modifiers.SurfaceRuleModifier;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import static net.minecraft.world.level.levelgen.SurfaceRules.*;
import net.minecraft.world.level.levelgen.SurfaceRules.ConditionSource;

import java.util.concurrent.CompletableFuture;

public class PioneerChunkGeneratorModifierProvider extends ChunkGeneratorModifierProvider {

  private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
  private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
  private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
  private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
  private static final SurfaceRules.RuleSource DIORITE = makeStateRule(Blocks.DIORITE);
  private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);

  private static final SurfaceRules.RuleSource GRASS_DIRT_FLOOR = sequence(
    ifTrue(ON_FLOOR, sequence(ifTrue(waterBlockCheck(0, 0), GRASS_BLOCK), DIRT)),
    ifTrue(UNDER_FLOOR, DIRT)
  );
  private static final SurfaceRules.RuleSource SAND_SANDSTONE_FLOOR = sequence(
    sequence(
      ifTrue(ON_FLOOR, ifTrue(waterBlockCheck(-1, 0), sequence(ifTrue(ON_CEILING, SANDSTONE), SAND))),
      ifTrue(waterStartCheck(-6, -1),
        sequence(ifTrue(UNDER_FLOOR,
          sequence(ifTrue(ON_CEILING, SANDSTONE), SAND)),
          sequence((ifTrue(DEEP_UNDER_FLOOR, SANDSTONE)), ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE))))
    ));

  public static final SurfaceRules.RuleSource VERDANT_SANDS = sequence(ifTrue(surfaceNoiseAbove(1.8D), SAND_SANDSTONE_FLOOR),
    ifTrue(surfaceNoiseAbove(0.1D), GRASS_DIRT_FLOOR),
    ifTrue(surfaceNoiseAbove(-0.6D), SAND_SANDSTONE_FLOOR), SAND_SANDSTONE_FLOOR);


  public static final SurfaceRules.RuleSource PINE_MEADOWS = sequence(ifTrue(surfaceNoiseAbove(1.75D), GRASS_DIRT_FLOOR),
    ifTrue(noiseCondition(Noises.SURFACE, -0.02D, 0.02D), DIORITE),
    GRASS_DIRT_FLOOR);

  public PioneerChunkGeneratorModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(Pioneer.MOD_ID, output, lookupProvider);
  }

  @Override
  protected void registerEntries(HolderLookup.Provider provider) {
    ConditionSource isVerdantSands = isBiome(PioneerBiomes.VERDANT_SANDS);
    ConditionSource isPineMeadows = isBiome(PioneerBiomes.PINE_MEADOWS);

    this.entry("pioneer_surface_rule")
      .selects("minecraft:overworld")
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isVerdantSands, VERDANT_SANDS)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isPineMeadows, PINE_MEADOWS)), false));
  }

  private static SurfaceRules.RuleSource makeStateRule(Block block) {
    return state(block.defaultBlockState());
  }

  private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
    return noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
  }
}
