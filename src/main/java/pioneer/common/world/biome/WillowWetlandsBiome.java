package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import pioneer.common.world.PioneerBiomeFeatures;

public class WillowWetlandsBiome {

	public static Biome willowWetlands() {
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);
		mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));

		BiomeGenerationSettings.Builder biomeGenSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addFossilDecoration(biomeGenSettings);
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_SWAMP);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
		BiomeDefaultFeatures.addSwampExtraVegetation(biomeGenSettings);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
		PioneerBiomeFeatures.addWillowWetlandsVegetation(biomeGenSettings);

		Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN)
				.temperature(0.8F).downfall(0.9F)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(6388580)
						.waterFogColor(2302743)
						.fogColor(12638463)
						.skyColor(BiomeUtils.calculateSkyColor(0.8F))
						.foliageColorOverride(0x70D325)
						.grassColorOverride(0x74C238)
						.backgroundMusic(music)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnSettings.build())
				.generationSettings(biomeGenSettings.build()).build();
 
	}
}
