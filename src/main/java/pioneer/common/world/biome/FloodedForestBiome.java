package pioneer.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import pioneer.common.world.PioneerBiomeFeatures;

public class FloodedForestBiome {

  public static Biome floodedForest() {
    BiomeGenerationSettings.Builder biomeGenSettings = new BiomeGenerationSettings.Builder();
    BiomeUtils.globalOverworldGeneration(biomeGenSettings);
    BiomeDefaultFeatures.addForestFlowers(biomeGenSettings);

    BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
    BiomeDefaultFeatures.addOtherBirchTrees(biomeGenSettings);
    BiomeDefaultFeatures.addDefaultFlowers(biomeGenSettings);
    BiomeDefaultFeatures.addForestGrass(biomeGenSettings);

    BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
    BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
    PioneerBiomeFeatures.addFloodedForestVegetation(biomeGenSettings);

    MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
    BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);
    mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

    Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST);
    return new Biome.BiomeBuilder()
      .precipitation(Biome.Precipitation.RAIN)
      .temperature(0.7F)
      .downfall(0.8F)
      .generationSettings(biomeGenSettings.build())
      .mobSpawnSettings(mobSpawnSettings.build())
      .specialEffects(new BiomeSpecialEffects.Builder()
        .waterColor(4150204).waterFogColor(329011).fogColor(12638643)
        .skyColor(BiomeUtils.calculateSkyColor(0.5F))
        .backgroundMusic(music).build())
      .build();
  }
}
