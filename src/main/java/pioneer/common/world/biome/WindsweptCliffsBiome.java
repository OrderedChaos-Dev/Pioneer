package pioneer.common.world.biome;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import pioneer.common.world.PioneerBiomeFeatures;

public class WindsweptCliffsBiome {
	
	public static Biome windsweptCliffs() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
		
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addForestGrass(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addExtraEmeralds(biomeGenSettings);
		BiomeDefaultFeatures.addInfestedStone(biomeGenSettings);
		PioneerBiomeFeatures.addWindsweptCliffsVegetation(biomeGenSettings);

		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_STONY_PEAKS);
		return new Biome.BiomeBuilder()
				.precipitation(Precipitation.RAIN)
				.temperature(0.5F)
				.downfall(0.3F)
				.generationSettings(biomeGenSettings.build())
				.mobSpawnSettings(mobSpawnSettings.build())
				.specialEffects(new BiomeSpecialEffects.Builder()
					.waterColor(4150204).waterFogColor(329011).fogColor(12638643)
					.grassColorOverride(0x98d957).foliageColorOverride(0x98d957)
					.ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.05F))
					.skyColor(BiomeUtils.calculateSkyColor(0.25F))
					.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
					.backgroundMusic(music).build())
				.build();
	}
}
