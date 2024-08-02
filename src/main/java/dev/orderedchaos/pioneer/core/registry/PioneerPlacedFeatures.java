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

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class PioneerPlacedFeatures {

  public static final ResourceKey<PlacedFeature> PATCH_MANY_CACTUS  = createKey("patch_many_cactus");
  public static final ResourceKey<PlacedFeature> WILLOW_WETLANDS_GRASS  = createKey("willow_wetlands_grass");
  public static final ResourceKey<PlacedFeature> WILLOW_WETLANDS_SEA_PICKLE  = createKey("willow_wetlands_sea_pickle");
  public static final ResourceKey<PlacedFeature> OVERGROWN_SPIRES_POOL  = createKey("overgrown_spires_pool");

  public static final ResourceKey<PlacedFeature> PINE_CHECKED = createKey("pine_checked");
  public static final ResourceKey<PlacedFeature> FIR_CHECKED = createKey("fir_checked");
  public static final ResourceKey<PlacedFeature> TAMARACK_CHECKED = createKey("tamarack_checked");
  public static final ResourceKey<PlacedFeature> TAMARACK_BEES_0002_CHECKED = createKey("tamarack_bees_0002_checked");
  public static final ResourceKey<PlacedFeature> WILLOW_CHECKED = createKey("willow_checked");
  public static final ResourceKey<PlacedFeature> SPRUCE_BUSH_CHECKED = createKey("spruce_bush_checked");

  public static final ResourceKey<PlacedFeature> TREES_VERDANT_SANDS  = createKey("trees_verdant_sands");
  public static final ResourceKey<PlacedFeature> TREES_PINE_MEADOWS  = createKey("trees_pine_meadows");
  public static final ResourceKey<PlacedFeature> TREES_AUTUMNAL_CONIFEROUS_FOREST  = createKey("trees_autumnal_coniferous_forest");
  public static final ResourceKey<PlacedFeature> TREES_BOREAL_FOREST  = createKey("trees_boreal_forest");
  public static final ResourceKey<PlacedFeature> TREES_WILLOW_WETLANDS  = createKey("trees_willow_wetlands");
  public static final ResourceKey<PlacedFeature> TREES_OVERGROWN_SPIRES  = createKey("trees_overgrown_spires");

  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    register(context, PATCH_MANY_CACTUS, VegetationFeatures.PATCH_CACTUS, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    register(context, WILLOW_WETLANDS_GRASS, VegetationFeatures.PATCH_TALL_GRASS, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    register(context, WILLOW_WETLANDS_SEA_PICKLE, AquaticFeatures.SEA_PICKLE, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    register(context, OVERGROWN_SPIRES_POOL, PioneerConfiguredFeatures.OVERGROWN_SPIRES_POOL, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(2)), BiomeFilter.biome());

    register(context, PINE_CHECKED, PioneerConfiguredFeatures.PINE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PINE.sapling().get()));
    register(context, FIR_CHECKED, PioneerConfiguredFeatures.FIR_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.FIR.sapling().get()));
    register(context, TAMARACK_CHECKED, PioneerConfiguredFeatures.TAMARACK_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.TAMARACK.sapling().get()));
    register(context, TAMARACK_BEES_0002_CHECKED, PioneerConfiguredFeatures.TAMARACK_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.TAMARACK.sapling().get()));
    register(context, WILLOW_CHECKED, PioneerConfiguredFeatures.WILLOW_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.WILLOW.sapling().get()));
    register(context, SPRUCE_BUSH_CHECKED, PioneerConfiguredFeatures.SPRUCE_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));

    register(context, TREES_VERDANT_SANDS, PioneerConfiguredFeatures.TREES_VERDANT_SANDS, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
    register(context, TREES_PINE_MEADOWS, PioneerConfiguredFeatures.TREES_PINE_MEADOWS, treePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
    register(context, TREES_AUTUMNAL_CONIFEROUS_FOREST, PioneerConfiguredFeatures.TREES_AUTUMNAL_CONIFEROUS_FOREST, treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
    register(context, TREES_BOREAL_FOREST, PioneerConfiguredFeatures.TREES_BOREAL_FOREST, treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
    register(context, TREES_WILLOW_WETLANDS, PioneerConfiguredFeatures.TREES_WILLOW_WETLANDS,PlacementUtils.countExtra(4, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(PioneerBlocks.WILLOW.sapling().get().defaultBlockState(), BlockPos.ZERO)));
    register(context, TREES_OVERGROWN_SPIRES, PioneerConfiguredFeatures.TREES_OVERGROWN_SPIRES, treePlacement(PlacementUtils.countExtra(13, 0.1F, 1)));
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
