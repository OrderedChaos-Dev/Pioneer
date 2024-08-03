package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBiomeTags;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PioneerBiomeTagsProvider extends BiomeTagsProvider {

  public PioneerBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(packOutput, lookupProvider, Pioneer.MOD_ID, existingFileHelper);
  }

  @Override
  public void addTags(HolderLookup.Provider lookupProvider) {
    this.tag(BiomeTags.IS_MOUNTAIN).add(PioneerBiomes.WINDSWEPT_CLIFFS);
    this.tag(BiomeTags.IS_BADLANDS).add(PioneerBiomes.RED_ROCK_CANYON, PioneerBiomes.RED_ROCK_CLIFFS);
    this.tag(BiomeTags.IS_HILL).add(PioneerBiomes.WINDSWEPT_CLIFFS);
    this.tag(BiomeTags.IS_TAIGA).add(PioneerBiomes.BOREAL_FOREST, PioneerBiomes.SNOWY_BOREAL_FOREST, PioneerBiomes.REDWOODS, PioneerBiomes.SNOWY_REDWOODS, PioneerBiomes.CRYSTAL_LAKES, PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST);
    this.tag(BiomeTags.IS_JUNGLE).add(PioneerBiomes.OVERGROWN_SPIRES);
    this.tag(BiomeTags.IS_FOREST).add(PioneerBiomes.FLOODED_FOREST, PioneerBiomes.ASPEN_GROVE);
    this.tag(BiomeTags.IS_SAVANNA).add(PioneerBiomes.BAOBAB_FIELDS, PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS);
    this.tag(BiomeTags.HAS_DESERT_PYRAMID).add(PioneerBiomes.DESERT_SHRUBLAND, PioneerBiomes.VERDANT_SANDS);
    this.tag(BiomeTags.HAS_IGLOO).add(PioneerBiomes.SNOWY_BOREAL_FOREST, PioneerBiomes.SNOWY_REDWOODS);
    this.tag(BiomeTags.HAS_JUNGLE_TEMPLE).add(PioneerBiomes.OVERGROWN_SPIRES);
    this.tag(BiomeTags.HAS_MINESHAFT).add(
      PioneerBiomes.WINDSWEPT_CLIFFS,
      PioneerBiomes.SNOWY_REDWOODS,
      PioneerBiomes.REDWOODS,
      PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST,
      PioneerBiomes.ASPEN_GROVE,
      PioneerBiomes.VERDANT_SANDS,
      PioneerBiomes.CRYSTAL_LAKES,
      PioneerBiomes.FLOODED_FOREST,
      PioneerBiomes.SNOWY_BOREAL_FOREST,
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.BOREAL_FOREST,
      PioneerBiomes.DESERT_SHRUBLAND,
      PioneerBiomes.WILLOW_WETLANDS,
      PioneerBiomes.OVERGROWN_SPIRES,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.PRAIRIE,
      PioneerBiomes.PINE_MEADOWS
    );
    this.tag(BiomeTags.HAS_MINESHAFT_MESA).add(PioneerBiomes.RED_ROCK_CANYON, PioneerBiomes.RED_ROCK_CLIFFS);
    this.tag(BiomeTags.HAS_PILLAGER_OUTPOST).add(
      PioneerBiomes.VERDANT_SANDS,
      PioneerBiomes.RED_ROCK_CANYON,
      PioneerBiomes.DESERT_SHRUBLAND,
      PioneerBiomes.RED_ROCK_CLIFFS,
      PioneerBiomes.PINE_MEADOWS,
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.PINE_MEADOWS
    );
    this.tag(BiomeTags.HAS_RUINED_PORTAL_DESERT).add(PioneerBiomes.VERDANT_SANDS, PioneerBiomes.DESERT_SHRUBLAND);
    this.tag(BiomeTags.HAS_RUINED_PORTAL_JUNGLE).add(PioneerBiomes.OVERGROWN_SPIRES);
    this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(PioneerBiomes.WILLOW_WETLANDS);
    this.tag(BiomeTags.HAS_RUINED_PORTAL_MOUNTAIN).add(PioneerBiomes.WINDSWEPT_CLIFFS, PioneerBiomes.RED_ROCK_CLIFFS, PioneerBiomes.RED_ROCK_CANYON);
    this.tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD).add(
      PioneerBiomes.SNOWY_REDWOODS,
      PioneerBiomes.REDWOODS,
      PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST,
      PioneerBiomes.ASPEN_GROVE,
      PioneerBiomes.CRYSTAL_LAKES,
      PioneerBiomes.FLOODED_FOREST,
      PioneerBiomes.SNOWY_BOREAL_FOREST,
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.BOREAL_FOREST,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.PRAIRIE,
      PioneerBiomes.PINE_MEADOWS
    );
    this.tag(BiomeTags.HAS_SWAMP_HUT).add(PioneerBiomes.WILLOW_WETLANDS);
    this.tag(BiomeTags.HAS_VILLAGE_DESERT).add(PioneerBiomes.VERDANT_SANDS, PioneerBiomes.DESERT_SHRUBLAND, PioneerBiomes.RED_ROCK_CANYON, PioneerBiomes.RED_ROCK_CLIFFS);
    this.tag(BiomeTags.HAS_VILLAGE_PLAINS).add(PioneerBiomes.PINE_MEADOWS, PioneerBiomes.PRAIRIE);
    this.tag(BiomeTags.HAS_VILLAGE_SAVANNA).add(PioneerBiomes.BAOBAB_FIELDS, PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS);
    this.tag(BiomeTags.HAS_VILLAGE_TAIGA).add(PioneerBiomes.REDWOODS, PioneerBiomes.BOREAL_FOREST, PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST, PioneerBiomes.CRYSTAL_LAKES);
    this.tag(BiomeTags.HAS_TRAIL_RUINS).add(PioneerBiomes.REDWOODS, PioneerBiomes.BOREAL_FOREST, PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST, PioneerBiomes.SNOWY_REDWOODS, PioneerBiomes.SNOWY_BOREAL_FOREST, PioneerBiomes.PRAIRIE);
    this.tag(BiomeTags.STRONGHOLD_BIASED_TO).add(
      PioneerBiomes.SNOWY_REDWOODS,
      PioneerBiomes.REDWOODS,
      PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST,
      PioneerBiomes.ASPEN_GROVE,
      PioneerBiomes.CRYSTAL_LAKES,
      PioneerBiomes.FLOODED_FOREST,
      PioneerBiomes.SNOWY_BOREAL_FOREST,
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.BOREAL_FOREST,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.PRAIRIE,
      PioneerBiomes.PINE_MEADOWS,
      PioneerBiomes.OVERGROWN_SPIRES,
      PioneerBiomes.VERDANT_SANDS,
      PioneerBiomes.DESERT_SHRUBLAND,
      PioneerBiomes.WINDSWEPT_CLIFFS,
      PioneerBiomes.RED_ROCK_CLIFFS,
      PioneerBiomes.RED_ROCK_CANYON
    );
    this.tag(BiomeTags.HAS_CLOSER_WATER_FOG).add(PioneerBiomes.WILLOW_WETLANDS);
    this.tag(BiomeTags.WATER_ON_MAP_OUTLINES).add(PioneerBiomes.WILLOW_WETLANDS);
    this.tag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).add(PioneerBiomes.SNOWY_REDWOODS, PioneerBiomes.SNOWY_BOREAL_FOREST);
    this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.OVERGROWN_SPIRES,
      PioneerBiomes.VERDANT_SANDS,
      PioneerBiomes.DESERT_SHRUBLAND,
      PioneerBiomes.RED_ROCK_CLIFFS,
      PioneerBiomes.RED_ROCK_CANYON
    );
    this.tag(BiomeTags.SPAWNS_GOLD_RABBITS).add(PioneerBiomes.VERDANT_SANDS, PioneerBiomes.DESERT_SHRUBLAND);
    this.tag(BiomeTags.SPAWNS_WHITE_RABBITS).add(PioneerBiomes.SNOWY_REDWOODS, PioneerBiomes.SNOWY_BOREAL_FOREST);
    this.tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS).add(PioneerBiomes.WILLOW_WETLANDS);
    this.tag(BiomeTags.SPAWNS_SNOW_FOXES).add(PioneerBiomes.SNOWY_REDWOODS, PioneerBiomes.SNOWY_BOREAL_FOREST);
    this.tag(BiomeTags.INCREASED_FIRE_BURNOUT).add(PioneerBiomes.WILLOW_WETLANDS, PioneerBiomes.OVERGROWN_SPIRES);
    this.tag(BiomeTags.SNOW_GOLEM_MELTS).add(
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.OVERGROWN_SPIRES,
      PioneerBiomes.VERDANT_SANDS,
      PioneerBiomes.DESERT_SHRUBLAND,
      PioneerBiomes.RED_ROCK_CLIFFS,
      PioneerBiomes.RED_ROCK_CANYON,
      PioneerBiomes.PRAIRIE
    );

    this.tag(Tags.Biomes.IS_HOT_OVERWORLD).add(
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.OVERGROWN_SPIRES,
      PioneerBiomes.VERDANT_SANDS,
      PioneerBiomes.DESERT_SHRUBLAND,
      PioneerBiomes.RED_ROCK_CLIFFS,
      PioneerBiomes.RED_ROCK_CANYON,
      PioneerBiomes.OVERGROWN_SPIRES,
      PioneerBiomes.WILLOW_WETLANDS
    );
    this.tag(Tags.Biomes.IS_COLD_OVERWORLD).add(
      PioneerBiomes.SNOWY_REDWOODS,
      PioneerBiomes.REDWOODS,
      PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST,
      PioneerBiomes.CRYSTAL_LAKES,
      PioneerBiomes.SNOWY_BOREAL_FOREST,
      PioneerBiomes.BOREAL_FOREST,
      PioneerBiomes.WINDSWEPT_CLIFFS
    );
    this.tag(Tags.Biomes.IS_SPARSE_OVERWORLD).add(
      PioneerBiomes.PRAIRIE,
      PioneerBiomes.DESERT_SHRUBLAND
    );
    this.tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(
      PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST,
      PioneerBiomes.FLOODED_FOREST,
      PioneerBiomes.SNOWY_BOREAL_FOREST,
      PioneerBiomes.BOREAL_FOREST,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.OVERGROWN_SPIRES
    );
    this.tag(Tags.Biomes.IS_WET_OVERWORLD).add(
      PioneerBiomes.FLOODED_FOREST,
      PioneerBiomes.CRYSTAL_LAKES,
      PioneerBiomes.OVERGROWN_SPIRES
    );
    this.tag(Tags.Biomes.IS_DRY_OVERWORLD).add(
      PioneerBiomes.BAOBAB_FIELDS,
      PioneerBiomes.OLD_GROWTH_BAOBAB_FIELDS,
      PioneerBiomes.PRAIRIE,
      PioneerBiomes.DESERT_SHRUBLAND
    );
    this.tag(Tags.Biomes.IS_CONIFEROUS).add(
      PioneerBiomes.SNOWY_BOREAL_FOREST,
      PioneerBiomes.BOREAL_FOREST,
      PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST,
      PioneerBiomes.SNOWY_REDWOODS,
      PioneerBiomes.REDWOODS,
      PioneerBiomes.CRYSTAL_LAKES,
      PioneerBiomes.PINE_MEADOWS
    );
    this.tag(Tags.Biomes.IS_PLATEAU).add(PioneerBiomes.RED_ROCK_CLIFFS);
    this.tag(Tags.Biomes.IS_DESERT).add(PioneerBiomes.DESERT_SHRUBLAND, PioneerBiomes.VERDANT_SANDS);
    this.tag(Tags.Biomes.IS_PLAINS).add(PioneerBiomes.PRAIRIE, PioneerBiomes.PINE_MEADOWS);
    this.tag(Tags.Biomes.IS_SWAMP).add(PioneerBiomes.WILLOW_WETLANDS);
    this.tag(Tags.Biomes.IS_SANDY).add(PioneerBiomes.DESERT_SHRUBLAND, PioneerBiomes.VERDANT_SANDS);
    this.tag(Tags.Biomes.IS_SNOWY).add(PioneerBiomes.SNOWY_BOREAL_FOREST, PioneerBiomes.SNOWY_REDWOODS);
    this.tag(Tags.Biomes.IS_PEAK).add(PioneerBiomes.WINDSWEPT_CLIFFS);
    this.tag(Tags.Biomes.IS_SLOPE).add(PioneerBiomes.WINDSWEPT_CLIFFS);
    this.tag(Tags.Biomes.IS_MOUNTAIN).add(PioneerBiomes.WINDSWEPT_CLIFFS);

    this.tag(BlueprintBiomeTags.IS_DESERT).add(PioneerBiomes.DESERT_SHRUBLAND, PioneerBiomes.VERDANT_SANDS);
    this.tag(BlueprintBiomeTags.IS_GRASSLAND).add(PioneerBiomes.PRAIRIE, PioneerBiomes.PINE_MEADOWS);
  }
}
