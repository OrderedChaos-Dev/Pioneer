package pioneer.common.blocks.grower;

import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class TamarackTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return canSpawnBeehive ? PioneerConfiguredFeatures.TAMARACK_TREE_BEES_005.getHolder().get() : PioneerConfiguredFeatures.TAMARACK_TREE.getHolder().get();
	}
	
}