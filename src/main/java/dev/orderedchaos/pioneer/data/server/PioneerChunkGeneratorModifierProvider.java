package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.common.world.modification.chunk.ChunkGeneratorModifierProvider;
import com.teamabnormals.blueprint.common.world.modification.chunk.modifiers.SurfaceRuleModifier;
import dev.orderedchaos.pioneer.common.world.surfacerules.RandomThresholdConditionSource;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import static net.minecraft.world.level.levelgen.SurfaceRules.*;
import net.minecraft.world.level.levelgen.SurfaceRules.ConditionSource;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import java.util.concurrent.CompletableFuture;

public class PioneerChunkGeneratorModifierProvider extends ChunkGeneratorModifierProvider {

  private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
  private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
  private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
  private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
  private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
  private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
  private static final SurfaceRules.RuleSource DIORITE = makeStateRule(Blocks.DIORITE);
  private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
  private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
  private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
  private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
  private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
  private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
  private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
  private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
  private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
  private static final SurfaceRules.RuleSource MOSSY_COBBLESTONE = makeStateRule(Blocks.MOSSY_COBBLESTONE);
  private static final SurfaceRules.RuleSource ANDESITE = makeStateRule(Blocks.ANDESITE);
  private static final SurfaceRules.RuleSource MOSS_BLOCK = makeStateRule(Blocks.MOSS_BLOCK);

  private static final SurfaceRules.ConditionSource BADLANDS_Y_BLOCK_CHECK_1 = yBlockCheck(VerticalAnchor.absolute(256), 0);
  private static final SurfaceRules.ConditionSource BADLANDS_Y_BLOCK_CHECK_2 = yBlockCheck(VerticalAnchor.absolute(63), 0);
  private static final SurfaceRules.ConditionSource BADLANDS_Y_START_CHECK_1 = yStartCheck(VerticalAnchor.absolute(63), -1);
  private static final SurfaceRules.ConditionSource BADLANDS_Y_START_CHECK_2 = yStartCheck(VerticalAnchor.absolute(74), 1);
  private static final SurfaceRules.ConditionSource BADLANDS_WATER_CHECK_1 = waterBlockCheck(-1, 0);
  private static final SurfaceRules.ConditionSource BADLANDS_WATER_CHECK_2 = waterStartCheck(-6, -1);
  private static final SurfaceRules.ConditionSource BADLANDS_HOLE = hole();
  private static final SurfaceRules.ConditionSource NOISE_SURFACE_1 = noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
  private static final SurfaceRules.ConditionSource NOISE_SURFACE_2 = noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
  private static final SurfaceRules.ConditionSource NOISE_SURFACE_3 = noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

  private static final SurfaceRules.RuleSource STONE_CEILING = sequence(ifTrue(ON_CEILING, STONE), GRAVEL);

  private static final SurfaceRules.ConditionSource Y_97 = yBlockCheck(VerticalAnchor.absolute(97), 2);
  private static final SurfaceRules.ConditionSource Y_80 = yBlockCheck(VerticalAnchor.absolute(80), 0);
  private static final SurfaceRules.ConditionSource Y_76 = yBlockCheck(VerticalAnchor.absolute(76), 0);
  private static final SurfaceRules.ConditionSource Y_66 = yBlockCheck(VerticalAnchor.absolute(66), 0);
  private static final SurfaceRules.ConditionSource Y_63 = yBlockCheck(VerticalAnchor.absolute(63), 0);
  private static final SurfaceRules.ConditionSource Y_62 = yBlockCheck(VerticalAnchor.absolute(62), 0);


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
          sequence((ifTrue(DEEP_UNDER_FLOOR, SANDSTONE)), ifTrue(VERY_DEEP_UNDER_FLOOR, SANDSTONE))))
  ));
  private static final SurfaceRules.RuleSource PODZOL_DIRT_FLOOR = sequence(
    ifTrue(ON_FLOOR, sequence(ifTrue(waterBlockCheck(0, 0), PODZOL), DIRT)),
    ifTrue(UNDER_FLOOR, DIRT)
  );

  private static final SurfaceRules.RuleSource COARSE_DIRT_FLOOR = sequence(
    ifTrue(ON_FLOOR, sequence(ifTrue(waterBlockCheck(0, 0), COARSE_DIRT), COARSE_DIRT)),
    ifTrue(UNDER_FLOOR, DIRT)
  );

  public static final SurfaceRules.RuleSource VERDANT_SANDS = sequence(
    ifTrue(surfaceNoiseAbove(1.8D), SAND_SANDSTONE_FLOOR),
    ifTrue(BADLANDS_WATER_CHECK_1, ifTrue(ON_FLOOR, ifTrue(not(Y_66), GRASS_DIRT_FLOOR))),
    ifTrue(surfaceNoiseAbove(0.1D), GRASS_DIRT_FLOOR),
    ifTrue(surfaceNoiseAbove(-0.6D), SAND_SANDSTONE_FLOOR), SAND_SANDSTONE_FLOOR);

  public static final SurfaceRules.RuleSource PINE_MEADOWS = sequence(
    ifTrue(surfaceNoiseAbove(1.75D), GRASS_DIRT_FLOOR),
    ifTrue(noiseCondition(Noises.SURFACE, -0.02D, 0.02D), DIORITE),
    GRASS_DIRT_FLOOR);

  public static final SurfaceRules.RuleSource OLD_GROWTH_BAOBAB_FIELDS = sequence(
    ifTrue(surfaceNoiseAbove(0.9D), COARSE_DIRT_FLOOR),
    GRASS_DIRT_FLOOR);

  private static final SurfaceRules.RuleSource RED_ROCK_CANYON = sequence(
    ifTrue(
      isBiome(PioneerBiomes.RED_ROCK_CLIFFS),
      sequence(
        ifTrue(Y_97,
          sequence(
            ifTrue(NOISE_SURFACE_1, COARSE_DIRT_FLOOR),
            ifTrue(NOISE_SURFACE_2, COARSE_DIRT_FLOOR),
            ifTrue(NOISE_SURFACE_3, COARSE_DIRT_FLOOR), GRASS_DIRT_FLOOR)),
        ifTrue(Y_76,
          ifTrue(
            not(Y_80),
            sequence(
              ifTrue(NOISE_SURFACE_1, COARSE_DIRT_FLOOR),
              ifTrue(NOISE_SURFACE_2, COARSE_DIRT_FLOOR),
              ifTrue(NOISE_SURFACE_3, COARSE_DIRT_FLOOR), GRASS_DIRT_FLOOR)))
      )
    ),
    ifTrue(
      ON_FLOOR,
      sequence(
        ifTrue(BADLANDS_Y_BLOCK_CHECK_1, ORANGE_TERRACOTTA),
        ifTrue(BADLANDS_Y_START_CHECK_2,
          sequence(
            ifTrue(NOISE_SURFACE_1, TERRACOTTA),
            ifTrue(NOISE_SURFACE_2, TERRACOTTA),
            ifTrue(NOISE_SURFACE_3, TERRACOTTA), bandlands())),
        ifTrue(BADLANDS_WATER_CHECK_1,
          sequence(
            ifTrue(ON_FLOOR, ifTrue(not(Y_66), GRASS_DIRT_FLOOR)),
            ifTrue(ON_CEILING, RED_SANDSTONE),
            ifTrue(surfaceNoiseAbove(1.8D), RED_SAND),
            ifTrue(surfaceNoiseAbove(0.1D), GRASS_DIRT_FLOOR), RED_SAND)),
        ifTrue(
          not(BADLANDS_HOLE), ORANGE_TERRACOTTA),
        ifTrue(BADLANDS_WATER_CHECK_2, WHITE_TERRACOTTA), STONE_CEILING)),
    ifTrue(BADLANDS_Y_START_CHECK_1,
      sequence(
        ifTrue(BADLANDS_Y_BLOCK_CHECK_2,
          ifTrue(
            not(BADLANDS_Y_START_CHECK_2), ORANGE_TERRACOTTA)), bandlands())),
    ifTrue(UNDER_FLOOR, ifTrue(BADLANDS_WATER_CHECK_2, WHITE_TERRACOTTA)));

  public static final SurfaceRules.RuleSource WILLOW_WETLANDS = sequence(
    ifTrue(ON_FLOOR,
      ifTrue(Y_62,
        ifTrue(not(Y_63),
          ifTrue(noiseCondition(Noises.SWAMP, 0.0D),
            WATER)))));

  public static final SurfaceRules.RuleSource OVERGROWN_SPIRES = sequence(
    ifTrue(surfaceNoiseAbove(2.15D), STONE),
    ifTrue(surfaceNoiseAbove(0D), COARSE_DIRT_FLOOR),
    GRASS_DIRT_FLOOR);

  private static final SurfaceRules.RuleSource WINDSWEPT_CLIFFS = sequence(
    ifTrue(random(0.15F), STONE),
    ifTrue(random(0.30F), GRAVEL),
    ifTrue(random(0.35F), GRASS_DIRT_FLOOR),
    ifTrue(random(0.1F), MOSS_BLOCK),
    ifTrue(random(0.6F), ANDESITE),
    ifTrue(random(0.75F), MOSSY_COBBLESTONE),
    COBBLESTONE);

  public static final SurfaceRules.RuleSource REDWOODS = sequence(
    ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT_FLOOR),
    ifTrue(surfaceNoiseAbove(-0.90D), PODZOL_DIRT_FLOOR),
    GRASS_DIRT_FLOOR);

  public PioneerChunkGeneratorModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(Pioneer.MOD_ID, output, lookupProvider);
  }

  @Override
  protected void registerEntries(HolderLookup.Provider provider) {
    ConditionSource isVerdantSands = isBiome(PioneerBiomes.VERDANT_SANDS);
    ConditionSource isPineMeadows = isBiome(PioneerBiomes.PINE_MEADOWS);
    ConditionSource isWillowWetlands = isBiome(PioneerBiomes.WILLOW_WETLANDS);
    ConditionSource isOvergrownSpires = isBiome(PioneerBiomes.OVERGROWN_SPIRES);
    ConditionSource isRedRockCanyon = isBiome(PioneerBiomes.RED_ROCK_CANYON, PioneerBiomes.RED_ROCK_CLIFFS);
    ConditionSource isWindsweptCliffs = isBiome(PioneerBiomes.WINDSWEPT_CLIFFS);
    ConditionSource isOldGrowthBaobabFields = isBiome(PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS);
    ConditionSource isRedwoods = isBiome(PioneerBiomes.REDWOODS, PioneerBiomes.SNOWY_REDWOODS);

    this.entry("pioneer_surface_rule")
      .selects("minecraft:overworld")
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isVerdantSands, VERDANT_SANDS)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isPineMeadows, PINE_MEADOWS)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isWillowWetlands, WILLOW_WETLANDS)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isOvergrownSpires, OVERGROWN_SPIRES)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isRedRockCanyon, RED_ROCK_CANYON)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isWindsweptCliffs, WINDSWEPT_CLIFFS)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isOldGrowthBaobabFields, OLD_GROWTH_BAOBAB_FIELDS)), false))
      .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isRedwoods, REDWOODS)), false));

  }

  private static SurfaceRules.RuleSource makeStateRule(Block block) {
    return state(block.defaultBlockState());
  }

  private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
    return noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
  }

  private static RandomThresholdConditionSource random(float threshold) {
    return new RandomThresholdConditionSource(threshold);
  }
}
