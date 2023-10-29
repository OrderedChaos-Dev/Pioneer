package pioneer.core.registry.world;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.core.registry.BlueprintSurfaceRules;
import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper.KeyedBiome;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;
import pioneer.common.world.biome.*;
import pioneer.common.world.surfacerules.RandomThresholdConditionSource;
import pioneer.core.Pioneer;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = Pioneer.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PioneerBiomes {
	
	public static final BiomeSubRegistryHelper HELPER = Pioneer.REGISTRY_HELPER.getBiomeSubHelper();
	
	public static final KeyedBiome VERDANT_SANDS = HELPER.createBiome("verdant_sands", VerdantSandsBiome::verdantSands);
	public static final KeyedBiome PINE_MEADOWS = HELPER.createBiome("pine_meadows", PineMeadowsBiome::pineMeadows);
	public static final KeyedBiome AUTUMNAL_CONIFEROUS_FOREST = HELPER.createBiome("autumnal_coniferous_forest", AutumnalConiferousForestBiome::autumnalConiferousForest);
	public static final KeyedBiome BOREAL_FOREST = HELPER.createBiome("boreal_forest", () -> BorealForestBiome.borealForest(false));
	public static final KeyedBiome SNOWY_BOREAL_FOREST = HELPER.createBiome("snowy_boreal_forest", () -> BorealForestBiome.borealForest(true));
	public static final KeyedBiome DESERT_SHRUBLAND = HELPER.createBiome("desert_shrubland", DesertShrublandBiome::desertShrubland);
	public static final KeyedBiome OVERGROWN_SPIRES = HELPER.createBiome("overgrown_spires", OvergrownSpiresBiome::overgrownSpires);
	public static final KeyedBiome REDWOODS = HELPER.createBiome("redwoods", () -> RedwoodsBiome.redwoods(false));
	public static final KeyedBiome SNOWY_REDWOODS = HELPER.createBiome("snowy_redwoods", () -> RedwoodsBiome.redwoods(true));
	public static final KeyedBiome ASPEN_GROVE = HELPER.createBiome("aspen_grove", AspenGroveBiome::aspenGrove);
	public static final KeyedBiome BAOBAB_FIELDS = HELPER.createBiome("baobab_fields", BaobabFieldsBiome::baobabFields);
	public static final KeyedBiome PRAIRIE = HELPER.createBiome("prairie", PrairieBiome::prairie);
	public static final KeyedBiome BLOSSOMING_FIELDS = HELPER.createBiome("blossoming_fields", BlossomingFieldsBiome::blossomingFields);
	public static final KeyedBiome CRYSTAL_LAKES = HELPER.createBiome("crystal_lakes", CrystalLakesBiome::crystalLakes);
	public static final KeyedBiome RED_ROCK_CANYON = HELPER.createBiome("red_rock_canyon", RedRockCanyonBiome::redRockCanyon);
	public static final KeyedBiome FLOODED_FOREST = HELPER.createBiome("flooded_forest", FloodedForestBiome::floodedForest);
	public static final KeyedBiome WINDSWEPT_CLIFFS = HELPER.createBiome("windswept_cliffs", WindsweptCliffsBiome::windsweptCliffs);
	public static final KeyedBiome WILLOW_WETLANDS = HELPER.createBiome("willow_wetlands", WillowWetlandsBiome::willowWetlands);
}
