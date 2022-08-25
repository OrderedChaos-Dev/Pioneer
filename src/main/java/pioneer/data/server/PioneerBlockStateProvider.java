package pioneer.data.server;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import pioneer.core.Pioneer;

public class PioneerBlockStateProvider extends BlockStateProvider {

	public PioneerBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Pioneer.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		
	}

}
