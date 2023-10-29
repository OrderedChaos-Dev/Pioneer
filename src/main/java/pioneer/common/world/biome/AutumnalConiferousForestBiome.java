package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import pioneer.common.world.PioneerBiomeFeatures;

public class AutumnalConiferousForestBiome {

	public static Biome autumnalConiferousForest() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());
		
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
	    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
	    
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenSettings);
		BiomeDefaultFeatures.addFerns(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addGiantTaigaVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addRareBerryBushes(biomeGenSettings);
		PioneerBiomeFeatures.addAutumnalConiferousForestTrees(biomeGenSettings);
		
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeUtils.addTaigaSpawns(mobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST);

		return BiomeUtils.biome(Biome.Precipitation.RAIN, 0.4F, 0.8F, 4159204, 329011, 0x76b53f, 0x76b53f, mobSpawnSettings, biomeGenSettings, music);
	}
}
