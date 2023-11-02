package pioneer.common.world;

import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import pioneer.core.registry.world.PioneerPlacements;

public class PioneerBiomeFeatures {

  public static void addPalmTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.TREES_PALM.getHolder().get());
  }

  public static void addPineMeadowsTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.PINE_MEADOWS_TREES.getHolder().get());
  }

  public static void addAutumnalConiferousForestTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.AUTUMNAL_CONIFEROUS_TREES.getHolder().get());
  }

  public static void addBorealForestTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.BOREAL_FOREST_TREES.getHolder().get());
  }

  public static void addDesertShrublandVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.DRY_GRASS.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.DESERT_AGAVE.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.DESERT_SAGE.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.DESERT_SHRUBLAND_TREES.getHolder().get());
  }

  public static void addOvergrownSpiresTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.OVERGROWN_SPIRES_TREES.getHolder().get());
  }

  public static void addOvergrownSpiresPools(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.OVERGROWN_SPIRES_POOL.getHolder().get());
  }

  public static void addPrairieVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.PRAIRIE_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.PRAIRIE_GRASS.getHolder().get());
  }

  public static void addBaobabFieldTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.BAOBAB_FIELDS_TREES.getHolder().get());
  }

  public static void addRedwoodsTrees(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.REDWOOD_FOREST_TREES.getHolder().get());
  }

  public static void addCrystalLakesVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.CRYSTAL_LAKES_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.CRYSTAL_POOL.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.AMETHYST_CRYSTALS.getHolder().get());
  }

  public static void addBlossomingFieldsVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.BLOSSOMING_FIELDS_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.WHITE_SAKURA_FALLEN_LEAVES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.PINK_SAKURA_FALLEN_LEAVES.getHolder().get());
  }

  public static void addAspenGroveVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.ASPEN_GROVE_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.RED_MAPLE_FALLEN_LEAVES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.ORANGE_MAPLE_FALLEN_LEAVES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.PURPLE_MAPLE_FALLEN_LEAVES.getHolder().get());
  }

  public static void addFloodedForestVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.FLOOD_POOL.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.DRIPLEAF.getHolder().get());
  }

  public static void addWindsweptCliffsVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.WINDSWEPT_CLIFFS_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.WINDSWEPT_SPIKE.getHolder().get());
  }

  public static void addWillowWetlandsVegetation(BiomeGenerationSettings.Builder builder) {
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.WILLOW_WETLANDS_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.WATER_WILLOW_WETLANDS_TREES.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacements.WETLANDS_POOL.getHolder().get());
    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
  }
}
