package dev.orderedchaos.pioneer.common.blocks;

import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerConfiguredFeatures;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BerriedJuniperLeavesBlock extends LeavesBlock {

  public BerriedJuniperLeavesBlock(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
    if(player.mayBuild()) {
      Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(PioneerItems.JUNIPER_BERRIES.get(), 1 + world.getRandom().nextInt(2)));
      world.setBlock(pos, PioneerBlocks.JUNIPER.leaves().get().defaultBlockState().setValue(PERSISTENT, state.getValue(PERSISTENT)), 2);
    }
    return InteractionResult.SUCCESS;
  }
}