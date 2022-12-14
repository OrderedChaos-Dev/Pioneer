package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class RedwoodsBiome {
	public static Biome redwoods(boolean snowy) {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());

		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenSettings);
		BiomeDefaultFeatures.addFerns(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addGiantTaigaVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		if (snowy) {
			BiomeDefaultFeatures.addRareBerryBushes(biomeGenSettings);
		} else {
			BiomeDefaultFeatures.addCommonBerryBushes(biomeGenSettings);
		}

		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeUtils.addTaigaSpawns(mobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		float temperature = snowy ? -0.4F : 0.23F;

	    return BiomeUtils.biome(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN, Biome.BiomeCategory.TAIGA, temperature, 0.8F, 4159204, 329011, 0x379332, 0x379C32, mobSpawnSettings, biomeGenSettings, null);
	}
}
