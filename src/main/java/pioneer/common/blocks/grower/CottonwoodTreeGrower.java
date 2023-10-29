package pioneer.common.blocks.grower;

import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class CottonwoodTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean canSpawnBeehive) {
		return canSpawnBeehive ? PioneerConfiguredFeatures.COTTONWOOD_TREE_BEES_005.getHolder().get() : PioneerConfiguredFeatures.COTTONWOOD_TREE.getHolder().get();
	}
	
}