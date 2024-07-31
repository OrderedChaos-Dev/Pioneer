package dev.orderedchaos.pioneer.common.world.features.tree.foliageplacers;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerTreePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class AspenFoliagePlacer extends FoliagePlacer  {

  public static final Codec<AspenFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
    return foliagePlacerParts(p).apply(p, AspenFoliagePlacer::new);
  });

  public AspenFoliagePlacer(IntProvider f1, IntProvider f2) {
    super(f1, f2);
  }

  @Override
  protected FoliagePlacerType<?> type() {
    return PioneerTreePlacers.Foliage.ASPEN_FOLIAGE_PLACER.get();
  }

  @Override
  protected void createFoliage(LevelSimulatedReader world, FoliagePlacer.FoliageSetter placer,
                               RandomSource rand, TreeConfiguration config, int p_161350_, FoliagePlacer.FoliageAttachment foliage,
                               int p_161352_, int p_161353_, int p_161354_) {

    BlockPos pos = foliage.pos();
    for(Direction dir : Direction.values()) {
      this.placeLeavesRow(world, placer, rand, config, pos.offset(dir.getNormal()), 1, 0, foliage.doubleTrunk());
    }
  }

  @Override
  public int foliageHeight(RandomSource rand, int h, TreeConfiguration config) {
    return 1;
  }

  @Override
  protected boolean shouldSkipLocation(RandomSource rand, int x, int y, int z, int radius, boolean p_230373_6_) {
    return rand.nextBoolean() || Math.abs(x) == Math.abs(z);
  }

}