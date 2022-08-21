package pioneer.common.world.placements;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.RegistryObject;
import pioneer.core.registry.PioneerBlocks;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class PioneerTreePlacements {

	public static final RegistryObject<PlacedFeature> PALM_TREE_CHECKED = PioneerPlacements.register("palm_tree_checked", PioneerConfiguredFeatures.PALM_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PALM_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> BIG_REDWOOD_TREE_CHECKED = PioneerPlacements.register("big_redwood_tree_checked", PioneerConfiguredFeatures.BIG_REDWOOD_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.REDWOOD_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> SMALL_REDWOOD_TREE_CHECKED = PioneerPlacements.register("small_redwood_tree_checked", PioneerConfiguredFeatures.SMALL_REDWOOD_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.REDWOOD_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> SMALL_REDWOOD_TREE_BEES_CHECKED = PioneerPlacements.register("small_redwood_tree_bees_checked", PioneerConfiguredFeatures.SMALL_REDWOOD_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.REDWOOD_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> FIR_TREE_CHECKED = PioneerPlacements.register("fir_tree_checked", PioneerConfiguredFeatures.FIR_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.FIR_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> PINE_TREE_CHECKED = PioneerPlacements.register("pine_tree_checked", PioneerConfiguredFeatures.PINE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PINE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> WILLOW_TREE_CHECKED = PioneerPlacements.register("willow_tree_checked", PioneerConfiguredFeatures.WILLOW_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.WILLOW_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> MANGROVE_TREE_CHECKED = PioneerPlacements.register("mangrove_tree_checked", PioneerConfiguredFeatures.MANGROVE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.MANGROVE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> BAOBAB_TREE_CHECKED = PioneerPlacements.register("baobab_tree_checked", PioneerConfiguredFeatures.BAOBAB_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.BAOBAB_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> JUNIPER_TREE_CHECKED = PioneerPlacements.register("juniper_tree_checked", PioneerConfiguredFeatures.JUNIPER_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.JUNIPER_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> COTTONWOOD_TREE_CHECKED = PioneerPlacements.register("cottonwood_tree_checked", PioneerConfiguredFeatures.COTTONWOOD_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.COTTONWOOD_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> COTTONWOOD_TREE_BEES_CHECKED = PioneerPlacements.register("cottonwood_tree_bees_checked", PioneerConfiguredFeatures.COTTONWOOD_TREE_BEES_005, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.COTTONWOOD_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> PINK_SAKURA_TREE_CHECKED = PioneerPlacements.register("pink_sakura_tree_checked", PioneerConfiguredFeatures.PINK_SAKURA_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PINK_SAKURA_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> WHITE_SAKURA_TREE_CHECKED = PioneerPlacements.register("white_sakura_tree_checked", PioneerConfiguredFeatures.WHITE_SAKURA_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.WHITE_SAKURA_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> PINK_SAKURA_TREE_BEES_CHECKED = PioneerPlacements.register("pink_sakura_tree_bees_checked", PioneerConfiguredFeatures.PINK_SAKURA_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PINK_SAKURA_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> WHITE_SAKURA_TREE_BEES_CHECKED = PioneerPlacements.register("white_sakura_tree_bees_checked", PioneerConfiguredFeatures.WHITE_SAKURA_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.WHITE_SAKURA_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> ASPEN_TREE_CHECKED = PioneerPlacements.register("aspen_tree_checked", PioneerConfiguredFeatures.ASPEN_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.ASPEN_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> ASPEN_TREE_BEES_CHECKED = PioneerPlacements.register("aspen_tree_bees_checked", PioneerConfiguredFeatures.ASPEN_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.ASPEN_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> RED_MAPLE_TREE_CHECKED = PioneerPlacements.register("red_maple_tree_checked", PioneerConfiguredFeatures.RED_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.RED_MAPLE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> ORANGE_MAPLE_TREE_CHECKED = PioneerPlacements.register("orange_maple_tree_checked", PioneerConfiguredFeatures.ORANGE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.ORANGE_MAPLE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> PURPLE_MAPLE_TREE_CHECKED = PioneerPlacements.register("purple_maple_tree_checked", PioneerConfiguredFeatures.PURPLE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PURPLE_MAPLE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> FANCY_RED_MAPLE_TREE_CHECKED = PioneerPlacements.register("fancy_red_maple_tree_checked", PioneerConfiguredFeatures.FANCY_RED_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.RED_MAPLE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> FANCY_ORANGE_MAPLE_TREE_CHECKED = PioneerPlacements.register("fancy_orange_maple_tree_checked", PioneerConfiguredFeatures.FANCY_ORANGE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.ORANGE_MAPLE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> FANCY_PURPLE_MAPLE_TREE_CHECKED = PioneerPlacements.register("fancy_purple_tree_maple_checked", PioneerConfiguredFeatures.FANCY_PURPLE_MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.PURPLE_MAPLE_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> TAMARACK_TREE_CHECKED = PioneerPlacements.register("tamarack_tree_checked", PioneerConfiguredFeatures.TAMARACK_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.TAMARACK_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> TAMARACK_TREE_BEES_CHECKED = PioneerPlacements.register("tamarack_tree_bees_checked", PioneerConfiguredFeatures.TAMARACK_TREE_BEES_0002, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.TAMARACK_SAPLING.get()));
	public static final RegistryObject<PlacedFeature> JOSHUA_TREE_CHECKED = PioneerPlacements.register("joshua_tree_checked", PioneerConfiguredFeatures.JOSHUA_TREE, PlacementUtils.filteredByBlockSurvival(PioneerBlocks.JOSHUA_SAPLING.get()));

	public static void init() {};
}
