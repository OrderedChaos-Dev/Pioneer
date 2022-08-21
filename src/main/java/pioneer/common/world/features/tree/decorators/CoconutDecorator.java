package pioneer.common.world.features.tree.decorators;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import pioneer.core.registry.PioneerBlocks;
import pioneer.core.registry.world.PioneerTreePlacers;

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
	public void place(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, List<BlockPos> logs, List<BlockPos> leaves) {
		leaves.forEach((pos) -> {
			if(world.isStateAtPosition(pos.below(), (state) -> state.getMaterial().isReplaceable()) && rand.nextFloat() <= 0.15F)
				placer.accept(pos.below(), PioneerBlocks.COCONUT.get().defaultBlockState());
		});
	}
}