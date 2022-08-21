package pioneer.common.blocks.grower;

import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class OrangeMapleTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return random.nextInt(10) == 0 ? PioneerConfiguredFeatures.FANCY_ORANGE_MAPLE_TREE.getHolder().get() : PioneerConfiguredFeatures.ORANGE_MAPLE_TREE.getHolder().get();
	}
	
}