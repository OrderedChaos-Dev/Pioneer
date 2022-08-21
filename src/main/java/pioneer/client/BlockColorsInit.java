package pioneer.client;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pioneer.core.registry.PioneerBlocks;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockColorsInit {

    @SubscribeEvent
    public static void onColorHandlerEvent(ColorHandlerEvent.Block event) {
    	BlockColors blockColors = event.getBlockColors();

		registerWaterColorBlock(blockColors, PioneerBlocks.POTTED_MANGROVE_SAPLING.get());
    }
	
	private static void registerWaterColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getAverageWaterColor(world, pos)
				: -1, block);
	}
}
