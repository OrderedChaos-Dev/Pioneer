package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class PioneerPlacedFeatures {

  public static final ResourceKey<PlacedFeature> PATCH_MANY_CACTUS  = createKey("patch_many_cactus");
  public static final ResourceKey<PlacedFeature> WILLOW_WETLANDS_GRASS  = createKey("willow_wetlands_grass");
  public static final ResourceKey<PlacedFeature> WILLOW_WETLANDS_SEA_PICKLE  = createKey("willow_wetlands_sea_pickle");
  public static final ResourceKey<PlacedFeature> OVERGROWN_SPIRES_POOL  = createKey("overgrown_spires_pool");
  public static final ResourceKey<PlacedFeature> WINDSWEPT_SPIKE = createKey("windswept_spike");
  public static final ResourceKey<PlacedFeature> ASPEN_FALLEN_LEAVES = createKey("aspen_fallen_leaves");
  public static final ResourceKey<PlacedFeature> RED_MAPLE_FALLEN_LEAVES = createKey("red_maple_fallen_leaves");
  public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_FALLEN_LEAVES = createKey("orange_maple_fallen_leaves");
  public static final ResourceKey<PlacedFeature> PURPLE_MAPLE_FALLEN_LEAVES = createKey("purple_fallen_leaves");
  public static final ResourceKey<PlacedFeature> PRAIRIE_GRASS = createKey("prairie_grass");
  public static final ResourceKey<PlacedFeature> AMETHYST_CRYSTALS = createKey("amethyst_crystals");
  public static final ResourceKey<PlacedFeature> CRYSTAL_POOL = createKey("crystal_pool");

  public static final ResourceKey<PlacedFeature> PINE_CHECKED = createKey("pine_checked");
  public static final ResourceKey<PlacedFeature> FIR_CHECKED = createKey("fir_checked");
  public static final ResourceKey<PlacedFeature> TAMARACK_CHECKED = createKey("tamarack_checked");
  public static final ResourceKey<PlacedFeature> TAMARACK_BEES_0002_CHECKED = createKey("tamarack_bees_0002_checked");
  public static final ResourceKey<PlacedFeature> WILLOW_CHECKED = createKey("willow_checked");
  public static final ResourceKey<PlacedFeature> BAOBAB_CHECKED = createKey("baobab_checked");
  public static final ResourceKey<PlacedFeature> ASPEN_CHECKED = createKey("aspen_checked");
  public static final ResourceKey<PlacedFeature> ASPEN_BEES_0002_CHECKED = createKey("aspen_bees_0002_checked");
  public static final ResourceKey<PlacedFeature> RED_MAPLE_CHECKED = createKey("red_maple_checked");
  public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_CHECKED = createKey("orange_maple_checked");
  public static final ResourceKey<PlacedFeature> PURPLE_MAPLE_CHECKED = createKey("purple_maple_checked");
  public static final ResourceKey<PlacedFeature> FANCY_RED_MAPLE_CHECKED = createKey("fancy_red_maple_checked");
  public static final ResourceKey<PlacedFeature> FANCY_ORANGE_MAPLE_CHECKED = createKey("fancy_orange_maple_checked");
  public static final ResourceKey<PlacedFeature> FANCY_PURPLE_MAPLE_CHECKED = createKey("fancy_purple_maple_checked");
  public static final ResourceKey<PlacedFeature> TALL_BAOBAB_CHECKED = createKey("tall_baobab_checked");
  public static final ResourceKey<PlacedFeature> REDWOOD_CHECKED = createKey("redwood_checked");
  public static final ResourceKey<PlacedFeature> SMALL_REDWOOD_CHECKED = createKey("small_redwood_checked");
  public static final ResourceKey<PlacedFeature> SMALL_REDWOOD_BEES_0002_CHECKED = createKey("small_redwood_bees_0002_checked");
  public static final ResourceKey<PlacedFeature> COTTONWOOD_CHECKED = createKey("cottonwood_checked");
  public static final ResourceKey<PlacedFeature> COTTONWOOD_BEES_005_CHECKED = createKey("cottonwood_bees_005_checked");
  public static final ResourceKey<PlacedFeature> SPRUCE_BUSH_CHECKED = createKey("spruce_bush_checked");
  public static final ResourceKey<PlacedFeature> OAK_BUSH_CHECKED = createKey("oak_bush");

  public static final ResourceKey<PlacedFeature> TREES_VERDANT_SANDS  = createKey("trees_verdant_sands");
  public static final ResourceKey<PlacedFeature> TREES_PINE_MEADOWS  = createKey("trees_pine_meadows");
  public static final ResourceKey<PlacedFeature> TREES_AUTUMNAL_CONIFEROUS_FOREST  = createKey("trees_autumnal_coniferous_forest");
  public static final ResourceKey<PlacedFeature> TREES_BOREAL_FOREST  = createKey("trees_boreal_forest");
  public static final ResourceKey<PlacedFeature> TREES_WILLOW_WETLANDS  = createKey("trees_willow_wetlands");
  public static final ResourceKey<PlacedFeature> TREES_OVERGROWN_SPIRES  = createKey("trees_overgrown_spires");
  public static final ResourceKey<PlacedFeature> TREES_WINDSWEPT_CLIFFS  = createKey("trees_windswept_cliffs");
  public static final ResourceKey<PlacedFeature> TREES_BAOBAB_FIELDS  = createKey("trees_baobab_fields");
  public static final ResourceKey<PlacedFeature> TREES_OLD_GROWTH_BAOBAB_FIELDS  = createKey("trees_old_growth_baobab_fields");
  public static final ResourceKey<PlacedFeature> TREES_ASPEN_GROVE  = createKey("trees_aspen_grove");
  public static final ResourceKey<PlacedFeature> TREES_REDWOODS  = createKey("trees_redwoods");
  public static final ResourceKey<PlacedFeature> TREES_PRAIRIE  = createKey("trees_prairie");
  public static final ResourceKey<PlacedFeature> TREES_CRYSTAL_LAKES  = createKey("trees_crystal_lakes");

  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    register(context, PATCH_MANY_CACTUS, VegetationFeatures.PATCH_CACTUS, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    register(context, WILLOW_WETLANDS_GRASS, VegetationFeatures.PATCH_TALL_GRASS, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    register(context, WILLOW_WETLANDS_SEA_PICKLE, AquaticFeatures.SEA_PICKLE, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    register(context, OVERGROWN_SPIRES_POOL, PioneerConfiguredFeatures.OVERGROWN_SPIRES_POOL, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(2)), BiomeFilter.biome());
    register(context, WINDSWEPT_SPIKE, PioneerConfiguredFeatures.WINDSWEPT_SPIKE, VegetationPlacements.worldSurfaceSquaredWithCount(2));
    register(context, ASPEN_FALLEN_LEAVES, PioneerConfiguredFeatures.ASPEN_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
    register(context, RED_MAPLE_FALLEN_LEAVES, PioneerConfiguredFeatures.RED_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
    register(context, ORANGE_MAPLE_FALLEN_LEAVES, PioneerConfiguredFeatures.ORANGE_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
    register(context, PURPLE_MAPLE_FALLEN_LEAVES, PioneerConfiguredFeatures.PURPLE_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
    register(context, PRAIRIE_GRASS, PioneerConfiguredFeatures.PRAIRIE_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(32));
    register(context, AMETHYST_CRYSTALS, PioneerConfiguredFeatures.AMETHYST_CRYSTALS, VegetationPlacements.worldSurfaceSquaredWithCount(3));
    register(context, CRYSTAL_POOL, PioneerConfiguredFeatures.CRYSTAL_POOL, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());

    register(context, PINE_CHECKED, PioneerConfiguredFeatures.PINE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PINE.sapling().get()));
    register(context, FIR_CHECKED, PioneerConfiguredFeatures.FIR_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.FIR.sapling().get()));
    register(context, TAMARACK_CHECKED, PioneerConfiguredFeatures.TAMARACK_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.TAMARACK.sapling().get()));
    register(context, TAMARACK_BEES_0002_CHECKED, PioneerConfiguredFeatures.TAMARACK_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.TAMARACK.sapling().get()));
    register(context, WILLOW_CHECKED, PioneerConfiguredFeatures.WILLOW_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.WILLOW.sapling().get()));
    register(context, BAOBAB_CHECKED, PioneerConfiguredFeatures.BAOBAB_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.BAOBAB.sapling().get()));
    register(context, TALL_BAOBAB_CHECKED, PioneerConfiguredFeatures.TALL_BAOBAB_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.BAOBAB.sapling().get()));
    register(context, ASPEN_CHECKED, PioneerConfiguredFeatures.ASPEN_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.ASPEN.sapling().get()));
    register(context, ASPEN_BEES_0002_CHECKED, PioneerConfiguredFeatures.ASPEN_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.ASPEN.sapling().get()));
    register(context, RED_MAPLE_CHECKED, PioneerConfiguredFeatures.RED_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MAPLE.sapling().get()));
    register(context, ORANGE_MAPLE_CHECKED, PioneerConfiguredFeatures.ORANGE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MAPLE.sapling().get()));
    register(context, PURPLE_MAPLE_CHECKED, PioneerConfiguredFeatures.PURPLE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MAPLE.sapling().get()));
    register(context, FANCY_RED_MAPLE_CHECKED, PioneerConfiguredFeatures.FANCY_RED_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MAPLE.sapling().get()));
    register(context, FANCY_ORANGE_MAPLE_CHECKED, PioneerConfiguredFeatures.FANCY_ORANGE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MAPLE.sapling().get()));
    register(context, FANCY_PURPLE_MAPLE_CHECKED, PioneerConfiguredFeatures.FANCY_PURPLE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MAPLE.sapling().get()));
    register(context, REDWOOD_CHECKED, PioneerConfiguredFeatures.BIG_REDWOOD_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.REDWOOD.sapling().get()));
    register(context, SMALL_REDWOOD_BEES_0002_CHECKED, PioneerConfiguredFeatures.SMALL_REDWOOD_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.REDWOOD.sapling().get()));
    register(context, SMALL_REDWOOD_CHECKED, PioneerConfiguredFeatures.SMALL_REDWOOD_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.REDWOOD.sapling().get()));
    register(context, SPRUCE_BUSH_CHECKED, PioneerConfiguredFeatures.SPRUCE_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
    register(context, COTTONWOOD_CHECKED, PioneerConfiguredFeatures.COTTONWOOD_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.COTTONWOOD.sapling().get()));
    register(context, COTTONWOOD_BEES_005_CHECKED, PioneerConfiguredFeatures.COTTONWOOD_TREE_BEES_005, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.COTTONWOOD.sapling().get()));
    register(context, OAK_BUSH_CHECKED, PioneerConfiguredFeatures.OAK_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

    register(context, TREES_VERDANT_SANDS, PioneerConfiguredFeatures.TREES_VERDANT_SANDS, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
    register(context, TREES_PINE_MEADOWS, PioneerConfiguredFeatures.TREES_PINE_MEADOWS, treePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
    register(context, TREES_AUTUMNAL_CONIFEROUS_FOREST, PioneerConfiguredFeatures.TREES_AUTUMNAL_CONIFEROUS_FOREST, treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
    register(context, TREES_BOREAL_FOREST, PioneerConfiguredFeatures.TREES_BOREAL_FOREST, treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
    register(context, TREES_WILLOW_WETLANDS, PioneerConfiguredFeatures.TREES_WILLOW_WETLANDS,PlacementUtils.countExtra(4, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(PioneerBlocks.WILLOW.sapling().get().defaultBlockState(), BlockPos.ZERO)));
    register(context, TREES_OVERGROWN_SPIRES, PioneerConfiguredFeatures.TREES_OVERGROWN_SPIRES, treePlacement(PlacementUtils.countExtra(18, 0.1F, 1)));
    register(context, TREES_WINDSWEPT_CLIFFS, PioneerConfiguredFeatures.TREES_WINDSWEPT_CLIFFS, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    register(context, TREES_BAOBAB_FIELDS, PioneerConfiguredFeatures.TREES_BAOBAB_FIELDS, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.2F, 1)));
    register(context, TREES_OLD_GROWTH_BAOBAB_FIELDS, PioneerConfiguredFeatures.TREES_OLD_GROWTH_BAOBAB_FIELDS, VegetationPlacements.treePlacement(PlacementUtils.countExtra(12, 0.2F, 1)));
    register(context, TREES_ASPEN_GROVE, PioneerConfiguredFeatures.TREES_ASPEN_GROVE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.2F, 1)));
    register(context, TREES_REDWOODS, PioneerConfiguredFeatures.TREES_REDWOODS, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
    register(context, TREES_PRAIRIE, PioneerConfiguredFeatures.TREES_PRAIRIE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    register(context, TREES_CRYSTAL_LAKES, PioneerConfiguredFeatures.TREES_CRYSTAL_LAKES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
  }

  private static ResourceKey<PlacedFeature> createKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Pioneer.MOD_ID, name));
  }

  private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers) {
    HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
    PlacementUtils.register(context, key, holderGetter.getOrThrow(configuredFeature), modifiers);
  }

  private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature, PlacementModifier... modifiers) {
    HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
    PlacementUtils.register(context, key, holderGetter.getOrThrow(configuredFeature), modifiers);
  }
}
