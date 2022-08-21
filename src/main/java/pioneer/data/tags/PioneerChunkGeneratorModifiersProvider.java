package pioneer.data.tags;

import com.teamabnormals.blueprint.common.world.modification.chunk.ChunkGeneratorModifierProvider;
import com.teamabnormals.blueprint.common.world.modification.chunk.modifiers.SurfaceRuleModifier;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import pioneer.core.Pioneer;
import pioneer.core.registry.world.PioneerBiomes;
import static net.minecraft.world.level.levelgen.SurfaceRules.ifTrue;
import static net.minecraft.world.level.levelgen.SurfaceRules.isBiome;
import static net.minecraft.world.level.levelgen.SurfaceRules.sequence;
import static net.minecraft.world.level.levelgen.SurfaceRules.state;

public class PioneerChunkGeneratorModifiersProvider extends ChunkGeneratorModifierProvider {

	public PioneerChunkGeneratorModifiersProvider(DataGenerator generator) {
		super(generator, Pioneer.MOD_ID);
	}
	
	private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
	private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
	private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
	private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
	private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
	private static final SurfaceRules.RuleSource DIORITE = makeStateRule(Blocks.DIORITE);
	private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
	private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
	private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
	
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
	
	private static final SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
	
    private static SurfaceRules.ConditionSource yBlockCheck1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
    private static SurfaceRules.ConditionSource yStartCheck2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
    private static SurfaceRules.ConditionSource yStartCheck1 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
    private static  SurfaceRules.ConditionSource yBlockCheck2 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
    private static SurfaceRules.ConditionSource waterBlockCheck = SurfaceRules.waterBlockCheck(-1, 0);
    private static  SurfaceRules.ConditionSource waterStartcheck = SurfaceRules.waterStartCheck(-6, -1);
    private static SurfaceRules.ConditionSource hole = SurfaceRules.hole();
    
    private static SurfaceRules.ConditionSource noise1 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
    private static SurfaceRules.ConditionSource noise2 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
    private static SurfaceRules.ConditionSource noise3 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);
    
    private static SurfaceRules.RuleSource onCeilingStoneGravel = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
    
	public static final SurfaceRules.RuleSource GRASS_DIRT_FLOOR = sequence(ifTrue(SurfaceRules.ON_FLOOR, sequence(ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK))), ifTrue(SurfaceRules.UNDER_FLOOR, DIRT));
	public static final SurfaceRules.RuleSource DESERT = sequence(ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), ifTrue(SurfaceRules.ON_FLOOR, sequence(ifTrue(isAtOrAboveWaterLevel, SAND))), ifTrue(SurfaceRules.UNDER_FLOOR, SANDSTONE));
	public static final SurfaceRules.RuleSource COARSE_DIRT_FLOOR = sequence(ifTrue(SurfaceRules.ON_FLOOR, sequence(ifTrue(isAtOrAboveWaterLevel, COARSE_DIRT))), ifTrue(SurfaceRules.UNDER_FLOOR, DIRT));
	public static final SurfaceRules.RuleSource PODZOL_DIRT_FLOOR = sequence(ifTrue(SurfaceRules.ON_FLOOR, sequence(ifTrue(isAtOrAboveWaterLevel, PODZOL))), ifTrue(SurfaceRules.UNDER_FLOOR, DIRT));
	
    private static final SurfaceRules.RuleSource BADLANDS = SurfaceRules.sequence(
							SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
									SurfaceRules.ifTrue(yBlockCheck1, ORANGE_TERRACOTTA),
									SurfaceRules.ifTrue(yStartCheck1,
											SurfaceRules.sequence(
													SurfaceRules.ifTrue(noise1, TERRACOTTA),
													SurfaceRules.ifTrue(noise2, TERRACOTTA),
													SurfaceRules.ifTrue(noise3, TERRACOTTA),
													SurfaceRules.bandlands())),
									SurfaceRules.ifTrue(waterBlockCheck, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), ifTrue(surfaceNoiseAbove(1.8D), RED_SAND), ifTrue(surfaceNoiseAbove(0.1D), GRASS_DIRT_FLOOR), RED_SAND)),
									SurfaceRules.ifTrue(SurfaceRules.not(hole), ORANGE_TERRACOTTA),
									SurfaceRules.ifTrue(waterStartcheck, WHITE_TERRACOTTA), onCeilingStoneGravel)),
							SurfaceRules.ifTrue(yStartCheck2, SurfaceRules.sequence(SurfaceRules.ifTrue(yBlockCheck2, SurfaceRules.ifTrue(SurfaceRules.not(yStartCheck1), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())),
							SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,SurfaceRules.ifTrue(waterStartcheck, WHITE_TERRACOTTA)));

	
	public static final SurfaceRules.RuleSource DESERT_SHRUBLAND = ifTrue(isBiome(PioneerBiomes.DESERT_SHRUBLAND.getKey()), DESERT);
	
	public static final SurfaceRules.RuleSource VERDANT_SANDS = ifTrue(isBiome(PioneerBiomes.VERDANT_SANDS.getKey()),
																	sequence(ifTrue(surfaceNoiseAbove(1.8D), DESERT),
																							ifTrue(surfaceNoiseAbove(0.2D), GRASS_DIRT_FLOOR),
																							ifTrue(surfaceNoiseAbove(-0.6D), DESERT), DESERT));
	
	public static final SurfaceRules.RuleSource PINE_MEADOWS = ifTrue(isBiome(PioneerBiomes.PINE_MEADOWS.getKey()),
																	sequence(ifTrue(surfaceNoiseAbove(1.75D), GRASS_DIRT_FLOOR),
																							ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -2.0D), ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.02D, 0.02D), DIORITE)), GRASS_DIRT_FLOOR));
	
	public static final SurfaceRules.RuleSource OVERGROWN_SPIRES = ifTrue(isBiome(PioneerBiomes.OVERGROWN_SPIRES.getKey()),
																	sequence(ifTrue(surfaceNoiseAbove(1.75D), STONE), ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_DIRT_FLOOR));
	
	public static final SurfaceRules.RuleSource REDWOODS = ifTrue(isBiome(PioneerBiomes.REDWOODS.getKey(), PioneerBiomes.SNOWY_REDWOODS.getKey()),
																	sequence(ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT_FLOOR), ifTrue(surfaceNoiseAbove(1.25D), COARSE_DIRT), ifTrue(surfaceNoiseAbove(-0.90D), PODZOL_DIRT_FLOOR), GRASS_DIRT_FLOOR));
	
	public static final SurfaceRules.RuleSource RED_ROCK_CANYON = ifTrue(isBiome(PioneerBiomes.RED_ROCK_CANYON.getKey()), BADLANDS);
	
	
	@Override
	protected void registerEntries() {
		this.entry("verdant_sands_surface_rule")
			.selects("minecraft:overworld")
			.addModifier(new SurfaceRuleModifier(VERDANT_SANDS, false));
		
		this.entry("pine_meadows_surface_rule")
			.selects("minecraft:overworld")
			.addModifier(new SurfaceRuleModifier(PINE_MEADOWS, false));
		
		this.entry("overgrown_spires_surface_rule")
			.selects("minecraft:overworld")
			.addModifier(new SurfaceRuleModifier(OVERGROWN_SPIRES, false));
		
		this.entry("redwoods_surface_rule")
			.selects("minecraft:overworld")
			.addModifier(new SurfaceRuleModifier(REDWOODS, false));
		
		this.entry("desert_shrubland_surface_rule")
			.selects("minecraft:overworld")
			.addModifier(new SurfaceRuleModifier(DESERT_SHRUBLAND, false));
		
		this.entry("red_rock_canyon_surface_rule")
			.selects("minecraft:overworld")
			.addModifier(new SurfaceRuleModifier(RED_ROCK_CANYON, false));
	}
	
	private static SurfaceRules.RuleSource makeStateRule(Block block) {
		return state(block.defaultBlockState());
	}

	private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
		return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
	}
}
