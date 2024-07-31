package dev.orderedchaos.pioneer.common.world.features.tree.decorators;

import com.mojang.serialization.Codec;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerTreePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;

public class CoconutDecorator extends TreeDecorator {

  public static final CoconutDecorator INSTANCE = new CoconutDecorator();
  public static final Codec<CoconutDecorator> CODEC = Codec.unit(() -> {
    return INSTANCE;
  });

  @Override
  protected TreeDecoratorType<?> type() {
    return PioneerTreePlacers.Decorator.COCONUT_DECORATOR.get();
  }

  @Override
  public void place(TreeDecorator.Context context) {
    context.leaves().forEach((pos) -> {
      if(context.level().isStateAtPosition(pos.below(), BlockState::canBeReplaced) && context.random().nextFloat() <= 0.15F) {
        context.setBlock(pos.below(), PioneerBlocks.COCONUT.get().defaultBlockState());
      }
    });
  }
}