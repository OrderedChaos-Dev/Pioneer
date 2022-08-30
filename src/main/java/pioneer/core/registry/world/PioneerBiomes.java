package pioneer.core.registry.world;

import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper.KeyedBiome;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import pioneer.common.world.biome.AspenGroveBiome;
import pioneer.common.world.biome.AutumnalConiferousForestBiome;
import pioneer.common.world.biome.BaobabFieldsBiome;
import pioneer.common.world.biome.BlossomingFieldsBiome;
import pioneer.common.world.biome.BorealForestBiome;
import pioneer.common.world.biome.CrystalLakesBiome;
import pioneer.common.world.biome.DesertShrublandBiome;
import pioneer.common.world.biome.OvergrownSpiresBiome;
import pioneer.common.world.biome.PineMeadowsBiome;
import pioneer.common.world.biome.PrairieBiome;
import pioneer.common.world.biome.RedRockCanyonBiome;
import pioneer.common.world.biome.RedwoodsBiome;
import pioneer.common.world.biome.VerdantSandsBiome;
import pioneer.common.world.biome.WillowWetlandsBiome;
import pioneer.common.world.biome.WindsweptCliffsBiome;
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
	public static final KeyedBiome REDWOODS = HELPER.createBiome("redwoods", ()-> RedwoodsBiome.redwoods(false));
	public static final KeyedBiome SNOWY_REDWOODS = HELPER.createBiome("snowy_redwoods", ()-> RedwoodsBiome.redwoods(true));
	public static final KeyedBiome ASPEN_GROVE = HELPER.createBiome("aspen_grove", AspenGroveBiome::aspenGrove);
	public static final KeyedBiome BAOBAB_FIELDS = HELPER.createBiome("baobab_fields", BaobabFieldsBiome::baobabFields);
	public static final KeyedBiome PRAIRIE = HELPER.createBiome("prairie", PrairieBiome::prairie);
	public static final KeyedBiome BLOSSOMING_FIELDS = HELPER.createBiome("blossoming_fields", BlossomingFieldsBiome::blossomingFields);
	public static final KeyedBiome CRYSTAL_LAKES = HELPER.createBiome("crystal_lakes", CrystalLakesBiome::crystalLakes);
	public static final KeyedBiome RED_ROCK_CANYON = HELPER.createBiome("red_rock_canyon", RedRockCanyonBiome::redRockCanyon);
	public static final KeyedBiome FLOODED_FOREST = HELPER.createBiome("flooded_forest", () -> OverworldBiomes.forest(false, false, false));
	public static final KeyedBiome WINDSWEPT_CLIFFS = HELPER.createBiome("windswept_cliffs", WindsweptCliffsBiome::windsweptCliffs);
	public static final KeyedBiome WILLOW_WETLANDS = HELPER.createBiome("willow_wetlands", WillowWetlandsBiome::willowWetlands);

	// deprecated, since biomes should now use tags
	// but including this here just in case for extra compatibility
	public static void registerBiomeTypes() {
		BiomeDictionary.addTypes(VERDANT_SANDS.getKey(), Type.SAVANNA, Type.SANDY, Type.LUSH, Type.HOT, Type.DENSE, Type.OVERWORLD);
		BiomeDictionary.addTypes(PINE_MEADOWS.getKey(), Type.PLAINS, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(AUTUMNAL_CONIFEROUS_FOREST.getKey(), Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(BOREAL_FOREST.getKey(), Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(SNOWY_BOREAL_FOREST.getKey(), Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.SNOWY, Type.OVERWORLD);
		BiomeDictionary.addTypes(DESERT_SHRUBLAND.getKey(), Type.DRY, Type.HOT, Type.SANDY, Type.OVERWORLD);
		BiomeDictionary.addTypes(OVERGROWN_SPIRES.getKey(), Type.JUNGLE, Type.WET, Type.LUSH, Type.HOT, Type.DENSE, Type.MOUNTAIN, Type.OVERWORLD);
		BiomeDictionary.addTypes(PRAIRIE.getKey(), Type.PLAINS, Type.OVERWORLD);
		BiomeDictionary.addTypes(REDWOODS.getKey(), Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(SNOWY_BOREAL_FOREST.getKey(), Type.SNOWY, Type.FOREST, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(BAOBAB_FIELDS.getKey(), Type.SAVANNA, Type.HOT, Type.OVERWORLD);
		BiomeDictionary.addTypes(CRYSTAL_LAKES.getKey(), Type.FOREST, Type.WET, Type.COLD, Type.CONIFEROUS, Type.OVERWORLD);
		BiomeDictionary.addTypes(BLOSSOMING_FIELDS.getKey(), Type.PLAINS, Type.OVERWORLD);
		BiomeDictionary.addTypes(ASPEN_GROVE.getKey(), Type.FOREST, Type.COLD, Type.OVERWORLD);
		BiomeDictionary.addTypes(FLOODED_FOREST.getKey(), Type.FOREST, Type.WET, Type.OVERWORLD);
		BiomeDictionary.addTypes(WINDSWEPT_CLIFFS.getKey(), Type.MOUNTAIN, Type.PEAK, Type.OVERWORLD);
		BiomeDictionary.addTypes(WILLOW_WETLANDS.getKey(), Type.SWAMP, Type.WET, Type.OVERWORLD);
	}
}
