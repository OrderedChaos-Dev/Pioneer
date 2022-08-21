package pioneer.common;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import pioneer.core.registry.PioneerBlocks;
import pioneer.core.registry.PioneerItems;

public class PioneerCompostables {
	
	public static void init() {
		setCompostInfo(PioneerBlocks.DESERT_SAGE.get(), 0.5F);
		setCompostInfo(PioneerBlocks.DESERT_AGAVE.get(), 0.65F);
		setCompostInfo(PioneerBlocks.BLOOMING_DESERT_AGAVE.get(), 0.65F);
		setCompostInfo(PioneerBlocks.PRAIRIE_GRASS.get(), 0.25F);
		setCompostInfo(PioneerBlocks.DRY_GRASS.get(), 0.25F);
		setCompostInfo(PioneerBlocks.ASPEN_FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PioneerBlocks.RED_MAPLE_FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PioneerBlocks.ORANGE_MAPLE_FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PioneerBlocks.PURPLE_MAPLE_FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PioneerBlocks.PINK_SAKURA_FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PioneerBlocks.WHITE_SAKURA_FALLEN_LEAVES.get(), 0.1F);
		
		setCompostInfo(PioneerBlocks.COCONUT.get(), 0.2F);
		setCompostInfo(PioneerItems.JUNIPER_BERRIES.get(), 0.1F);
		
		setCompostInfo(PioneerBlocks.FIR_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PINE_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.REDWOOD_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.WILLOW_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.MANGROVE_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PALM_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.ASPEN_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.JUNIPER_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.BERRIED_JUNIPER_LEAVES.get(), 0.4F);
		setCompostInfo(PioneerBlocks.COTTONWOOD_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.BAOBAB_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.RED_MAPLE_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PINK_SAKURA_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.WHITE_SAKURA_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.TAMARACK_LEAVES.get(), 0.3F);
		setCompostInfo(PioneerBlocks.JOSHUA_LEAVES.get(), 0.3F);
		
		setCompostInfo(PioneerBlocks.FIR_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PINE_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.REDWOOD_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.WILLOW_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.MANGROVE_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PALM_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.ASPEN_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.JUNIPER_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.COTTONWOOD_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.BAOBAB_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.RED_MAPLE_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.ORANGE_MAPLE_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PURPLE_MAPLE_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.PINK_SAKURA_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.WHITE_SAKURA_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.TAMARACK_SAPLING.get(), 0.3F);
		setCompostInfo(PioneerBlocks.JOSHUA_SAPLING.get(), 0.3F);
	}

	public static void setCompostInfo(ItemLike item, float chance) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
}
