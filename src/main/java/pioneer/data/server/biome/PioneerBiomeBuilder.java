package pioneer.data.server.biome;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;

import net.minecraft.SharedConstants;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import pioneer.core.registry.world.PioneerBiomes;

@SuppressWarnings("unchecked")
public class PioneerBiomeBuilder {
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
	private final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER.getKey();
	private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{{VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}};
	private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{{VANILLA, VANILLA, PioneerBiomes.SNOWY_REDWOODS.getKey(), PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), PioneerBiomes.BOREAL_FOREST.getKey()}, {VANILLA, PioneerBiomes.PINE_MEADOWS.getKey(), PioneerBiomes.PINE_MEADOWS.getKey(), PioneerBiomes.PINE_MEADOWS.getKey(), VANILLA}, {PioneerBiomes.BLOSSOMING_FIELDS.getKey(), PioneerBiomes.PRAIRIE.getKey(), VANILLA, VANILLA, VANILLA}, {PioneerBiomes.PRAIRIE.getKey(), VANILLA, VANILLA, VANILLA, VANILLA}, {PioneerBiomes.DESERT_SHRUBLAND.getKey(), VANILLA, VANILLA, PioneerBiomes.VERDANT_SANDS.getKey(), PioneerBiomes.VERDANT_SANDS.getKey()}};
	private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{{VANILLA, null, PioneerBiomes.SNOWY_REDWOODS.getKey(), PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey()}, {null, PioneerBiomes.ASPEN_GROVE.getKey(), PioneerBiomes.CRYSTAL_LAKES.getKey(), PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(), PioneerBiomes.REDWOODS.getKey()}, {PioneerBiomes.BAOBAB_FIELDS.getKey(), null, null, VANILLA, null}, {null, null, VANILLA, VANILLA, VANILLA}, {null, null, null, null, null}};
	private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{{VANILLA, VANILLA, VANILLA, PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), PioneerBiomes.BOREAL_FOREST.getKey()}, {VANILLA, VANILLA, VANILLA, PioneerBiomes.BOREAL_FOREST.getKey(), VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, PioneerBiomes.OVERGROWN_SPIRES.getKey(), PioneerBiomes.OVERGROWN_SPIRES.getKey()}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}};
	private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{{VANILLA, null, null, PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey()}, {null, null, VANILLA, PioneerBiomes.REDWOODS.getKey(), PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey()}, {null, null, VANILLA, VANILLA, null}, {null, null, null, PioneerBiomes.BAOBAB_FIELDS.getKey(), PioneerBiomes.BAOBAB_FIELDS.getKey()}, {VANILLA, VANILLA, null, null, null}};
	private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{{VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, PioneerBiomes.REDWOODS.getKey(), VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, PioneerBiomes.REDWOODS.getKey(), PioneerBiomes.REDWOODS.getKey()}, {null, null, null, PioneerBiomes.OVERGROWN_SPIRES.getKey(), PioneerBiomes.OVERGROWN_SPIRES.getKey()}, {null, null, null, PioneerBiomes.OVERGROWN_SPIRES.getKey(), PioneerBiomes.OVERGROWN_SPIRES.getKey()}};


	public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
		if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
			TerrainProvider.overworld(false).addDebugBiomesToVisualizeSplinePoints(consumer);
		} else {
			this.addOffCoastBiomes(consumer);
			this.addInlandBiomes(consumer);
			this.addUndergroundBiomes(consumer);
		}
	}

	private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
		this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.MUSHROOM_FIELDS);

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

	private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187178_, Climate.Parameter consumer) {
		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter climate$parameter = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, consumer);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, consumer);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, consumer);
				ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, consumer);
				ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, consumer);
				ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, consumer, resourcekey4);
				ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, consumer);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], consumer, 0.0F, resourcekey6);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], consumer, 0.0F, resourcekey2);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], consumer, 0.0F, resourcekey6);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), consumer, 0.0F, resourcekey);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], consumer, 0.0F, resourcekey3);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], consumer, 0.0F, resourcekey1);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], consumer, 0.0F, resourcekey3);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], consumer, 0.0F, resourcekey);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], consumer, 0.0F, resourcekey5);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], consumer, 0.0F, resourcekey4);
				this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], consumer, 0.0F, resourcekey);
			}
		}

	}

	private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter climate$parameter = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
				ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
				ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, weirdness);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[0], weirdness, 0.0F, resourcekey6);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey7);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[1], weirdness, 0.0F, resourcekey2);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey6);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, resourcekey3);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, resourcekey3);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey5);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey4);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
			}
		}

	}

	private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
		this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, Biomes.STONY_SHORE);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.SWAMP);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter climate$parameter = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
				ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
				ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
				ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, weirdness);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey8);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey2);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[1], weirdness, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey4);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey1);
				if (weirdness.max() < 0L) {
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[4], weirdness, 0.0F, resourcekey5);
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				} else {
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				}

				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey7);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey6);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey3);
				if (weirdness.max() < 0L) {
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey5);
				} else {
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey);
				}

				if (i == 0) {
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
				}
			}
		}

	}

	private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
		this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, Biomes.STONY_SHORE);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.SWAMP);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter climate$parameter = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
				ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
				ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
				ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, weirdness);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey2);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey1);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), weirdness, 0.0F, resourcekey3);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey5);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey4);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey3);
				if (i == 0) {
					this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
				}
			}
		}

	}

	private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? Biomes.STONY_SHORE : Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? Biomes.STONY_SHORE : Biomes.RIVER);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.FROZEN_RIVER);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter climate$parameter = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
			}
		}

	}

	private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
		this.addUndergroundBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES);
		this.addUndergroundBiome(consumer, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.LUSH_CAVES);
	}

	private ResourceKey<Biome> pickMiddleBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (weirdness.max() < 0L) {
			return this.MIDDLE_BIOMES[temperature][humidity];
		} else {
			ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[temperature][humidity];
			return resourcekey == null ? this.MIDDLE_BIOMES[temperature][humidity] : resourcekey;
		}
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int temperature, int humidity, Climate.Parameter weirdness) {
		return temperature == 4 ? this.pickBadlandsBiome(humidity, weirdness) : this.pickMiddleBiome(temperature, humidity, weirdness);
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int temperature, int humidity, Climate.Parameter weirdness) {
		return temperature == 0 ? this.pickSlopeBiome(temperature, humidity, weirdness) : this.pickMiddleBiomeOrBadlandsIfHot(temperature, humidity, weirdness);
	}

	private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int temperature, int humidity, Climate.Parameter weirdness, ResourceKey<Biome> altMiddleBiome) {
		return temperature > 1 && humidity < 4 && weirdness.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : altMiddleBiome;
	}

	private ResourceKey<Biome> pickShatteredCoastBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		ResourceKey<Biome> resourcekey = weirdness.max() >= 0L ? this.pickMiddleBiome(temperature, humidity, weirdness) : this.pickBeachBiome(temperature, humidity);
		return this.maybePickWindsweptSavannaBiome(temperature, humidity, weirdness, resourcekey);
	}

	private ResourceKey<Biome> pickBeachBiome(int temperature, int humidity) {
		if (temperature == 0) {
			return Biomes.SNOWY_BEACH;
		} else {
			return temperature == 4 ? Biomes.DESERT : Biomes.BEACH;
		}
	}

	private ResourceKey<Biome> pickBadlandsBiome(int humidity, Climate.Parameter weirdness) {
		if (humidity < 2) {
			return PioneerBiomes.RED_ROCK_CANYON.getKey();
		} else {
			return humidity < 3 ? Biomes.BADLANDS : Biomes.WOODED_BADLANDS;
		}
	}

	private ResourceKey<Biome> pickPlateauBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (weirdness.max() < 0L) {
			return this.PLATEAU_BIOMES[temperature][humidity];
		} else {
			ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[temperature][humidity];
			return resourcekey == null ? this.PLATEAU_BIOMES[temperature][humidity] : resourcekey;
		}
	}

	private ResourceKey<Biome> pickPeakBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (temperature <= 2) {
			return weirdness.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
		} else {
			return temperature == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(humidity, weirdness);
		}
	}

	private ResourceKey<Biome> pickSlopeBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (temperature >= 3) {
			return this.pickPlateauBiome(temperature, humidity, weirdness);
		} else {
			return humidity <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
		}
	}

	private ResourceKey<Biome> pickShatteredBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[temperature][humidity];
		return resourcekey == null ? this.pickMiddleBiome(temperature, humidity, weirdness) : resourcekey;
	}

	private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
	}

	private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.2F, 0.9F), weirdness, offset), biome));
	}
}