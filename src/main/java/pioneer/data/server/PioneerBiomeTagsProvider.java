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
		});

		this.tag(BiomeTags.IS_FOREST).add(PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(), PioneerBiomes.BOREAL_FOREST.getKey(),
				PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), PioneerBiomes.REDWOODS.getKey(), PioneerBiomes.SNOWY_REDWOODS.getKey(),
				PioneerBiomes.ASPEN_GROVE.getKey(), PioneerBiomes.CRYSTAL_LAKES.getKey());
		
		this.tag(BiomeTags.IS_MOUNTAIN).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.IS_JUNGLE).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.IS_TAIGA).add(PioneerBiomes.BOREAL_FOREST.getKey(), PioneerBiomes.SNOWY_BOREAL_FOREST.getKey());
		this.tag(BiomeTags.IS_BADLANDS).add(PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.HAS_PILLAGER_OUTPOST).add(PioneerBiomes.BAOBAB_FIELDS.getKey(), PioneerBiomes.PINE_MEADOWS.getKey(), PioneerBiomes.VERDANT_SANDS.getKey(), PioneerBiomes.PRAIRIE.getKey(), PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.HAS_DESERT_PYRAMID).add(PioneerBiomes.DESERT_SHRUBLAND.getKey(), PioneerBiomes.VERDANT_SANDS.getKey());
		this.tag(BiomeTags.HAS_JUNGLE_TEMPLE).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.HAS_VILLAGE_DESERT).add(PioneerBiomes.DESERT_SHRUBLAND.getKey(), PioneerBiomes.VERDANT_SANDS.getKey(), PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.HAS_VILLAGE_PLAINS).add(PioneerBiomes.PRAIRIE.getKey(), PioneerBiomes.BLOSSOMING_FIELDS.getKey(), PioneerBiomes.ASPEN_GROVE.getKey());
		this.tag(BiomeTags.HAS_VILLAGE_SAVANNA).add(PioneerBiomes.BAOBAB_FIELDS.getKey());
		this.tag(BiomeTags.HAS_VILLAGE_TAIGA).add(PioneerBiomes.BOREAL_FOREST.getKey(), PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), PioneerBiomes.REDWOODS.getKey(), PioneerBiomes.SNOWY_REDWOODS.getKey(), PioneerBiomes.CRYSTAL_LAKES.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_DESERT).add(PioneerBiomes.VERDANT_SANDS.getKey(), PioneerBiomes.DESERT_SHRUBLAND.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_JUNGLE).add(PioneerBiomes.OVERGROWN_SPIRES.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD).add(PioneerBiomes.PINE_MEADOWS.getKey(), PioneerBiomes.ASPEN_GROVE.getKey(), PioneerBiomes.PRAIRIE.getKey(), PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(),
				PioneerBiomes.BAOBAB_FIELDS.getKey(), PioneerBiomes.BLOSSOMING_FIELDS.getKey(), PioneerBiomes.BOREAL_FOREST.getKey(), PioneerBiomes.CRYSTAL_LAKES.getKey(), PioneerBiomes.REDWOODS.getKey(),
				PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.HAS_MINESHAFT_MESA).add(PioneerBiomes.RED_ROCK_CANYON.getKey());
		this.tag(BiomeTags.HAS_RUINED_PORTAL_MOUNTAIN).add(PioneerBiomes.RED_ROCK_CANYON.getKey());

		
		addTags(PioneerBiomes.VERDANT_SANDS.getKey(), Tags.Biomes.IS_SAVANNA, Tags.Biomes.IS_SANDY, Tags.Biomes.IS_LUSH, Tags.Biomes.IS_HOT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_HOT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_DENSE, Tags.Biomes.IS_DENSE_OVERWORLD, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.PINE_MEADOWS.getKey(), Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.AUTUMNAL_CONIFEROUS_FOREST.getKey(), Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.BOREAL_FOREST.getKey(), Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_SNOWY, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.DESERT_SHRUBLAND.getKey(), Tags.Biomes.IS_DRY, Tags.Biomes.IS_DRY_OVERWORLD, Tags.Biomes.IS_HOT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_SANDY, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.OVERGROWN_SPIRES.getKey(), Tags.Biomes.IS_WET, Tags.Biomes.IS_WET_OVERWORLD, Tags.Biomes.IS_LUSH, Tags.Biomes.IS_HOT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_DENSE, Tags.Biomes.IS_DENSE_OVERWORLD, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.PRAIRIE.getKey(), Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.REDWOODS.getKey(), Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.SNOWY_BOREAL_FOREST.getKey(), Tags.Biomes.IS_SNOWY, Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.BAOBAB_FIELDS.getKey(), Tags.Biomes.IS_SAVANNA, Tags.Biomes.IS_HOT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.CRYSTAL_LAKES.getKey(), Tags.Biomes.IS_WET, Tags.Biomes.IS_WET_OVERWORLD, Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.BLOSSOMING_FIELDS.getKey(), Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.ASPEN_GROVE.getKey(), Tags.Biomes.IS_COLD, Tags.Biomes.IS_COLD_OVERWORLD, Tags.Biomes.IS_OVERWORLD);
		addTags(PioneerBiomes.RED_ROCK_CANYON.getKey(), Tags.Biomes.IS_LUSH, Tags.Biomes.IS_HOT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_SANDY, Tags.Biomes.IS_DRY, Tags.Biomes.IS_DRY_OVERWORLD, Tags.Biomes.IS_OVERWORLD);
	};
	

	private void addTags(ResourceKey<Biome> key, TagKey<Biome>... tags) {
		for(TagKey<Biome> tag : tags) {
			this.tag(tag).add(key);
		}
	}
}
