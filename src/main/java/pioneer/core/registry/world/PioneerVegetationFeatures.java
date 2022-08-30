package pioneer.core.registry.world;

import java.util.List;

import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraftforge.registries.RegistryObject;
import pioneer.core.registry.PioneerBlocks;

public class PioneerVegetationFeatures {

	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_PALM = PioneerConfiguredFeatures.register("trees_palm", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.PALM_TREE_CHECKED.getHolder().get(), 0.8F)), PioneerTreePlacements.PALM_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_JUNIPER = PioneerConfiguredFeatures.register("trees_juniper", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.JUNIPER_TREE_CHECKED.getHolder().get(), 0.8F)), PioneerTreePlacements.JUNIPER_TREE_CHECKED.getHolder().get()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINE_MEADOWS_TREES = PioneerConfiguredFeatures.register("pine_meadows_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.PINE_TREE_CHECKED.getHolder().get(), 0.5F), new WeightedPlacedFeature(TreePlacements.OAK_BEES_0002, 0.2F), new WeightedPlacedFeature(TreePlacements.OAK_BEES_0002, 0.1F)), PioneerPlacements.SPRUCE_BUSH.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> AUTUMNAL_CONIFEROUS_TREES = PioneerConfiguredFeatures.register("autumnal_coniferous_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.TAMARACK_TREE_CHECKED.getHolder().get(), 0.3F), new WeightedPlacedFeature(PioneerTreePlacements.TAMARACK_TREE_BEES_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(PioneerTreePlacements.FIR_TREE_CHECKED.getHolder().get(), 0.55F)), TreePlacements.SPRUCE_CHECKED)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BOREAL_FOREST_TREES = PioneerConfiguredFeatures.register("boreal_forest_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.FIR_TREE_CHECKED.getHolder().get(), 0.75F), new WeightedPlacedFeature(PioneerTreePlacements.PINE_TREE_CHECKED.getHolder().get(), 0.2F)), PioneerTreePlacements.FIR_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DESERT_SHRUBLAND_TREES = PioneerConfiguredFeatures.register("desert_shrubland_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.JOSHUA_TREE_CHECKED.getHolder().get(), 0.8F)), PioneerTreePlacements.JOSHUA_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> OVERGROWN_SPIRES_TREES = PioneerConfiguredFeatures.register("overgrown_spires_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TreePlacements.FANCY_OAK_CHECKED, 0.05F), new WeightedPlacedFeature(TreePlacements.JUNGLE_BUSH, 0.35F), new WeightedPlacedFeature(TreePlacements.MEGA_JUNGLE_TREE_CHECKED, 0.3F), new WeightedPlacedFeature(TreePlacements.DARK_OAK_CHECKED, 0.05F), new WeightedPlacedFeature(TreePlacements.OAK_CHECKED, 0.15F), new WeightedPlacedFeature(TreePlacements.JUNGLE_TREE_CHECKED, 0.2F)), TreePlacements.JUNGLE_TREE_CHECKED)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> REDWOOD_FOREST_TREES = PioneerConfiguredFeatures.register("redwood_forest_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.BIG_REDWOOD_TREE_CHECKED.getHolder().get(), 0.75F), new WeightedPlacedFeature(PioneerTreePlacements.SMALL_REDWOOD_TREE_BEES_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(PioneerTreePlacements.SMALL_REDWOOD_TREE_CHECKED.getHolder().get(), 0.2F)), PioneerTreePlacements.SMALL_REDWOOD_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_GROVE_TREES = PioneerConfiguredFeatures.register("aspen_grove_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.ASPEN_TREE_BEES_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(PioneerTreePlacements.ASPEN_TREE_CHECKED.getHolder().get(), 0.2F), new WeightedPlacedFeature(PioneerTreePlacements.RED_MAPLE_TREE_CHECKED.getHolder().get(), 0.15F), new WeightedPlacedFeature(PioneerTreePlacements.ORANGE_MAPLE_TREE_CHECKED.getHolder().get(), 0.15F), new WeightedPlacedFeature(PioneerTreePlacements.PURPLE_MAPLE_TREE_CHECKED.getHolder().get(), 0.15F), new WeightedPlacedFeature(PioneerTreePlacements.FANCY_RED_MAPLE_TREE_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(PioneerTreePlacements.FANCY_ORANGE_MAPLE_TREE_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(PioneerTreePlacements.FANCY_PURPLE_MAPLE_TREE_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(TreePlacements.FANCY_OAK_BEES, 0.1F)), TreePlacements.FANCY_OAK_CHECKED)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> MANGROVE_MARSH_TREES = PioneerConfiguredFeatures.register("mangrove_marsh_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.MANGROVE_TREE_CHECKED.getHolder().get(), 0.9F)), PioneerTreePlacements.MANGROVE_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BAOBAB_FIELDs_TREES = PioneerConfiguredFeatures.register("baobab_fields_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.BAOBAB_TREE_CHECKED.getHolder().get(), 0.9F)), TreePlacements.ACACIA_CHECKED)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WILLOW_WETLANDS_TREES = PioneerConfiguredFeatures.register("willow_wetlands_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.WILLOW_TREE_CHECKED.getHolder().get(), 0.6F)), PioneerTreePlacements.MANGROVE_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRIMSON_THICKET_TREES = PioneerConfiguredFeatures.register("crimson_thicket_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.RED_MAPLE_TREE_CHECKED.getHolder().get(), 0.15F), new WeightedPlacedFeature(PioneerTreePlacements.FANCY_RED_MAPLE_TREE_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(PioneerTreePlacements.PURPLE_MAPLE_TREE_CHECKED.getHolder().get(), 0.15F), new WeightedPlacedFeature(PioneerTreePlacements.FANCY_PURPLE_MAPLE_TREE_CHECKED.getHolder().get(), 0.05F), new WeightedPlacedFeature(TreePlacements.SPRUCE_CHECKED, 0.3F), new WeightedPlacedFeature(TreePlacements.PINE_CHECKED, 0.1F)), TreePlacements.SPRUCE_CHECKED)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRYSTAL_LAKES_TREES = PioneerConfiguredFeatures.register("crystal_lakes_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.FIR_TREE_CHECKED.getHolder().get(), 0.75F), new WeightedPlacedFeature(PioneerTreePlacements.PINE_TREE_CHECKED.getHolder().get(), 0.2F)), PioneerTreePlacements.FIR_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WINDSWEPT_CLIFFS_TREES = PioneerConfiguredFeatures.register("windswept_cliffs_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TreePlacements.OAK_CHECKED, 0.6F), new WeightedPlacedFeature(TreePlacements.OAK_BEES_0002, 0.05F)), PioneerPlacements.OAK_BUSH.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PRAIRIE_TREES = PioneerConfiguredFeatures.register("prairie_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.COTTONWOOD_TREE_BEES_CHECKED.getHolder().get(), 0.4F), new WeightedPlacedFeature(PioneerTreePlacements.COTTONWOOD_TREE_CHECKED.getHolder().get(), 0.55F)), PioneerTreePlacements.COTTONWOOD_TREE_CHECKED.getHolder().get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BLOSSOMING_FIELDS_TREES = PioneerConfiguredFeatures.register("blossoming_fields_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.WHITE_SAKURA_TREE_BEES_CHECKED.getHolder().get(), 0.5F), new WeightedPlacedFeature(PioneerTreePlacements.PINK_SAKURA_TREE_BEES_CHECKED.getHolder().get(), 0.5F)), PioneerTreePlacements.PINK_SAKURA_TREE_BEES_CHECKED.getHolder().get())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> EXTRA_VEGETATION_LUSH_CAVES = PioneerConfiguredFeatures.register("extra_vegetation_lush_caves", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PioneerTreePlacements.MANGROVE_TREE_CHECKED.getHolder().get(), 0.4F)), PioneerTreePlacements.MANGROVE_TREE_CHECKED.getHolder().get())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> DESERT_AGAVE = PioneerConfiguredFeatures.register("desert_agave", () -> new ConfiguredFeature<>(Feature.FLOWER, PioneerConfiguredFeatures.simpleRandomPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(PioneerBlocks.DESERT_AGAVE.get().defaultBlockState(), 2).add(PioneerBlocks.BLOOMING_DESERT_AGAVE.get().defaultBlockState(), 1)))));
	
	public static void init() {};
}