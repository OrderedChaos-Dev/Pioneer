package pioneer.data.server;

import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import pioneer.core.Pioneer;
import pioneer.core.registry.PioneerBlocks;

public class PioneerBlockTagsProvider extends BlockTagsProvider {

	public PioneerBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, Pioneer.MOD_ID, existingFileHelper);
	}
	
    @Override
    protected void addTags() {
    	PioneerBlocks.HELPER.getDeferredRegister().getEntries().forEach((block) -> {
    		ResourceKey<Block> key = block.getKey();
    		String name = ForgeRegistries.BLOCKS.getKey(block.get()).getPath();
    		
    		if(name.endsWith("_log")) {
    			this.tag(BlockTags.LOGS).add(key);
    			this.tag(BlockTags.LOGS_THAT_BURN).add(key);
					this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(key);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof LeavesBlock) {
    			this.tag(BlockTags.LEAVES).add(key).replace(false);
    		} else if(block.get() instanceof SaplingBlock) {
    			this.tag(BlockTags.SAPLINGS).add(key).replace(false);
    		} else if(name.endsWith("planks")) {
    			this.tag(BlockTags.PLANKS).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof StairBlock) {
    			this.tag(BlockTags.STAIRS).add(key).replace(false);
    			this.tag(BlockTags.WOODEN_STAIRS).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof SlabBlock) {
    			this.tag(BlockTags.SLABS).add(key).replace(false);
    			this.tag(BlockTags.WOODEN_SLABS).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof WoodButtonBlock) {
    			this.tag(BlockTags.WOODEN_BUTTONS).add(key).replace(false);
    			this.tag(BlockTags.BUTTONS).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof PressurePlateBlock) {
    			this.tag(BlockTags.PRESSURE_PLATES).add(key).replace(false);
    			this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof DoorBlock) {
    			this.tag(BlockTags.DOORS).add(key).replace(false);
    			this.tag(BlockTags.WOODEN_DOORS).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof TrapDoorBlock) {
    			this.tag(BlockTags.TRAPDOORS).add(key).replace(false);
    			this.tag(BlockTags.WOODEN_TRAPDOORS).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    		} else if(block.get() instanceof FenceBlock) {
    			this.tag(BlockTags.FENCES).add(key).replace(false);
    			this.tag(BlockTags.WOODEN_FENCES).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    			this.tag(Tags.Blocks.FENCES).add(key).replace(false);
    			this.tag(Tags.Blocks.FENCES_WOODEN).add(key).replace(false);
    		} else if(block.get() instanceof FenceGateBlock) {
    			this.tag(BlockTags.FENCE_GATES).add(key).replace(false);
    			this.tag(BlockTags.MINEABLE_WITH_AXE).add(key).replace(false);
    			this.tag(Tags.Blocks.FENCE_GATES).add(key).replace(false);
    			this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(key).replace(false);
    		} else if(block.get() instanceof FlowerPotBlock) {
    			this.tag(BlockTags.FLOWER_POTS).add(key).replace(false);
    		} else if(block == PioneerBlocks.PRAIRIE_GRASS || block == PioneerBlocks.DRY_GRASS) {
    			this.tag(BlockTags.REPLACEABLE_PLANTS).add(key).replace(false);
    		}
    		
    	});
    }
    
	@Override
	public String getName() {
		return "Pioneer Block Tags";
	}
}