package dev.orderedchaos.pioneer.common.world.features.tree.decorators;

import com.mojang.serialization.Codec;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerTreePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;

public class JuniperBerriesDecorator extends TreeDecorator {

  public static final JuniperBerriesDecorator INSTANCE = new JuniperBerriesDecorator();
  public static final Codec<JuniperBerriesDecorator> CODEC = Codec.unit(() -> {
    return INSTANCE;
  });

  @Override
  protected TreeDecoratorType<?> type() {
    return PioneerTreePlacers.Decorator.JUNIPER_BERRIES_DECORATOR.get();
  }

  @Override
  public void place(TreeDecorator.Context context) {
    context.leaves().forEach((pos) -> {
      if(context.random().nextFloat() <= 0.2F) {
        context.setBlock(pos, PioneerBlocks.BERRIED_JUNIPER_LEAVES.get().defaultBlockState());
      }
    });
  }
}