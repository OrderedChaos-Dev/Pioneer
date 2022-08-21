package pioneer.common.blocks.grower;

import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class RedwoodTreeGrower extends AbstractMegaTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return canSpawnBeehive ? PioneerConfiguredFeatures.SMALL_REDWOOD_TREE_BEES_005.getHolder().get() : PioneerConfiguredFeatures.SMALL_REDWOOD_TREE.getHolder().get();
	}

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random random) {
		return PioneerConfiguredFeatures.BIG_REDWOOD_TREE.getHolder().get();
	}
	
}