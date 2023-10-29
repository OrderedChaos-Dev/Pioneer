package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import pioneer.common.world.PioneerBiomeFeatures;

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
		PioneerBiomeFeatures.addRedwoodsTrees(biomeGenSettings);

		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeUtils.addTaigaSpawns(mobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		float temperature = snowy ? -0.4F : 0.23F;
		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
		return BiomeUtils.biome(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN, temperature, 0.8F, 4159204, 329011, 0x379332, 0x379C32, mobSpawnSettings, biomeGenSettings, music);
	}
}
