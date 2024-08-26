package dev.orderedchaos.pioneer.data.server;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSlice;
import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import com.teamabnormals.blueprint.core.util.BiomeUtil;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBiomes;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PioneerModdedBiomeSlices {

  public static final ResourceKey<ModdedBiomeSlice> PIONEER = ResourceKey.create(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, new ResourceLocation(Pioneer.MOD_ID, "pioneer"));

  public static final ResourceKey<Biome> VERDANT_SANDS_AREA = PioneerBiomes.createKey("verdant_sands_area");
  public static final ResourceKey<Biome> PINE_MEADOWS_AREA = PioneerBiomes.createKey("pine_meadows_area");
  public static final ResourceKey<Biome> AUTUMNAL_CONIFEROUS_FOREST_AREA = PioneerBiomes.createKey("autumnal_coniferous_forest_area");
  public static final ResourceKey<Biome> BOREAL_FOREST_AREA = PioneerBiomes.createKey("boreal_forest_area");
  public static final ResourceKey<Biome> SNOWY_BOREAL_FOREST_AREA = PioneerBiomes.createKey("snowy_boreal_forest_area");
  public static final ResourceKey<Biome> DESERT_SHRUBLAND_AREA = PioneerBiomes.createKey("desert_shrubland_area");
  public static final ResourceKey<Biome> OVERGROWN_SPIRES_AREA = PioneerBiomes.createKey("overgrown_spires_area");
  public static final ResourceKey<Biome> REDWOODS_AREA = PioneerBiomes.createKey("redwoods_area");
  public static final ResourceKey<Biome> SNOWY_REDWOODS_AREA = PioneerBiomes.createKey("snowy_redwoods_area");
  public static final ResourceKey<Biome> ASPEN_GROVE_AREA = PioneerBiomes.createKey("aspen_grove_area");
  public static final ResourceKey<Biome> BAOBAB_FIELDS_AREA = PioneerBiomes.createKey("baobab_fields_area");
  public static final ResourceKey<Biome> OLD_GROWTH_BAOBAB_FIELDS_AREA = PioneerBiomes.createKey("old_growth_baobab_fields_area");
  public static final ResourceKey<Biome> PRAIRIE_AREA = PioneerBiomes.createKey("prairie_area");
  public static final ResourceKey<Biome> CRYSTAL_LAKES_AREA = PioneerBiomes.createKey("crystal_lakes_area");
  public static final ResourceKey<Biome> RED_ROCK_CANYON_AREA = PioneerBiomes.createKey("red_rock_canyon_area");
  public static final ResourceKey<Biome> RED_ROCK_CLIFFS_AREA = PioneerBiomes.createKey("red_rock_cliffs_area");
  public static final ResourceKey<Biome> FLOODED_FOREST_AREA = PioneerBiomes.createKey("flooded_forest_area");
  public static final ResourceKey<Biome> WINDSWEPT_CLIFFS_AREA = PioneerBiomes.createKey("windswept_cliffs_area");
  public static final ResourceKey<Biome> WILLOW_WETLANDS_AREA = PioneerBiomes.createKey("willow_wetlands_area");

  public static void bootstrap(BootstapContext<ModdedBiomeSlice> context) {
    List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> entries = new ArrayList<>();
    (new PioneerBiomeBuilder()).addBiomes(entries::add);

    ModdedBiomeSlice pioneerSlice = new ModdedBiomeSlice(
      80,
      BiomeUtil.MultiNoiseModdedBiomeProvider.builder()
        .biomes(entries::forEach)
        .area(VERDANT_SANDS_AREA, PioneerBiomes.VERDANT_SANDS)
        .area(PINE_MEADOWS_AREA, PioneerBiomes.PINE_MEADOWS)
        .area(AUTUMNAL_CONIFEROUS_FOREST_AREA, PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST)
        .area(BOREAL_FOREST_AREA, PioneerBiomes.BOREAL_FOREST)
        .area(SNOWY_BOREAL_FOREST_AREA, PioneerBiomes.SNOWY_BOREAL_FOREST)
        .area(DESERT_SHRUBLAND_AREA, PioneerBiomes.DESERT_SHRUBLAND)
        .area(OVERGROWN_SPIRES_AREA, PioneerBiomes.OVERGROWN_SPIRES)
        .area(REDWOODS_AREA, PioneerBiomes.REDWOODS)
        .area(SNOWY_REDWOODS_AREA, PioneerBiomes.SNOWY_REDWOODS)
        .area(ASPEN_GROVE_AREA, PioneerBiomes.ASPEN_GROVE)
        .area(BAOBAB_FIELDS_AREA, PioneerBiomes.BAOBAB_FIELDS)
        .area(OLD_GROWTH_BAOBAB_FIELDS_AREA, PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS)
        .area(PRAIRIE_AREA, PioneerBiomes.PRAIRIE)
        .area(CRYSTAL_LAKES_AREA, PioneerBiomes.CRYSTAL_LAKES)
        .area(RED_ROCK_CANYON_AREA, PioneerBiomes.RED_ROCK_CANYON)
        .area(RED_ROCK_CLIFFS_AREA, PioneerBiomes.RED_ROCK_CLIFFS)
        .area(FLOODED_FOREST_AREA, PioneerBiomes.FLOODED_FOREST)
        .area(WINDSWEPT_CLIFFS_AREA, PioneerBiomes.WINDSWEPT_CLIFFS)
        .area(WILLOW_WETLANDS_AREA, PioneerBiomes.WILLOW_WETLANDS)
        .build(),
      LevelStem.OVERWORLD);
    context.register(PIONEER, pioneerSlice);
  }

  private static class PioneerBiomeBuilder {
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
    private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
    private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
    private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
    private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
    private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
    private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
    private final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER;
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
      {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
      {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}
    };
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
      {VANILLA, VANILLA, VANILLA, SNOWY_BOREAL_FOREST_AREA, BOREAL_FOREST_AREA},
      {PINE_MEADOWS_AREA, PINE_MEADOWS_AREA, VANILLA, BOREAL_FOREST_AREA, REDWOODS_AREA},
      {PRAIRIE_AREA, VANILLA, FLOODED_FOREST_AREA, ASPEN_GROVE_AREA, ASPEN_GROVE_AREA},
      {BAOBAB_FIELDS_AREA, BAOBAB_FIELDS_AREA, FLOODED_FOREST_AREA, OVERGROWN_SPIRES_AREA, OVERGROWN_SPIRES_AREA},
      {VERDANT_SANDS_AREA, VERDANT_SANDS_AREA, VERDANT_SANDS_AREA, VERDANT_SANDS_AREA, VERDANT_SANDS_AREA}
    };
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
      {VANILLA, null, SNOWY_BOREAL_FOREST_AREA, SNOWY_REDWOODS_AREA, AUTUMNAL_CONIFEROUS_FOREST_AREA},
      {PRAIRIE_AREA, PRAIRIE_AREA, null, CRYSTAL_LAKES_AREA, REDWOODS_AREA},
      {VANILLA, null, null, ASPEN_GROVE_AREA, null},
      {OLD_GROWTH_BAOBAB_FIELDS_AREA, OLD_GROWTH_BAOBAB_FIELDS_AREA, OVERGROWN_SPIRES_AREA, OVERGROWN_SPIRES_AREA, OVERGROWN_SPIRES_AREA},
      {DESERT_SHRUBLAND_AREA, DESERT_SHRUBLAND_AREA, null, null, null}
    };
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
      {VANILLA, VANILLA, VANILLA, SNOWY_BOREAL_FOREST_AREA, SNOWY_BOREAL_FOREST_AREA},
      {PINE_MEADOWS_AREA, PINE_MEADOWS_AREA, VANILLA, BOREAL_FOREST_AREA, REDWOODS_AREA},
      {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
      {BAOBAB_FIELDS_AREA, BAOBAB_FIELDS_AREA, VANILLA, VANILLA, VANILLA},
      {RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA}
    };
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
      {null, null, null, SNOWY_REDWOODS_AREA, SNOWY_REDWOODS_AREA},
      {null, null, null, AUTUMNAL_CONIFEROUS_FOREST_AREA, null},
      {null, null, VANILLA, VANILLA, null},
      {OLD_GROWTH_BAOBAB_FIELDS_AREA, OLD_GROWTH_BAOBAB_FIELDS_AREA, null, null, null},
      {RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA, RED_ROCK_CLIFFS_AREA}
    };
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
      {SNOWY_BOREAL_FOREST_AREA, SNOWY_BOREAL_FOREST_AREA, SNOWY_BOREAL_FOREST_AREA, SNOWY_BOREAL_FOREST_AREA, SNOWY_REDWOODS_AREA},
      {VANILLA, VANILLA, VANILLA, AUTUMNAL_CONIFEROUS_FOREST_AREA, VANILLA},
      {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
      {null, null, null, OVERGROWN_SPIRES_AREA, OVERGROWN_SPIRES_AREA},
      {null, null, null, VERDANT_SANDS_AREA, VERDANT_SANDS_AREA}
    };

    public List<Climate.ParameterPoint> spawnTarget() {
      Climate.Parameter climate$parameter = Climate.Parameter.point(0.0F);
      float f = 0.16F;
      return List.of(new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, climate$parameter, Climate.Parameter.span(-1.0F, -0.16F), 0L), new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, climate$parameter, Climate.Parameter.span(0.16F, 1.0F), 0L));
    }

    protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
      this.addOffCoastBiomes(consumer);
      this.addInlandBiomes(consumer);
      this.addUndergroundBiomes(consumer);
    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
      this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);

      for(int i = 0; i < this.temperatures.length; ++i) {
        Climate.Parameter climate$parameter = this.temperatures[i];
        this.addSurfaceBiome(consumer, climate$parameter, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][i]);
        this.addSurfaceBiome(consumer, climate$parameter, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][i]);
      }

    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
      this.addMidSlice(consumer, Climate.Parameter.span(-1.0F, -0.93333334F));
      this.addHighSlice(consumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
      this.addPeaks(consumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
      this.addHighSlice(consumer, Climate.Parameter.span(-0.56666666F, -0.4F));
      this.addMidSlice(consumer, Climate.Parameter.span(-0.4F, -0.26666668F));
      this.addLowSlice(consumer, Climate.Parameter.span(-0.26666668F, -0.05F));
      this.addValleys(consumer, Climate.Parameter.span(-0.05F, 0.05F));
      this.addLowSlice(consumer, Climate.Parameter.span(0.05F, 0.26666668F));
      this.addMidSlice(consumer, Climate.Parameter.span(0.26666668F, 0.4F));
      this.addHighSlice(consumer, Climate.Parameter.span(0.4F, 0.56666666F));
      this.addPeaks(consumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
      this.addHighSlice(consumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
      this.addMidSlice(consumer, Climate.Parameter.span(0.93333334F, 1.0F));
    }

    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187178_, Climate.Parameter p_187179_) {
      for(int i = 0; i < this.temperatures.length; ++i) {
        Climate.Parameter climate$parameter = this.temperatures[i];

        for(int j = 0; j < this.humidities.length; ++j) {
          Climate.Parameter climate$parameter1 = this.humidities[j];
          ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187179_);
          ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187179_);
          ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187179_);
          ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, p_187179_);
          ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, p_187179_);
          ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, p_187179_, resourcekey4);
          ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, p_187179_);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], p_187179_, 0.0F, resourcekey6);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], p_187179_, 0.0F, resourcekey2);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], p_187179_, 0.0F, resourcekey6);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187179_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], p_187179_, 0.0F, resourcekey3);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], p_187179_, 0.0F, resourcekey1);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], p_187179_, 0.0F, resourcekey3);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187179_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], p_187179_, 0.0F, resourcekey5);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187179_, 0.0F, resourcekey4);
          this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], p_187179_, 0.0F, resourcekey);
        }
      }

    }

    private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187198_, Climate.Parameter p_187199_) {
      for(int i = 0; i < this.temperatures.length; ++i) {
        Climate.Parameter climate$parameter = this.temperatures[i];

        for(int j = 0; j < this.humidities.length; ++j) {
          Climate.Parameter climate$parameter1 = this.humidities[j];
          ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187199_);
          ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187199_);
          ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187199_);
          ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, p_187199_);
          ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, p_187199_);
          ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, p_187199_, resourcekey);
          ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, p_187199_);
          ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, p_187199_);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187199_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[0], p_187199_, 0.0F, resourcekey6);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], p_187199_, 0.0F, resourcekey7);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[1], p_187199_, 0.0F, resourcekey2);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], p_187199_, 0.0F, resourcekey6);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187199_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], p_187199_, 0.0F, resourcekey3);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], p_187199_, 0.0F, resourcekey1);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], p_187199_, 0.0F, resourcekey3);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187199_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], p_187199_, 0.0F, resourcekey5);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187199_, 0.0F, resourcekey4);
          this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], p_187199_, 0.0F, resourcekey);
        }
      }

    }

    private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187218_, Climate.Parameter p_187219_) {
      this.addSurfaceBiome(p_187218_, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), p_187219_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187218_, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187219_, 0.0F, WILLOW_WETLANDS_AREA);
      this.addSurfaceBiome(p_187218_, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187219_, 0.0F, VANILLA);

      for(int i = 0; i < this.temperatures.length; ++i) {
        Climate.Parameter climate$parameter = this.temperatures[i];

        for(int j = 0; j < this.humidities.length; ++j) {
          Climate.Parameter climate$parameter1 = this.humidities[j];
          ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187219_);
          ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187219_);
          ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187219_);
          ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, p_187219_);
          ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, p_187219_);
          ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
          ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, p_187219_, resourcekey);
          ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, p_187219_);
          ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, p_187219_);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], p_187219_, 0.0F, resourcekey8);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], p_187219_, 0.0F, resourcekey2);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[1], p_187219_, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[2], p_187219_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[2], p_187219_, 0.0F, resourcekey1);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[2], p_187219_, 0.0F, resourcekey4);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], p_187219_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], p_187219_, 0.0F, resourcekey1);
          if (p_187219_.max() < 0L) {
            this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[4], p_187219_, 0.0F, resourcekey5);
            this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], p_187219_, 0.0F, resourcekey);
          } else {
            this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187219_, 0.0F, resourcekey);
          }

          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], p_187219_, 0.0F, resourcekey7);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], p_187219_, 0.0F, resourcekey6);
          this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187219_, 0.0F, resourcekey3);
          if (p_187219_.max() < 0L) {
            this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], p_187219_, 0.0F, resourcekey5);
          } else {
            this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], p_187219_, 0.0F, resourcekey);
          }

          if (i == 0) {
            this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187219_, 0.0F, resourcekey);
          }
        }
      }

    }

    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187229_, Climate.Parameter p_187230_) {
      this.addSurfaceBiome(p_187229_, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), p_187230_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187229_, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187230_, 0.0F, WILLOW_WETLANDS_AREA);
      this.addSurfaceBiome(p_187229_, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187230_, 0.0F, VANILLA);

      for(int i = 0; i < this.temperatures.length; ++i) {
        Climate.Parameter climate$parameter = this.temperatures[i];

        for(int j = 0; j < this.humidities.length; ++j) {
          Climate.Parameter climate$parameter1 = this.humidities[j];
          ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187230_);
          ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187230_);
          ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187230_);
          ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
          ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, p_187230_, resourcekey);
          ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, p_187230_);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187230_, 0.0F, resourcekey1);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187230_, 0.0F, resourcekey2);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187230_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187230_, 0.0F, resourcekey1);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), p_187230_, 0.0F, resourcekey3);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], p_187230_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], p_187230_, 0.0F, resourcekey5);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], p_187230_, 0.0F, resourcekey4);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187230_, 0.0F, resourcekey);
          this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], p_187230_, 0.0F, resourcekey3);
          if (i == 0) {
            this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187230_, 0.0F, resourcekey);
          }
        }
      }

    }

    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187238_, Climate.Parameter p_187239_) {
      this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187239_, 0.0F, WILLOW_WETLANDS_AREA);
      this.addSurfaceBiome(p_187238_, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187239_, 0.0F, VANILLA);
      this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187239_, 0.0F, VANILLA);

      for(int i = 0; i < this.temperatures.length; ++i) {
        Climate.Parameter climate$parameter = this.temperatures[i];

        for(int j = 0; j < this.humidities.length; ++j) {
          Climate.Parameter climate$parameter1 = this.humidities[j];
          ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187239_);
          this.addSurfaceBiome(p_187238_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187239_, 0.0F, resourcekey);
        }
      }
    }

    private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187227_) {
      this.addUndergroundBiome(p_187227_, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
      this.addUndergroundBiome(p_187227_, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
      this.addBottomBiome(p_187227_, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, VANILLA);
    }

    private ResourceKey<Biome> pickMiddleBiome(int p_187164_, int p_187165_, Climate.Parameter p_187166_) {
      if (p_187166_.max() < 0L) {
        return this.MIDDLE_BIOMES[p_187164_][p_187165_];
      } else {
        ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[p_187164_][p_187165_];
        return resourcekey == null ? this.MIDDLE_BIOMES[p_187164_][p_187165_] : resourcekey;
      }
    }

    private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int p_187192_, int p_187193_, Climate.Parameter p_187194_) {
      return p_187192_ == 4 ? this.pickBadlandsBiome(p_187193_, p_187194_) : this.pickMiddleBiome(p_187192_, p_187193_, p_187194_);
    }

    private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int p_187212_, int p_187213_, Climate.Parameter p_187214_) {
      return p_187212_ == 0 ? this.pickSlopeBiome(p_187212_, p_187213_, p_187214_) : this.pickMiddleBiomeOrBadlandsIfHot(p_187212_, p_187213_, p_187214_);
    }

    private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int p_201991_, int p_201992_, Climate.Parameter p_201993_, ResourceKey<Biome> p_201994_) {
      return p_201991_ > 1 && p_201992_ < 4 && p_201993_.max() >= 0L ? VANILLA : p_201994_;
    }

    private ResourceKey<Biome> pickShatteredCoastBiome(int p_187223_, int p_187224_, Climate.Parameter p_187225_) {
      ResourceKey<Biome> resourcekey = p_187225_.max() >= 0L ? this.pickMiddleBiome(p_187223_, p_187224_, p_187225_) : this.pickBeachBiome(p_187223_, p_187224_);
      return this.maybePickWindsweptSavannaBiome(p_187223_, p_187224_, p_187225_, resourcekey);
    }

    private ResourceKey<Biome> pickBeachBiome(int p_187161_, int p_187162_) {
      return VANILLA;
    }

    private ResourceKey<Biome> pickBadlandsBiome(int p_187173_, Climate.Parameter p_187174_) {
      if (p_187173_ < 2) {
        return RED_ROCK_CANYON_AREA;
      } else {
        return RED_ROCK_CLIFFS_AREA;
      }
    }

    private ResourceKey<Biome> pickPlateauBiome(int p_187234_, int p_187235_, Climate.Parameter p_187236_) {
      if (p_187236_.max() >= 0L) {
        ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[p_187234_][p_187235_];
        if (resourcekey != null) {
          return resourcekey;
        }
      }

      return this.PLATEAU_BIOMES[p_187234_][p_187235_];
    }

    private ResourceKey<Biome> pickPeakBiome(int p_187241_, int p_187242_, Climate.Parameter p_187243_) {
      if (p_187241_ <= 2) {
        return p_187243_.max() < 0L ? WINDSWEPT_CLIFFS_AREA : VANILLA;
      } else {
        return p_187241_ == 3 ? WINDSWEPT_CLIFFS_AREA : this.pickBadlandsBiome(p_187242_, p_187243_);
      }
    }

    private ResourceKey<Biome> pickSlopeBiome(int p_187245_, int p_187246_, Climate.Parameter p_187247_) {
      if (p_187245_ >= 3) {
        return this.pickPlateauBiome(p_187245_, p_187246_, p_187247_);
      } else {
        return VANILLA;
      }
    }

    private ResourceKey<Biome> pickShatteredBiome(int p_202002_, int p_202003_, Climate.Parameter p_202004_) {
      ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[p_202002_][p_202003_];
      return resourcekey == null ? this.pickMiddleBiome(p_202002_, p_202003_, p_202004_) : resourcekey;
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187181_, Climate.Parameter p_187182_, Climate.Parameter p_187183_, Climate.Parameter p_187184_, Climate.Parameter p_187185_, Climate.Parameter p_187186_, float p_187187_, ResourceKey<Biome> p_187188_) {
      p_187181_.accept(Pair.of(Climate.parameters(p_187182_, p_187183_, p_187184_, p_187185_, Climate.Parameter.point(0.0F), p_187186_, p_187187_), p_187188_));
      p_187181_.accept(Pair.of(Climate.parameters(p_187182_, p_187183_, p_187184_, p_187185_, Climate.Parameter.point(1.0F), p_187186_, p_187187_), p_187188_));
    }

    private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187201_, Climate.Parameter p_187202_, Climate.Parameter p_187203_, Climate.Parameter p_187204_, Climate.Parameter p_187205_, Climate.Parameter p_187206_, float p_187207_, ResourceKey<Biome> p_187208_) {
      p_187201_.accept(Pair.of(Climate.parameters(p_187202_, p_187203_, p_187204_, p_187205_, Climate.Parameter.span(0.2F, 0.9F), p_187206_, p_187207_), p_187208_));
    }

    private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_220669_, Climate.Parameter p_220670_, Climate.Parameter p_220671_, Climate.Parameter p_220672_, Climate.Parameter p_220673_, Climate.Parameter p_220674_, float p_220675_, ResourceKey<Biome> p_220676_) {
      p_220669_.accept(Pair.of(Climate.parameters(p_220670_, p_220671_, p_220672_, p_220673_, Climate.Parameter.point(1.1F), p_220674_, p_220675_), p_220676_));
    }
  }

}
