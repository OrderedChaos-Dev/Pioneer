package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerBiomes {

  public static final ResourceKey<Biome> VERDANT_SANDS = createKey("verdant_sands");
//  public static final ResourceKey<Biome> PINE_MEADOWS = createKey("pine_meadows", PineMeadowsBiome::pineMeadows);
//  public static final ResourceKey<Biome> AUTUMNAL_CONIFEROUS_FOREST = createKey("autumnal_coniferous_forest", AutumnalConiferousForestBiome::autumnalConiferousForest);
//  public static final ResourceKey<Biome> BOREAL_FOREST = createKey("boreal_forest", () -> BorealForestBiome.borealForest(false));
//  public static final ResourceKey<Biome> SNOWY_BOREAL_FOREST = createKey("snowy_boreal_forest", () -> BorealForestBiome.borealForest(true));
//  public static final ResourceKey<Biome> DESERT_SHRUBLAND = createKey("desert_shrubland", DesertShrublandBiome::desertShrubland);
//  public static final ResourceKey<Biome> OVERGROWN_SPIRES = createKey("overgrown_spires", OvergrownSpiresBiome::overgrownSpires);
//  public static final ResourceKey<Biome> REDWOODS = createKey("redwoods", () -> RedwoodsBiome.redwoods(false));
//  public static final ResourceKey<Biome> SNOWY_REDWOODS = createKey("snowy_redwoods", () -> RedwoodsBiome.redwoods(true));
//  public static final ResourceKey<Biome> ASPEN_GROVE = createKey("aspen_grove", AspenGroveBiome::aspenGrove);
//  public static final ResourceKey<Biome> BAOBAB_FIELDS = createKey("baobab_fields", BaobabFieldsBiome::baobabFields);
//  public static final ResourceKey<Biome> PRAIRIE = createKey("prairie", PrairieBiome::prairie);
//  public static final ResourceKey<Biome> BLOSSOMING_FIELDS = createKey("blossoming_fields", BlossomingFieldsBiome::blossomingFields);
//  public static final ResourceKey<Biome> CRYSTAL_LAKES = createKey("crystal_lakes", CrystalLakesBiome::crystalLakes);
//  public static final ResourceKey<Biome> RED_ROCK_CANYON = createKey("red_rock_canyon", RedRockCanyonBiome::redRockCanyon);
//  public static final ResourceKey<Biome> FLOODED_FOREST = createKey("flooded_forest", FloodedForestBiome::floodedForest);
//  public static final ResourceKey<Biome> WINDSWEPT_CLIFFS = createKey("windswept_cliffs", WindsweptCliffsBiome::windsweptCliffs);
//  public static final ResourceKey<Biome> WILLOW_WETLANDS = createKey("willow_wetlands", WillowWetlandsBiome::willowWetlands);

  public static void bootstrap(BootstapContext<Biome> context) {
    HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);
    HolderGetter<ConfiguredWorldCarver<?>> carvers = context.lookup(Registries.CONFIGURED_CARVER);

    context.register(VERDANT_SANDS, verdantSands(features, carvers));
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
    BiomeDefaultFeatures.addDefaultFlowers(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultGrass(biomeGenBuilder);
    BiomeDefaultFeatures.addDesertVegetation(biomeGenBuilder);
    BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
    BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenBuilder);
    BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenBuilder);
    biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(PioneerPlacedFeatures.TREES_VERDANT_SANDS));

    MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.farmAnimals(mobSpawnBuilder);
    BiomeDefaultFeatures.desertSpawns(mobSpawnBuilder);
    mobSpawnBuilder
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6))
      .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));

    return biome(true, 0.5F, 1.5F, biomeGenBuilder, mobSpawnBuilder)
      .specialEffects(new BiomeSpecialEffects.Builder()
        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
        .waterColor(4159204)
        .waterFogColor(329011)
        .fogColor(12638463)
        .skyColor(calculateSkyColor(1.5F))
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