package pioneer.common.blocks.grower;

import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import pioneer.core.registry.world.PioneerConfiguredFeatures;

public class WhiteSakuraTreeGrower extends AbstractTreeGrower {
	
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean canSpawnBeehive) {
		return canSpawnBeehive ? PioneerConfiguredFeatures.WHITE_SAKURA_TREE_BEES_005.getHolder().get() : PioneerConfiguredFeatures.WHITE_SAKURA_TREE.getHolder().get();
	}
	
}