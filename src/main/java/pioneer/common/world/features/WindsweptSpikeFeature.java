package pioneer.common.world.features;

import java.util.List;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WindsweptSpikeFeature extends Feature<NoneFeatureConfiguration> {
	
	private static final List<Block> bases = List.of(Blocks.COBBLESTONE, Blocks.STONE, Blocks.ANDESITE, Blocks.MOSSY_COBBLESTONE);
	private static final List<Block> tops = List.of(Blocks.COBBLESTONE_WALL, Blocks.ANDESITE_WALL, Blocks.MOSSY_COBBLESTONE_WALL);

	public WindsweptSpikeFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}
	

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos pos = context.origin();
		WorldGenLevel level = context.level();
		if(Block.isFaceFull(level.getBlockState(pos.below()).getShape(level, pos.below()), Direction.UP)) {
			if(level.isEmptyBlock(pos.above())) {
				level.setBlock(pos, bases.get(level.getRandom().nextInt(bases.size())).defaultBlockState(), 2);
				level.setBlock(pos.above(), tops.get(level.getRandom().nextInt(tops.size())).defaultBlockState(), 2);
			}
		}
		return false;
	}

}
