package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.util.FeatureOrderUtil;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerBiomes {

  public static final ResourceKey<Biome> VERDANT_SANDS = createKey("verdant_sands");
  public static final ResourceKey<Biome> PINE_MEADOWS = createKey("pine_meadows");
  public static final ResourceKey<Biome> AUTUMNAL_CONIFEROUS_FOREST = createKey("autumnal_coniferous_forest");
  public static final ResourceKey<Biome> BOREAL_FOREST = createKey("boreal_forest");
  public static final ResourceKey<Biome> SNOWY_BOREAL_FOREST = createKey("snowy_boreal_forest");
//  public static final ResourceKey<Biome> DESERT_SHRUBLAND = createKey("desert_shrubland", DesertShrublandBiome::desertShrubland);
  public static final ResourceKey<Biome> OVERGROWN_SPIRES = createKey("overgrown_spires");
  public static final ResourceKey<Biome> REDWOODS = createKey("redwoods");
  public static final ResourceKey<Biome> SNOWY_REDWOODS = createKey("snowy_redwoods");
  public static final ResourceKey<Biome> ASPEN_GROVE = createKey("aspen_grove");
  public static final ResourceKey<Biome> BAOBAB_FIELDS = createKey("baobab_fields");
  public static final ResourceKey<Biome> OLD_GROWTH_BAOBAB_FIELDS = createKey("old_growth_baobab_fields");
  public static final ResourceKey<Biome> PRAIRIE = createKey("prairie");
//  public static final ResourceKey<Biome> CRYSTAL_LAKES = createKey("crystal_lakes", CrystalLakesBiome::crystalLakes);
  public static final ResourceKey<Biome> RED_ROCK_CANYON = createKey("red_rock_canyon");
  public static final ResourceKey<Biome> RED_ROCK_CLIFFS = createKey("red_rock_cliffs");
//  public static final ResourceKey<Biome> FLOODED_FOREST = createKey("flooded_forest", FloodedForestBiome::floodedForest);
  public static final ResourceKey<Biome> WINDSWEPT_CLIFFS = createKey("windswept_cliffs");
  public static final ResourceKey<Biome> WILLOW_WETLANDS = createKey("willow_wetlands");

  public static void bootstrap(BootstapContext<Biome> context) {
    HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);
    HolderGetter<ConfiguredWorldCarver<?>> carvers = context.lookup(Registries.CONFIGURED_CARVER);

    context.register(VERDANT_SANDS, verdantSands(features, carvers));
    context.register(PINE_MEADOWS, pineMeadows(features, carvers));
    context.register(AUTUMNAL_CONIFEROUS_FOREST, autumnalConiferousForest(features, carvers));
    context.register(BOREAL_FOREST, borealForest(features, carvers, false));
    context.register(SNOWY_BOREAL_FOREST, borealForest(features, carvers, true));
    context.register(WILLOW_WETLANDS, willowWetlands(features, carvers));
    context.register(OVERGROWN_SPIRES, overgrownSpires(features, carvers));
    context.register(RED_ROCK_CANYON, verdantSands(features, carvers));
    context.register(RED_ROCK_CLIFFS, verdantSands(features, carvers));
    context.register(WINDSWEPT_CLIFFS, windsweptCliffs(features, carvers));
    context.register(BAOBAB_FIELDS, baobabFields(features, carvers, false));
    context.register(OLD_GROWTH_BAOBAB_FIELDS, baobabFields(features, carvers, true));
    context.register(ASPEN_GROVE, aspenGrove(features, carvers));
    context.register(REDWOODS, redwoods(features, carvers, false));
    context.register(SNOWY_REDWOODS, redwoods(features, carvers, true));
    context.register(PRAIRIE, prairie(features, carvers));
  }

  private static ResourceKey<Biome> createKey(String name) {
    return ResourceKey.create(Registries.BIOME, new ResourceLocation(Pioneer.MOD_ID, name));
  }

  private static Biome verdantSands(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    BiomeDefaultFeatures.addFossilDecoration(biomeGenBuilder);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);

    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_TALL_GRASS,
      VegetationPlacements.FLOWER_SWAMP,
      VegetationPlacements.FLOWER_DEFAULT,
      VegetationPlacements.PATCH_GRASS_PLAIN,
      VegetationPlacements.PATCH_DEAD_BUSH_2,
      VegetationPlacements.PATCH_SUGAR_CANE_DESERT,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_CACTUS_DESERT,
      AquaticPlacements.SEAGRASS_WARM
    );

    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.PATCH_MANY_CACTUS);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_VERDANT_SANDS);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
    BiomeDefaultFeatures.desertSpawns(mobSpawnBuilder);

    return biome(true, 0.5F, 1.5F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .skyColor(calculateSkyColor(1.5F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome pineMeadows(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);

    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.PATCH_TALL_GRASS_2,
      VegetationPlacements.PATCH_SUNFLOWER,
      VegetationPlacements.FLOWER_PLAINS,
      VegetationPlacements.PATCH_GRASS_PLAIN,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_PINE_MEADOWS);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.plainsSpawns(mobSpawnBuilder);

    return biome(true, 0.8F, 0.7F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .grassColorOverride(0x59cf70)
        .foliageColorOverride(0x69cf59)
        .skyColor(calculateSkyColor(1.5F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome autumnalConiferousForest(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.FOREST_ROCK);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.PATCH_BERRY_COMMON,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.BROWN_MUSHROOM_OLD_GROWTH,
      VegetationPlacements.RED_MUSHROOM_OLD_GROWTH,
      VegetationPlacements.FLOWER_DEFAULT,
      VegetationPlacements.PATCH_LARGE_FERN,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_GRASS_TAIGA
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_AUTUMNAL_CONIFEROUS_FOREST);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    return biome(true, 0.8F, 0.4F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .grassColorOverride(0x76b53f)
        .foliageColorOverride(0x76b53f)
        .skyColor(calculateSkyColor(0.4F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome borealForest(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean snowy) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.FOREST_ROCK);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      (snowy ? VegetationPlacements.PATCH_BERRY_RARE : VegetationPlacements.PATCH_BERRY_COMMON),
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.BROWN_MUSHROOM_OLD_GROWTH,
      VegetationPlacements.RED_MUSHROOM_OLD_GROWTH,
      VegetationPlacements.FLOWER_DEFAULT,
      VegetationPlacements.PATCH_LARGE_FERN,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_GRASS_TAIGA
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_BOREAL_FOREST);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    float temperature = snowy ? -0.4F : 0.23F;
    return biome(true, 0.8F, temperature, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .grassColorOverride(0x00994d)
        .foliageColorOverride(0x00994d)
        .skyColor(calculateSkyColor(temperature))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome willowWetlands(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    BiomeDefaultFeatures.addFossilDecoration(biomeGenBuilder);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addSwampClayDisk(biomeGenBuilder);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.FLOWER_SWAMP,
      VegetationPlacements.PATCH_GRASS_NORMAL,
      VegetationPlacements.PATCH_DEAD_BUSH,
      VegetationPlacements.PATCH_WATERLILY,
      VegetationPlacements.BROWN_MUSHROOM_SWAMP,
      VegetationPlacements.RED_MUSHROOM_SWAMP,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_SUGAR_CANE_SWAMP,
      VegetationPlacements.PATCH_PUMPKIN,
      AquaticPlacements.SEAGRASS_SWAMP
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_WILLOW_WETLANDS);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.WILLOW_WETLANDS_GRASS);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.WILLOW_WETLANDS_SEA_PICKLE);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    return biome(true, 0.9F, 0.8F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP))
        .waterColor(6388580)
        .waterFogColor(2302743)
        .fogColor(12638463)
        .grassColorOverride(0x70D325)
        .foliageColorOverride(0x74C238)
        .skyColor(0x69d170)
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome overgrownSpires(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.BAMBOO_LIGHT,
      VegetationPlacements.FLOWER_SWAMP,
      VegetationPlacements.FLOWER_WARM,
      VegetationPlacements.PATCH_WATERLILY,
      VegetationPlacements.PATCH_GRASS_JUNGLE,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_MELON,
      AquaticPlacements.SEAGRASS_SWAMP
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_OVERGROWN_SPIRES);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.OVERGROWN_SPIRES_POOL);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2))
      .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 1, 1, 2));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    return biome(true, 0.9F, 0.95F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE))
        .waterColor(4445678)
        .waterFogColor(329011)
        .fogColor(12638463)
        .skyColor(calculateSkyColor(0.95F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome windsweptCliffs(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    BiomeDefaultFeatures.addExtraEmeralds(biomeGenBuilder);
    BiomeDefaultFeatures.addInfestedStone(biomeGenBuilder);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.PATCH_GRASS_FOREST,
      VegetationPlacements.FLOWER_DEFAULT,
      VegetationPlacements.PATCH_TALL_GRASS,
      VegetationPlacements.PATCH_WATERLILY,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_WINDSWEPT_CLIFFS);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.WINDSWEPT_SPIKE);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    return biome(true, 0.3F, 0.5F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_STONY_PEAKS))
        .waterColor(4150204)
        .waterFogColor(329011)
        .grassColorOverride(0x98d957)
        .foliageColorOverride(0x98d957)
        .fogColor(12638463)
        .skyColor(calculateSkyColor(0.25F))
        .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.05F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome baobabFields(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean oldGrowth) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    BiomeDefaultFeatures.addExtraEmeralds(biomeGenBuilder);
    BiomeDefaultFeatures.addInfestedStone(biomeGenBuilder);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.PATCH_GRASS_SAVANNA,
      VegetationPlacements.FLOWER_WARM,
      VegetationPlacements.PATCH_TALL_GRASS,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN
    );
    if (oldGrowth) {
      biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_OLD_GROWTH_BAOBAB_FIELDS);
    } else {
      biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_BAOBAB_FIELDS);
    }


    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    mobSpawnBuilder
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    return biome(false, 0.0F, 1.2F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
        .waterColor(4159204)
        .waterFogColor(4159204)
        .fogColor(12638463)
        .grassColorOverride(0x8aab32)
        .foliageColorOverride(0xa6c918)
        .skyColor(calculateSkyColor(0.95F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome aspenGrove(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);

    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.PATCH_LARGE_FERN,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_GRASS_TAIGA,
      VegetationPlacements.FLOWER_DEFAULT,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_BERRY_RARE
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_ASPEN_GROVE);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.ASPEN_FALLEN_LEAVES);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.RED_MAPLE_FALLEN_LEAVES);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.ORANGE_MAPLE_FALLEN_LEAVES);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.PURPLE_MAPLE_FALLEN_LEAVES);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    return biome(true, 0.8F, 0.7F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .grassColorOverride(0xF4D342)
        .foliageColorOverride(0xB8E83E)
        .skyColor(calculateSkyColor(0.4F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome redwoods(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean snowy) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.FOREST_ROCK);
    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      (snowy ? VegetationPlacements.PATCH_BERRY_RARE : VegetationPlacements.PATCH_BERRY_COMMON),
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.BROWN_MUSHROOM_OLD_GROWTH,
      VegetationPlacements.RED_MUSHROOM_OLD_GROWTH,
      VegetationPlacements.FLOWER_DEFAULT,
      VegetationPlacements.PATCH_LARGE_FERN,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_GRASS_TAIGA
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_REDWOODS);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
    BiomeDefaultFeatures.commonSpawns(mobSpawnBuilder);

    float temperature = snowy ? -0.4F : 0.23F;
    return biome(true, 0.8F, temperature, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .grassColorOverride(0x379332)
        .foliageColorOverride(0x379C32)
        .skyColor(calculateSkyColor(temperature))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome prairie(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
    BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder(features, carvers);
    globalOverworldGeneration(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);

    FeatureOrderUtil.addFeatures(biomeGenBuilder,
      VegetationPlacements.FLOWER_PLAINS,
      VegetationPlacements.BROWN_MUSHROOM_NORMAL,
      VegetationPlacements.RED_MUSHROOM_NORMAL,
      VegetationPlacements.PATCH_SUGAR_CANE,
      VegetationPlacements.PATCH_PUMPKIN,
      VegetationPlacements.PATCH_SUNFLOWER
    );
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.TREES_PRAIRIE);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PioneerPlacedFeatures.PRAIRIE_GRASS);

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    mobSpawnBuilder
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
    BiomeDefaultFeatures.desertSpawns(mobSpawnBuilder);

    return biome(true, 0.8F, 0.6F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .grassColorOverride(0xe2fc6d)
        .foliageColorOverride(0xa7cc5c)
        .skyColor(calculateSkyColor(0.4F))
        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        .build()
      )
      .build();
  }

  private static Biome.BiomeBuilder biome(boolean hasPrecipitation, float downfall, float temperature, BiomeGenerationSettings.Builder biomeGenBuilder, MobSpawnSettings.Builder mobSpawnBuilder) {
    return new Biome.BiomeBuilder().hasPrecipitation(hasPrecipitation).downfall(downfall).temperature(temperature).generationSettings(biomeGenBuilder.build()).mobSpawnSettings(mobSpawnBuilder.build());
  }

  protected static int calculateSkyColor(float temperature) {
    float i = temperature / 3.0F;
    i = Mth.clamp(i, -1.0F, 1.0F);
    return Mth.hsvToRgb(0.62222224F - i * 0.05F, 0.5F + i * 0.1F, 1.0F);
  }

  private static void globalOverworldGeneration(BiomeGenerationSettings.Builder biomeGenBuilder) {
    BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
    BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
  }
}