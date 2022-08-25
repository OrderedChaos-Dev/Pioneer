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
public class PioneerBiomeBuilderOld {
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
	
	public static final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER.getKey();
	
    public static final ResourceKey<Biome>[][] MIDDLE_VANILLA = new ResourceKey[][]{{VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}};
    public static final ResourceKey<Biome>[][] MIDDLE_VARIANT_VANILLA = new ResourceKey[][]{{VANILLA, null, VANILLA, null, null}, {null, null, null, null, VANILLA}, {VANILLA, null, null, VANILLA, null}, {null, null, VANILLA, VANILLA, VANILLA}, {null, null, null, null, null}};
    public static final ResourceKey<Biome>[][] PLATEAU_VANILLA = new ResourceKey[][]{{VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}};
    public static final ResourceKey<Biome>[][] PLATEAU_VARIANT_VANILLA = new ResourceKey[][]{{VANILLA, null, null, null, null}, {null, null, VANILLA, VANILLA, VANILLA}, {null, null, VANILLA, VANILLA, null}, {null, null, null, null, null}, {VANILLA, VANILLA, null, null, null}};
    public static final ResourceKey<Biome>[][] SHATTERED_VANILLA = new ResourceKey[][]{{VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}, {null, null, null, null, null}, {null, null, null, null, null}};
	
	private ResourceKey<Biome>[][] OCEANS = new ResourceKey[][] { { VANILLA, VANILLA, VANILLA, VANILLA, VANILLA }, { VANILLA, VANILLA, VANILLA, VANILLA, VANILLA } };
	private ResourceKey<Biome>[][] MIDDLE_BIOMES;
	private ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT;
	private ResourceKey<Biome>[][] PLATEAU_BIOMES;
	private ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT;
	private ResourceKey<Biome>[][] SHATTERED_BIOMES;
	
	private ResourceKey<Biome> biome;

	public PioneerBiomeBuilderOld(ResourceKey<Biome> biome) {
		this.MIDDLE_BIOMES = MIDDLE_VANILLA;
		this.MIDDLE_BIOMES_VARIANT = MIDDLE_VARIANT_VANILLA;
		this.PLATEAU_BIOMES = PLATEAU_VANILLA;
		this.PLATEAU_BIOMES_VARIANT = PLATEAU_VARIANT_VANILLA;
		this.SHATTERED_BIOMES = SHATTERED_VANILLA;
		this.biome = biome;
	}
	
	public PioneerBiomeBuilderOld middle(ResourceKey<Biome>[][] biomes) {
		this.MIDDLE_BIOMES = biomes;
		return this;
	}
	
	public PioneerBiomeBuilderOld middleVariant(ResourceKey<Biome>[][] biomes) {
		this.MIDDLE_BIOMES_VARIANT = biomes;
		return this;
	}
	
	public PioneerBiomeBuilderOld plateau(ResourceKey<Biome>[][] biomes) {
		this.PLATEAU_BIOMES = biomes;
		return this;
	}
	
	public PioneerBiomeBuilderOld plateauVariant(ResourceKey<Biome>[][] biomes) {
		this.PLATEAU_BIOMES_VARIANT = biomes;
		return this;
	}
	
	public PioneerBiomeBuilderOld shattered(ResourceKey<Biome>[][] biomes) {
		this.SHATTERED_BIOMES = biomes;
		return this;
	}

	public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
		this.addOffCoastBiomes(consumer);
		this.addInlandBiomes(consumer);
		this.addUndergroundBiomes(consumer);
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

	private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter climate$parameter = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter climate$parameter1 = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, parameter);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
				ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, parameter);
				ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, parameter);
				ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, parameter, resourcekey4);
				ResourceKey<Biome> resourcekey6 = VANILLA;
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, resourcekey6);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey2);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey6);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], parameter, 0.0F, resourcekey3);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey1);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey3);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey5);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey4);
				this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, resourcekey);
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
				ResourceKey<Biome> resourcekey7 = VANILLA;
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
				ResourceKey<Biome> resourcekey5 = VANILLA;
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
				ResourceKey<Biome> resourcekey3 = VANILLA;
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
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);
		this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, VANILLA);

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
		this.addUndergroundBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
		this.addUndergroundBiome(consumer, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
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
		return temperature == 4 ? VANILLA : this.pickMiddleBiome(temperature, humidity, weirdness);
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int temperature, int humidity, Climate.Parameter weirdness) {
		return temperature == 0 ? this.pickSlopeBiome(temperature, humidity, weirdness) : this.pickMiddleBiomeOrBadlandsIfHot(temperature, humidity, weirdness);
	}

	private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int temperature, int humidity, Climate.Parameter weirdness, ResourceKey<Biome> altMiddleBiome) {
		return temperature > 1 && humidity < 4 && weirdness.max() >= 0L ? VANILLA : altMiddleBiome;
	}

	private ResourceKey<Biome> pickShatteredCoastBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		ResourceKey<Biome> resourcekey = weirdness.max() >= 0L ? this.pickMiddleBiome(temperature, humidity, weirdness) : VANILLA;
		return this.maybePickWindsweptSavannaBiome(temperature, humidity, weirdness, resourcekey);
	}


	private ResourceKey<Biome> pickPlateauBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (weirdness.max() < 0L) {
			return this.PLATEAU_BIOMES[temperature][humidity];
		} else {
			ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[temperature][humidity];
			return resourcekey == null ? this.PLATEAU_BIOMES[temperature][humidity] : resourcekey;
		}
	}

	private ResourceKey<Biome> pickSlopeBiome(int temperature, int humidity, Climate.Parameter weirdness) {
		if (temperature >= 3) {
			return this.pickPlateauBiome(temperature, humidity, weirdness);
		} else {
			return VANILLA;
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

//package pioneer.data.tags.server;
//
//import static pioneer.core.registry.world.PioneerBiomes.*;
//
//import java.util.Collections;
//import java.util.List;
//
//import com.google.common.collect.ImmutableList;
//import com.mojang.datafixers.util.Pair;
//import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSliceProvider;
//import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
//import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;
//import com.teamabnormals.blueprint.core.util.BiomeUtil;
//import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
//import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
//
//import net.minecraft.data.DataGenerator;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.biome.Climate;
//import net.minecraft.world.level.dimension.LevelStem;
//import net.minecraftforge.common.ForgeConfigSpec;
//import pioneer.core.Pioneer;
//import pioneer.core.PioneerConfig;
//import pioneer.data.tags.server.biome.PioneerBiomeBuilder;
//
//public class PioneerModdedBiomeSlicesProvider extends ModdedBiomeSliceProvider {
//	
//	//temperatures
//	private static final int COLD = 0;
//	private static final int COOL = 1;
//	private static final int WARM = 2;
//	private static final int HOT = 3;
//	private static final int MY_GF = 4;
//	
//	//humidities
//	private static final int SUPER_DRY = 0;
//	private static final int DRY = 1;
//	private static final int NORMAL = 2;
//	private static final int WET = 3;
//	private static final int SUPER_WET = 4;
//	
//	Climate.Parameter zero = Climate.Parameter.point(0.0F);
//	
//	//humidities
//
//	public PioneerModdedBiomeSlicesProvider(DataGenerator dataGenerator) {
//		super(dataGenerator, Pioneer.MOD_ID);
//	}
//	
//	@Override
//	protected void registerSlices() {
//		ConfigValueCondition configCondition = new ConfigValueCondition(new ResourceLocation(Pioneer.MOD_ID, "config"), PioneerConfig.aspenGrove, "aspenGrove", Collections.emptyMap(), false);
//		ConditionedResourceSelector selector = new ConditionedResourceSelector(new NamesResourceSelector(LevelStem.OVERWORLD.location()), configCondition);
//		this.registerSlice("aspen_grove", selector, 3, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(
//				List.of(Pair.of(Climate.parameters(Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.55F), zero, zero, zero, 1.0F),
//					BlueprintBiomes.ORIGINAL_SOURCE_MARKER.getKey()),
//					Pair.of(Climate.parameters(zero, zero, zero, zero, zero, zero, 0.0F), ASPEN_GROVE.getKey())))));
//		
//		ConfigValueCondition configCondition2 = new ConfigValueCondition(new ResourceLocation(Pioneer.MOD_ID, "config"), PioneerConfig.borealForest, "borealForest", Collections.emptyMap(), false);
//		ConditionedResourceSelector selector2 = new ConditionedResourceSelector(new NamesResourceSelector(LevelStem.OVERWORLD.location()), configCondition2);
//		this.registerSlice("aspen_grove", selector2, 3, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(
//				List.of(Pair.of(Climate.parameters(Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.55F), zero, zero, zero, 1.0F),
//					BlueprintBiomes.ORIGINAL_SOURCE_MARKER.getKey()),
//					Pair.of(Climate.parameters(zero, zero, zero, zero, zero, zero, 0.0F), BOREAL_FOREST.getKey())))));
//		
//		ResourceKey<Biome>[][] aspenGroveMiddleVariant = new Builder(MIDDLE_VANILLA, ASPEN_GROVE.getKey()).add(COOL, DRY).get();
//		this.registerSlice("aspen_grove", new PioneerBiomeBuilder(ASPEN_GROVE.getKey()).middleVariant(aspenGroveMiddleVariant), PioneerConfig.aspenGrove, "aspenGrove", 2);
//		
//		ResourceKey<Biome>[][] ACFMiddleVariant = new Builder(MIDDLE_VANILLA, AUTUMNAL_CONIFEROUS_FOREST.getKey()).add(COLD, SUPER_WET).add(COOL, WET).add(COOL, SUPER_WET).get();
//		ResourceKey<Biome>[][] ACFPlateauVariant = new Builder(PLATEAU_VANILLA, AUTUMNAL_CONIFEROUS_FOREST.getKey()).add(COLD, SUPER_WET).add(COOL, WET).add(COOL, SUPER_WET).get();
//		this.registerSlice("autumnal_coniferous_forest", new PioneerBiomeBuilder(AUTUMNAL_CONIFEROUS_FOREST.getKey()).middleVariant(ACFMiddleVariant).plateauVariant(ACFPlateauVariant), PioneerConfig.autumnalConiferousForest, "autumnalConiferousForest", 2);
//
//		ResourceKey<Biome>[][] verdantSandsMiddle = new Builder(MIDDLE_VANILLA, VERDANT_SANDS.getKey()).add(MY_GF, WET).add(MY_GF, SUPER_WET).get();
//		this.registerSlice("verdant_sands", new PioneerBiomeBuilder(VERDANT_SANDS.getKey()).middle(verdantSandsMiddle), PioneerConfig.verdantSands, "verdantSands", 2);
//		
//		ResourceKey<Biome>[][] pineMeadowsMiddle = new Builder(MIDDLE_VANILLA, PINE_MEADOWS.getKey()).add(COOL, WET).add(COOL, NORMAL).get();
//		this.registerSlice("pine_meadows", new PioneerBiomeBuilder(PINE_MEADOWS.getKey()).middle(pineMeadowsMiddle), PioneerConfig.pineMeadows, "pineMeadows", 2);
//		
//		ResourceKey<Biome>[][] borealForestMiddle = new Builder(MIDDLE_VANILLA, BOREAL_FOREST.getKey()).add(COOL, WET).add(COLD, SUPER_WET).add(COLD, WET).get();
//		ResourceKey<Biome>[][] borealForestPlateau = new Builder(PLATEAU_VANILLA, BOREAL_FOREST.getKey()).add(COOL, WET).add(COLD, SUPER_WET).get();
//		this.registerSlice("boreal_forest", new PioneerBiomeBuilder(BOREAL_FOREST.getKey()).middle(borealForestMiddle).plateau(borealForestPlateau), PioneerConfig.borealForest, "borealForest", 2);
//		
//		ResourceKey<Biome>[][] snowyBorealForestMiddle = new Builder(MIDDLE_VANILLA, SNOWY_BOREAL_FOREST.getKey()).add(COLD, NORMAL).add(COLD, WET).get();
//		ResourceKey<Biome>[][] snowyBorealForestPlateau = new Builder(PLATEAU_VANILLA, SNOWY_BOREAL_FOREST.getKey()).add(COLD, WET).add(COLD, SUPER_WET).get();
//		this.registerSlice("snowy_boreal_forest", new PioneerBiomeBuilder(SNOWY_BOREAL_FOREST.getKey()).middle(snowyBorealForestMiddle).plateau(snowyBorealForestPlateau), PioneerConfig.snowyBorealForest, "snowyBorealForest", 2);
//		
//		ResourceKey<Biome>[][] redwoodsMiddle = new Builder(MIDDLE_VANILLA, REDWOODS.getKey()).add(COOL, NORMAL).add(COLD, WET).add(COOL, SUPER_WET).get();
//		ResourceKey<Biome>[][] redwoodsPlateau = new Builder(PLATEAU_VANILLA, REDWOODS.getKey()).add(COOL, WET).add(COOL, SUPER_WET).get();
//		ResourceKey<Biome>[][] redwoodsShattered = new Builder(SHATTERED_VANILLA, REDWOODS.getKey()).add(COOL, WET).add(COOL, SUPER_WET).get();
//		this.registerSlice("redwoods", new PioneerBiomeBuilder(REDWOODS.getKey()).middle(redwoodsMiddle).plateau(redwoodsPlateau).shattered(redwoodsShattered), PioneerConfig.redwoods, "redwoods", 2);
//		
//		ResourceKey<Biome>[][] snowyRedwoodsMiddle = new Builder(MIDDLE_VANILLA, SNOWY_REDWOODS.getKey()).add(COLD, NORMAL).add(COLD, WET).add(COLD, SUPER_WET).get();
//		ResourceKey<Biome>[][] snowyRedwoodsPlateau = new Builder(PLATEAU_VANILLA, SNOWY_REDWOODS.getKey()).add(COLD, WET).add(COLD, SUPER_WET).get();
//		this.registerSlice("snowy_redwoods", new PioneerBiomeBuilder(SNOWY_REDWOODS.getKey()).middle(snowyRedwoodsMiddle).plateau(snowyRedwoodsPlateau), PioneerConfig.snowyRedwoods, "snowyRedwoods", 2);
//		
//		ResourceKey<Biome>[][] overgrownSpiresPlateau = new Builder(PLATEAU_VANILLA, OVERGROWN_SPIRES.getKey()).add(HOT, WET).add(HOT, SUPER_WET).get();
//		ResourceKey<Biome>[][] overgrownSpiresShattered = new Builder(SHATTERED_VANILLA, OVERGROWN_SPIRES.getKey()).add(HOT, WET).add(HOT, SUPER_WET).add(MY_GF, WET).add(MY_GF, SUPER_WET).get();
//		this.registerSlice("overgrown_spires", new PioneerBiomeBuilder(OVERGROWN_SPIRES.getKey()).plateau(overgrownSpiresPlateau).shattered(overgrownSpiresShattered), PioneerConfig.overgrownSpires, "overgrownSpires", 2);
//		
//		ResourceKey<Biome>[][] baobabFieldsMiddleVariant = new Builder(MIDDLE_VARIANT_VANILLA, BAOBAB_FIELDS.getKey()).add(HOT, DRY).add(HOT, SUPER_DRY).get();
//		ResourceKey<Biome>[][] baobabFieldsPlateauVariant = new Builder(PLATEAU_VARIANT_VANILLA, BAOBAB_FIELDS.getKey()).add(HOT, DRY).add(HOT, SUPER_DRY).get();
//		this.registerSlice("baobab_fields", new PioneerBiomeBuilder(BAOBAB_FIELDS.getKey()).middleVariant(baobabFieldsMiddleVariant).plateauVariant(baobabFieldsPlateauVariant), PioneerConfig.baobabFields, "baobabFields", 2);
//		
//		ResourceKey<Biome>[][] crystalLakesMiddleVariant = new Builder(MIDDLE_VANILLA, CRYSTAL_LAKES.getKey()).add(COOL, NORMAL).add(COOL, WET).get();
//		ResourceKey<Biome>[][] crystalLakesPlateauVariant = new Builder(PLATEAU_VANILLA, CRYSTAL_LAKES.getKey()).add(COOL, NORMAL).add(COOL, WET).get();
//		this.registerSlice("crystal_lakes", new PioneerBiomeBuilder(CRYSTAL_LAKES.getKey()).middleVariant(crystalLakesMiddleVariant).plateauVariant(crystalLakesPlateauVariant), PioneerConfig.crystalLakes, "crystalLakes", 2);
//		
//		ResourceKey<Biome>[][] prairieMiddle = new Builder(MIDDLE_VANILLA, PRAIRIE.getKey()).add(WARM, DRY).add(HOT, SUPER_DRY).get();
//		this.registerSlice("prairie", new PioneerBiomeBuilder(PRAIRIE.getKey()).middle(prairieMiddle), PioneerConfig.prairie, "prairie", 2);
//		
//		ResourceKey<Biome>[][] blossomingFieldsMiddle = new Builder(MIDDLE_VANILLA, BLOSSOMING_FIELDS.getKey()).add(WARM, DRY).get();
//		this.registerSlice("blossoming_fields", new PioneerBiomeBuilder(BLOSSOMING_FIELDS.getKey()).middle(blossomingFieldsMiddle), PioneerConfig.blossomingFields, "blossomingFields", 2);
//		
//		ResourceKey<Biome>[][] desertShrublandMiddle = new Builder(MIDDLE_VANILLA, DESERT_SHRUBLAND.getKey()).add(MY_GF, SUPER_DRY).get();
//		this.registerSlice("desert_shrubland", new PioneerBiomeBuilder(DESERT_SHRUBLAND.getKey()).middle(desertShrublandMiddle), PioneerConfig.desertShrubland, "desertShrubland", 2);
//		
//		ResourceKey<Biome>[][] redRockCanyonMiddle = new Builder(MIDDLE_VANILLA, RED_ROCK_CANYON.getKey()).add(MY_GF, SUPER_DRY).add(MY_GF, DRY).add(MY_GF, NORMAL).get();
//		ResourceKey<Biome>[][] redRockCanyonPlateau = new Builder(PLATEAU_VANILLA, RED_ROCK_CANYON.getKey()).add(MY_GF, SUPER_DRY).add(MY_GF, DRY).add(MY_GF, NORMAL).get();
//		this.registerSlice("red_rock_canyon", new PioneerBiomeBuilder(RED_ROCK_CANYON.getKey()).middle(redRockCanyonMiddle).plateau(redRockCanyonPlateau), PioneerConfig.redRockCanyon, "redRockCanyon", 2);
		
//		ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>>();
//		new PioneerBiomeBuilder().middleBiomesVariant(aspenGroveMiddleVariant).addBiomes(pair -> builder.add(pair));
//		this.registerSlice("pioneer_modded_slice", new ConditionedResourceSelector(new NamesResourceSelector(LevelStem.OVERWORLD.location()),
//				new ConfigValueCondition(new ResourceLocation(Pioneer.MOD_ID, "config"),
//						PioneerConfig.enableBiomes, "enableBiomes", Collections.emptyMap(), false)),
//				8, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(builder.build())));
//	}
//	
//	private void registerSlice(String biomeName, PioneerBiomeBuilder biomeBuilder, ForgeConfigSpec.ConfigValue<?> configValue, String value, int weight) {
//		ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>>();
//		biomeBuilder.addBiomes(pair -> builder.add(pair));
//		ConfigValueCondition configCondition = new ConfigValueCondition(new ResourceLocation(Pioneer.MOD_ID, "config"), configValue, value, Collections.emptyMap(), false);
//		ConditionedResourceSelector selector = new ConditionedResourceSelector(new NamesResourceSelector(LevelStem.OVERWORLD.location()), configCondition);
//		
//		this.registerSlice(biomeName + "_modded_slice", selector, weight, new BiomeUtil.MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(builder.build())));
//	}
//	
//	private static class Builder {
//		
//		private ResourceKey<Biome>[][] array;
//		private ResourceKey<Biome> biome;
//		
//		@SuppressWarnings("unchecked")
//		public Builder(ResourceKey<Biome>[][] base, ResourceKey<Biome> biome) {
//			this.array = new ResourceKey[base.length][];
//			for(int i = 0; i < base.length; i++) {
//				array[i] = base[i].clone();
//			}
//
//			this.biome = biome;
//		}
//		
//		public Builder add(int temperatureIndex, int humidityIndex) {
//			array[temperatureIndex][humidityIndex] = biome;
//			return this;
//		}
//		
//		public ResourceKey<Biome>[][] get() {
//			return array;
//		}
//	}
//}
