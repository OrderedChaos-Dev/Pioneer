package pioneer.data.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import pioneer.core.Pioneer;
import pioneer.core.registry.world.PioneerBiomes;

@SuppressWarnings("unchecked")
public class PioneerBiomeTagsProvider extends BiomeTagsProvider {

	public PioneerBiomeTagsProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, Pioneer.MOD_ID, existingFileHelper);
	}

	@Override
	public void addTags() {
		PioneerBiomes.HELPER.getDeferredRegister().getEntries().forEach(biome -> {
			if(biome.getKey() != PioneerBiomes.RED_ROCK_CANYON.getKey())
				this.tag(BiomeTags.HAS_MINESHAFT).add(biome.getKey());
			
			this.tag(BiomeTags.HAS_STRONGHOLD).add(biome.getKey());
			this.tag(BiomeTags.IS_OVERWORLD).add(biome.getKey());
		});

		this.tag(BiomeTags.HAS_MINESHAFT_MESA).add(PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.IS_FOREST).add(
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey(),
			PioneerBiomes.ASPEN_GROVE.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.FLOODED_FOREST.getKey()
		);
		this.tag(BiomeTags.IS_MOUNTAIN).add(
			PioneerBiomes.OVERGROWN_SPIRES.getKey(),
			PioneerBiomes.WINDSWEPT_CLIFFS.getKey()
		);
		this.tag(BiomeTags.IS_JUNGLE).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.IS_TAIGA).add(
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey()
		);
		this.tag(BiomeTags.IS_BADLANDS).add(PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.HAS_SWAMP_HUT).add(PioneerBiomes.WILLOW_WETLANDS.getKey());
		this.tag(BiomeTags.HAS_PILLAGER_OUTPOST).add(
			PioneerBiomes.BAOBAB_FIELDS.getKey(),
			PioneerBiomes.PINE_MEADOWS.getKey(),
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.PRAIRIE.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey(),
			PioneerBiomes.BLOSSOMING_FIELDS.getKey(),
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey()
	);
		this.tag(BiomeTags.HAS_DESERT_PYRAMID).add(
			PioneerBiomes.DESERT_SHRUBLAND.getKey(),
			PioneerBiomes.VERDANT_SANDS.getKey()
		);
		this.tag(BiomeTags.HAS_JUNGLE_TEMPLE).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.HAS_VILLAGE_DESERT).add(
			PioneerBiomes.DESERT_SHRUBLAND.getKey(),
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey()
		);
		this.tag(BiomeTags.HAS_VILLAGE_PLAINS).add(
			PioneerBiomes.PRAIRIE.getKey(),
			PioneerBiomes.BLOSSOMING_FIELDS.getKey(),
			PioneerBiomes.ASPEN_GROVE.getKey()
		);
		this.tag(BiomeTags.HAS_VILLAGE_SAVANNA).add(PioneerBiomes.BAOBAB_FIELDS.getKey());
		this.tag(BiomeTags.HAS_VILLAGE_TAIGA).add(
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey()
		);
		this.tag(BiomeTags.HAS_RUINED_PORTAL_DESERT).add(
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.DESERT_SHRUBLAND.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_JUNGLE).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD).add(
			PioneerBiomes.PINE_MEADOWS.getKey(),
			PioneerBiomes.ASPEN_GROVE.getKey(),
			PioneerBiomes.PRAIRIE.getKey(),
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
			PioneerBiomes.BAOBAB_FIELDS.getKey(),
			PioneerBiomes.BLOSSOMING_FIELDS.getKey(),
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey(),
			PioneerBiomes.FLOODED_FOREST.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_MOUNTAIN).add(PioneerBiomes.RED_ROCK_CANYON.getKey(), PioneerBiomes.WINDSWEPT_CLIFFS.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(PioneerBiomes.WILLOW_WETLANDS.getKey());

		this.tag(BiomeTags.IS_SAVANNA).add(PioneerBiomes.BAOBAB_FIELDS.getKey());
		this.tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS).add(PioneerBiomes.WILLOW_WETLANDS.getKey());
		this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(PioneerBiomes.WILLOW_WETLANDS.getKey());

		this.tag(Tags.Biomes.IS_COLD).add(
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.ASPEN_GROVE.getKey()
		);
		this.tag(Tags.Biomes.IS_COLD_OVERWORLD).add(
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.ASPEN_GROVE.getKey()
		);
		this.tag(Tags.Biomes.IS_CONIFEROUS).add(
			PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
			PioneerBiomes.BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.REDWOODS.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey()
		);
		this.tag(Tags.Biomes.IS_SANDY).add(
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.DESERT_SHRUBLAND.getKey()
		);
		this.tag(Tags.Biomes.IS_HOT).add(
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.DESERT_SHRUBLAND.getKey(),
			PioneerBiomes.OVERGROWN_SPIRES.getKey(),
			PioneerBiomes.BAOBAB_FIELDS.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey()
		);
		this.tag(Tags.Biomes.IS_HOT_OVERWORLD).add(
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.DESERT_SHRUBLAND.getKey(),
			PioneerBiomes.OVERGROWN_SPIRES.getKey(),
			PioneerBiomes.BAOBAB_FIELDS.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey()
		);
		this.tag(Tags.Biomes.IS_LUSH).add(
			PioneerBiomes.VERDANT_SANDS.getKey(),
			PioneerBiomes.OVERGROWN_SPIRES.getKey(),
			PioneerBiomes.FLOODED_FOREST.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey()
		);
		this.tag(Tags.Biomes.IS_PLAINS).add(
			PioneerBiomes.PINE_MEADOWS.getKey(),
			PioneerBiomes.PRAIRIE.getKey(),
			PioneerBiomes.BLOSSOMING_FIELDS.getKey()
		);
		this.tag(Tags.Biomes.IS_SNOWY).add(
			PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(),
			PioneerBiomes.SNOWY_REDWOODS.getKey()
		);
		this.tag(Tags.Biomes.IS_DENSE).add(
			PioneerBiomes.OVERGROWN_SPIRES.getKey()
		);
		this.tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(
			PioneerBiomes.OVERGROWN_SPIRES.getKey()
		);
		this.tag(Tags.Biomes.IS_DRY).add(
			PioneerBiomes.DESERT_SHRUBLAND.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey(),
			PioneerBiomes.VERDANT_SANDS.getKey()
		);
		this.tag(Tags.Biomes.IS_DRY_OVERWORLD).add(
			PioneerBiomes.DESERT_SHRUBLAND.getKey(),
			PioneerBiomes.RED_ROCK_CANYON.getKey(),
			PioneerBiomes.VERDANT_SANDS.getKey()
		);
		this.tag(Tags.Biomes.IS_WET).add(
			PioneerBiomes.OVERGROWN_SPIRES.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.FLOODED_FOREST.getKey(),
			PioneerBiomes.WILLOW_WETLANDS.getKey()
		);
		this.tag(Tags.Biomes.IS_WET_OVERWORLD).add(
			PioneerBiomes.OVERGROWN_SPIRES.getKey(),
			PioneerBiomes.CRYSTAL_LAKES.getKey(),
			PioneerBiomes.FLOODED_FOREST.getKey(),
			PioneerBiomes.WILLOW_WETLANDS.getKey()
		);
		this.tag(Tags.Biomes.IS_SWAMP).add(
			PioneerBiomes.WILLOW_WETLANDS.getKey()
		);
		this.tag(Tags.Biomes.IS_PEAK).add(
			PioneerBiomes.WINDSWEPT_CLIFFS.getKey()
		);
	};
	

	private void addTags(ResourceKey<Biome> key, TagKey<Biome>... tags) {
		for(TagKey<Biome> tag : tags) {
			this.tag(tag).add(key);
		}
	}
}
