package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import pioneer.common.world.PioneerBiomeFeatures;

public class BorealForestBiome {
	public static Biome borealForest(boolean snowy) {
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
		PioneerBiomeFeatures.addBorealForestTrees(biomeGenSettings);

		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeUtils.addTaigaSpawns(mobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		float temperature = snowy ? -0.4F : 0.23F;

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST);

		return BiomeUtils.biome(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN, temperature, 0.8F, 4159204, 329011, 0x00994d, 0x00994d, mobSpawnSettings, biomeGenSettings, music);
	}
}
