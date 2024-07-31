package dev.orderedchaos.pioneer.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class DesertSaplingBlock extends SaplingBlock  {
  public DesertSaplingBlock(AbstractTreeGrower treeGrower, Properties props) {
    super(treeGrower, props);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    if (level.getBlockState(pos.below()).is(BlockTags.SAND)) {
      return true;
    }

    return super.canSurvive(state, level, pos);
  }
}
