package pioneer.common;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import pioneer.common.world.placements.PioneerPlacements;
import pioneer.core.PioneerConfig;
import pioneer.core.registry.world.PioneerBiomes;

public class PioneerWorldGenEvents {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void addBiomeFeatures(BiomeLoadingEvent event) {
		ResourceKey<Biome> biome = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
		List<Holder<PlacedFeature>> vegetalFeatures = event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION);
		
		if(biome == Biomes.BEACH && PioneerConfig.palmTrees.get()) {
			vegetalFeatures.add(PioneerPlacements.TREES_PALM.getHolder().get());
		}
		
		if(event.getCategory() == BiomeCategory.MESA && PioneerConfig.juniperTrees.get()) {
			vegetalFeatures.add(PioneerPlacements.TREES_JUNIPER.getHolder().get());
		}
		
		//BIOMES
		if(biome == PioneerBiomes.PINE_MEADOWS.getKey()) {
			vegetalFeatures.add(PioneerPlacements.PINE_MEADOWS_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.VERDANT_SANDS.getKey()) {
//			vegetalFeatures.add(PioneerPlacements.LUSH_CACTUS);
		} else if(biome == PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey()) {
			vegetalFeatures.add(PioneerPlacements.AUTUMNAL_CONIFEROUS_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.BOREAL_FOREST.getKey() || biome == PioneerBiomes.SNOWY_BOREAL_FOREST.getKey()) {
			vegetalFeatures.add(PioneerPlacements.BOREAL_FOREST_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.DESERT_SHRUBLAND.getKey()) {
			vegetalFeatures.add(PioneerPlacements.DRY_GRASS.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.DESERT_SAGE.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.DESERT_AGAVE.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.DESERT_SHRUBLAND_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.OVERGROWN_SPIRES.getKey()) {
			vegetalFeatures.add(PioneerPlacements.OVERGROWN_SPIRES_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.PRAIRIE.getKey()) {
			vegetalFeatures.add(PioneerPlacements.PRAIRIE_TREES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.PRAIRIE_GRASS.getHolder().get());
		} else if(biome == PioneerBiomes.BAOBAB_FIELDS.getKey()) {
			vegetalFeatures.add(PioneerPlacements.BAOBAB_FIELDS_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.REDWOODS.getKey() || biome == PioneerBiomes.SNOWY_REDWOODS.getKey()) {
			vegetalFeatures.add(PioneerPlacements.REDWOOD_FOREST_TREES.getHolder().get());
		} else if(biome == PioneerBiomes.CRYSTAL_LAKES.getKey()) {
			vegetalFeatures.add(PioneerPlacements.CRYSTAL_LAKES_TREES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.CRYSTAL_POOL.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.AMETHYST_CRYSTALS.getHolder().get());
		} else if(biome == PioneerBiomes.BLOSSOMING_FIELDS.getKey()) {
			vegetalFeatures.add(PioneerPlacements.BLOSSOMING_FIELDS_TREES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.WHITE_SAKURA_FALLEN_LEAVES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.PINK_SAKURA_FALLEN_LEAVES.getHolder().get());
		} else if(biome == PioneerBiomes.ASPEN_GROVE.getKey()) {
			vegetalFeatures.add(PioneerPlacements.ASPEN_GROVE_TREES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.RED_MAPLE_FALLEN_LEAVES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.ORANGE_MAPLE_FALLEN_LEAVES.getHolder().get());
			vegetalFeatures.add(PioneerPlacements.PURPLE_MAPLE_FALLEN_LEAVES.getHolder().get());
		} else if(biome == PioneerBiomes.RED_ROCK_CANYON.getKey()) {

		} else if(biome == PioneerBiomes.FLOODED_FOREST.getKey()) {
			vegetalFeatures.add(PioneerPlacements.FLOOD_POOL.getHolder().get());
			vegetalFeatures.add(VegetationPlacements.FLOWER_SWAMP);
			vegetalFeatures.add(VegetationPlacements.PATCH_GRASS_PLAIN);
			vegetalFeatures.add(VegetationPlacements.PATCH_WATERLILY);
			vegetalFeatures.add(AquaticPlacements.SEAGRASS_NORMAL);
			vegetalFeatures.add(VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);
			vegetalFeatures.add(PioneerPlacements.DRIPLEAF.getHolder().get());
		}
	}
}
