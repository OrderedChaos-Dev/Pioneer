package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RedRockCanyonBiome {

	public static Biome redRockCanyon() {
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		BiomeGenerationSettings.Builder biomeGenSettings = new BiomeGenerationSettings.Builder();
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenSettings);
	    
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
		BiomeDefaultFeatures.addSparseJungleTrees(biomeGenSettings);
		BiomeDefaultFeatures.addSavannaTrees(biomeGenSettings);
		BiomeDefaultFeatures.addWarmFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addJungleGrass(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenSettings);
		return BiomeUtils.biome(Biome.Precipitation.RAIN, 2.0F, 0.55F, 4159204, 329011, 0x8aab32, mobSpawnSettings, biomeGenSettings, null);
	}
}
