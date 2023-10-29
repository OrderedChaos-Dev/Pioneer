package pioneer.data.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSliceProvider;
import com.teamabnormals.blueprint.core.util.BiomeUtil;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import pioneer.core.Pioneer;
import pioneer.data.server.biome.PioneerBiomeBuilder;

public class PioneerModdedBiomeSlicesProvider extends ModdedBiomeSliceProvider {

	private final ResourceLocation OVERWORLD = new ResourceLocation("overworld");
	
	public PioneerModdedBiomeSlicesProvider(DataGenerator dataGenerator) {
		super(dataGenerator, Pioneer.MOD_ID);
	}
	
	@Override
	protected void registerSlices() {
		for(int i = 1; i <= 3; i++) {
			ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>>();
			new PioneerBiomeBuilder(i).addBiomes(pair -> builder.add(pair));
			this.registerSlice("pioneer_modded_slice_" + i, 6, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(builder.build())), OVERWORLD);
		}
	}
	

}
