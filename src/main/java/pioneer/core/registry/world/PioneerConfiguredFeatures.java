package pioneer.core.registry.world;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmallDripleafBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import pioneer.common.blocks.DryGrassBlock;
import pioneer.common.world.features.tree.decorators.CoconutDecorator;
import pioneer.common.world.features.tree.decorators.JuniperBerriesDecorator;
import pioneer.common.world.features.tree.foliageplacers.AspenFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.BaobabFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.DesertJuniperFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.PalmFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.PioneerPineFoliagePlacer;
import pioneer.common.world.features.tree.trunkplacers.AspenTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.BaobabTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.DesertJuniperTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.MangroveTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.PalmTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.RedwoodTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.SmallRedwoodTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.WillowTrunkPlacer;
import pioneer.core.Pioneer;
import pioneer.core.registry.PioneerBlocks;

public class PioneerConfiguredFeatures {
	
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Pioneer.MOD_ID);
	
	private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
	private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
	private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);

	public static final RegistryObject<ConfiguredFeature<?, ?>> DESERT_SAGE = register("desert_sage", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(2, 7, 2, PioneerBlocks.DESERT_SAGE.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DRY_GRASS = register("dry_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new RandomizedIntStateProvider(BlockStateProvider.simple(PioneerBlocks.DRY_GRASS.get()), DryGrassBlock.MODEL, UniformInt.of(0, 1))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PRAIRIE_GRASS = register("prairie_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(64, 7, 3, PioneerBlocks.PRAIRIE_GRASS.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SPRUCE_BUSH = register("spruce_bush", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(1, 0, 0), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), Blocks.SPRUCE_LOG, Blocks.OAK_LEAVES, new TwoLayersFeatureSize(0, 0, 0))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_FALLEN_LEAVES = register("white_sakura_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PioneerBlocks.WHITE_SAKURA_FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_FALLEN_LEAVES = register("pink_sakura_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PioneerBlocks.PINK_SAKURA_FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_FALLEN_LEAVES = register("aspen_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PioneerBlocks.ASPEN_FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE_FALLEN_LEAVES = register("red_maple_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PioneerBlocks.RED_MAPLE_FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_MAPLE_FALLEN_LEAVES = register("orange_maple_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PioneerBlocks.ORANGE_MAPLE_FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PURPLE_MAPLE_FALLEN_LEAVES = register("purple_maple_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PioneerBlocks.PURPLE_MAPLE_FALLEN_LEAVES.get().defaultBlockState())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> AMETHYST_CRYSTALS = register("amethyst_crystals", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SMALL_AMETHYST_BUD.defaultBlockState(), 2).add(Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(), 2).add(Blocks.LARGE_AMETHYST_BUD.defaultBlockState(), 2).add(Blocks.AMETHYST_CLUSTER.defaultBlockState(), 1)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DRIPLEAF = register("dripleaf", () -> new ConfiguredFeature<>(Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(makeSmallDripleaf(), makeDripleaf(Direction.EAST), makeDripleaf(Direction.WEST), makeDripleaf(Direction.SOUTH), makeDripleaf(Direction.NORTH)))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> PALM_TREE = register("palm_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new PalmTrunkPlacer(7, 2, 2), new PalmFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.PALM_LOG.get(), PioneerBlocks.PALM_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(new CoconutDecorator()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BIG_REDWOOD_TREE = register("big_redwood_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new RedwoodTrunkPlacer(31, 23, 17), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(17, 24)), PioneerBlocks.REDWOOD_LOG.get(), PioneerBlocks.REDWOOD_LEAVES.get(), new TwoLayersFeatureSize(1, 1, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE = register("small_redwood_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.REDWOOD_LOG.get(), PioneerBlocks.REDWOOD_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE_BEES_0002 = register("small_redwood_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.REDWOOD_LOG.get(), PioneerBlocks.REDWOOD_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE_BEES_005 = register("small_redwood_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.REDWOOD_LOG.get(), PioneerBlocks.REDWOOD_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FIR_TREE = register("fir_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 4, 6), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.FIR_LOG.get(), PioneerBlocks.FIR_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINE_TREE = register("pine_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(9, 2, 2), new PioneerPineFoliagePlacer(UniformInt.of(3, 3), UniformInt.of(1, 1), UniformInt.of(2, 3)), PioneerBlocks.PINE_LOG.get(), PioneerBlocks.PINE_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WILLOW_TREE = register("willow_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new WillowTrunkPlacer(6, 3, 3), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.WILLOW_LOG.get(), PioneerBlocks.WILLOW_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1), List.of(new LeaveVineDecorator()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> MANGROVE_TREE = register("mangrove_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new MangroveTrunkPlacer(4, 2, 2), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MANGROVE_LOG.get(), PioneerBlocks.MANGROVE_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BAOBAB_TREE = register("baobab_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new BaobabTrunkPlacer(20, 5, 2), new BaobabFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.BAOBAB_LOG.get(), PioneerBlocks.BAOBAB_LEAVES.get(), new TwoLayersFeatureSize(1, 1, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> JUNIPER_TREE = register("juniper_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new DesertJuniperTrunkPlacer(7, 2, 1), new DesertJuniperFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.JUNIPER_LOG.get(), PioneerBlocks.JUNIPER_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(new JuniperBerriesDecorator()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> COTTONWOOD_TREE = register("cottonwood_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(15, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.COTTONWOOD_LOG.get(), PioneerBlocks.COTTONWOOD_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> COTTONWOOD_TREE_BEES_005 = register("cottonwood_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(15, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.COTTONWOOD_LOG.get(), PioneerBlocks.COTTONWOOD_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE = register("pink_sakura_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.SAKURA_LOG.get(), PioneerBlocks.PINK_SAKURA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE = register("white_sakura_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.SAKURA_LOG.get(), PioneerBlocks.WHITE_SAKURA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE_BEES_0002 = register("pink_sakura_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.SAKURA_LOG.get(), PioneerBlocks.PINK_SAKURA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE_BEES_0002 = register("white_sakura_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.SAKURA_LOG.get(), PioneerBlocks.WHITE_SAKURA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE_BEES_005 = register("pink_sakura_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.SAKURA_LOG.get(), PioneerBlocks.PINK_SAKURA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE_BEES_005 = register("white_sakura_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.SAKURA_LOG.get(), PioneerBlocks.WHITE_SAKURA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_TREE = register("aspen_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.ASPEN_LOG.get(), PioneerBlocks.ASPEN_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES_0002 = register("aspen_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.ASPEN_LOG.get(), PioneerBlocks.ASPEN_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES_005 = register("aspen_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.ASPEN_LOG.get(), PioneerBlocks.ASPEN_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE_TREE = register("red_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MAPLE_LOG.get(), PioneerBlocks.RED_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = register("orange_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MAPLE_LOG.get(), PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PURPLE_MAPLE_TREE = register("purple_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MAPLE_LOG.get(), PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_RED_MAPLE_TREE = register("fancy_red_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PioneerBlocks.MAPLE_LOG.get(), PioneerBlocks.RED_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_ORANGE_MAPLE_TREE = register("fancy_orange_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PioneerBlocks.MAPLE_LOG.get(), PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_PURPLE_MAPLE_TREE = register("fancy_purple_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PioneerBlocks.MAPLE_LOG.get(), PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAMARACK_TREE = register("tamarack_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.TAMARACK_LOG.get(), PioneerBlocks.TAMARACK_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAMARACK_TREE_BEES_0002 = register("tamarack_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.TAMARACK_LOG.get(), PioneerBlocks.TAMARACK_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAMARACK_TREE_BEES_005 = register("tamarack_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.TAMARACK_LOG.get(), PioneerBlocks.TAMARACK_LEAVES.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> JOSHUA_TREE = register("joshua_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(8, 8, 0), new DesertJuniperFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.JOSHUA_LOG.get(), PioneerBlocks.JOSHUA_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRYSTAL_POOL = register("crystal_pool", () -> new ConfiguredFeature<>(Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(
					BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.STONE), PlacementUtils.inlinePlaced(CaveFeatures.GLOW_LICHEN), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FLOOD_POOL = register("flood_pool", () -> new ConfiguredFeature<>(Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(
			BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.GRASS_BLOCK), PlacementUtils.inlinePlaced(CaveFeatures.DRIPLEAF), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F)));

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistryObject<ConfiguredFeature<?, ?>> register(String name, Supplier<ConfiguredFeature<?, ?>> configuredFeature) {
		return CONFIGURED_FEATURES.register(name, configuredFeature);
	}
	
	private static RandomPatchConfiguration createRandomPatchFeature(int tries, int xzSpread, int ySpread, BlockState block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PioneerFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
				new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))),
								BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration simpleRandomPatch(BlockState blockstate) {
		return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(blockstate)));
	}
	
	public static RandomPatchConfiguration simpleRandomPatch(BlockStateProvider provider) {
		return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider));
	}
	
	private static RandomPatchConfiguration columnPlantWithFluid(int tries, int xzspread, int yspread, Block block, Fluid fluid1, Fluid fluid2) {
		return new RandomPatchConfiguration(tries, xzspread, yspread, PlacementUtils.filtered(Feature.BLOCK_COLUMN, BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 4), BlockStateProvider.simple(block)),
		    		  BlockPredicate.allOf(BlockPredicate.matchesBlock(Blocks.AIR, BlockPos.ZERO),
		    				  BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO),
		    				  BlockPredicate.anyOf(BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    						  new BlockPos(1, -1, 0)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    								  new BlockPos(-1, -1, 0)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    										  new BlockPos(0, -1, 1)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2), new BlockPos(0, -1, -1))))));
	}
	
	private static TreeConfiguration tree(TrunkPlacer trunkPlacer, FoliagePlacer foliagePlacer, Block log, Block leaves, FeatureSize featureSize, List<TreeDecorator> decorators) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), trunkPlacer,
																						BlockStateProvider.simple(leaves),
																						foliagePlacer, featureSize).ignoreVines().decorators(decorators).build();
	}
	
	private static TreeConfiguration tree(TrunkPlacer trunkPlacer, FoliagePlacer foliagePlacer, Block log, Block leaves, FeatureSize featureSize) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), trunkPlacer,
																						BlockStateProvider.simple(leaves),
																						foliagePlacer, featureSize).ignoreVines().build();
	}
	
	private static Holder<PlacedFeature> makeDripleaf(Direction p_206468_) {
		return PlacementUtils.inlinePlaced(Feature.BLOCK_COLUMN,
				new BlockColumnConfiguration(
						List.of(BlockColumnConfiguration.layer(
								new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
										.add(UniformInt.of(0, 4), 2).add(ConstantInt.of(0), 1).build()),
								BlockStateProvider.simple(Blocks.BIG_DRIPLEAF_STEM.defaultBlockState()
										.setValue(BlockStateProperties.HORIZONTAL_FACING, p_206468_))),
								BlockColumnConfiguration.layer(ConstantInt.of(1),
										BlockStateProvider.simple(Blocks.BIG_DRIPLEAF.defaultBlockState()
												.setValue(BlockStateProperties.HORIZONTAL_FACING, p_206468_)))),
						Direction.UP, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	}

	private static Holder<PlacedFeature> makeSmallDripleaf() {
		return PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
				new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
						.add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING,
								Direction.EAST), 1)
						.add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING,
								Direction.WEST), 1)
						.add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING,
								Direction.NORTH), 1)
						.add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING,
								Direction.SOUTH), 1))));
	}
}
