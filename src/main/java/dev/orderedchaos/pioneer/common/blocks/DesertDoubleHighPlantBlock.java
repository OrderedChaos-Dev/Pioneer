package dev.orderedchaos.pioneer.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class DesertDoubleHighPlantBlock extends DoublePlantBlock {

  public DesertDoubleHighPlantBlock(BlockBehaviour.Properties properties) {
    super(properties);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      BlockState ground = world.getBlockState(pos.below());
      return ground.is(BlockTags.DIRT) || ground.is(BlockTags.SAND) || ground.getBlock() instanceof GrassBlock;
    } else {
      BlockState blockstate = world.getBlockState(pos.below());
      if (state.getBlock() != this)
        return false;
      return blockstate.getBlock() == this && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
    }
  }
}