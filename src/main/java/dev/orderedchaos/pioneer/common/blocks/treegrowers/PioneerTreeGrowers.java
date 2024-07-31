package dev.orderedchaos.pioneer.common.blocks.treegrowers;

import dev.orderedchaos.pioneer.core.registry.PioneerConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PioneerTreeGrowers {

  public static PioneerTreeGrower WILLOW = new PioneerTreeGrower(PioneerConfiguredFeatures.WILLOW_TREE);
  public static PioneerTreeGrower ASPEN = new PioneerTreeGrower(PioneerConfiguredFeatures.ASPEN_TREE, PioneerConfiguredFeatures.ASPEN_TREE_BEES_005);
  public static PioneerMegaTreeGrower BAOBAB = new PioneerMegaTreeGrower(PioneerConfiguredFeatures.BAOBAB_TREE, null);
  public static PioneerTreeGrower JOSHUA = new PioneerTreeGrower(PioneerConfiguredFeatures.JOSHUA_TREE);
  public static PioneerTreeGrower PALM = new PioneerTreeGrower(PioneerConfiguredFeatures.PALM_TREE);
  public static PioneerTreeGrower FIR = new PioneerTreeGrower(PioneerConfiguredFeatures.FIR_TREE);
  public static PioneerTreeGrower PINE = new PioneerTreeGrower(PioneerConfiguredFeatures.PINE_TREE);
  public static PioneerTreeGrower COTTONWOOD = new PioneerTreeGrower(PioneerConfiguredFeatures.COTTONWOOD_TREE, PioneerConfiguredFeatures.COTTONWOOD_TREE_BEES_005);
  public static PioneerTreeGrower JUNIPER = new PioneerTreeGrower(PioneerConfiguredFeatures.JUNIPER_TREE);
  public static PioneerTreeGrower TAMARACK = new PioneerTreeGrower(PioneerConfiguredFeatures.TAMARACK_TREE, PioneerConfiguredFeatures.TAMARACK_TREE_BEES_005);
  public static PioneerMegaTreeGrower REDWOOD = new PioneerMegaTreeGrower(PioneerConfiguredFeatures.BIG_REDWOOD_TREE, PioneerConfiguredFeatures.SMALL_REDWOOD_TREE, PioneerConfiguredFeatures.SMALL_REDWOOD_TREE_BEES_005);
  public static PioneerFancyTreeGrower RED_MAPLE = new PioneerFancyTreeGrower(PioneerConfiguredFeatures.RED_MAPLE_TREE, PioneerConfiguredFeatures.FANCY_RED_MAPLE_TREE, 10);
  public static PioneerFancyTreeGrower ORANGE_MAPLE = new PioneerFancyTreeGrower(PioneerConfiguredFeatures.ORANGE_MAPLE_TREE, PioneerConfiguredFeatures.FANCY_ORANGE_MAPLE_TREE, 10);
  public static PioneerFancyTreeGrower PURPLE_MAPLE = new PioneerFancyTreeGrower(PioneerConfiguredFeatures.PURPLE_MAPLE_TREE, PioneerConfiguredFeatures.FANCY_PURPLE_MAPLE_TREE, 10);

  public static class PioneerTreeGrower extends AbstractTreeGrower  {

    private ResourceKey<ConfiguredFeature<?, ?>> tree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> treeWithBeehive;

    public PioneerTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> tree) {
      this(tree, null);
    }

    public PioneerTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> tree, @Nullable ResourceKey<ConfiguredFeature<?, ?>> treeWithBeehive) {
      this.tree = tree;
      this.treeWithBeehive = Optional.ofNullable(treeWithBeehive);
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean canGrowBeehive) {
      if (treeWithBeehive.isPresent()) {
        return canGrowBeehive ? this.treeWithBeehive.get() : this.tree;
      } else {
        return this.tree;
      }
    }
  }

  public static class PioneerFancyTreeGrower extends AbstractTreeGrower  {

    private ResourceKey<ConfiguredFeature<?, ?>> tree;
    private ResourceKey<ConfiguredFeature<?, ?>> fancyTree;
    private int fancyChance;

    public PioneerFancyTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> tree, ResourceKey<ConfiguredFeature<?, ?>> fancyTree, int fancyChance) {
      this.tree = tree;
      this.fancyTree = fancyTree;
      this.fancyChance = fancyChance;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean canGrowBeehive) {
      return randomSource.nextInt(this.fancyChance) == 0 ? this.fancyTree : this.tree;
    }
  }

  public static class PioneerMegaTreeGrower extends AbstractMegaTreeGrower {

    private ResourceKey<ConfiguredFeature<?, ?>> bigTree;
    private Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree;
    private Optional<ResourceKey<ConfiguredFeature<?, ?>>> treeWithBeehive;

    public PioneerMegaTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> bigTree, @Nullable ResourceKey<ConfiguredFeature<?, ?>> tree) {
      this(bigTree, tree, null);
    }

    public PioneerMegaTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> bigTree, @Nullable ResourceKey<ConfiguredFeature<?, ?>> tree, @Nullable ResourceKey<ConfiguredFeature<?, ?>> treeWithBeehive) {
      this.bigTree = bigTree;
      this.tree = Optional.ofNullable(tree);
      this.treeWithBeehive = Optional.ofNullable(treeWithBeehive);
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource randomSource) {
      return this.bigTree;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean canGrowBeehive) {
      if (this.tree.isPresent()) {
        if (this.treeWithBeehive.isPresent()) {
          return canGrowBeehive ? this.treeWithBeehive.get() : this.tree.get();
        } else {
          return this.tree.get();
        }
      }
      return null;
    }
  }
}