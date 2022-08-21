package pioneer.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import pioneer.core.registry.PioneerBlocks;

public class BlockRendering {
	
	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		RenderType cutout = RenderType.cutout();
		RenderType cutout_mipped = RenderType.cutoutMipped();

		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.ASPEN_FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.RED_MAPLE_FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.ORANGE_MAPLE_FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PURPLE_MAPLE_FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PINK_SAKURA_FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.WHITE_SAKURA_FALLEN_LEAVES.get(), cutout_mipped);

		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PRAIRIE_GRASS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.DRY_GRASS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.DESERT_SAGE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.DESERT_AGAVE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.BLOOMING_DESERT_AGAVE.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_FIR_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_PINE_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_REDWOOD_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_WILLOW_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_MANGROVE_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_PALM_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_ASPEN_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_JUNIPER_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_COTTONWOOD_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_BAOBAB_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_RED_MAPLE_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_PURPLE_MAPLE_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_PINK_SAKURA_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_WHITE_SAKURA_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_TAMARACK_SAPLING.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.POTTED_JOSHUA_SAPLING.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.FIR_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.FIR_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PINE_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PINE_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.REDWOOD_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.REDWOOD_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.WILLOW_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.WILLOW_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.MANGROVE_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.MANGROVE_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PALM_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PALM_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.ASPEN_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.ASPEN_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.JUNIPER_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.JUNIPER_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.COTTONWOOD_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.COTTONWOOD_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.BAOBAB_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.BAOBAB_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.MAPLE_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.MAPLE_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.SAKURA_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.SAKURA_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.TAMARACK_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.TAMARACK_TRAPDOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.JOSHUA_DOOR.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.JOSHUA_TRAPDOOR.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.FIR_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PINE_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.REDWOOD_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.WILLOW_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.MANGROVE_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PALM_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.ASPEN_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.JUNIPER_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.BAOBAB_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.COTTONWOOD_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.RED_MAPLE_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.ORANGE_MAPLE_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PURPLE_MAPLE_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.PINK_SAKURA_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.WHITE_SAKURA_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.TAMARACK_SAPLING.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PioneerBlocks.JOSHUA_SAPLING.get(), cutout_mipped);
	}

	
}