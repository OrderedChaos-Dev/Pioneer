package pioneer.data.server;

import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import pioneer.core.Pioneer;
import pioneer.core.registry.PioneerItems;

public class PioneerItemTagsProvider extends ItemTagsProvider {

	public PioneerItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, blockTagsProvider, Pioneer.MOD_ID, existingFileHelper);
	}
	
    @Override
    protected void addTags() {
    	PioneerItems.HELPER.getDeferredRegister().getEntries().forEach((item) -> {
    		ResourceKey<Item> key = item.getKey();
    		String name = ForgeRegistries.ITEMS.getKey(item.get()).getPath();
    		if(name.endsWith("_log")) {
    			this.tag(ItemTags.LOGS).add(key);
    			this.tag(ItemTags.LOGS_THAT_BURN).add(key);
    		} else if(name.endsWith("_leaves")) {
    			this.tag(ItemTags.LEAVES).add(key).replace(false);
    		} else if(name.endsWith("_sapling")) {
    			this.tag(ItemTags.SAPLINGS).add(key).replace(false);
    		} else if(name.endsWith("planks")) {
    			this.tag(ItemTags.PLANKS).add(key).replace(false);
    		} else if(name.endsWith("_stairs")) {
    			this.tag(ItemTags.STAIRS).add(key).replace(false);
    			this.tag(ItemTags.WOODEN_STAIRS).add(key).replace(false);
    		} else if(name.endsWith("_slab")) {
    			this.tag(ItemTags.SLABS).add(key).replace(false);
    			this.tag(ItemTags.WOODEN_SLABS).add(key).replace(false);
    		} else if(name.endsWith("_button")) {
    			this.tag(ItemTags.WOODEN_BUTTONS).add(key).replace(false);
    			this.tag(ItemTags.BUTTONS).add(key).replace(false);
    		} else if(name.endsWith("_pressure_plate")) {
    			this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(key).replace(false);
    		} else if(name.endsWith("_door")) {
    			this.tag(ItemTags.DOORS).add(key).replace(false);
    			this.tag(ItemTags.WOODEN_DOORS).add(key).replace(false);
    		} else if(name.endsWith("_trapdoor")) {
    			this.tag(ItemTags.TRAPDOORS).add(key).replace(false);
    			this.tag(ItemTags.WOODEN_TRAPDOORS).add(key).replace(false);
    		} else if(name.endsWith("_fence")) {
    			this.tag(ItemTags.FENCES).add(key).replace(false);
    			this.tag(ItemTags.WOODEN_FENCES).add(key).replace(false);
    			this.tag(Tags.Items.FENCES_WOODEN).add(key).replace(false);
    		} else if(name.endsWith("_fence_gate")) {
    			this.tag(Tags.Items.FENCE_GATES).add(key).replace(false);
    			this.tag(Tags.Items.FENCE_GATES_WOODEN).add(key).replace(false);
    		}
    	});
    }
    
	@Override
	public String getName() {
		return "Pioneer Block Tags";
	}
}