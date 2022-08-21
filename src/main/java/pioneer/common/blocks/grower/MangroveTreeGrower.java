package pioneer.common.blocks.grower;

import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class MangroveTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return PioneerConfiguredFeatures.MANGROVE_TREE.getHolder().get();
	}
	
}