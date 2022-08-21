package pioneer.core.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import pioneer.core.Pioneer;

public class PioneerCreativeModeTab extends CreativeModeTab {
	
	public static final PioneerCreativeModeTab INSTANCE = new PioneerCreativeModeTab();

	public PioneerCreativeModeTab() {
		super(Pioneer.MOD_ID);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(PioneerBlocks.BAOBAB_SAPLING.get());
	}

}
