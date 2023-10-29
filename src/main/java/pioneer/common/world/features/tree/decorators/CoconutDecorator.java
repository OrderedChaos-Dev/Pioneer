package pioneer.common.world.features.tree.decorators;


import com.mojang.serialization.Codec;
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
	public void place(Context context) {
		context.leaves().forEach((pos) -> {
			if(context.level().isStateAtPosition(pos.below(), (state) -> state.getMaterial().isReplaceable()) && context.random().nextFloat() <= 0.15F)
				context.setBlock(pos.below(), PioneerBlocks.COCONUT.get().defaultBlockState());
		});
	}
}