package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import pioneer.common.world.PioneerBiomeFeatures;

public class CrystalLakesBiome {
	public static Biome crystalLakes() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());

		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenSettings);
		BiomeDefaultFeatures.addFerns(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addGiantTaigaVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addCommonBerryBushes(biomeGenSettings);
		PioneerBiomeFeatures.addCrystalLakesVegetation(biomeGenSettings);

		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeUtils.addTaigaSpawns(mobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST);
		return BiomeUtils.biome(Biome.Precipitation.RAIN, 0.23F, 0.8F, 4445678, 329011, 0x5bbf39, 0x00994d, mobSpawnSettings, biomeGenSettings, music);
	}
}
