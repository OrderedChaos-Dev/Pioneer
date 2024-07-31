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
  private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);

  private static final SurfaceRules.RuleSource GRASS_DIRT_FLOOR = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0, 0), GRASS_BLOCK), DIRT);
  private static final SurfaceRules.RuleSource SAND_SANDSTONE_FLOOR = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);

  public static final SurfaceRules.RuleSource VERDANT_SANDS = ifTrue(isBiome(PioneerBiomes.VERDANT_SANDS),
    sequence(ifTrue(surfaceNoiseAbove(1.8D), SAND_SANDSTONE_FLOOR),
      ifTrue(surfaceNoiseAbove(0.1D), GRASS_DIRT_FLOOR),
      ifTrue(surfaceNoiseAbove(-0.6D), SAND_SANDSTONE_FLOOR), SAND_SANDSTONE_FLOOR));

  public PioneerChunkGeneratorModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(Pioneer.MOD_ID, output, lookupProvider);
  }

  @Override
  protected void registerEntries(HolderLookup.Provider provider) {
    ConditionSource isVerdantSands = isBiome(PioneerBiomes.VERDANT_SANDS);

    this.entry("pioneer_surface_rule")
      .selects("minecraft:overworld")
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isVerdantSands, VERDANT_SANDS)), false));
  }

  private static SurfaceRules.RuleSource makeStateRule(Block block) {
    return state(block.defaultBlockState());
  }

  private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
    return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
  }
}
