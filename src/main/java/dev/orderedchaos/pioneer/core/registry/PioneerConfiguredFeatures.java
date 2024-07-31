package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.common.world.features.tree.decorators.CoconutDecorator;
import dev.orderedchaos.pioneer.common.world.features.tree.decorators.JuniperBerriesDecorator;
import dev.orderedchaos.pioneer.common.world.features.tree.foliageplacers.*;
import dev.orderedchaos.pioneer.common.world.features.tree.trunkplacers.*;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalInt;

public class PioneerConfiguredFeatures {

  public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, Pioneer.MOD_ID);

  public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE  = createKey("palm_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_REDWOOD_TREE  = createKey("big_redwood_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE  = createKey("small_redwood_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE_BEES_0002  = createKey("small_redwood_tree_bees_0002");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE_BEES_005  = createKey("small_redwood_tree_bees_005");
  public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_TREE  = createKey("fir_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE  = createKey("pine_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE = createKey("willow_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_TREE  = createKey("baobab_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> JUNIPER_TREE  = createKey("juniper_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> COTTONWOOD_TREE  = createKey("cottonwood_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> COTTONWOOD_TREE_BEES_005  = createKey("cottonwood_tree_bees_005");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE  = createKey("aspen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES_0002  = createKey("aspen_tree_bees_0002");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES_005  = createKey("aspen_tree_bees_005");
  public static final ResourceKey<ConfiguredFeature<?, ?>> TAMARACK_TREE  = createKey("tamarack_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> TAMARACK_TREE_BEES_0002  = createKey("tamarack_tree_bees_0002");
  public static final ResourceKey<ConfiguredFeature<?, ?>> TAMARACK_TREE_BEES_005  = createKey("tamarack_tree_bees_005");
  public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_TREE  = createKey("joshua_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE  = createKey("red_maple_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE  = createKey("orange_maple_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_MAPLE_TREE  = createKey("purple_maple_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_RED_MAPLE_TREE  = createKey("fancy_red_maple_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ORANGE_MAPLE_TREE  = createKey("fancy_orange_maple_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_PURPLE_MAPLE_TREE  = createKey("fancy_purple_maple_tree");

  public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_VERDANT_SANDS  = createKey("trees_verdant_sands");

  public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
    HolderGetter<PlacedFeature> holderGetter = context.lookup(Registries.PLACED_FEATURE);

    register(context, PALM_TREE, Feature.TREE, TreeFeatureConfigs.PALM);
    register(context, BIG_REDWOOD_TREE, Feature.TREE, TreeFeatureConfigs.BIG_REDWOOD);
    register(context, SMALL_REDWOOD_TREE, Feature.TREE, TreeFeatureConfigs.SMALL_REDWOOD);
    register(context, SMALL_REDWOOD_TREE_BEES_0002, Feature.TREE, TreeFeatureConfigs.SMALL_REDWOOD_BEES_0002);
    register(context, SMALL_REDWOOD_TREE_BEES_005, Feature.TREE, TreeFeatureConfigs.SMALL_REDWOOD_BEES_005);
    register(context, FIR_TREE, Feature.TREE, TreeFeatureConfigs.FIR_);
    register(context, PINE_TREE, Feature.TREE, TreeFeatureConfigs.PINE);
    register(context, WILLOW_TREE, Feature.TREE, TreeFeatureConfigs.WILLOW);
    register(context, BAOBAB_TREE, Feature.TREE, TreeFeatureConfigs.BAOBAB);
    register(context, JUNIPER_TREE, Feature.TREE, TreeFeatureConfigs.JUNIPER);
    register(context, COTTONWOOD_TREE, Feature.TREE, TreeFeatureConfigs.COTTONWOOD);
    register(context, COTTONWOOD_TREE_BEES_005, Feature.TREE, TreeFeatureConfigs.COTTONWOOD_BEES_005);
    register(context, ASPEN_TREE, Feature.TREE, TreeFeatureConfigs.ASPEN);
    register(context, ASPEN_TREE_BEES_0002, Feature.TREE, TreeFeatureConfigs.ASPEN_BEES_0002);
    register(context, ASPEN_TREE_BEES_005, Feature.TREE, TreeFeatureConfigs.ASPEN_BEES_005);
    register(context, TAMARACK_TREE, Feature.TREE, TreeFeatureConfigs.TAMARACK);
    register(context, TAMARACK_TREE_BEES_0002, Feature.TREE, TreeFeatureConfigs.TAMARACK_BEES_0002);
    register(context, TAMARACK_TREE_BEES_005, Feature.TREE, TreeFeatureConfigs.TAMARACK_BEES_005);
    register(context, RED_MAPLE_TREE, Feature.TREE, TreeFeatureConfigs.RED_MAPLE);
    register(context, ORANGE_MAPLE_TREE, Feature.TREE, TreeFeatureConfigs.ORANGE_MAPLE);
    register(context, PURPLE_MAPLE_TREE, Feature.TREE, TreeFeatureConfigs.PURPLE_MAPLE);
    register(context, FANCY_RED_MAPLE_TREE, Feature.TREE, TreeFeatureConfigs.FANCY_RED_MAPLE);
    register(context, FANCY_ORANGE_MAPLE_TREE, Feature.TREE, TreeFeatureConfigs.FANCY_ORANGE_MAPLE);
    register(context, FANCY_PURPLE_MAPLE_TREE, Feature.TREE, TreeFeatureConfigs.FANCY_PURPLE_MAPLE);
    register(context, JOSHUA_TREE, Feature.TREE, TreeFeatureConfigs.JOSHUA);

    register(context, TREES_VERDANT_SANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(TreePlacements.ACACIA_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(TreePlacements.JUNGLE_TREE_CHECKED), 0.2F), new WeightedPlacedFeature(holderGetter.getOrThrow(TreePlacements.JUNGLE_BUSH), 0.2f), new WeightedPlacedFeature(holderGetter.getOrThrow(TreePlacements.FANCY_OAK_CHECKED), 0.2f)), holderGetter.getOrThrow(TreePlacements.OAK_CHECKED)));
  }

  private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
    return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Pioneer.MOD_ID, name));
  }

  private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
    context.register(key, new ConfiguredFeature<>(feature, config));
  }

  private static class TreeFeatureConfigs {
    private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
    private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);

    public static final TreeConfiguration PALM = tree(new PalmTrunkPlacer(7, 2, 2), new PalmFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.PALM.log().get(), PioneerBlocks.PALM.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(new CoconutDecorator()));
    public static final TreeConfiguration BIG_REDWOOD = tree(new RedwoodTrunkPlacer(31, 23, 17), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(17, 24)), PioneerBlocks.REDWOOD.log().get(), PioneerBlocks.REDWOOD.leaves().get(), new TwoLayersFeatureSize(1, 1, 2));
    public static final TreeConfiguration SMALL_REDWOOD = tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.REDWOOD.log().get(), PioneerBlocks.REDWOOD.leaves().get(), new TwoLayersFeatureSize(2, 0, 2));
    public static final TreeConfiguration SMALL_REDWOOD_BEES_0002 = tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.REDWOOD.log().get(), PioneerBlocks.REDWOOD.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002));
    public static final TreeConfiguration SMALL_REDWOOD_BEES_005 = tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.REDWOOD.log().get(), PioneerBlocks.REDWOOD.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005));
    public static final TreeConfiguration FIR_ = tree(new StraightTrunkPlacer(15, 4, 6), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.FIR.log().get(), PioneerBlocks.FIR.leaves().get(), new TwoLayersFeatureSize(2, 0, 2));
    public static final TreeConfiguration PINE = tree(new StraightTrunkPlacer(9, 2, 2), new PioneerPineFoliagePlacer(UniformInt.of(3, 3), UniformInt.of(1, 1), UniformInt.of(2, 3)), PioneerBlocks.PINE.log().get(), PioneerBlocks.PINE.leaves().get(), new TwoLayersFeatureSize(2, 0, 2));
    public static final TreeConfiguration WILLOW = tree(new WillowTrunkPlacer(6, 3, 3), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.WILLOW.log().get(), PioneerBlocks.WILLOW.leaves().get(), new TwoLayersFeatureSize(1, 0, 1), List.of(new LeaveVineDecorator(0.3F)));
    public static final TreeConfiguration BAOBAB = tree(new BaobabTrunkPlacer(20, 5, 2), new BaobabFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.BAOBAB.log().get(), PioneerBlocks.BAOBAB.leaves().get(), new TwoLayersFeatureSize(1, 1, 2));
    public static final TreeConfiguration JUNIPER = tree(new DesertJuniperTrunkPlacer(7, 2, 1), new DesertJuniperFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.JUNIPER.log().get(), PioneerBlocks.JUNIPER.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(new JuniperBerriesDecorator()));
    public static final TreeConfiguration COTTONWOOD = tree(new FancyTrunkPlacer(15, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.COTTONWOOD.log().get(), PioneerBlocks.COTTONWOOD.leaves().get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));
    public static final TreeConfiguration COTTONWOOD_BEES_005 = tree(new FancyTrunkPlacer(15, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PioneerBlocks.COTTONWOOD.log().get(), PioneerBlocks.COTTONWOOD.leaves().get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005));
    public static final TreeConfiguration ASPEN = tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.ASPEN.log().get(), PioneerBlocks.ASPEN.leaves().get(), new TwoLayersFeatureSize(2, 0, 2));
    public static final TreeConfiguration ASPEN_BEES_0002 = tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.ASPEN.log().get(), PioneerBlocks.ASPEN.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002));
    public static final TreeConfiguration ASPEN_BEES_005 = tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.ASPEN.log().get(), PioneerBlocks.ASPEN.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005));
    public static final TreeConfiguration RED_MAPLE = tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MAPLE.log().get(), PioneerBlocks.MAPLE.leaves().get(), new TwoLayersFeatureSize(1, 0, 1));
    public static final TreeConfiguration ORANGE_MAPLE = tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MAPLE.log().get(), PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1));
    public static final TreeConfiguration PURPLE_MAPLE = tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PioneerBlocks.MAPLE.log().get(), PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(1, 0, 1));
    public static final TreeConfiguration FANCY_RED_MAPLE = tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PioneerBlocks.MAPLE.log().get(), PioneerBlocks.MAPLE.leaves().get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));
    public static final TreeConfiguration FANCY_ORANGE_MAPLE = tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PioneerBlocks.MAPLE.log().get(), PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));
    public static final TreeConfiguration FANCY_PURPLE_MAPLE = tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PioneerBlocks.MAPLE.log().get(), PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));
    public static final TreeConfiguration TAMARACK = tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.TAMARACK.log().get(), PioneerBlocks.TAMARACK.leaves().get(), new TwoLayersFeatureSize(2, 0, 2));
    public static final TreeConfiguration TAMARACK_BEES_0002 = tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.TAMARACK.log().get(), PioneerBlocks.TAMARACK.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002));
    public static final TreeConfiguration TAMARACK_BEES_005 = tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PioneerBlocks.TAMARACK.log().get(), PioneerBlocks.TAMARACK.leaves().get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005));
    public static final TreeConfiguration JOSHUA = tree(new FancyTrunkPlacer(8, 8, 0), new DesertJuniperFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PioneerBlocks.JOSHUA.log().get(), PioneerBlocks.JOSHUA.leaves().get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));


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
  }
}
