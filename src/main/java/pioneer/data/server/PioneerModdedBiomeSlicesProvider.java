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
		ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>>();
		new PioneerBiomeBuilder().addBiomes(pair -> builder.add(pair));
		this.registerSlice("pioneer_modded_slice", 7, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(builder.build())), OVERWORLD);
		
//		ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>>();
//		new PioneerBiomeBuilder().addBiomes(pair -> builder.add(pair));
//		this.registerSlice("pioneer_modded_slice", new ConditionedResourceSelector(new NamesResourceSelector(LevelStem.OVERWORLD.location()),
//				new ConfigValueCondition(new ResourceLocation(Pioneer.MOD_ID, "config"),
//						PioneerConfig.enableBiomes, "enableBiomes", Collections.emptyMap(), false)),
//				8, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(builder.build())));
	}
	

}
