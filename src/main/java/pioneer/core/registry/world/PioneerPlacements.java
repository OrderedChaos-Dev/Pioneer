package pioneer.core.registry.world;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import pioneer.core.Pioneer;
import pioneer.core.registry.PioneerBlocks;

public class PioneerPlacements {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Pioneer.MOD_ID);
	
	public static final RegistryObject<PlacedFeature> DESERT_SAGE = register("desert_sage", PioneerConfiguredFeatures.DESERT_SAGE, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> DRY_GRASS = register("dry_grass", PioneerConfiguredFeatures.DRY_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(10));
	public static final RegistryObject<PlacedFeature> PRAIRIE_GRASS = register("prairie_grass", PioneerConfiguredFeatures.PRAIRIE_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(32));
	public static final RegistryObject<PlacedFeature> SPRUCE_BUSH = register("spruce_bush", PioneerConfiguredFeatures.SPRUCE_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
	public static final RegistryObject<PlacedFeature> OAK_BUSH = register("oak_bush", PioneerConfiguredFeatures.OAK_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> WINDSWEPT_SPIKE = register("windswept_spike", PioneerConfiguredFeatures.WINDSWEPT_SPIKE, VegetationPlacements.worldSurfaceSquaredWithCount(2));
	
	public static final RegistryObject<PlacedFeature> WHITE_SAKURA_FALLEN_LEAVES = register("white_sakura_fallen_leaves", PioneerConfiguredFeatures.WHITE_SAKURA_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> PINK_SAKURA_FALLEN_LEAVES = register("pink_sakura_fallen_leaves", PioneerConfiguredFeatures.PINK_SAKURA_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> ASPEN_FALLEN_LEAVES = register("aspen_fallen_leaves", PioneerConfiguredFeatures.ASPEN_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> RED_MAPLE_FALLEN_LEAVES = register("red_maple_fallen_leaves", PioneerConfiguredFeatures.RED_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> ORANGE_MAPLE_FALLEN_LEAVES = register("orange_maple_fallen_leaves", PioneerConfiguredFeatures.ORANGE_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> PURPLE_MAPLE_FALLEN_LEAVES = register("purple_maple_fallen_leaves", PioneerConfiguredFeatures.PURPLE_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));

	public static final RegistryObject<PlacedFeature> CRYSTAL_POOL = register("crystal_pool", PioneerConfiguredFeatures.CRYSTAL_POOL, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> AMETHYST_CRYSTALS = register("amethyst_crystals", PioneerConfiguredFeatures.AMETHYST_CRYSTALS, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> FLOOD_POOL = register("flood_pool", PioneerConfiguredFeatures.FLOOD_POOL, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> DRIPLEAF = register("dripleaf", PioneerConfiguredFeatures.DRIPLEAF, AquaticPlacements.seagrassPlacement(16));
	public static final RegistryObject<PlacedFeature> WETLANDS_POOL = register("wetlands_pool", PioneerConfiguredFeatures.WETLANDS_POOL, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(2)), BiomeFilter.biome());
	
	public static final RegistryObject<PlacedFeature> TREES_PALM = register("trees_palm", PioneerVegetationFeatures.TREES_PALM, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> TREES_JUNIPER = register("trees_juniper", PioneerVegetationFeatures.TREES_JUNIPER, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.04F, 1)));
	public static final RegistryObject<PlacedFeature> EXTRA_VEGETATION_LUSH_CAVES = register("extra_vegetation_lush_caves", PioneerVegetationFeatures.EXTRA_VEGETATION_LUSH_CAVES, CountPlacement.of(20), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> PINE_MEADOWS_TREES = register("pine_meadows_trees", PioneerVegetationFeatures.PINE_MEADOWS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
	public static final RegistryObject<PlacedFeature> AUTUMNAL_CONIFEROUS_TREES = register("autumnal_coniferous_trees", PioneerVegetationFeatures.AUTUMNAL_CONIFEROUS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> BOREAL_FOREST_TREES = register("boreal_forest_trees", PioneerVegetationFeatures.BOREAL_FOREST_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> DESERT_SHRUBLAND_TREES = register("desert_shrubland_trees", PioneerVegetationFeatures.DESERT_SHRUBLAND_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> OVERGROWN_SPIRES_TREES = register("overgrown_spires_trees", PioneerVegetationFeatures.OVERGROWN_SPIRES_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> BAOBAB_FIELDS_TREES = register("baobab_field_trees", PioneerVegetationFeatures.BAOBAB_FIELDs_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> PRAIRIE_TREES = register("prairie_trees", PioneerVegetationFeatures.PRAIRIE_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> REDWOOD_FOREST_TREES = register("redwood_forest_trees", PioneerVegetationFeatures.REDWOOD_FOREST_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> CRYSTAL_LAKES_TREES = register("crystal_lakes_trees", PioneerVegetationFeatures.CRYSTAL_LAKES_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> WATER_WILLOW_WETLANDS_TREES = register("water_willow_wetlands_trees", PioneerVegetationFeatures.WILLOW_WETLANDS_TREES, PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(List.of(Blocks.SAND, Blocks.DIRT, Blocks.CLAY), new BlockPos(0, -1, 0))));
	public static final RegistryObject<PlacedFeature> WILLOW_WETLANDS_TREES = register("willow_wetlands_trees", PioneerVegetationFeatures.WILLOW_WETLANDS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> BLOSSOMING_FIELDS_TREES = register("blossoming_fields_trees", PioneerVegetationFeatures.BLOSSOMING_FIELDS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> ASPEN_GROVE_TREES = register("aspen_grove_trees", PioneerVegetationFeatures.ASPEN_GROVE_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> WINDSWEPT_CLIFFS_TREES = register("windswept_cliffs_trees", PioneerVegetationFeatures.WINDSWEPT_CLIFFS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
//	public static final RegistryObject<PlacedFeature> LUSH_CACTUS = register("lush_cactus", VegetationFeatures.PATCH_CACTUS, PVJPlacements.onceEvery(2));
	public static final RegistryObject<PlacedFeature> DESERT_AGAVE = register("desert_agave", PioneerVegetationFeatures.DESERT_AGAVE, PioneerPlacements.onceEvery(32));
	
	
	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return PLACED_FEATURES.register(name, () -> new PlacedFeature(feature.getHolder().orElseThrow(), modifiers));
	}
	
	public static RegistryObject<PlacedFeature> register(String name, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return PLACED_FEATURES.register(name, () -> new PlacedFeature(feature, modifiers));
	}

	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return register(name, feature, List.of(modifiers));
	}
	
	public static List<PlacementModifier> onceEvery(int distance) {
		Builder<PlacementModifier> builder = ImmutableList.builder();
		builder.add(RarityFilter.onAverageOnceEvery(distance));

		builder.add(InSquarePlacement.spread());
		builder.add(PlacementUtils.HEIGHTMAP);
		builder.add(BiomeFilter.biome());
		return builder.build();
	}
	
	public static void init() {};
}
